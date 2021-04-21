package xyz.zfdu.mall.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.zfdu.mall.api.common.Constants;
import xyz.zfdu.mall.api.config.handler.TokenToMallUserMethodArgumentResolver;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zfdu
 * @description WebMvc配置
 * @data 2021-04-21
 */
@Configuration
public class MallWebMvcConfigurer implements WebMvcConfigurer {
    @Resource
    private TokenToMallUserMethodArgumentResolver tokenToMallUserMethodArgumentResolver;
    /**
     * TokenToMallUser 注解处理方法
     *
     * @param argumentResolvers 参数解析器
     */

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(tokenToMallUserMethodArgumentResolver);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
        registry.addResourceHandler("/goods-img/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
    }
}
