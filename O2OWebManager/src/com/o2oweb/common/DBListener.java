package com.o2oweb.common;

import org.apache.log4j.Logger;
import org.hibernate.event.PostDeleteEvent;
import org.hibernate.event.PostDeleteEventListener;
import org.hibernate.event.PostInsertEvent;
import org.hibernate.event.PostInsertEventListener;
import org.hibernate.event.PostUpdateEvent;
import org.hibernate.event.PostUpdateEventListener;

/**
 * @author 作者姓名 zj
 * @version 创建时间：Feb 22, 2013 11:42:55 AM
 * 类说明    数据库操作监听
 */
public class DBListener implements PostInsertEventListener,   
        PostUpdateEventListener, PostDeleteEventListener {   
     private Logger logger = Logger.getLogger(DBListener.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void onPostInsert(PostInsertEvent arg0) {
//		logger.info("id: " + arg0.getId());
//		logger.info("state: " + arg0.getState());
//		logger.info("persister: " + arg0.getPersister());
//		logger.info("class: " + arg0.getClass());
//		logger.info("entity: " + arg0.getEntity());
//		logger.info("保存 插入日志");
	}

	public void onPostUpdate(PostUpdateEvent arg0) {

//		logger.info("id: " + arg0.getId());
//		logger.info("state: " + arg0.getState());
//		logger.info("oldState: " + arg0.getOldState());
//		logger.info("persister: " + arg0.getPersister());
//		logger.info("class: " + arg0.getClass());
//		logger.info("entity: " + arg0.getEntity());
//		logger.info("info: " + "保存 修改日志");
	}

	public void onPostDelete(PostDeleteEvent arg0) {
//		logger.info("id: " + arg0.getId());
//		logger.info("deleteState: " + arg0.getDeletedState());
//		logger.info("class: " + arg0.getClass());
//		logger.info("entity: " + arg0.getEntity());
//		logger.info("保存 删除日志");
	} 
}  
