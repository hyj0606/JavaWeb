package com.pojo;

import java.util.List;

/**
 * @ClassName ProductCategory
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-20 15:50
 * @Version 1.0
 */

public class ProductCategory {

    private int id;             //主键
    private String name;        //名称
    private int parentId;       //父级目录
    private int type;           //级别(1:一级, 2:二级)
    private String iconClass;   //图标

    private List level;

    public ProductCategory() {
    }

    public ProductCategory(int id, String name, int parentId, int type, String iconClass) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.type = type;
        this.iconClass = iconClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public List getLevel() {
        return level;
    }

    public void setLevel(List level) {
        this.level = level;
    }
}
