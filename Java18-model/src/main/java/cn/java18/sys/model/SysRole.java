package cn.java18.sys.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SysRole implements Serializable {
    private Integer roleId;

    /**
    * 角色名称
    */
    private String roleName;

    /**
    * 0,用户自定义.1系统内置的
    */
    private Integer roleDefault;

    /**
    * 0,有效.1.禁用
    */
    private Integer roleStatus;

    private String roleExplain;

    /**
    * 创建人id
    */
    private Integer roleCuid;

    /**
    * 创建时间
    */
    private Date roleCdate;

    /**
    * 最后修改人
    */
    private Integer roleEuid;

    private Date roleEdate;

    private static final long serialVersionUID = 1L;
}