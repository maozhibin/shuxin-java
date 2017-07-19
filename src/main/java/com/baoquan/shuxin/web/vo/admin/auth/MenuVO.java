package com.baoquan.shuxin.web.vo.admin.auth;

import java.util.Map;

/**
 * Desc:
 * Created by yongj on 7/18/2017,
 */
public class MenuVO {
    private Long id;
    private String name;
    private String uri;
    private String ico;
    private Map<Long, MenuVO> children;
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public Map<Long, MenuVO> getChildren() {
        return children;
    }

    public void setChildren(Map<Long, MenuVO> children) {
        this.children = children;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
