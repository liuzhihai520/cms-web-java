package com.trunk.controller;

import com.trunk.bean.TreeObject;
import com.trunk.bean.User;
import com.trunk.service.MenuService;
import com.trunk.service.SysService;
import com.trunk.util.Common;
import com.trunk.util.TreeUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 方法描述:系统控制
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/22
 */
@RequestMapping("/sys/*")
@Controller
public class SysController {

    //日志
    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private SysService sysService;
    @Autowired
    private MenuService menuService;

    //登录
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        //如果登陆失败从request中获取认证异常信息
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        //根据shiro返回的异常类路径判断,抛出指定异常信息
        if(exceptionClassName!=null){
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                //账号不存在
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                //用户名/密码错误
            }else {
                //其他认证错误
            }
        }
        return "/main/index";
    }

    //主界面
    @RequestMapping("/main")
    public String index(Model model){
        //用户信息
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipals();
        //菜单列表
        List<Map<String,Object>> mps = menuService.allMenuList();
        List<TreeObject> list = new ArrayList<TreeObject>();
        for(int i=0;i<mps.size();i++){
            Map<String,Object> map = mps.get(i);
            TreeObject treeObject = Common.map2Bean(map, TreeObject.class);
            list.add(treeObject);
        }
        TreeUtil treeUtil = new TreeUtil();
        List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0);
        model.addAttribute("user",user);
        model.addAttribute("menuList", ns);
        return "main/main";
    }
}
