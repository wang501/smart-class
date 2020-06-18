package cn.java18.sys.service;

import cn.java18.sys.model.SysUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SysUserService{


    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    PageInfo<SysUser> selectAll(Integer pageNum,Integer pageSize,SysUser sysUser);

    /**
     * 用户登录模块
     * @param sysUser
     * @return
     */
    SysUser selectByNameAndPwd(SysUser sysUser);
}
