package top.krasus1966.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Krasus1966
 * @date 2020/11/15 15:10
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ResourceApp {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApp.class,args);
    }
}
