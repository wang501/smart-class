package cn.java18.sys.service;

import cn.java18.sys.model.SysOrg;
public interface SysOrgService{


    int deleteByPrimaryKey(Integer orgId);

    int insert(SysOrg record);

    int insertSelective(SysOrg record);

    SysOrg selectByPrimaryKey(Integer orgId);

    int updateByPrimaryKeySelective(SysOrg record);

    int updateByPrimaryKey(SysOrg record);

}
