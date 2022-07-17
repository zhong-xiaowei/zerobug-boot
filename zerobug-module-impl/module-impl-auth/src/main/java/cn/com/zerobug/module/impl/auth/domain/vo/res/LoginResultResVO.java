package cn.com.zerobug.module.impl.auth.domain.vo.res;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录结果
 *
 * @author zhongxiaowei
 * @date 2022/3/13
 */
@Data
public class LoginResultResVO implements Serializable {

    private static final long serialVersionUID = -7879201240327635241L;

    /**
     * 访问token
     */
    private String accessToken;
    /**
     * 刷新token
     */
    private String refreshToken;
    /**
     * 访问token过期时间
     */
    private Long   expiresIn;

}
