package com.o2oweb.common;

/**
 * @author 作者姓名 zj
 * @version 创建时间：May 20, 2013 10:10:36 AM
 * 类说明    aop切入点
 */
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect
{
	private static Logger logger = Logger.getLogger(MyAspect.class.getName());

	public MyAspect()
	{
	}

	@Before("Pointcuts.pointcut()")
	public void beforeAdvice()
	{
		logger.info("执行前置通知");
	}

	@After("Pointcuts.pointcut()")
	public void afterAdvice()
	{
		logger.info("执行尾置通知");
	}

	@AfterReturning(pointcut = "Pointcuts.pointcut()", returning = "returnValue")
	public void afterReturningAdvice(Object returnValue)
	{
		logger.info("执行返回值尾通知：" + returnValue);
	}

	@AfterThrowing(pointcut = "Pointcuts.pointcut()", throwing = "ex")
	public void afterThrowException(Exception ex)
	{
		logger.error("捕获到异常信息：" + ex.getMessage());
	}

	@Around("Pointcuts.pointcut()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		Object returnValue = null;
		logger.info("进入环绕通知！");
		logger.info("进入类：" + pjp.getTarget().getClass().getName());
		logger.info("代理类：" + pjp.getThis().getClass().getName());
		logger.info("进入方法：" + pjp.getSignature().getName());
		Object[] args = pjp.getArgs();
		for (Object o : args) {
			logger.info(o + " ");
		}
		try {
			returnValue = pjp.proceed();
			logger.info("方法执行完成！");
		} catch (Exception e) {
			logger.info("捕获到异常信息:", e);
			throw e;
		} finally {
			logger.info("完成环绕通知!");
		}
		return returnValue;
	}
}
