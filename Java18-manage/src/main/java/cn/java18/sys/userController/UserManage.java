package cn.java18.sys.userController;

import cn.java18.sys.model.SysUser;
import cn.java18.sys.service.SysUserService;
import cn.java18.utils.RestBean;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserManage {
    @Resource
    private SysUserService userService;
    @RequestMapping("userList")
    public Map<String,Object> userList(Integer pageNum, Integer pageSize,SysUser sysUser){
        PageInfo<SysUser> pageInfo = userService.selectAll(pageNum, pageSize,sysUser);
        long total = pageInfo.getTotal();
       List<SysUser> sysUsers =  pageInfo.getList();
        Map<String, Object> oom = RestBean.getMapPara();
        oom.put(RestBean.CODE,0);
        oom.put(RestBean.MSG,"数据展示成功");
        oom.put(RestBean.COUNT,total);
        oom.put(RestBean.DATA,sysUsers);
        return oom;
    }
    @RequestMapping("userAdd")
    public Map<String,Object> userAdd(SysUser sysUser,String user_name,String user_no,String user_phone
    ,String user_pwd,String rePassword){
        sysUser.setUserName(user_name);
        sysUser.setUserNo(Integer.parseInt(user_no));
        sysUser.setUserPhone(user_phone);
        sysUser.setUserCdate(new Date());
        Map<String, Object> oom = RestBean.getMapPara();
       int i = 0;
        if (user_pwd.equals(rePassword)){
            sysUser.setUserPwd(user_pwd);
            i = userService.insertSelective(sysUser);
        }else {
            oom.put(RestBean.MSG,"两次密码不一致");
        }
        if (i>0){
            oom.put(RestBean.CODE,0);
            oom.put(RestBean.MSG,"添加成功");
        }else {
            oom.put(RestBean.CODE,1);
            oom.put(RestBean.MSG,"添加失败");
        }
        return oom;
    }
    @RequestMapping("userDel")
    public Map<String,Object> userDel(Integer userId){
        int i = userService.deleteByPrimaryKey(userId);
        Map<String, Object> oom = RestBean.getMapPara();
        if (i>0){
            oom.put(RestBean.CODE,0);
            oom.put(RestBean.MSG,"删除成功");
        }else {
            oom.put(RestBean.CODE,1);
            oom.put(RestBean.MSG,"删除失败");
        }
        return  oom;
    }
    @PutMapping("userUpdate")
    public Map<String, Object> userUpdate(SysUser sysUser){
        int i = userService.updateByPrimaryKeySelective(sysUser);
        Map<String, Object> oom = RestBean.getMapPara();
        if (i>0){
            oom.put(RestBean.MSG,"更新成功");
            oom.put(RestBean.CODE,0);
        }
        return oom;
    }

}
