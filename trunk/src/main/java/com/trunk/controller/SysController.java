package com.trunk.controller;

import com.alibaba.fastjson.JSON;
import com.trunk.bean.Menu;
import com.trunk.bean.TreeObject;
import com.trunk.service.MenuService;
import com.trunk.service.SysService;
import com.trunk.util.Common;
import com.trunk.util.Pages;
import com.trunk.util.ResultUtil;
import com.trunk.util.TreeUtil;
import com.trunk.util.xutil.StringUtils;
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
 * 方法描述:系统控制
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/22
 */
@RequestMapping("/sys/*")
@Controller
public class SysController {

    //日志
    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private SysService sysService;
    @Autowired
    private MenuService menuService;

    //主界面
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        //菜单列表
        List<Map<String,Object>> mps = menuService.allMenuList();
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
        List<Map<String,Object>> list = menuService.menuList(menuId);
        return JSON.toJSONString(list);
    }
}
