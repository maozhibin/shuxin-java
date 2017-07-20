package com.baoquan.shuxin.model.product;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer userId;

    private String name;

    private Byte frequent;

    private Byte type;

    private Integer productClassId;

    private Integer productBaseId;

    private Integer areaId;

    private String icon;

    private Integer used;

    private Integer dateline;

    private Integer status;

    private String reflectClass;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getFrequent() {
        return frequent;
    }

    public void setFrequent(Byte frequent) {
        this.frequent = frequent;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getProductClassId() {
        return productClassId;
    }

    public void setProductClassId(Integer productClassId) {
        this.productClassId = productClassId;
    }

    public Integer getProductBaseId() {
        return productBaseId;
    }

    public void setProductBaseId(Integer productBaseId) {
        this.productBaseId = productBaseId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getDateline() {
        return dateline;
    }

    public void setDateline(Integer dateline) {
        this.dateline = dateline;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReflectClass() {
        return reflectClass;
    }

    public void setReflectClass(String reflectClass) {
        this.reflectClass = reflectClass == null ? null : reflectClass.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}