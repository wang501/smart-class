package cn.java18.sys.roleManage;

import cn.java18.sys.model.SysRole;
import cn.java18.sys.service.SysMenuService;
import cn.java18.sys.service.SysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Resource
    private SysRoleService roleService;

    @RequestMapping("roleList")
    @ResponseBody
    public HashMap<String,Object> roleList(){
        List<SysRole> sysRoles = roleService.FindRoleMenus();
        HashMap<String, Object> oom = new HashMap<>();
        oom.put("code",0);
        oom.put("msg","数据运行正常");
        oom.put("count",sysRoles.size());
        oom.put("data",sysRoles);
        return oom;
    }
}
