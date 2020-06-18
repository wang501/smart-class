package cn.java18.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java18.sys.model.SysUser;
import cn.java18.sys.mapper.SysUserMapper;
import cn.java18.sys.service.SysUserService;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(Integer userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<SysUser> selectAll(Integer pageNum, Integer pageSize,SysUser sysUser) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> sysUsers = sysUserMapper.selectAll();
        return new PageInfo<>(sysUsers);
    }

    @Override
    public SysUser selectByNameAndPwd(SysUser sysUser) {
        return sysUserMapper.selectByNameAndPwd(sysUser);
    }

}
