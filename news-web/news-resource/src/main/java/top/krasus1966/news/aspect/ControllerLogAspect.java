package top.krasus1966.news.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Krasus1966
 * @date 2020/11/26 23:21
 **/
@Aspect
@Component
@Slf4j
public class ControllerLogAspect {

    /**
     * AOP通知：
     * 1. 前置通知
     * 2. 后置通知
     * 3. 环绕通知
     * 4. 异常通知
     * 5. 最终通知
     */
    @Around("execution(* top.krasus1966.*.controller..*.*(..))")
    public Object recordTimeOfService(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("===开始执行 {}.{} ===",joinPoint.getTarget().getClass(),joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long takeTime = end - start;
        if (takeTime > 3000){
            log.error("当前执行耗时:{}ms",takeTime);
        }else if (takeTime >2000){
            log.warn("当前执行耗时:{}ms",takeTime);
        }else{
            log.info("当前执行耗时:{}ms",takeTime);
        }
        log.info("===执行结束 {}.{} ===",joinPoint.getTarget().getClass(),joinPoint.getSignature().getName());
        return result;
    }
}
