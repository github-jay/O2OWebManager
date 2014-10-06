package test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;

import org.junit.Test;

import com.o2oweb.entity.Rollbar;
import com.o2oweb.util.PropertiesUtil;

public class URLtest {

	@Test
	public void testget(){
		PropertiesUtil p = new PropertiesUtil();
		String value = p.getValue("imageURL");
		System.out.println(value);
		File file = new File(value,"xxxxxx.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testfield(){
		
		String imgpre = "image";
		String imgend = "name";
		int index = 1;
		
		String imgfname = imgpre+index;
		String titlefname = imgpre+index+imgend;
		Class rollclass = Rollbar.class;
		
		try {
//			Field idfield = rollclass.getField(imgfname);
			Field[] fields = rollclass.getDeclaredFields();
			for(Field field:fields){
				System.out.println(field.getName());
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
