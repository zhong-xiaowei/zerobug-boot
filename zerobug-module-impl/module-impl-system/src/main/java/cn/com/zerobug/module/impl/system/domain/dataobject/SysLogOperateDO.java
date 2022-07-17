package cn.com.zerobug.module.impl.system.domain.dataobject;

import cn.com.zerobug.common.base.dataobject.TenantDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 操作日志记录 实体类
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@Data
@TableName("sys_log_operate")
public class SysLogOperateDO extends TenantDO {

    private static final long serialVersionUID = 1L;

    /**
     * 追踪ID
     */
    @NotBlank
    @Size(max = 64)
    private String traceId;
    /**
     * 请求方法
     */
    private String requestMethod;
    /**
     * 请求路径
     */
    private String requestUrl;
    /**
     * 用户Id
     */
    @NotNull
    private Long   userId;
    /**
     * 请求者 ip
     */
    @Size(max = 50)
    private String requestIp;
    /**
     * 请求使用的 浏览器 UA
     */
    @Size(max = 200)
    private String requestUserAgent;

    /**
     * 方法作用描述
     */
    @Size(max = 500)
    private String description;

    /**
     * java类型路径
     */
    @NotBlank
    @Size(max = 255)
    private String javaClassPath;

    /**
     * Java 方法名
     */
    @NotBlank
    @Size(max = 512)
    private String javaMethod;

    /**
     * Java 方法的参数
     */
    @Size(max = 8000)
    private String javaMethodArgs;

    /**
     * 操作时间
     */
    @NotNull
    private Date startTime;

    /**
     * 执行时长
     */
    @NotNull
    private Integer duration;

    /**
     * 结果码
     */
    @NotNull
    private Integer resultCode;

    /**
     * 结果提示
     */
    @Size(max = 512)
    private String resultMsg;

    /**
     * 结果数据
     */
    @Size(max = 4000)
    private String resultData;


}
