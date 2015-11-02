package com.trunk.controller;

import com.alibaba.fastjson.JSON;
import com.trunk.bean.Menu;
import com.trunk.bean.TreeObject;
import com.trunk.service.MenuService;
import com.trunk.util.Common;
import com.trunk.util.Pages;
import com.trunk.util.ResultUtil;
import com.trunk.util.TreeUtil;
import com.trunk.util.xutil.Validators;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 方法描述:系统菜单
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/11/2
 */
@RequestMapping("/menu/*")
@Controller
public class MenuController {

    //日志
    private Logger logger = Logger.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    //菜单管理列表
    @RequestMapping("/menusList")
    public String menuList(HttpServletRequest request,
                           @RequestParam(required = false, defaultValue = "1") int pageNumber){
        int index = (pageNumber - 1) * 10;
        Pages<Map<String,Object>> page = menuService.menuList(index,pageNumber);
        request.setAttribute("list",page.getList());
        request.setAttribute("page", page);
        request.setAttribute("hasPreviousPage", page.hasPreviousPage());
        request.setAttribute("hasNextPage", page.hasNextPage());
        request.setAttribute("navigatePageNumbers", page.getNavigatePageNumbers());
        return "menu/menuList";
    }

    //添加菜单页
    @RequestMapping("/initMenu")
    public String toAddMenu(HttpServletRequest request){
        List<Map<String,Object>> mps = menuService.allMenuList();
        List<TreeObject> list = new ArrayList<TreeObject>();
        for(int i=0;i<mps.size();i++){
            Map<String,Object> map = mps.get(i);
            TreeObject treeObject = Common.map2Bean(map, TreeObject.class);
            list.add(treeObject);
        }
        TreeUtil treeUtil = new TreeUtil();
        List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0, "&nbsp;&nbsp;&nbsp;");
        request.setAttribute("treeList",ns);
        return "menu/addMenu";
    }

    //新增菜单
    @RequestMapping("/addMenu")
    public void addMenu(HttpServletResponse response,Menu menu){
        Map<String,Object> map = ResultUtil.result();
        PrintWriter out = null;
        int i = 0;
        try{
            out = response.getWriter();
            if(Validators.isBlank(menu.getName())){
                map.put("code",1);
                map.put("msg","请输入菜单名称");
            }else if(Validators.isBlank(menu.getResKey())){
                map.put("code",2);
                map.put("msg","请输入菜单标识");
            }else if(Validators.isBlank(menu.getUrl())){
                map.put("code",3);
                map.put("msg","请输入菜单名称");
            }else if(Validators.isBlank(menu.getDescription())){
                map.put("code",4);
                map.put("msg","请输入菜单描述");
            }else{
                menuService.addMenu(menu);
                map.put("msg","菜单添加成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            map.put("code",-1);
            map.put("msg","添加菜单失败,请联系管理员");
        }
        out.print("<script type=\"text/javascript\">parent.callback('"+ResultUtil.toJSON(map)+"')</script>");
    }

    //查询角色权限
    @RequestMapping("/roleRootList")
    public String roleRootList(HttpServletRequest request,long role_id){
        List<TreeObject> list = menuService.roleRootList(role_id);
        request.setAttribute("roleId",role_id);
        request.setAttribute("treeList",ResultUtil.toJSON(list));
        return "menu/roleRoot";
    }

    //角色菜单授权
    @RequestMapping("/roleRoot")
    @ResponseBody
    public String roleRoot(long role_id,String treeList){
        Map<String,Object> map = ResultUtil.result();
        try{
            if(treeList != null && !treeList.equals("")){
                treeList = treeList.substring(0,treeList.length()-1);
                menuService.roleRoot(treeList, role_id);
                map.put("msg","权限分配成功");
            }else{
                map.put("code",1);
                map.put("msg","请为角色分配权限");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            map.put("code",-1);
            map.put("msg","权限分配失败,联系管理员");
        }
        return JSON.toJSONString(map);
    }

    //查看菜单
    @RequestMapping("/menu")
    public String menu(HttpServletRequest request,long menuId){
        //菜单列表
        List<Map<String,Object>> mps = menuService.allMenuList();
        List<TreeObject> list = new ArrayList<TreeObject>();
        for(int i=0;i<mps.size();i++){
            Map<String,Object> map = mps.get(i);
            TreeObject treeObject = Common.map2Bean(map, TreeObject.class);
            list.add(treeObject);
        }
        TreeUtil treeUtil = new TreeUtil();
        List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0, "&nbsp;&nbsp;&nbsp;");
        request.setAttribute("treeList",ns);
        //查看信息
        Map<String,Object> menu = menuService.menu(menuId);
        request.setAttribute("menu",menu);
        return "menu/updateMenu";
    }

    //更新菜单
    @RequestMapping("/updateMenu")
    public void updateMenu(HttpServletResponse response,Menu menu){
        Map<String,Object> map = ResultUtil.result();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if(Validators.isBlank(menu.getName())){
                map.put("code",1);
                map.put("msg","请输入菜单名称");
            }else if(Validators.isBlank(menu.getResKey())){
                map.put("code",2);
                map.put("msg","请输入菜单标识");
            }else if(Validators.isBlank(menu.getUrl())){
                map.put("code",3);
                map.put("msg","请输入菜单名称");
            }else if(Validators.isBlank(menu.getDescription())){
                map.put("code",4);
                map.put("msg","请输入菜单描述");
            }else{
                menuService.updateMneu(menu);
                map.put("msg","菜单更新成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            map.put("code",-1);
            map.put("msg","更新菜单失败,请联系管理员");
        }
        out.print("<script type=\"text/javascript\">parent.callback('"+ResultUtil.toJSON(map)+"')</script>");
    }

    //删除菜单
    @RequestMapping("/deleteMenu")
    @ResponseBody
    public String deleteMenu(long menuId){
        Map<String,Object> map = ResultUtil.result();
        try {
            menuService.deleteMenu(menuId);
            map.put("msg","菜单删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            map.put("code",-1);
            map.put("msg","菜单删除失败,请联系管理员");
        }
        return ResultUtil.toJSON(map);
    }
}
