package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.o2oweb.dao.RollbarDao;
import com.o2oweb.entity.Rollbar;
import com.o2oweb.util.AppContext;

public class TestRollbarDao {

	@Test
	public void testGet() {
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AppContext apc = (AppContext) applicationcontext.getBean("appContext");
		RollbarDao rollbarDao = (RollbarDao) apc.getBean("rollbarDao");

	}
}
