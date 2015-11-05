package com.trunk.shiro;

import com.trunk.bean.TreeObject;
import com.trunk.bean.User;
import com.trunk.service.MenuService;
import com.trunk.service.SysService;
import com.trunk.util.Common;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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
        //获取认证设置的用户对象
        User user = (User)principalCollection.getPrimaryPrincipal();
        //用户权限菜单
        List<TreeObject> menuList = menuService.userAuthMenuList(user.getId());
        //单独定一个集合对象
        List<String> permissions = new ArrayList<String>();
        if(menuList != null && menuList.size() > 0){
            for(TreeObject sysPermission:menuList){
                //将数据库中的权限标签 符放入集合
                permissions.add(sysPermission.getResKey());
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //用户输入的认证信息
        String username = (String)authenticationToken.getPrincipal();
        //查询用户
        User user = sysService.user(username);
        if(user == null){
            // 没找到帐号
            throw new UnknownAccountException();
        }else{
            //盐
            String salt = user.getSalt();
            //设置菜单
            List<TreeObject> menuList = menuService.userMenuList(user.getId());
            user.setMenuList(menuList);
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(salt),getName());
            return authenticationInfo;
        }
    }

    /**
     * 更新用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCachedAuthorizationInfo(principals);
    }
    /**
     * 更新用户信息缓存.
     */
    public void clearCachedAuthenticationInfo() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCachedAuthenticationInfo(principals);
    }

    /**
     * 清除用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 清除用户信息缓存.
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 清空所有缓存
     */
    public void clearCache() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }


    /**
     * 清空所有认证缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
