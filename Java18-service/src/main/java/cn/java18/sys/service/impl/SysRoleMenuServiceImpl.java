package cn.java18.sys.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java18.sys.model.SysRoleMenu;
import cn.java18.sys.mapper.SysRoleMenuMapper;
import cn.java18.sys.service.SysRoleMenuService;

import java.util.List;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService{

    @Resource
    private SysRoleMenuMapper sysRoleMenu;

    @Override
    public List<SysRoleMenu> listByRolePidRoleMenus(Integer rolePid) {
        return sysRoleMenu.listByRolePidRoleMenus(rolePid);
    }

    @Override
    public int roleGrant(Integer roleId, List<Integer> menuIds) {
        sysRoleMenu.deleteRoleMenuByRolePid(roleId);
        int i = 0;
        if (menuIds.size()>0){
            i = sysRoleMenu.insertByList(roleId,menuIds);
        }
        return i;
    }

    @Override
    public List<Integer> selMenuIdByRoleId(Integer roleId) {
        return sysRoleMenu.selMenuIdByRoleId(roleId);
    }
}
