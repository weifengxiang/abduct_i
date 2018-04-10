package org.sky.log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.sky.sys.model.SysLog;
import org.sky.sys.model.SysUser;
import org.sky.sys.service.SysLogService;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 
 * @ClassName:  SysLogAspect   
 * @Description:TODO(日志切点类)   
 * @author: weifx 
 * @date:   2018年4月4日 下午3:58:07   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Aspect
@Component
public class SysLogAspect {
	// 注入Service用于把日志保存数据库
	@Autowired
	private SysLogService syslogservice;
	// 本地异常日志记录对象
	private static final Logger logger = LoggerFactory
			.getLogger(SysLogAspect.class);

	// Service层切点
	@Pointcut("@annotation(org.sky.log.SysServiceLog)")
	public void serviceAspect() {
	}

	// Controller层切点
	@Pointcut("@annotation(org.sky.log.SysControllerLog)")
	public void controllerAspect() {
	}

	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 * 
	 * @param joinPoint
	 *            切点
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
	}

	/**
	 * 异常通知 用于拦截service层记录异常日志
	 * 
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		SysUser user = (SysUser) BspUtils.getLoginUser();
		// 获取请求ip
		String ip = request.getRemoteAddr();
		// 获取用户请求方法的参数并序列化为JSON格式字符串
		String params = "";
		if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
			for (int i = 0; i < joinPoint.getArgs().length; i++) {
				System.out.println(joinPoint.getArgs()[i].getClass());
				params += JsonUtils.obj2json(joinPoint.getArgs()[i]) + ";";
			}
		}
		try {
			/* ========控制台输出========= */
			System.out.println("=====异常通知开始=====");
			System.out.println("异常代码:" + e.getClass().getName());
			System.out.println("异常信息:" + e.getMessage());
			System.out.println("异常方法:"
					+ (joinPoint.getTarget().getClass().getName() + "."
							+ joinPoint.getSignature().getName() + "()"));
			System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));
			System.out.println("请求人:" + user.getCode());
			System.out.println("请求IP:" + ip);
			System.out.println("请求参数:" + params);
			System.out.println("=====异常通知结束=====");
		} catch (Exception ex) {
			// 记录本地异常日志
			logger.error("==异常通知异常==");
			logger.error("异常信息:{}", ex.getMessage());
		}
	}

	/**
	 * 获取注解中对方法的描述信息 用于service层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getServiceMthodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(SysServiceLog.class).desc();
					break;
				}
			}
		}
		return description;
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getControllerMethodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(
							SysControllerLog.class).desc();
					break;
				}
			}
		}
		return description;
	}
	/**
	 * 环绕通知需要携带ProceedingJoinPoint类型的参数
	 * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法。
	 * 而且环绕通知必须有返回值，返回值即为目标方法的返回值
	 */
	@Around("controllerAspect()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) {
		Object result = null;
		String methodName = joinPoint.getSignature().getName();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		// 执行目标方法
		SysLog log = new SysLog();
		try {
			SysUser user = (SysUser) BspUtils.getLoginUser();
			log.setId(CommonUtils.getUUID());
			log.setIp(CommonUtils.getIpAddr(request));
			log.setOptMethod(joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName()+"()");
			log.setOptName(getControllerMethodDescription(joinPoint));
			//获取用户请求方法的参数并序列化为JSON格式字符串
			String params = "";
			if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
				for (int i = 0; i < joinPoint.getArgs().length; i++) {
					System.out.println(joinPoint.getArgs()[i].getClass());
					if(joinPoint.getArgs()[i] instanceof Serializable){
						params += JsonUtils.obj2json(joinPoint.getArgs()[i]) + ";";
					}else{
						params += "{\"Class:\""+joinPoint.getArgs()[i].getClass()+"};";
					}
				}
			}
			log.setOptParam(params);
			log.setUrl(request.getRequestURI());
			log.setUserCode(user.getCode());
			
			// 前置通知
			System.out.println("The method " + methodName + " begins with "
					+ Arrays.asList(joinPoint.getArgs()));
			long begin = System.currentTimeMillis();
			result = joinPoint.proceed();
			long end = System.currentTimeMillis();
			log.setLastTime(new BigDecimal(end-begin).shortValue());
			// 返回通知
			System.out.println("The method " + methodName + " ends with "
					+ Arrays.asList(joinPoint.getArgs()));
			log.setOptResult(result.getClass().toString());
		} catch (Throwable e) {
			// 异常通知
			log.setOptResult("执行失败："+e.getMessage());
		}// 后置通知
		String LOGTYPE = ConfUtils.getValue("LOGTYPE");
		if("DB".equals(LOGTYPE)) {
			syslogservice.saveAddSysLog(log);
		}else if("FILE".equals(LOGTYPE)) {
			logger.info(JsonUtils.obj2json(log));
		}else if("NONE".equals(LOGTYPE)) {
			
		}else {
			
		}
		
		return result;
	}
}