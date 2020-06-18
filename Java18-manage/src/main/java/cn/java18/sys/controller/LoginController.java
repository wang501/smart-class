package cn.java18.sys.controller;

import cn.java18.sys.model.SysUser;
import cn.java18.sys.service.SysRoleMenuService;
import cn.java18.sys.service.SysUserService;
import cn.java18.utils.RestBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {

    @Resource
    private SysUserService userService;

    @Resource
    private SysRoleMenuService sysRoleMenuService;

    @RequestMapping("loginUser")
    @ResponseBody
    public Map<String,Object> loginUser(SysUser sysUser, String username, String password,  HttpSession session){
        sysUser.setUserName(username);
        sysUser.setUserPwd(password);
        SysUser user = userService.selectByNameAndPwd(sysUser);
        Map<String, Object> oom = RestBean.getMapPara();
        if (user !=null){
            //加载权限menuId
            List<Integer> menuIdList = sysRoleMenuService.selMenuIdByRoleId(user.getRolePid());
            System.out.println(menuIdList);
            session.setAttribute(user.getUserName(),menuIdList);

            oom.put(RestBean.MSG,"登录成功");
            oom.put(RestBean.CODE,0);
            session.setAttribute("data",user);
        }else {
            oom.put(RestBean.CODE,1);
            oom.put(RestBean.MSG,"用户名或密码错误");
        }
        return oom;
    }

    @GetMapping("logout")
    public String logOut(HttpSession session){

        session.removeAttribute("data");
        return "redirect:/login.html";
    }
}
