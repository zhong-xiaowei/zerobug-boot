package cn.com.zerobug.module.impl.system.domain.dataobject;

import cn.com.zerobug.common.base.dataobject.TenantDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * 部门数据实体
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@Data
@TableName("sys_dept")
public class SysDeptDO extends TenantDO {

    private static final long serialVersionUID = 1L;

    /**
     * 部门名称
     */
    @Size(max = 100, message = "部门名称长度不能超过100")
    @NotEmpty(message = "部门名称不能为空")
    private String  name;
    /**
     * 父部门ID
     */
    @PositiveOrZero
    private Long    parentId;
    /**
     * 显示顺序
     */
    @PositiveOrZero
    private Integer sort;
    /**
     * 负责人
     */
    @PositiveOrZero
    private Long    leaderUserId;
    /**
     * 联系电话
     */
    @Size(max = 11, message = "联系电话长度不能超过11")
    @NotEmpty(message = "联系电话不能为空")
    private String  phone;
    /**
     * 邮箱
     */
    @Size(max = 100, message = "邮箱长度不能超过100")
    @Email(message = "邮箱格式不正确")
    private String  email;
    /**
     * 部门状态:0正常,1停用
     */
    @PositiveOrZero(message = "部门状态不正确")
    private Integer status;

}
