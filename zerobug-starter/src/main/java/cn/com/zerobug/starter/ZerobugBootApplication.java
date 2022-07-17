package cn.com.zerobug.starter;

import cn.com.zerobug.common.base.ZerobugProperties;
import cn.com.zerobug.common.exception.GeneralException;
import cn.com.zerobug.module.impl.auth.AuthApplication;
import cn.com.zerobug.module.impl.system.SystemApplication;
import cn.hutool.core.util.StrUtil;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.net.InetAddress;

/**
 * @author zhongxiaowei
 * @date 2022/3/9
 */
@SpringBootApplication
@Import(value = {
        AuthApplication.class,
        SystemApplication.class
})
public class ZerobugBootApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ZerobugBootApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        bannerPrint(springApplication.run(args));
    }

    private static void bannerPrint(ConfigurableApplicationContext applicationContext) {
        try {
            ZerobugProperties properties     = applicationContext.getBean(ZerobugProperties.class);
            String            profilesActive = applicationContext.getEnvironment().getProperty("spring.profiles.active");
            String            hostAddress    = InetAddress.getLocalHost().getHostAddress();
            String            port           = applicationContext.getEnvironment().getProperty("server.port");
            String            contentPath    = applicationContext.getEnvironment().getProperty("server.servlet.context-path");
            StringBuilder     banner         = new StringBuilder();
            banner.append("\033[1;33m");
            banner.append("=========================================================================================\n");
            banner.append("                            /\\ \\                      /\\ \\                     /\\ \\__   \n");
            banner.append(" ____       __   _ __   ___ \\ \\ \\____   __  __     __ \\ \\ \\____    ___     ___ \\ \\ ,_\\  \n");
            banner.append("/\\_ ,`\\   /'__`\\/\\`'__\\/ __`\\\\ \\ '__`\\ /\\ \\/\\ \\  /'_ `\\\\ \\ '__`\\  / __`\\  / __`\\\\ \\ \\/  \n");
            banner.append("\\/_/  /_ /\\  __/\\ \\ \\//\\ \\L\\ \\\\ \\ \\L\\ \\\\ \\ \\_\\ \\/\\ \\L\\ \\\\ \\ \\L\\ \\/\\ \\L\\ \\/\\ \\L\\ \\\\ \\ \\_ \n");
            banner.append("  /\\____\\\\ \\____\\\\ \\_\\\\ \\____/ \\ \\_,__/ \\ \\____/\\ \\____ \\\\ \\_,__/\\ \\____/\\ \\____/ \\ \\__\\\n");
            banner.append("  \\/____/ \\/____/ \\/_/ \\/___/   \\/___/   \\/___/  \\/___L\\ \\\\/___/  \\/___/  \\/___/   \\/__/\n");
            banner.append("                                                   /\\____/                              \n");
            banner.append("                                                   \\_/__/        \n");
            banner.append(StrUtil.format("\t服务启动成功!~ \n"));
            banner.append(StrUtil.format("\t当前服务: {} 版 本: {} \n", properties.getApplicationInfo().getName(), properties.getApplicationInfo().getVersion()));
            banner.append(StrUtil.format("\tSpringBoot 框架版本: {}   当前配置环境: {}  \n", properties.getApplicationInfo().getSpringbootVersion(), profilesActive));
            banner.append(StrUtil.format("\t项目访问路径: http://{}:{}{} \n", hostAddress, port, contentPath));
            banner.append("=========================================================================================\n");
            banner.append("\033[5m");
            System.out.println(banner.toString());
        } catch (Exception e) {
            throw new GeneralException("banner打印失败: " + e.getMessage());
        }
    }

}
