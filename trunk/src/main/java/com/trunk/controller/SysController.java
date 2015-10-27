package com.trunk.controller;

import com.alibaba.fastjson.JSON;
import com.trunk.bean.Menu;
import com.trunk.bean.TreeObject;
import com.trunk.service.SysService;
import com.trunk.util.Common;
import com.trunk.util.Pages;
import com.trunk.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 方法描述:系统控制
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/22
 */
@RequestMapping("/sys/*")
@Controller
public class SysController {

    @Autowired
    private SysService sysService;

    //主界面
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        //菜单列表
        List<Map<String,Object>> mps = sysService.allMenuList();
        List<TreeObject> list = new ArrayList<TreeObject>();
        for(int i=0;i<mps.size();i++){
            Map<String,Object> map = mps.get(i);
            TreeObject treeObject = Common.map2Bean(map, TreeObject.class);
            list.add(treeObject);
        }
        TreeUtil treeUtil = new TreeUtil();
        List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0);
        request.setAttribute("menuList",ns);
        return "main/main";
    }

    //查询菜单列表
    @RequestMapping("/menuList")
    @ResponseBody
    public String menuList(@RequestParam(required = true, defaultValue = "0") long menuId){
        List<Map<String,Object>> list = sysService.menuList(menuId);
        return JSON.toJSONString(list);
    }

    //菜单管理列表
    @RequestMapping("/menusList")
    public String menuList(HttpServletRequest request,
                           @RequestParam(required = false, defaultValue = "1") int pageNumber){
        int index = (pageNumber - 1) * 10;
        Pages<Map<String,Object>> page = sysService.menuList(index,pageNumber);
        request.setAttribute("list",page.getList());
        return "sys/menuList";
    }

    //添加菜单页
    @RequestMapping("/initMenu")
    public String toAddMenu(HttpServletRequest request){
        List<Map<String,Object>> mps = sysService.allMenuList();
        List<TreeObject> list = new ArrayList<TreeObject>();
        for(int i=0;i<mps.size();i++){
            Map<String,Object> map = mps.get(i);
            TreeObject treeObject = Common.map2Bean(map, TreeObject.class);
            list.add(treeObject);
        }
        TreeUtil treeUtil = new TreeUtil();
        List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0, "&nbsp;&nbsp;&nbsp;");
        request.setAttribute("treeList",ns);
        return "sys/addMenu";
    }

    //新增菜单
    @RequestMapping("/addMenu")
    public String addMenu(Menu menu){
        sysService.addMenu(menu);
        return "sys/addMenu";
    }
}
