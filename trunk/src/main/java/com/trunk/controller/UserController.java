package com.trunk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    //新增用户
    @RequestMapping("/initAddUser")
    public String initAddUser(){
        return "user/addUser";
    }
}
