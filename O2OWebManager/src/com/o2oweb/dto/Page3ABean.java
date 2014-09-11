package com.o2oweb.dto;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.o2oweb.dao.ItemDao;
import com.o2oweb.dao.impl.ItemDaoImpl;
import com.o2oweb.entity.AbstractPageitem;
import com.o2oweb.entity.Index3ainfo;
import com.o2oweb.entity.Pageitemlist1f;
import com.o2oweb.entity.Pageitemlist2f;
import com.o2oweb.entity.Pageitemlist3f;
import com.o2oweb.entity.Rollbar;
import com.o2oweb.util.AppContext;

public class Page3ABean {
	private List<Pageitemlist1f> oneF3;
	private List<Pageitemlist1f> oneF4;
	private List<Pageitemlist2f> twoF3;
	private List<Pageitemlist2f> twoF4;
	private List<Pageitemlist3f> threeF3;
	private List<Pageitemlist3f> threeF4;
	private Set<Rollbar> rollbars;
	private static ItemDao itemDao;
	static {//静态代码块，初始化ItemDao，保证单例
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		AppContext apc = (AppContext) applicationcontext.getBean("appContext");
		itemDao = (ItemDao) apc.getBean("itemDao");
	}
	public Page3ABean(Index3ainfo index3){
		oneF3 = new LinkedList<Pageitemlist1f>();
		oneF4 = new LinkedList<Pageitemlist1f>();
		Set<Pageitemlist1f> pageitemlist1f = index3.getPageitemlist1fs();
		injectItem(pageitemlist1f);
		change2F3F4(pageitemlist1f,oneF3,oneF4);
		
		twoF3 = new LinkedList<Pageitemlist2f>();
		twoF4 = new LinkedList<Pageitemlist2f>();
		Set<Pageitemlist2f> pageitemlist2f = index3.getPageitemlist2fs();
		injectItem(pageitemlist2f);
		change2F3F4(pageitemlist2f, twoF3, twoF4);
		
		threeF3 = new LinkedList<Pageitemlist3f>();
		threeF4 = new LinkedList<Pageitemlist3f>();
		Set<Pageitemlist3f> pageitemlist3f = index3.getPageitemlist3fs();
		injectItem(pageitemlist3f);
		change2F3F4(pageitemlist3f, threeF3, threeF4);
		
		this.rollbars = index3.getRollbars();
	}
	/**
	 * 将集合拆分成两个list
	 * @param orignalSet
	 * @param list3
	 * @param list4
	 */
	private void change2F3F4(Set orignalSet,
			List list3, List list4) {
		Iterator iterator = orignalSet.iterator();
		int index = 0;
		while(iterator.hasNext()){
			Object obj = iterator.next();
			if(index<3){
				list3.add(obj);
			}else {
				list4.add(obj);
			}
			index++;
		}
	}
	/**
	 * 向Bean中注入Item对象
	 * @param pageitemlist
	 */
	private void injectItem(Set pageitemlist){
		Iterator<Object> itemsIterator = pageitemlist.iterator();
		AbstractPageitem abspageitem = null;
		Object pageItem = null;
		Class objectClass = null;
		Field itemidproperty = null;
		Integer itemid;
		while(itemsIterator.hasNext()){
			pageItem = itemsIterator.next();
			objectClass = pageItem.getClass();
			try {
				itemidproperty = objectClass.getDeclaredField("itemId");
				itemidproperty.setAccessible(true);
				itemid = (Integer) itemidproperty.get(pageItem);
				abspageitem = (AbstractPageitem) pageItem;
				abspageitem.setItem(itemDao.getItem(itemid));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
	}
	
	public List<Pageitemlist1f> getOneF3() {
		return oneF3;
	}
	public List<Pageitemlist1f> getOneF4() {
		return oneF4;
	}
	public List<Pageitemlist2f> getTwoF3() {
		return twoF3;
	}
	public List<Pageitemlist2f> getTwoF4() {
		return twoF4;
	}
	public List<Pageitemlist3f> getThreeF3() {
		return threeF3;
	}
	public List<Pageitemlist3f> getThreeF4() {
		return threeF4;
	}
	public void setOneF3(List<Pageitemlist1f> oneF3) {
		this.oneF3 = oneF3;
	}
	public void setOneF4(List<Pageitemlist1f> oneF4) {
		this.oneF4 = oneF4;
	}
	public void setTwoF3(List<Pageitemlist2f> twoF3) {
		this.twoF3 = twoF3;
	}
	public void setTwoF4(List<Pageitemlist2f> twoF4) {
		this.twoF4 = twoF4;
	}
	public void setThreeF3(List<Pageitemlist3f> threeF3) {
		this.threeF3 = threeF3;
	}
	public void setThreeF4(List<Pageitemlist3f> threeF4) {
		this.threeF4 = threeF4;
	}
	public Set<Rollbar> getRollbars() {
		return rollbars;
	}
	public void setRollbars(Set<Rollbar> rollbars) {
		this.rollbars = rollbars;
	}
	
}
