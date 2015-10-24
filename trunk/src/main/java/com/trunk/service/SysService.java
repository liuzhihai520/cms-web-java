package com.trunk.service;

import com.trunk.bean.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
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

    //顶级菜单列表查询
    public List<Map<String,Object>> topMenuList(){
        String sql = "select * from t_sys_menu";
        return jdbcTemplate.queryForList(sql);
    }

    //子菜单列表
    public List<Map<String,Object>> menuList(long menuId){
        String sql = "select * from t_sys_menu where parentId = ?";
        return jdbcTemplate.queryForList(sql,new Object[]{menuId});
    }

    //新增菜单
    public void addMenu(Menu menu){
        String sql = "insert into t_sys_menu(name,parentId,resKey,type,url,level,icon,ishide,description) " +
                     "values(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{menu.getName(),menu.getParentId(),menu.getResKey(),
                menu.getType(),menu.getUrl(),menu.getLevel(),menu.getIcon(),menu.getIshide(),menu.getDescription()});
    }
}
