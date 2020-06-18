package cn.java18.sys.roleManage;

import cn.java18.sys.model.SysRoleMenu;
import cn.java18.sys.service.SysMenuService;
import cn.java18.sys.service.SysRoleMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/roleMenus/roleMenu")
public class RoleMenuController {

    @Resource
    private SysRoleMenuService sysRoleMenuService;

    @GetMapping
    @ResponseBody
    public List<SysRoleMenu> listByRolePidRoleMenus(Integer roleId){
        return  sysRoleMenuService.listByRolePidRoleMenus(roleId);
    }
    @PostMapping
    @ResponseBody
    public Map<String,Integer> roleGrant(@RequestBody Map<String,Object> requestMap){
        String  roleId =(String) requestMap.get("roleId");
        List<Integer> menuIds = (List<Integer>) requestMap.get("menuIds");
        int i = sysRoleMenuService.roleGrant(Integer.parseInt(roleId), menuIds);
        Map<String, Integer> map = new HashMap<>();
        map.put("success",i);
        return  map;
    }

}
