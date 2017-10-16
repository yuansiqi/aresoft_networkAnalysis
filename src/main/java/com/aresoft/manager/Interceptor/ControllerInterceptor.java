package com.aresoft.manager.Interceptor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**拦截器：记录用户操作日志，检查用户是否登录……
 * Created by yuans on 2017/9/24.
 */
@Aspect
@Component
public class ControllerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);
    /**
     * 定义拦截规则：拦截* com.aresoft.*.controller..*(..)) 包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(* com.aresoft.*.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping) ")
    public void executeService() {

    }

    @Before("executeService()")
    public void before()
    {
        System.out.println("before");
     }

    @AfterReturning("executeService()")
    public void after()
    {
        System.out.println("after");
    }

}