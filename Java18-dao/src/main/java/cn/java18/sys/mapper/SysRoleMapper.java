package cn.java18.sys.mapper;

import cn.java18.sys.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    /**
     * 根据条件查询角色列表
     * @param sysRole
     * @return
     */
    List<SysRole> selRoleMenus(SysRole sysRole);

    /**
     * 添加角色
     * @param record
     * @return
     */
    int insertSelective(SysRole record);

    SysRole findRoleById(Integer roleId);
}