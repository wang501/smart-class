package cn.java18.sys.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class SysMenu implements Serializable {
    /**
    * 菜单名称
    */
    private Integer menuId;

    /**
    * 菜单名称
    */
    private String menuName;

    /**
    * 关联自身id
    */
    private Integer menuPid;

    /**
    * 第一位,补位.之后每三位代表一个级别菜单编号
    */
    private String menuNo;

    /**
    * 菜单连接
    */
    private String menuUrl;

    /**
    * 0,本系统.1外联
    */
    private Integer menuTarget;

    /**
    * 菜单图标小
    */
    private String menuMinIco;

    /**
    * 菜单图标大
    */
    private String menuMaxIco;

    /**
    * 0,显示型菜单.1非显示型菜单
    */
    private Integer menuShow;

    /**
    * 菜单排序
    */
    private Integer menuOrder;

    private static final long serialVersionUID = 1L;
}