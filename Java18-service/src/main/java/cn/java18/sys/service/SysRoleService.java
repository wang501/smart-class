package cn.java18.sys.service;

import cn.java18.sys.model.SysRole;

import java.util.List;

public interface SysRoleService{

    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> FindRoleMenus();
}
