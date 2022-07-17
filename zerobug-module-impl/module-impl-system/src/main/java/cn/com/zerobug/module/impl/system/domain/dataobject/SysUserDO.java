package cn.com.zerobug.module.impl.system.domain.dataobject;

import cn.com.zerobug.common.base.dataobject.TenantDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * 用户信息 实体类
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@Data
@TableName("sys_user")
public class SysUserDO extends TenantDO {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @Size(max = 64, message = "用户账号长度不能超过64")
    @NotEmpty(message = "用户账号不能为空")
    private String  username;
    /**
     * 密码
     */
    @Size(max = 100, message = "密码长度不能超过100")
    private String  password;
    /**
     * 用户姓名
     */
    @Size(max = 100, message = "用户昵称长度不能超过100")
    private String  nickname;
    /**
     * 部门id
     */
    private Long    deptId;
    /**
     * 用户邮箱
     */
    @Size(max = 100, message = "用户邮箱长度不能超过100")
    @Email(message = "邮箱格式不正确")
    private String  email;
    /**
     * 手机号码
     */
    @Size(max = 11, message = "手机格式不正确")
    private String  mobile;
    /**
     * 用户性别
     */
    @PositiveOrZero
    private Integer gender;
    /**
     * 头像地址
     */
    @Size(max = 200)
    private String  avatar;
    /**
     * 帐号状态（0正常 1停用）
     */
    @PositiveOrZero(message = "状态不正确")
    private Integer status;

}
