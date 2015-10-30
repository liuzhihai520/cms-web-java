package com.trunk.controller;

import com.trunk.bean.User;
import com.trunk.service.UserService;
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
    public String roleList(HttpServletRequest request){
        List<Map<String,Object>> list = userService.roleList();
        request.setAttribute("list",list);
        return "user/roleList";
    }

    //初始化用户界面
    @RequestMapping("/initUser")
    public String initAddUser(HttpServletRequest request){
        List<Map<String,Object>> roleList = userService.roleList();
        request.setAttribute("roleList",roleList);
        return "user/user";
    }

    //新增用户
    @RequestMapping("/addUser")
    public void addUser(HttpServletResponse response,User user){
        PrintWriter out = null;
        int status = 0;
        try {
            out = response.getWriter();
            userService.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            status = -1;
        }
        out.print("<script type=\"text/javascript\">parent.callback('"+status+"')</script>");
    }

    //新增角色
    @RequestMapping("/addRole")
    public String addRole(@RequestParam(required = true, defaultValue = "") String roleName,
                          @RequestParam(required = true, defaultValue = "") String roleKey,
                          @RequestParam(required = true, defaultValue = "1") int status,
                          @RequestParam(required = true, defaultValue = "") String description){
        userService.addRole(roleName,roleKey,status,description);
        return "user/role";
    }

    //测试模块
    @RequestMapping("/test")
    public String test(){
        return "user/test";
    }
}
