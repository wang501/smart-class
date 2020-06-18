package cn.java18.sys.service;

import cn.java18.sys.model.SysOrg;

import java.util.List;

public interface SysOrgService{


    int deleteByPrimaryKey(Integer orgId);

    int insert(SysOrg record);

    int insertSelective(SysOrg record);

    SysOrg selectByPrimaryKey(Integer orgId);

    int updateByPrimaryKeySelective(SysOrg record);

    int updateByPrimaryKey(SysOrg record);

    /**
     * 查找组织结构
     * @return
     */
    List<SysOrg> selOrgAll();

}
