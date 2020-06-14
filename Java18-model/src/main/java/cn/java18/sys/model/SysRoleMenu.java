package cn.java18.sys.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class SysRoleMenu implements Serializable {
    private Integer menuId;
    private Integer menuPid;
    private String menuName;
    private Integer checked;
}