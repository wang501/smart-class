package cn.java18.sys.orgController;


import cn.java18.sys.model.SysOrg;
import cn.java18.sys.service.SysOrgService;
import cn.java18.utils.RestBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("organization")
public class OrgManage {

    @Resource
    private SysOrgService sysOrgService;

    @RequestMapping("findOrgsAll")
    public Map<String,Object> findAll(){
        Map<String, Object> mapPara = RestBean.getMapPara();
        List<SysOrg> sysOrgs = sysOrgService.selOrgAll();
        mapPara.put(RestBean.CODE,0);
        mapPara.put(RestBean.MSG,"成功");
        mapPara.put(RestBean.DATA,sysOrgs);
        return mapPara;
    }
}
