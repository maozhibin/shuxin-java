package com.baoquan.shuxin.service.spi.admin;

import java.util.List;
import java.util.Map;

import com.baoquan.shuxin.model.admin.AdminMenu;
import com.baoquan.shuxin.web.vo.auth.MenuVO;

/**
 * Desc:
 * Created by yongj on 7/18/2017,
 */
public interface AdminMenuService {
    AdminMenu queryById(Long id);

    List<AdminMenu> queryAllEffective();

    AdminMenu queryByUri(String uri);

    List<AdminMenu> query(Integer status, Integer isdir, Integer display);

    Map<Long, MenuVO> queryEffectiveMenuTree();

    Map<Long, MenuVO> buildMenuVOMap(List<AdminMenu> menuList);

}
