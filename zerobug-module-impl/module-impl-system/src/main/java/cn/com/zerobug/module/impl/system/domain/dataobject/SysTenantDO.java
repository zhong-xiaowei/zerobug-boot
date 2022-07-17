package cn.com.zerobug.module.impl.system.domain.dataobject;

import cn.com.zerobug.common.base.dataobject.TenantDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * 租户 实体类
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@Data
@TableName("sys_tenant")
public class SysTenantDO extends TenantDO {

    private static final long serialVersionUID = 1L;

    /**
     * 租户名称
     */
    @NotBlank(message = "租户名不能为空")
    @Size(max = 100, message = "租户名长度不能超过100")
    private String  name;
    /**
     * 联系人
     */
    @NotBlank(message = "联系人不能为空")
    @Size(max = 100, message = "联系人长度不能超过100")
    private String  contactName;
    /**
     * 联系手机
     */
    @Size(max = 30)
    private String  contactMobile;
    /**
     * 租户状态（0正常 1停用）
     */
    @PositiveOrZero(message = "租户状态必须为0或者1")
    private Integer status;

}
