package com.trunk.service;

import com.trunk.bean.Role;
import com.trunk.bean.User;
import com.trunk.util.Common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.trunk.util.Pages;
import org.apache.shiro.crypto.hash.Md5Hash;
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

    //新增用户
    @Transactional
    public int addUser(User user){
        int i = 0;
        //验证用户名
        String str = "select count(0) as getCount from t_sys_user where username = ?";
        int hasName = jdbcTemplate.queryForObject(str,new Object[]{user.getUsername()},Integer.class);
        if(hasName > 0){
            i = 1;
        }else{
            //验证账号
            String str1 = "select count(0) as getCount from t_sys_user where accountname = ?";
            int hasAccount = jdbcTemplate.queryForObject(str1,new Object[]{user.getAccountname()},Integer.class);
            if(hasAccount > 0){
                i = 2;
            }else{
                //随机生成4位字符串
                String salt = Common.getRandomString(4);
                //重新生成MD5
                Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1);
                String password = md5Hash.toString();
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
        }
        return i;
    }

    //用户信息
    public Map<String,Object> user(long id){
        String sql = "SELECT a.*,b.roleId FROM t_sys_user a " +
                "LEFT JOIN t_sys_user_role b ON a.id=b.userId " +
                "LEFT JOIN t_sys_role c ON b.roleId=c.id where a.id = ?";
        return jdbcTemplate.queryForMap(sql,new Object[]{id});
    }

    //修改用户
    @Transactional
    public int updateUser(User user){
        int i = 0;
        //验证用户名
        String str = "select count(0) as getCount from t_sys_user where username = ? and id != ?";
        int hasName = jdbcTemplate.queryForObject(str,new Object[]{user.getUsername(),user.getId()},Integer.class);
        if (hasName > 0){
            i = 1;
        }else{
            //修改用户
            String sql = "update t_sys_user set username=?,status=?,description=? where id = ?";
            jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getStatus(),user.getDescription(),user.getId()});
            //修改角色
            String sql1 = "update t_sys_user_role set roleId = ? where userId=?";
            jdbcTemplate.update(sql1,new Object[]{user.getRole(),user.getId()});
        }
        return i;
    }

    //删除用户
    @Transactional
    public void deleteUser(long userId){
        //删除用户
        String sql = "delete from t_sys_user where id = ?";
        jdbcTemplate.update(sql,new Object[]{userId});
        //删除用户角色表
        String str = "delete from t_sys_user_role where userId = ?";
        jdbcTemplate.update(str,new Object[]{userId});
    }

}
