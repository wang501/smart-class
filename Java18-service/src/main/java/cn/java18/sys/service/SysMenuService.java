package cn.java18.sys.service;

import cn.java18.sys.model.SysMenu;

import java.util.List;

public interface SysMenuService{

    int deleteByPrimaryKey(Integer menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> findSysMenus(Integer rolePid);

    /**
     * 根据id查询相应的菜单列表
     * @param menuId
     * @return
     */
    List<SysMenu> selSysMenusById(Integer menuId);

}
