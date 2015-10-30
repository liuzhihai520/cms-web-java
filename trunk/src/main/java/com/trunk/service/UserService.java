package com.trunk.service;

import com.trunk.bean.User;
import com.trunk.util.Common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
        String sql = "SELECT a.*,c.name AS role FROM t_sys_user a LEFT JOIN t_sys_user_role b ON a.id=b.userId LEFT JOIN t_sys_role c ON b.roleId = c.id";
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
        String salt = Common.getRandomString(4);
        //密码加盐
        String pas = Common.MD5(user.getPassword())+salt;
        //重新生成MD5
        String password = Common.MD5(pas);
        //插入用户表
        String sql = "insert into t_sys_user(username,accountname,password,salt,status,description)values(?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
                        ps.setString(1, user.getUsername());
                        ps.setString(2, user.getAccountname());
                        ps.setString(3, password);
                        ps.setString(4, salt);
                        ps.setInt(5, user.getStatus());
                        ps.setString(6, user.getDescription());
                        return ps;
                    }
                },
        keyHolder);
        //插入用户角色表
        String sql1 = "insert into t_sys_user_role(userId,roleId) values(?,?)";
        jdbcTemplate.update(sql1,new Object[]{keyHolder.getKey().longValue(),user.getRole()});
    }

    //增加用户角色
    public void addRole(String name,String roleKey,int status,String description){
        String sql = "insert into t_sys_role (name,roleKey,status,description) values (?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{name,roleKey,status,description});
    }

    //删除角色
    @Transactional
    public void deleteRole(long roleId){
        //删除角色
        String sql = "delete from t_sys_role where id = ?";
        jdbcTemplate.update(sql,new Object[]{roleId});
        //删除角色对应菜单
        String resSQL = "delete from t_sys_role_res where roleId = ?";
        jdbcTemplate.update(resSQL,new Object[]{roleId});
    }
}
