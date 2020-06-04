package cn.java18.sys.service.impl;

import org.springframework.stereotype.Service;
import cn.java18.sys.model.SysMenu;
import cn.java18.sys.mapper.SysMenuMapper;
import cn.java18.sys.service.SysMenuService;
import javax.annotation.Resource;


@Service
public class SysMenuServiceImpl implements SysMenuService{

   @Resource
   private SysMenuMapper sysMenuMapper;

    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return sysMenuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public int insert(SysMenu record) {
        return sysMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysMenu record) {
        return sysMenuMapper.insertSelective(record);
    }

    @Override
    public SysMenu selectByPrimaryKey(Integer menuId) {
        return sysMenuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKey(record);
    }

}
