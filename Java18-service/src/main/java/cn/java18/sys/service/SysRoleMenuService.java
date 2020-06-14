package cn.java18.sys.service;

import cn.java18.sys.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysRoleMenuService{


    List<SysRoleMenu> listByRolePidRoleMenus(Integer rolePid);
    int roleGrant(Integer roleId,List<Integer> menuIds);

}
