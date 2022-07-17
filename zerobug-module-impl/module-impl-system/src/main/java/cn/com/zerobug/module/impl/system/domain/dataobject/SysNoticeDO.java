package cn.com.zerobug.module.impl.system.domain.dataobject;

import cn.com.zerobug.common.base.dataobject.TenantDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 通知公告 实体类
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@Data
@TableName("sys_notice")
public class SysNoticeDO extends TenantDO {

    private static final long serialVersionUID = 1L;

    /**
     * 公告标题
     */
    @NotBlank(message = "公告标题不能为空")
    @Size(max = 100, message = "公告标题长度不能超过100")
    private String  title;
    /**
     * 公告内容
     */
    @NotNull(message = "公告内容不能为空")
    private String  content;
    /**
     * 公告类型（1通知 2公告）
     */
    @NotNull(message = "公告类型不能为空")
    private Integer noticeType;
    /**
     * 公告状态（0正常 1关闭）
     */
    @NotNull(message = "公告状态不能为空")
    private Integer status;

}
