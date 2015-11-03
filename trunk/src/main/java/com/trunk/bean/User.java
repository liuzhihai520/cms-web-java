package com.trunk.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 方法描述:用户
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/26
 */
public class User implements Serializable {
    private long id;
    private String username;
    private String accountname;
    private String password;
    private String salt;
    private int status;
    private Timestamp createTime;
    private String description;

    //额外字段
    private long role;
    //菜单
    List<TreeObject> menuList = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
        this.role = role;
    }

    public List<TreeObject> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<TreeObject> menuList) {
        this.menuList = menuList;
    }
}
