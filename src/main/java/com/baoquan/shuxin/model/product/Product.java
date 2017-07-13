package com.baoquan.shuxin.model.product;

import java.io.Serializable;

import lombok.Data;

/**
 * Desc:
 * Created by yongj on 7/10/2017,
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -3993874942780998213L;

    private Integer id;

    private String icon;

    private String name;

    private Integer level;

    private Integer used;

    private Integer userId;

    private Integer dateline;

    private Integer areaId;

    private String status;

    private String reflectClass;

    private Integer productClassId;

    private Integer price;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDateline() {
		return dateline;
	}

	public void setDateline(Integer dateline) {
		this.dateline = dateline;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReflectClass() {
		return reflectClass;
	}

	public void setReflectClass(String reflectClass) {
		this.reflectClass = reflectClass;
	}

	public Integer getProductClassId() {
		return productClassId;
	}

	public void setProductClassId(Integer productClassId) {
		this.productClassId = productClassId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String detail;

    private String description;
}
