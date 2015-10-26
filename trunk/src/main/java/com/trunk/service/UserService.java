package com.trunk.service;

import com.trunk.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 方法描述:用户管理业务逻辑处理
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/24
 */
@Service
public class UserService extends BaseService{

    //用户列表
    public List<Map<String,Object>> userList(){
        String sql = "select * from t_sys_user";
        return jdbcTemplate.queryForList(sql);
    }

    //角色列表
    public List<Map<String,Object>> roleList(){
        String sql = "select * from t_sys_role";
        return jdbcTemplate.queryForList(sql);
    }

    //新增用户
    @Transactional
    public void addUser(User user){

        //随机生成4位字符串

        //密码加盐

        //重新生成MD5

        //插入用户表
        String sql = "insert into t_sys_user(username,accountname,password,salt,status,description)values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getAccountname(),"","",user.getStatus(),user.getDescription()});
        //插入用户角色表
        String sql1 = "insert into t_sys_user_role(userId,roleId) values(?,?)";
        jdbcTemplate.update(sql1,new Object[]{0,0});
    }

    //增加用户角色
    public void addRole(String name,String roleKey,int status,String description){
        String sql = "insert into t_sys_role (name,roleKey,status,description) values (?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{name,roleKey,status,description});
    }


}
