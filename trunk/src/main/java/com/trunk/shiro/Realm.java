package com.trunk.shiro;

import com.trunk.bean.TreeObject;
import com.trunk.bean.User;
import com.trunk.service.MenuService;
import com.trunk.service.SysService;
import com.trunk.util.Common;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private MenuService menuService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //用户输入的认证信息
        User token = (User)authenticationToken.getPrincipal();
        //查询用户
        User user = sysService.user(token.getUsername());
        if(user == null){
            // 没找到帐号
            throw new UnknownAccountException();
        }else{
            //密码加盐
            String repass = Common.MD5(user.getPassword())+user.getSalt();
            //设置菜单
            List<TreeObject> menuList = menuService.roleRootList(user.getRole());
            user.setMenuList(menuList);
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(repass),getName());
            return authenticationInfo;
        }
    }
}
