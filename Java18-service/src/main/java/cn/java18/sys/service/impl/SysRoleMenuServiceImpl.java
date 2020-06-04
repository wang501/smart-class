package cn.java18.sys.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java18.sys.model.SysRoleMenu;
import cn.java18.sys.mapper.SysRoleMenuMapper;
import cn.java18.sys.service.SysRoleMenuService;
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService{

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public int deleteByPrimaryKey(Integer srmId) {
        return sysRoleMenuMapper.deleteByPrimaryKey(srmId);
    }

    @Override
    public int insert(SysRoleMenu record) {
        return sysRoleMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRoleMenu record) {
        return sysRoleMenuMapper.insertSelective(record);
    }

    @Override
    public SysRoleMenu selectByPrimaryKey(Integer srmId) {
        return sysRoleMenuMapper.selectByPrimaryKey(srmId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRoleMenu record) {
        return sysRoleMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRoleMenu record) {
        return sysRoleMenuMapper.updateByPrimaryKey(record);
    }

}
