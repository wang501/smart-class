package cn.java18.sys.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class SysOrg implements Serializable {
    private Integer orgId;

    /**
    * 组织结构名称
    */
    private String orgName;

    /**
    * 组织结构编号,第一位为补位1.每两位代表一级
    */
    private String orgNo;

    private Integer orgPid;

    /**
    * 状态 0正常 1.禁用
    */
    private Integer orgStatus;

    private static final long serialVersionUID = 1L;
}