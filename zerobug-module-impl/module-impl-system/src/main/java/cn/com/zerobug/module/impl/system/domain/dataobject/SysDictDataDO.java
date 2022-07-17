package cn.com.zerobug.module.impl.system.domain.dataobject;

import cn.com.zerobug.common.base.dataobject.TenantDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * 字典数据 实体类
 *
 * @author zhongxiaowei
 * @since 2022-04-06
 */
@Data
@TableName("sys_dict_data")
public class SysDictDataDO extends TenantDO {

    private static final long serialVersionUID = 1L;

    /**
     * 字典编码
     */
    private Integer sort;
    /**
     * 字典标签
     */
    @NotBlank(groups = CreateGroup.class, message = "字典标签不能为空")
    @Size(max = 100, message = "字典标签长度不能超过100")
    private String  label;
    /**
     * 字典键值
     */
    @NotBlank(groups = CreateGroup.class, message = "字典键值不能为空")
    @Size(max = 100, message = "字典键值长度不能超过100")
    private String  value;
    /**
     * 字典类型
     */
    @Size(max = 100, message = "字典类型长度不能超过100")
    private String  dictType;
    /**
     * 状态（0正常 1停用）
     */
    @PositiveOrZero(message = "状态不正确")
    private Integer status;
    /**
     * 颜色类型
     */
    @Size(max = 100, message = "颜色类型长度不能超过100")
    private String  colorType;
    /**
     * css样式
     */
    @Size(max = 100, message = "css 样式长度不能超过100")
    private String  cssClass;

}
