package com.trunk.controller;

import com.trunk.bean.TreeObject;
import com.trunk.bean.User;
import com.trunk.service.MenuService;
import com.trunk.service.SysService;
import com.trunk.util.Common;
import com.trunk.util.Patchca;
import com.trunk.util.ResultUtil;
import com.trunk.util.TreeUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.patchca.utils.encoder.EncoderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
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
@Controller
public class SysController {

    //日志
    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private SysService sysService;
    @Autowired
    private MenuService menuService;

    //初始化方法
    @RequestMapping("/")
    public String index(HttpServletRequest request){
        Map<String,Object> map = ResultUtil.result();
        request.setAttribute("data",ResultUtil.toJSON(map));
        return "main/index";
    }

    //验证码
    @RequestMapping("/code")
    public void code(HttpServletRequest request,HttpServletResponse response)throws Exception {
        response.setContentType("image/png");
        response.setHeader("cache", "no-cache");
        HttpSession session = request.getSession(true);
        OutputStream os = response.getOutputStream();
        String captcha = EncoderHelper.getChallangeAndWriteImage(Patchca.createImage(), "png", os);
        session.setAttribute("captcha", captcha);
        os.flush();
        os.close();
    }

    //登录
    @RequestMapping("sys/login")
    public String login(HttpServletRequest request,RedirectAttributes attr){
        Map<String,Object> map = ResultUtil.result();
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        if(exceptionClassName!=null){
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                map.put("code",1);
                map.put("msg","账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                map.put("code",2);
                map.put("msg","用户名/密码错误");
            }else if(exceptionClassName.equals("validateCodeError")){
                map.put("code",3);
                map.put("msg","验证码错误");
            }else {
                map.put("code",4);
                map.put("msg","未知错误");
            }
        }
        request.setAttribute("data",ResultUtil.toJSON(map));
        return "main/index";
    }

    //主界面
    @RequestMapping("sys/main")
    public String main(Model model){
        //用户信息
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipals().getPrimaryPrincipal();
        //菜单列表
        List<TreeObject> ns = user.getMenuList();
        model.addAttribute("user",user);
        model.addAttribute("menuList", ns);
        return "main/main";
    }

    //404
    @RequestMapping("/404")
    public String notFound(){
        return "sys/404";
    }

    //500
    @RequestMapping("/500")
    public String error(){
        return "sys/500";
    }
}
