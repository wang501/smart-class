package cn.java18.sys.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class SysRoleMenu implements Serializable {
    private Integer srmId;

    /**
    * 关联角色主键
    */
    private Integer rolePid;

    /**
    * 关联菜单主键
    */
    private Integer menuPid;

    private static final long serialVersionUID = 1L;
}