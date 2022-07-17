package cn.com.zerobug.module.impl.system.domain.dataobject;

import cn.com.zerobug.common.base.dataobject.TenantDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用户和角色关联 实体对象
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@Data
@TableName("sys_user_role")
public class SysUserRoleDO extends TenantDO {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long userId;
    /**
     * 角色ID
     */
    @NotNull(message = "角色ID不能为空")
    private Long roleId;

}
