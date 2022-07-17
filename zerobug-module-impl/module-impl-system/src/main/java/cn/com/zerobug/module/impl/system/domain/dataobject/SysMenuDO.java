package cn.com.zerobug.module.impl.system.domain.dataobject;

import cn.com.zerobug.common.base.dataobject.TenantDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * 菜单权限 实体类
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@Data
@TableName("sys_menu")
public class SysMenuDO extends TenantDO {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
    @NotBlank(message = "菜单名称不能为空")
    @Size(max = 50, message = "菜单名称长度不能超过50")
    private String  name;
    /**
     * 权限标识
     */
    @Size(max = 100, message = "权限标识长度不能超过100")
    private String  permission;
    /**
     * 菜单类型
     */
    private Integer menuType;
    /**
     * 层级
     */
    private Integer level;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 父菜单ID
     */
    private Long    parentId;
    /**
     * 路由地址
     */
    @Size(max = 200, message = "路由地址长度不能超过200")
    private String  path;
    /**
     * 菜单图标
     */
    @Size(max = 32, message = "菜单图标长度不能超过32")
    private String  icon;
    /**
     * 组件路径
     */
    @Size(max = 64, message = "组件路径长度不能超过64")
    private String  component;
    /**
     * 状态
     */
    @PositiveOrZero(message = "菜单状态不正确")
    private Integer status;
    /**
     * 是否外链 （0 否 1 是）
     */
    private Integer isLink;
    /**
     * 是否显示 （0 否 1 是）
     */
    private Integer isShow;
    /**
     * 是否缓存 （0 否 1 是）
     */
    private Integer isCache;

}
