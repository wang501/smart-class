package cn.java18.sys.mapper;

import cn.java18.sys.model.SysOrg;

import java.util.List;

public interface SysOrgMapper {
    int deleteByPrimaryKey(Integer orgId);

    int insert(SysOrg record);

    int insertSelective(SysOrg record);

    SysOrg selectByPrimaryKey(Integer orgId);

    int updateByPrimaryKeySelective(SysOrg record);

    int updateByPrimaryKey(SysOrg record);

    List<SysOrg> selOrgAll();
}