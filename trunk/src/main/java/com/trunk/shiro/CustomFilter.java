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
        return super.onAccessDenied(request, response);
    }
}
