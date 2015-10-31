package com.trunk.controller;

import com.trunk.bean.Role;
import com.trunk.bean.User;
import com.trunk.service.UserService;
import com.trunk.util.Pages;
import com.trunk.util.ResultUtil;
import com.trunk.util.xutil.Validators;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    //用户管理列表
    @RequestMapping("/userList")
    public String userList(HttpServletRequest request){
        List<Map<String,Object>> userList = userService.userList();
        request.setAttribute("userList",userList);
        return "user/userList";
    }

    //角色管理列表
    @RequestMapping("/roleList")
    public String roleList(HttpServletRequest request,
                             @RequestParam(required = false, defaultValue = "1") int pageNumber){
        int index = (pageNumber - 1) * 10;
        Pages<Map<String,Object>> page = userService.roleList(index,10,pageNumber);
        request.setAttribute("list",page.getList());
        request.setAttribute("page", page);
        request.setAttribute("hasPreviousPage", page.hasPreviousPage());
        request.setAttribute("hasNextPage", page.hasNextPage());
        request.setAttribute("navigatePageNumbers", page.getNavigatePageNumbers());
        return "user/roleList";
    }

    //初始化用户界面
    @RequestMapping("/initUser")
    public String initAddUser(HttpServletRequest request){
        int index = (1 - 1) * 10;
        Pages<Map<String,Object>> page = userService.roleList(index,100,1);
        List<Map<String,Object>> roleList = page.getList();
        request.setAttribute("roleList",roleList);
        return "user/user";
    }

    //新增用户
    @RequestMapping("/addUser")
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
        Pages<Map<String,Object>> page = userService.roleList(index,100,1);
        List<Map<String,Object>> roleList = page.getList();
        request.setAttribute("roleList",roleList);
        request.setAttribute("user",user);
        return "user/updateUser";
    }

    //修改用户
    @RequestMapping("/updateUser")
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
    public String deleteUser(long userId){
        userService.deleteRole(userId);
        return "redirect:/user/userList";
    }

    //新增角色
    @RequestMapping("/addRole")
    public void addRole(HttpServletResponse response,
                          @RequestParam(required = true, defaultValue = "") String roleName,
                          @RequestParam(required = true, defaultValue = "") String roleKey,
                          @RequestParam(required = true, defaultValue = "1") int status,
                          @RequestParam(required = true, defaultValue = "") String description){
        Map<String,Object> map = ResultUtil.result();
        PrintWriter out = null;
        int i = 0;
        try{
            out = response.getWriter();
            if(Validators.isBlank(roleName)){
                map.put("code",3);
                map.put("msg","请填写角色名称");
            }else if(Validators.isBlank(roleKey)){
                map.put("code",4);
                map.put("msg","请填写roleKey");
            }else if(Validators.isBlank(description)){
                map.put("code",5);
                map.put("msg","请填写描述");
            }else{
                i = userService.addRole(roleName,roleKey,status,description);
                map.put("code",i);
                if(i == 1){
                    map.put("msg","角色名已存在,请更改角色名");
                }else if(i == 2){
                    map.put("msg","roleKey已存在,请更改roleKey");
                }else {
                    map.put("msg","角色添加成功");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            map.put("code",-1);
            map.put("msg","角色添加出错,请联系管理员");
        }
        out.print("<script type=\"text/javascript\">parent.callback('"+ResultUtil.toJSON(map)+"')</script>");
    }

    //删除角色
    @RequestMapping("/deleteRole")
    public String deleteRole(long role_id){
        userService.deleteRole(role_id);
        return "redirect:/user/roleList";
    }

    //角色信息
    @RequestMapping("/role")
    public String role(HttpServletRequest request,long roleId){
        Map<String,Object> role = userService.role(roleId);
        request.setAttribute("role",role);
        return "user/updateRole";
    }

    //修改角色信息
    @RequestMapping("/updateRole")
    public void updateRole(HttpServletResponse response,Role role){
        Map<String,Object> map = ResultUtil.result();
        PrintWriter out = null;
        int i = 0;
        try {
            out = response.getWriter();
            if(Validators.isBlank(role.getName())){
                map.put("code",3);
                map.put("msg","请填写角色名称");
            }else if(Validators.isBlank(role.getRoleKey())){
                map.put("code",4);
                map.put("msg","请填写roleKey");
            }else if(Validators.isBlank(role.getDescription())){
                map.put("code",5);
                map.put("msg","请填写描述");
            }else{
                i = userService.updateRole(role);
                map.put("code",i);
                if(i == 1){
                    map.put("msg","角色名已存在,请更改角色名");
                }else if(i == 2){
                    map.put("msg","roleKey已存在,请更改roleKey");
                }else {
                    map.put("msg","角色更新成功");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            map.put("code",-1);
            map.put("msg","角色更新失败");
        }
        out.print("<script type=\"text/javascript\">parent.callback('"+ResultUtil.toJSON(map)+"')</script>");
    }
}
