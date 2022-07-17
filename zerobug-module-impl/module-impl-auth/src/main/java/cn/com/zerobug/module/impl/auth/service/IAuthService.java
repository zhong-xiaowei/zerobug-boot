package cn.com.zerobug.module.impl.auth.service;

import cn.com.zerobug.component.security.model.AuthenticatedUser;
import cn.com.zerobug.module.impl.auth.domain.param.LoginActionParam;
import cn.com.zerobug.module.impl.auth.domain.vo.LoginResultVO;

/**
 * 认证服务，做登录相关操作
 *
 * @author zhongxiaowei
 * @date 2022/3/13
 */
public interface IAuthService {

    /**
     * 生成登录结果
     *
     * @param authenticatedUser
     * @return
     */
    LoginResultVO generateLoginResultVO(AuthenticatedUser authenticatedUser);

    /**
     * 用户名密码方式进行认证
     *
     * @param loginActionParam
     * @return
     */
    AuthenticatedUser loginByUsernamePassword(LoginActionParam loginActionParam);

}
