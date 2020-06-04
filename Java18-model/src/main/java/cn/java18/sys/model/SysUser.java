package cn.java18.sys.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SysUser implements Serializable {
    private Integer userId;

    /**
    * 真实姓名
    */
    private String userName;

    /**
    * 手机号
    */
    private String userPhone;

    /**
    * 工号/学号
    */
    private Integer userNo;

    private String userPwd;

    /**
    * 组织结构
    */
    private Integer orgPid;

    /**
    * 角色id
    */
    private Integer rolePid;

    /**
    * 0,正常 1,禁用
    */
    private Integer userStatus;

    /**
    * 0,正常 1.已删除
    */
    private Integer userDelFlag;

    private Integer userCuid;

    private Date userCdate;

    private Integer userEuid;

    private Date userEdate;

    private static final long serialVersionUID = 1L;
}