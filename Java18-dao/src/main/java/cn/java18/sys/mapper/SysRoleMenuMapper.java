package cn.java18.sys.mapper;

import cn.java18.sys.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SysRoleMenuMapper {
    List<SysRoleMenu> listByRolePidRoleMenus(Integer rolePid);
    int insertByList(@Param("rolePid") Integer roleId, @Param("menuPids") List<Integer> menuIds);
    int deleteRoleMenuByRolePid(Integer rolePid);

    /**
     * 根据角色ID 获取对应菜单id集合
     * @param roleId
     * @return
     */
    List<Integer> selMenuIdByRoleId(Integer roleId);
}