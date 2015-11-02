package com.trunk.service;

import com.trunk.bean.User;
import com.trunk.util.Common;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 方法描述:系统业务逻辑处理
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/24
 */
@Service
public class SysService extends BaseService{

    //用户登录
    public User user(String username,String password){
        //通过用户名查询
        String str = "select * from t_sys_user where username = ?";
        Map<String,Object> map = jdbcTemplate.queryForMap(str,new Object[]{username});
        if(map == null || map.isEmpty()){
            return null;
        }else{
            //密码加盐
            String pas = Common.MD5(password)+map.get("salt");
            //重新生成MD5
            String rePas = Common.MD5(pas);
            //匹配用户账号密码
            String sql = "select * from t_sys_user where username = ? and password = ?";
            Map<String,Object> tempUser = jdbcTemplate.queryForMap(sql,new Object[]{username,rePas});
            User user = Common.map2Bean(tempUser,User.class);
            return user;
        }
    }
}
