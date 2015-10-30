package com.trunk.bean;

/**
 * 方法描述:角色
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/30
 */
public class Role {
    private long id;
    private String name;
    private String roleKey;
    private int status;
    private String description;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRoleKey() {
        return roleKey;
    }
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
