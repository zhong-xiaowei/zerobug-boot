package cn.com.zerobug.module.impl.auth.domain.vo.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author zhongxiaowei
 * @date 2022/3/13
 */
@Data
public class LoginActionReqVO implements Serializable {

    private static final long serialVersionUID = 5816460618596633773L;

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;

}
