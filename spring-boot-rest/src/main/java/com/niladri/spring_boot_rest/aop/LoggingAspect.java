	package com.niladri.spring_boot_rest.aop;
	import org.slf4j.LoggerFactory;
	import org.springframework.stereotype.Component;
	
	import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
	import org.aspectj.lang.annotation.Before;
	import org.slf4j.Logger;
	
	@Aspect
	@Component
	public class LoggingAspect 
	{
		private static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
		
		// return type, class-name.method-name(args)
		
		@Before("execution(* com.niladri.spring_boot_rest.service.JobService.getJob(..)) ||execution(* com.niladri.spring_boot_rest.service.JobService.updateJob(..))")
		public void logMethodCall(JoinPoint jp)
		{
			LOGGER.info("method called"+ jp.getSignature().getName());
		}
		

		@AfterThrowing("execution (* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
		public void logMethodCrashed(JoinPoint jp) {
			LOGGER.info("Method has some issues "+jp.getSignature().getName());
		}
		
		
		
		@AfterReturning("execution (* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
		public void logMethodExecutedSuccess(JoinPoint jp) {
			LOGGER.info("Method Executed Successfully "+jp.getSignature().getName());
		}
	
	}
