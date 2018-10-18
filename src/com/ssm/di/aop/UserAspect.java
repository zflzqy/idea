package com.ssm.di.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component  // 为了让spring能扫描得到
@Aspect   // 声明切面
public class UserAspect {
    // 声明切点 *所有方法是（..）
    @Pointcut(value = "execution(* com.ssm.di.service.*.*(..))")
    public  void pointCut(){}

    // 拦截执行方法之前 // pointCut()等同于execution(* com.ssm.di.service.*.*(..))
    @Before(value = "pointCut())")
    public void doBefore(JoinPoint joinPoint){
        // JoinPoint连接点，程序执行的点，相当于程序的方法
        // 拿到了方法的名称
        String name = joinPoint.getSignature().getName();
        System.out.println(name);
        // 拿到了方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println(args.toString());
    }

    // 拦截方法执行之后
    @After(value = "pointCut()")
    public void doAfter(JoinPoint joinPoint){
        // 拿到了方法的名称
        String name = joinPoint.getSignature().getName();
        System.out.println(name);
    }

    // 拦截在方法返回了返回值之后 注解的result必须与参数result一致
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println("这是在拦截返回值之后："+result);
    }

//    // 在方法抛异常的时候执行
//    @AfterThrowing
//    public void aflterThrowing(){
//
//    }
    // 环绕整个方法的执行
    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        // proceedingJoinPoint推进连接点
        try {
            proceedingJoinPoint.proceed();// 如果不调用，这个方法将会卡死，推进方法执行
            System.out.println("这是环绕方法");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
