package com.trunk.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 方法描述:自定义过滤器
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/11/3
 */
public class CustomFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request,ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session =httpServletRequest.getSession();

        //获取session中的验证码
        String validateCode = (String) session.getAttribute("captcha");

        //取出页面的验证码
        String randomcode = httpServletRequest.getParameter("validateCode");
        if(randomcode!=null && validateCode!=null && !randomcode.equals(validateCode)){
            httpServletRequest.setAttribute("shiroLoginFailure", "validateCodeError");
            //拒绝访问，不再校验账号和密码
            return true;
        }
        return super.onAccessDenied(request, response);
    }
}
