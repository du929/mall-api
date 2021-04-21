package xyz.zfdu.mall.api.config.annotation;

import java.lang.annotation.*;

/**
 * @author zfdu
 * @description
 * @data 2021-04-21
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenToMallUser {
    /**
     *  当前用户在request中的名字
     *  @return String
     */
    String value() default "user";
}
