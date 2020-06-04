package cn.java18.sys.service;

import cn.java18.sys.model.SysRoleMenu;
public interface SysRoleMenuService{


    int deleteByPrimaryKey(Integer srmId);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Integer srmId);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

}
