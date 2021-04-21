package xyz.zfdu.mall.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DuZeFeng
 */
@SpringBootApplication
@MapperScan(basePackages = {"xyz.zfdu.mall.api.mapper"})
public class MallApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApiApplication.class, args);
    }

}
