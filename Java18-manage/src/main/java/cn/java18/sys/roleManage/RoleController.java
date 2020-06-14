package cn.java18.sys.roleManage;

import cn.java18.sys.model.SysRole;
import cn.java18.sys.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController {

    @Resource
    private SysRoleService roleService;

    @RequestMapping("roleList")
    @ResponseBody
    public Map<String,Object> roleList(Integer pageNum,Integer pageSize,SysRole sysRole){

        if(sysRole.getRoleStatus() == -1){
            sysRole.setRoleStatus(null);
        }
        PageInfo<SysRole> pageInfo = roleService.FindRoleMenus(pageNum, pageSize,sysRole);
        HashMap<String, Object> oom = new HashMap<>();
        long total = pageInfo.getTotal();
        List<SysRole> list = pageInfo.getList();
        if (pageInfo != null){
            oom.put("code",0);
            oom.put("msg","数据运行正常");
            oom.put("count",total);
            oom.put("data",list);
        }else{
            oom.put("code",-1);
            oom.put("msg","数据上传失败");
        }
        return oom;
    }
    @PostMapping(value = "roleAdd")
    @ResponseBody
    public Map<String,Object> roleAdd(SysRole role,String role_name,String role_explain){
        role.setRoleCdate(new Date());
        role.setRoleName(role_name);
        role.setRoleExplain(role_explain);
        HashMap<String, Object> oom = new HashMap<>();
        oom.put("status",-1);
        oom.put("message","添加失败");
        boolean b = roleService.insertSelective(role);
        if (b){
            oom.put("status",1);
            oom.put("message","添加成功");
        }
        return oom;
    }
    @GetMapping("roleDo")
    @ResponseBody
    public Map<String,Object> roleDo(Integer roleId){
        SysRole role = roleService.findRoleById(roleId);
        HashMap<String, Object> oom = new HashMap<>();
        if (role == null){
            oom.put("status",-1);
            oom.put("message","查找失败");
        }else {
            oom.put("status",1);
            oom.put("message","成功");
            oom.put("roleId",role.getRoleId());
            oom.put("roleName",role.getRoleName());
            oom.put("roleExplain",role.getRoleExplain());
        }
        return oom;
    }

    @PostMapping("roleEdit")
    @ResponseBody
    public Map<String,Object> roleEdit(Integer role_id,String role_name,String role_explain){
        SysRole sysRole = new SysRole();
        sysRole.setRoleId(role_id);
        System.out.println(sysRole.getRoleId());
        sysRole.setRoleName(role_name);
        System.out.println(sysRole.getRoleName());
        sysRole.setRoleExplain(role_explain);
        System.out.println(sysRole.getRoleExplain());
        sysRole.setRoleEdate(new Date());
        int i = roleService.updateByPrimaryKeySelective(sysRole);
        HashMap<String, Object> oom = new HashMap<>();
        if (i == 0){
            oom.put("status",-1);
            oom.put("message","修改失败");
        }else {
            oom.put("status",1);
            oom.put("message","修改成功");
        }
        return  oom;
    }

    @RequestMapping("roleDel")
    @ResponseBody
    public Map<String,Object> roleDel(Integer roleId){
        HashMap<String, Object> oom = new HashMap<>();
        if (roleService.deleteByPrimaryKey(roleId) == 0){
            oom.put("message","删除失败");
            oom.put("status",-1);
        }else {
            oom.put("message","删除成功");
            oom.put("status",1);
        }
        return oom;
    }
    @PostMapping("roleStatus")
    @ResponseBody
    public Map<String,Object> roleEdit(Integer roleId,Integer roleStatus){
        SysRole sysRole = new SysRole();
        sysRole.setRoleId(roleId);
        sysRole.setRoleStatus(roleStatus);
        sysRole.setRoleEdate(new Date());
        int i = roleService.updateByPrimaryKeySelective(sysRole);
        HashMap<String, Object> oom = new HashMap<>();
        if (i == 0){
            oom.put("status",-1);
            oom.put("message","停用失败");
        }else {
            oom.put("status",1);
            if (roleStatus == 0){
                oom.put("message","已启用");
            }else {
                oom.put("message","已停用");
            }
        }
        return  oom;
    }
}
