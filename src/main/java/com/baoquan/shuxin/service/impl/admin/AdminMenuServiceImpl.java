package com.baoquan.shuxin.service.impl.admin;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.admin.AdminMenuDao;
import com.baoquan.shuxin.model.admin.AdminMenu;
import com.baoquan.shuxin.service.spi.admin.AdminMenuService;
import com.baoquan.shuxin.web.vo.admin.auth.MenuVO;

/**
 * Desc:
 * Created by yongj on 7/18/2017,
 */
@Named
public class AdminMenuServiceImpl implements AdminMenuService {

    @Inject
    private AdminMenuDao adminMenuDao;

    public AdminMenu queryById(Long id) {
        return adminMenuDao.queryById(id);
    }

    public List<AdminMenu> queryAllEffective() {
        return adminMenuDao.queryAllEffective();
    }

    public AdminMenu queryByUri(String uri) {
        return adminMenuDao.queryByUri(uri);
    }

    public Map<Long, MenuVO> queryEffectiveMenuTree() {
        List<AdminMenu> menuList = adminMenuDao.queryAllEffective();
        Map<Long, MenuVO> menuVOMap = buildMenuVOMap(menuList);
        return menuVOMap;
    }

    public Map<Long, MenuVO> buildMenuVOMap(List<AdminMenu> menuList) {
        Map<Long, MenuVO> menuVOMap = new TreeMap<>();
        for (AdminMenu menu : menuList) {
            MenuVO vo = buildMenuVO(menu);
            menuVOMap.put(vo.getId(), vo);
        }
        for (AdminMenu menu : menuList) {
            MenuVO parent = menuVOMap.get(menu.getParentId());
            if (parent != null) {
                Map<Long, MenuVO> children = parent.getChildren();
                if (children == null) {
                    parent.setChildren(new TreeMap<Long, MenuVO>());
                    children = parent.getChildren();
                }
                children.put(menu.getId(), menuVOMap.get(menu.getId()));
            }
        }
        Map<Long, MenuVO> rootMenuMap = new TreeMap<>();
        for (MenuVO menu : menuVOMap.values()) {
            MenuVO parent = menuVOMap.get(menu.getParentId());
            if (parent == null) {
                rootMenuMap.put(menu.getId(), menu);
            }
        }
        return rootMenuMap;
    }

    private MenuVO buildMenuVO(AdminMenu menu) {
        MenuVO vo = new MenuVO();
        vo.setId(menu.getId());
        vo.setName(menu.getName());
        vo.setUri(menu.getUri());
        vo.setIco(menu.getIco());
        vo.setParentId(menu.getParentId());
        return vo;
    }
}
