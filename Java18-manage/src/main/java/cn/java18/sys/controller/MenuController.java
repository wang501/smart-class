package cn.java18.sys.controller;


import cn.java18.sys.model.SysMenu;
import cn.java18.sys.service.SysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("menuList")
public class MenuController {

    @Resource
    private SysMenuService menuService;

    @RequestMapping("menus")
    @ResponseBody
    public List<SysMenu> menuList(){
        return  menuService.findSysMenus();
    }
}
