package top.krasus1966.news;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Krasus1966
 * @date 2020/11/6 23:53
 **/
@SpringBootApplication
@MapperScan("top.krasus1966.news.mapper")
public class BackendApp {
    public static void main(String[] args) {
        SpringApplication.run(BackendApp.class,args);
    }
}
