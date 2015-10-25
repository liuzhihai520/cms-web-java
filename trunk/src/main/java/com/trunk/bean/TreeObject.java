package com.trunk.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法描述:把菜单以树形显示出来
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/25
 */
public class TreeObject {
    private long id;
    private long parentId;
    private String name;
    private String parentName;
    private String resKey;
    private String url;
    private Integer level;
    private String type;
    private String description;
    private String icon;
    private Integer ishide;
    private List<TreeObject> children = new ArrayList<TreeObject>();
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getParentId() {
        return parentId;
    }
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
    public List<TreeObject> getChildren() {
        return children;
    }
    public void setChildren(List<TreeObject> children) {
        this.children = children;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getParentName() {
        return parentName;
    }
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
    public String getResKey() {
        return resKey;
    }
    public void setResKey(String resKey) {
        this.resKey = resKey;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getIshide() {
        return ishide;
    }
    public void setIshide(Integer ishide) {
        this.ishide = ishide;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
