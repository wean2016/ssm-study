package cn.wean2016.aspect;

import cn.wean2016.bean.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by hasee on 2017/7/14.
 */

@Aspect
@Component
public class PermAspect {

    @Pointcut(value = "execution(* cn.wean2016.service.serviceImpl.UserServiceImpl.*(..))")
    public void anyMethod(){
    }

    @Around(value = "anyMethod()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        // 获得拦截业务方法的参数
        Object[] args = proceedingJoinPoint.getArgs();

        System.out.println("环绕通知---前----传递的参数---"+args);

        Object result = null;
        User user = null;

        try {
            // 执行业务方法，也可以使用无参数，返回值就是业务方法的返回值
            proceedingJoinPoint.proceed(args);
        } catch (Throwable e){
            System.out.println("发生了异常-----------");
            e.printStackTrace();
            System.out.println("结束异常---------");
        }
        System.out.println("环绕通知--------后------返回值----"+user);

        return result;
    }
    @Before(value = "anyMethod()")
    public void before(){

    }
}
