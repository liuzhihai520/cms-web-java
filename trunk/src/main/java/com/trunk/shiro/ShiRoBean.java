package com.trunk.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

/**
 * 方法描述:TODO
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/11/3
 */
public class ShiRoBean extends ShiroFilterFactoryBean{
    @Override
    public String getSuccessUrl(){
        String url = super.getSuccessUrl();
        System.out.println(url);
        return url;
    }
}
