package cn.java18.sys.service;

import cn.java18.sys.model.SysRole;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SysRoleService{

    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRole record);

    boolean insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    PageInfo<SysRole> FindRoleMenus(Integer pageNum, Integer pageSize,SysRole sysRole);

    SysRole findRoleById(int roleId);
}
