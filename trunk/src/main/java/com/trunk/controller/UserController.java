package com.trunk.controller;

import com.trunk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private UserService userService;

    //新增用户
    @RequestMapping("/initAddUser")
    public String initAddUser(){
        return "user/addUser";
    }

    //新增角色
    @RequestMapping("/addRole")
    public String addRole(@RequestParam(required = true, defaultValue = "") String roleName,
                          @RequestParam(required = true, defaultValue = "") String roleKey,
                          @RequestParam(required = true, defaultValue = "1") int status,
                          @RequestParam(required = true, defaultValue = "") String description){
        System.out.println(status);
        userService.addRole(roleName,roleKey,status,description);
        return "user/addRole";
    }
}
