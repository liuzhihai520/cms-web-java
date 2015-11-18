package com.trunk.controller;

import com.trunk.bean.TreeObject;
import com.trunk.bean.User;
import com.trunk.service.MenuService;
import com.trunk.service.SysService;
import com.trunk.util.Patchca;
import com.trunk.util.ResultUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.patchca.utils.encoder.EncoderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
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
    private Logger log = Logger.getLogger(UserController.class);

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
    public String login(HttpServletRequest request,String username,String password){
        Map<String,Object> map = ResultUtil.result();
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            user.login(token);
        }catch (LockedAccountException e) {
            token.clear();
            map.put("code",1);
            map.put("msg","用户已经被锁定不能登录，请与管理员联系!");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.setAttribute("data",ResultUtil.toJSON(map));
            return "main/index";
        }catch (AuthenticationException e) {
            token.clear();
            map.put("code",2);
            map.put("msg","用户或密码不正确!");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.setAttribute("data",ResultUtil.toJSON(map));
            return "main/index";
        }catch (Exception e){
            token.clear();
            map.put("code",3);
            map.put("msg","未知异常");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.setAttribute("data",ResultUtil.toJSON(map));
            return "main/index";
        }
        return "redirect:sys/main";
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
