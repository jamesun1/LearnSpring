package com.sunxu.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class WebLogAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Pointcut("@annotation(com.sunxu.aspect.Permission)")
	public void WebLog() {
	}

	@Before("WebLog()")
	public void deBefore(JoinPoint joinPoint) throws Throwable {
		logger.info("调用成功2");
	}

	@Around("WebLog()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.info("调用成功3");
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
		Method targetMethod = methodSignature.getMethod();
        //得到方法的访问权限
        final String currentPermission = WebLogAspect.privilegeParse(targetMethod);
        // 获取 request
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        Object obj = proceedingJoinPoint.proceed();
		return obj;
	}
	
	public static String privilegeParse(Method method) throws Exception {
        //获取该方法
        if(method.isAnnotationPresent(Permission.class)){
            Permission annotation = method.getAnnotation(Permission.class);
            return annotation.value();
        }
        return null;
    }

}
