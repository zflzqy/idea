package com.ssm.di.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    public void doBefore(JoinPoint joinPoint){
        System.out.println("xml配置方式"+joinPoint.getSignature().getName());
    }

    public void doLog(ProceedingJoinPoint proceedingJoinPoint){
        try {
            proceedingJoinPoint.proceed();//推进方法执行
            System.out.println("xml配置方式执行了aop编程");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
