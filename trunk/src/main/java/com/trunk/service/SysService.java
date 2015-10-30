package com.trunk.service;

import com.alibaba.fastjson.JSON;
import com.trunk.bean.Menu;
import com.trunk.bean.TreeObject;
import com.trunk.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        String sql = "select * from t_sys_menu where parentId = 0";
        return jdbcTemplate.queryForList(sql);
    }

    //所有菜单查询
    public List<Map<String,Object>> allMenuList(){
        String sql = "select * from t_sys_menu where type != 3 order by level desc";
        return jdbcTemplate.queryForList(sql);
    }

    //子菜单列表
    public List<Map<String,Object>> menuList(long menuId){
        String sql = "select * from t_sys_menu where parentId = ?";
        return jdbcTemplate.queryForList(sql,new Object[]{menuId});
    }

    //菜单列表
    public Pages<Map<String,Object>> menuList(int index,int pageNumber){
        String str = "select count(0) as getCount from t_sys_menu";
        int count = jdbcTemplate.queryForObject(str,Integer.class);

        String sql = "SELECT * FROM t_sys_menu limit ?,10";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,new Object[]{index});
        Pages<Map<String, Object>> page = new Pages<>(count, pageNumber,10);
        page.setList(list);
        return page;
    }

    //新增菜单
    public void addMenu(Menu menu){
        String sql = "insert into t_sys_menu(name,parentId,resKey,type,url,level,icon,ishide,description) " +
                     "values(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{menu.getName(),menu.getParentId(),menu.getResKey(),
                menu.getType(),menu.getUrl(),menu.getLevel(),menu.getIcon(),menu.getIshide(),menu.getDescription()});
    }

    //查询角色权限
    public List<TreeObject> roleRootList(long role){
        List<TreeObject> list = new ArrayList<>();
        //查询所有菜单
        String sql = "select * from t_sys_menu where type != 3 order by level desc";
        List<Map<String,Object>> menuList = jdbcTemplate.queryForList(sql);
        //查询角色权限菜单
        String roleSQL = "SELECT c.* FROM t_sys_role a " +
                          "JOIN t_sys_role_res b ON a.id=b.roleId " +
                          "JOIN t_sys_menu c ON b.resId=c.id where a.id = ?";
        List<Map<String,Object>> roleMenuList = jdbcTemplate.queryForList(roleSQL,new Object[]{role});
        for(int i=0;i<menuList.size();i++){
            Map<String,Object> mMap = menuList.get(i);
            long mRes_id = Convert.strToLong(mMap.get("id")+"",0);
            for(int j=0;j<roleMenuList.size();j++){
                Map<String,Object> rMap = roleMenuList.get(j);
                long rRes_id = Convert.strToLong(rMap.get("id") + "", 0);
                if(mRes_id == rRes_id){
                    mMap.put("checked",true);
                    break;
                }
            }
            TreeObject treeObject = Common.map2Bean(mMap, TreeObject.class);
            list.add(treeObject);
        }
        TreeUtil treeUtil = new TreeUtil();
        List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0, "");
        return ns;
    }

    //角色授权
    @Transactional
    public void roleRoot(String treeList,long roleId){
        //删除当前角色所有菜单
        String sql = "delete from t_sys_role_res where roleId = ?";
        jdbcTemplate.update(sql,new Object[]{roleId});
        //新增角色菜单
        String idArr[] = treeList.split(",");
        for(int i=0;i<idArr.length;i++){
            String insert = "insert into t_sys_role_res (roleId,resId) values (?,?)";
            jdbcTemplate.update(insert,new Object[]{roleId,idArr[i]});
        }
    }
}
