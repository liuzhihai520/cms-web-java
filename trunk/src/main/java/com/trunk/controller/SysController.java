package com.trunk.controller;

import com.alibaba.fastjson.JSON;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.trunk.bean.Menu;
import com.trunk.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
        List<Map<String,Object>> menuList = sysService.topMenuList();
        request.setAttribute("menuList",menuList);
        return "main/main";
    }

    //查询菜单列表
    @RequestMapping("/menuList")
    @ResponseBody
    public String menuList(@RequestParam(required = true, defaultValue = "0") long menuId){
        List<Map<String,Object>> list = sysService.menuList(menuId);
        return JSON.toJSONString(list);
    }

    //新增菜单
    @RequestMapping("/addMenu")
    public String addMenu(Menu menu){
        sysService.addMenu(menu);
        return "sys/addMenu";
    }
}
