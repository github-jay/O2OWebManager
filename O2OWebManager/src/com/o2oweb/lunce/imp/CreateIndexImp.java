package com.o2oweb.lunce.imp;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.common.dao.support.Page;

import com.o2oweb.lunce.CreateIndex;

public class CreateIndexImp<T> extends HibernateEntityDao<T> implements CreateIndex{

	private Class<T> entityClass;
	private PropertyDescriptor[] properties;
	private String[] PropertyNames;
	public CreateIndexImp(){
		Type genType = getClass().getGenericSuperclass();  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
        entityClass = (Class) params[0];  
        try {
        	properties = Introspector.getBeanInfo(entityClass).getPropertyDescriptors();
        	PropertyNames = new String[properties.length];
        	for(int i=0;i<PropertyNames.length;i++){
        		PropertyNames[i] = properties[i].getName();
        	}
        } catch (IntrospectionException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
	}
	public void CreateOrAppent() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		int start = 1;
		int limte = 100;
		DetachedCriteria detachecriteria = DetachedCriteria.forClass(entityClass);
		Page page = super.pagedQuery(detachecriteria, start, limte);
		int pageNum = page.getPageSize();
		for(int i=0;i<pageNum;i++){
			List<T> dates =  (List<T>) page.getData();
			for(T t:dates){
				for(int j=0;j<properties.length;j++){
					Method method = properties[i].getReadMethod();
					Object value = method.invoke(t, null);
					
				}
			}
		}
	}
	public void reCreate() {
		// TODO Auto-generated method stub
		
	}

}
