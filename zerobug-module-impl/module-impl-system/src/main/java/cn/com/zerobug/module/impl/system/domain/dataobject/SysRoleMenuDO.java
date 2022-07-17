package cn.com.zerobug.module.impl.system.domain.dataobject;

import cn.com.zerobug.common.base.dataobject.TenantDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * 角色和菜单关联 实体类
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@Data
@Accessors(chain = true)
@TableName("sys_role_menu")
public class SysRoleMenuDO extends TenantDO {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @NotNull(message = "角色ID不能为空")
    private Long roleId;
    /**
     * 菜单ID
     */
    @NotNull(message = "菜单ID不能为空")
    private Long menuId;

}
