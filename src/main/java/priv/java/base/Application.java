package priv.java.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author huangxunhui
 * Date: Created in 2019-03-12 11:29
 * Utils: Intellij Idea
 * Description: 启动类
 */
/* dao 接口实例化，通过反射 */
@MapperScan(basePackages = "priv.java.base.access.module.**.dao")
/* 普通Bean的实例化 */
@ComponentScan("priv.java.base.*")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
