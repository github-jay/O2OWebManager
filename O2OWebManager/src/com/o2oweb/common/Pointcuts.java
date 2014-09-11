package com.o2oweb.common;

import org.aspectj.lang.annotation.Pointcut;




public class Pointcuts {
    /*��һ�� * ���� ͨ�� ���ⷵ��ֵ����
      �ڶ��� * ���� ͨ�� ��org.baicai.spring�µ�����class�����ⷽ��
            .. ���� ͨ�� ����������0����������
    */
	//@Pointcut("execution(* com.o2oweb.dao..*.*(..))")
	@Pointcut("execution(* com.o2oweb..*.service..*(..))")
  public void pointcut()
    { 
	  
    }
}
