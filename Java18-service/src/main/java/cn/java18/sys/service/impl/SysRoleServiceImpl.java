package cn.java18.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java18.sys.mapper.SysRoleMapper;
import cn.java18.sys.model.SysRole;
import cn.java18.sys.service.SysRoleService;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer roleId) {
        return sysRoleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int insert(SysRole record) {
        return sysRoleMapper.insert(record);
    }

    @Override
    public boolean insertSelective(SysRole record) {
        return sysRoleMapper.insertSelective(record) > 0 ? true : false;
    }

    @Override
    public SysRole selectByPrimaryKey(Integer roleId) {
        return sysRoleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRole record) {
        return sysRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<SysRole> FindRoleMenus(Integer pageNum, Integer pageSize,SysRole sysRole) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysRole> sysRoles = sysRoleMapper.selRoleMenus(sysRole);
        return new PageInfo<>(sysRoles);
    }

    @Override
    public SysRole findRoleById(int roleId) {
        return sysRoleMapper.findRoleById(roleId);
    }


}
