package cn.java18.sys.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java18.sys.model.SysOrg;
import cn.java18.sys.mapper.SysOrgMapper;
import cn.java18.sys.service.SysOrgService;

@Service
public class SysOrgServiceImpl implements SysOrgService{

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Override
    public int deleteByPrimaryKey(Integer orgId) {
        return sysOrgMapper.deleteByPrimaryKey(orgId);
    }

    @Override
    public int insert(SysOrg record) {
        return sysOrgMapper.insert(record);
    }

    @Override
    public int insertSelective(SysOrg record) {
        return sysOrgMapper.insertSelective(record);
    }

    @Override
    public SysOrg selectByPrimaryKey(Integer orgId) {
        return sysOrgMapper.selectByPrimaryKey(orgId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysOrg record) {
        return sysOrgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysOrg record) {
        return sysOrgMapper.updateByPrimaryKey(record);
    }

}
