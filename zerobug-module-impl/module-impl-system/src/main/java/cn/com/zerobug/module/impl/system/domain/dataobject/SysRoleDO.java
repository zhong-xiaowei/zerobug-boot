package cn.com.zerobug.module.impl.system.domain.dataobject;

import cn.com.zerobug.common.base.dataobject.TenantDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * 角色信息表
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@Data
@TableName("sys_role")
public class SysRoleDO extends TenantDO {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    @Size(max = 30, message = "角色名称长度不能超过30")
    private String  name;
    /**
     * 角色标识
     */
    @NotBlank(message = "角色权限字符串不能为空")
    @Size(max = 100, message = "角色权限字符串长度不能超过100")
    private String  code;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    private Integer dataScope;
    /**
     * 数据范围(指定部门数组)
     */
    @Size(max = 500)
    private String  dataScopeDeptIds;
    /**
     * 角色状态（0正常 1停用）
     */
    @PositiveOrZero(message = "角色状态不正确")
    private Integer status;
    /**
     * 角色类型
     */
    @NotNull(message = "角色类型不能为空")
    private Integer type;

}
