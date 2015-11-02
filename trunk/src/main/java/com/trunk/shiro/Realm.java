package com.trunk.shiro;

import com.trunk.bean.User;
import com.trunk.service.SysService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 方法描述:权限控制器
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/11/1
 */
public class Realm extends AuthorizingRealm {

    @Autowired
    private SysService sysService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户输入的认证信息
        User user = (User)authenticationToken.getPrincipal();

        return null;
    }
}
