package com.trunk.controller;

import com.trunk.bean.Role;
import com.trunk.service.RoleService;
import com.trunk.util.Pages;
import com.trunk.util.ResultUtil;
import com.trunk.util.xutil.Validators;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 方法描述:系统角色
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/31
 */
@RequestMapping("/role/*")
@Controller
public class RoleController {
    //日志
    private Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private RoleService roleService;

    //角色管理列表
    @RequestMapping("/roleList")
    public String roleList(HttpServletRequest request,
                           @RequestParam(required = false, defaultValue = "1") int pageNumber){
        int index = (pageNumber - 1) * 10;
        Pages<Map<String,Object>> page = roleService.roleList(index,10,pageNumber);
        request.setAttribute("list",page.getList());
        request.setAttribute("page", page);
        request.setAttribute("hasPreviousPage", page.hasPreviousPage());
        request.setAttribute("hasNextPage", page.hasNextPage());
        request.setAttribute("navigatePageNumbers", page.getNavigatePageNumbers());
        return "role/roleList";
    }

    //初始化角色
    @RequestMapping("/roleInit")
    public String roleInit(){
        return "role/role";
    }

    //新增角色
    @RequestMapping("/addRole")
    public void addRole(HttpServletResponse response,
                        @RequestParam(required = true, defaultValue = "") String roleName,
                        @RequestParam(required = true, defaultValue = "") String roleKey,
                        @RequestParam(required = true, defaultValue = "1") int status,
                        @RequestParam(required = true, defaultValue = "") String description){
        Map<String,Object> map = ResultUtil.result();
        PrintWriter out = null;
        int i = 0;
        try{
            out = response.getWriter();
            if(Validators.isBlank(roleName)){
                map.put("code",3);
                map.put("msg","请填写角色名称");
            }else if(Validators.isBlank(roleKey)){
                map.put("code",4);
                map.put("msg","请填写roleKey");
            }else if(Validators.isBlank(description)){
                map.put("code",5);
                map.put("msg","请填写描述");
            }else{
                i = roleService.addRole(roleName,roleKey,status,description);
                map.put("code",i);
                if(i == 1){
                    map.put("msg","角色名已存在,请更改角色名");
                }else if(i == 2){
                    map.put("msg","roleKey已存在,请更改roleKey");
                }else {
                    map.put("msg","角色添加成功");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            map.put("code",-1);
            map.put("msg","角色添加出错,请联系管理员");
        }
        out.print("<script type=\"text/javascript\">parent.callback('"+ResultUtil.toJSON(map)+"')</script>");
    }

    //删除角色
    @RequestMapping("/deleteRole")
    public String deleteRole(long role_id){
        roleService.deleteRole(role_id);
        return "redirect:/role/roleList";
    }

    //角色信息
    @RequestMapping("/role")
    public String role(HttpServletRequest request,long roleId){
        Map<String,Object> role = roleService.role(roleId);
        request.setAttribute("role",role);
        return "role/updateRole";
    }

    //修改角色信息
    @RequestMapping("/updateRole")
    public void updateRole(HttpServletResponse response,Role role){
        Map<String,Object> map = ResultUtil.result();
        PrintWriter out = null;
        int i = 0;
        try {
            out = response.getWriter();
            if(Validators.isBlank(role.getName())){
                map.put("code",3);
                map.put("msg","请填写角色名称");
            }else if(Validators.isBlank(role.getRoleKey())){
                map.put("code",4);
                map.put("msg","请填写roleKey");
            }else if(Validators.isBlank(role.getDescription())){
                map.put("code",5);
                map.put("msg","请填写描述");
            }else{
                i = roleService.updateRole(role);
                map.put("code",i);
                if(i == 1){
                    map.put("msg","角色名已存在,请更改角色名");
                }else if(i == 2){
                    map.put("msg","roleKey已存在,请更改roleKey");
                }else {
                    map.put("msg","角色更新成功");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            map.put("code",-1);
            map.put("msg","角色更新失败");
        }
        out.print("<script type=\"text/javascript\">parent.callback('"+ResultUtil.toJSON(map)+"')</script>");
    }
}
