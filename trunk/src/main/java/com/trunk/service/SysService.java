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
    public User user(String username){
        //通过用户名查询
        String str = "SELECT a.*,IFNULL(b.roleId,0) AS role FROM t_sys_user a LEFT JOIN t_sys_user_role b ON a.id=b.userId " +
                      "WHERE a.accountname = ?";
        Map<String,Object> map = jdbcTemplate.queryForMap(str,new Object[]{username});
        if(map == null || map.isEmpty()){
            return null;
        }else{
            User user = Common.map2Bean(map,User.class);
            return user;
        }
    }
}
