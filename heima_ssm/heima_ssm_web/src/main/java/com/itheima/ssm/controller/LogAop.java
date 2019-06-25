package com.itheima.ssm.controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;

    @Around("execution(* com.itheima.ssm.controller.*.*(..)) && !execution(* com.itheima.ssm.controller.SysLogController.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //访问时间
        Date visitTime = new Date();
        //执行的类
        Class<?> aClass = joinPoint.getTarget().getClass();

        //执行的方法
        String methodName = joinPoint.getSignature().getName();
        //获得访问方法的参数
        Object[] args = joinPoint.getArgs();

        Method method = null;
        if (args == null || args.length == 0) {
            method = aClass.getMethod(methodName);//只能获取无参数的方法
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = aClass.getMethod(methodName, classArgs);
        }

        Object proceed = joinPoint.proceed();

        //访问时长
        Long executionTime = new Date().getTime() - visitTime.getTime();

        //获得url
        String url = "";
        if (aClass != null && method != null && aClass != LogAop.class) {
            //1.获取类上的@RequestMapping("/orders")
            RequestMapping classAnnotation = aClass.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValues = classAnnotation.value();
                //2.获取方法上的@RequestMapping(xxx)
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValues = methodAnnotation.value();

                    url = classValues[0] + methodValues[0];

                    //获得请求ip
                    String ip = request.getRemoteAddr();

                    //操作者用户名
                    SecurityContext context = SecurityContextHolder.getContext();
                    Authentication authentication = context.getAuthentication();
                    User user = (User) authentication.getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名] " + aClass.getName() + "[方法名] " + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);

                    //调用service完成操作
                    sysLogService.save(sysLog);

                }

            }

        }

        return proceed;
    }

}
