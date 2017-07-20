package com.baoquan.shuxin.model.product;

import java.io.Serializable;

public class ProductInterface implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer productId;

    private String name;

    private String url;

    private String method;

    private Boolean free;

    private String character;

    private Integer timeout;

    private String responseFormat;

    private String reflectMethod;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character == null ? null : character.trim();
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getResponseFormat() {
        return responseFormat;
    }

    public void setResponseFormat(String responseFormat) {
        this.responseFormat = responseFormat == null ? null : responseFormat.trim();
    }

    public String getReflectMethod() {
        return reflectMethod;
    }

    public void setReflectMethod(String reflectMethod) {
        this.reflectMethod = reflectMethod == null ? null : reflectMethod.trim();
    }
}