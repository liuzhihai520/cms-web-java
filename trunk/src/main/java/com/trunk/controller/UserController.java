package com.trunk.controller;

import com.trunk.bean.User;
import com.trunk.service.RoleService;
import com.trunk.service.UserService;
import com.trunk.util.Pages;
import com.trunk.util.ResultUtil;
import com.trunk.util.xutil.Validators;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * 方法描述:用户管理
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/24
 */
@RequestMapping("/user/*")
@Controller
public class UserController {

    //日志
    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    //用户管理列表
    @RequestMapping("/userList")
    @RequiresPermissions("user:userList")
    public String userList(HttpServletRequest request){
        List<Map<String,Object>> userList = userService.userList();
        request.setAttribute("userList",userList);
        return "user/userList";
    }

    //初始化用户界面
    @RequestMapping("/initUser")
    public String initAddUser(HttpServletRequest request){
        int index = (1 - 1) * 10;
        Pages<Map<String,Object>> page = roleService.roleList(index,100,1);
        List<Map<String,Object>> roleList = page.getList();
        request.setAttribute("roleList",roleList);
        return "user/user";
    }

    //新增用户
    @RequestMapping("/addUser")
    @RequiresPermissions("user:add")
    public void addUser(HttpServletResponse response,User user){
        Map<String,Object> map = ResultUtil.result();
        PrintWriter out = null;
        int i = 0;
        try {
            out = response.getWriter();
            if(Validators.isBlank(user.getUsername())){
                map.put("code",3);
                map.put("msg","请填写角色名称");
            }else if(Validators.isBlank(user.getAccountname())){
                map.put("code",4);
                map.put("msg","请填写账号");
            }else if(Validators.isBlank(user.getDescription())){
                map.put("code",5);
                map.put("msg","请填写描述");
            }else{
                i = userService.addUser(user);
                map.put("code",i);
                if(i == 1){
                    map.put("msg","用户名已存在,请更改用户名");
                }else if(i == 2){
                    map.put("msg","账号已存在,请更改账号");
                }else {
                    map.put("msg","用户添加成功");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            i = -1;
            map.put("code",i);
            map.put("msg","用户添加出错,请联系管理员");
        }
        out.print("<script type=\"text/javascript\">parent.callback('"+ResultUtil.toJSON(map)+"')</script>");
    }

    //用户信息
    @RequestMapping("/user")
    public String user(HttpServletRequest request,long userId){
        //用户信息
        Map<String,Object> user = userService.user(userId);
        //角色列表
        int index = (1 - 1) * 10;
        Pages<Map<String,Object>> page = roleService.roleList(index,100,1);
        List<Map<String,Object>> roleList = page.getList();
        request.setAttribute("roleList",roleList);
        request.setAttribute("user",user);
        return "user/updateUser";
    }

    //修改用户
    @RequestMapping("/updateUser")
    @RequiresPermissions("user:update")
    public void updateUser(HttpServletResponse response,User user){
        Map<String,Object> map = ResultUtil.result();
        PrintWriter out = null;
        int i = 0;
        try {
            out = response.getWriter();
            if(Validators.isBlank(user.getUsername())){
                map.put("code",2);
                map.put("msg","请填写角色名称");
            }else if(Validators.isBlank(user.getDescription())){
                map.put("code",3);
                map.put("msg","请填写描述");
            }else{
                i = userService.updateUser(user);
                map.put("code",i);
                if(i == 1){
                    map.put("msg","用户名已存在,请更改用户名");
                }else {
                    map.put("msg","用户更新成功");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            i = -1;
            map.put("code",i);
            map.put("msg","更新用户出错,请联系管理员");
        }
        out.print("<script type=\"text/javascript\">parent.callback('"+ResultUtil.toJSON(map)+"')</script>");
    }

    //删除用户
    @RequestMapping("/deleteUser")
    @RequiresPermissions("user:deleteUser")
    public String deleteUser(long userId){
        userService.deleteUser(userId);
        return "redirect:/user/userList";
    }
}
