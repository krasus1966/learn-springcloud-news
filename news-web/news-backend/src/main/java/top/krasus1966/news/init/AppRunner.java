package top.krasus1966.news.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Krasus1966
 * @date 2020/11/15 15:13
 **/
@Component
@Slf4j
public class AppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        log.info("服务admin启动");
    }
}
