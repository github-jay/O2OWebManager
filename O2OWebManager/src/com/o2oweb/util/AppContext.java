package com.o2oweb.util;

/**
 * @author 作者姓名 zj
 * 类说明
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class AppContext implements ApplicationContextAware {
	private static final Log log = LogFactory.getLog(AppContext.class);
	
	private static ApplicationContext context;

	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		log.debug("applicationContext开始注入");
		setContext(context);
		log.debug("applicationContext注入成功");
	}

	public static ApplicationContext getContext() {
		if (context == null)
			throw new IllegalStateException(
					"applicaitonContext未注入,请在applicationContext.xml中定义AppContext");
		return context;
	}

	public static void setContext(ApplicationContext context) {
		AppContext.context = context;
	}

	public static Object getBean(String name) throws BeansException {
		if (context == null)
			throw new IllegalStateException(
					"applicaitonContext未注入,请在applicationContext.xml中定义AppContext");
		return context.getBean(name);
	}
}