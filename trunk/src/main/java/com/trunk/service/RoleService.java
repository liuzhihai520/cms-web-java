package com.trunk.service;

import com.trunk.bean.Role;
import com.trunk.util.Pages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 方法描述:系统角色
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/31
 */
@Service
public class RoleService extends BaseService{

    //角色列表
    public Pages<Map<String,Object>> roleList(int index,int limit,int pageNumber){
        //角色数
        String str = "select count(0) as getCount from t_sys_role";
        int count = jdbcTemplate.queryForObject(str,Integer.class);
        //集合
        String sql = "select * from t_sys_role limit ?,?";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,new Object[]{index,limit});
        Pages<Map<String, Object>> page = new Pages<>(count, pageNumber,limit);
        page.setList(list);
        return page;
    }

    //增加用户角色
    public int addRole(String name,String roleKey,int status,String description){
        int i = 0;
        //验证名称
        String str = "select count(0) as getCount from t_sys_role where name = ?";
        int hasName = jdbcTemplate.queryForObject(str,new Object[]{name},Integer.class);
        if(hasName > 0){
            i = 1;
        }else{
            //验证roleKey
            String str1 = "select count(0) as getCount from t_sys_role where roleKey = ?";
            int hasKey = jdbcTemplate.queryForObject(str1,new Object[]{roleKey},Integer.class);
            if(hasKey > 0){
                i = 2;
            }else{
                String sql = "insert into t_sys_role (name,roleKey,status,description) values (?,?,?,?)";
                jdbcTemplate.update(sql,new Object[]{name,roleKey,status,description});
            }
        }
        return i;
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

    //查询角色信息
    public Map<String,Object> role(long roleId){
        String sql = "select * from t_sys_role where id = ?";
        return jdbcTemplate.queryForMap(sql,new Object[]{roleId});
    }

    //修改角色信息
    public int updateRole(Role role){
        int i = 0;
        //验证名称
        String str = "select count(0) as getCount from t_sys_role where name = ? and id != ?";
        int hasName = jdbcTemplate.queryForObject(str,new Object[]{role.getName(),role.getId()},Integer.class);
        if(hasName > 0){
            i = 1;
        }else{
            //验证roleKey
            String str1 = "select count(0) as getCount from t_sys_role where roleKey = ? and id != ?";
            int hasKey = jdbcTemplate.queryForObject(str1,new Object[]{role.getRoleKey(),role.getId()},Integer.class);
            if(hasKey > 0){
                i = 2;
            }else{
                String sql = "update t_sys_role set name = ?,roleKey = ?,status = ?,description = ? where id = ?";
                jdbcTemplate.update(sql,new Object[]{role.getName(),role.getRoleKey(),role.getStatus(),role.getDescription(),role.getId()});
            }
        }
        return i;
    }
}
