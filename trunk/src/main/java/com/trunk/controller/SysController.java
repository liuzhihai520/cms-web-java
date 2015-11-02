package com.trunk.controller;

import com.trunk.bean.TreeObject;
import com.trunk.bean.User;
import com.trunk.service.MenuService;
import com.trunk.service.SysService;
import com.trunk.util.Common;
import com.trunk.util.ResultUtil;
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
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
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
    public void login(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = ResultUtil.result();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            //如果登陆失败从request中获取认证异常信息
            String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
            //根据shiro返回的异常类路径判断,抛出指定异常信息
            if(exceptionClassName!=null){
                if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                    map.put("code",1);
                    map.put("msg","账号不存在");
                } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                    map.put("code",2);
                    map.put("msg","账号/密码错误");
                }else {
                    map.put("code",3);
                    map.put("msg","未知异常,请联系管理员");
                }
            }else{
                map.put("code",4);
                map.put("msg","验证信息获取失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            map.put("code",-1);
            map.put("msg","登陆出错,请联系管理员");
        }
        out.print("<script type=\"text/javascript\">parent.callback('"+ResultUtil.toJSON(map)+"')</script>");
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
