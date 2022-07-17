package cn.com.zerobug.module.impl.system.domain.dataobject;

import cn.com.zerobug.common.base.dataobject.TenantDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 系统访问记录 实体类
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@Data
@TableName("sys_log_login")
public class SysLogLoginDO extends TenantDO {

    private static final long serialVersionUID = 1L;

    /**
     * 追踪ID
     */
    @NotBlank
    @Size(max = 64)
    private String  traceId;
    /**
     * 日志类型
     */
    @NotNull
    private Long    logType;
    /**
     * 用户id
     */
    @NotNull
    private Long    userId;
    /**
     * 用户类型
     */
    @NotNull
    private Integer userType;
    /**
     * 用户名
     */
    @NotBlank
    @Size(max = 50)
    private String  username;
    /**
     * 登录结果
     */
    @NotNull
    private Integer result;
    /**
     * 登录IP
     */
    @NotBlank
    @Size(max = 50)
    private String  userIp;
    /**
     * 浏览器 UA
     */
    @NotBlank
    @Size(max = 512)
    private String  userAgent;


}
