package com.trunk.bean;

/**
 * 方法描述:菜单实体类
 *
 * @author 小刘
 * @version v1.0
 * @date 2015/10/24
 */
public class Menu {
    //主键
    private long id;
    //名称
    private String name;
    //父id
    private long parentId;
    //菜单标识
    private String resKey;
    //菜单类型 1.主菜单url 2.页面元素
    private String type;
    //菜单地址
    private String url;
    //排序
    private int level;
    //图标名称
    private String icon;
    //是否隐藏 1.NO 2.YES
    private int ishide;
    //菜单描述
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

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getResKey() {
        return resKey;
    }

    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getIshide() {
        return ishide;
    }

    public void setIshide(int ishide) {
        this.ishide = ishide;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
