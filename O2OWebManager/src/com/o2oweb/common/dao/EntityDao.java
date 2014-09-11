package com.o2oweb.common.dao;
/**
 * @author 作者姓名 king
 * @version 创建时间：Feb 26, 2013 6:18:32 PM
 * 类说明
 */
import java.io.Serializable;
import java.util.List;

public abstract interface EntityDao<T>
{
  public abstract T get(Serializable paramSerializable);

  public abstract List<T> getAll();

  public abstract void save(Object paramObject);

  public abstract void remove(Object paramObject);

  public abstract void removeById(Serializable paramSerializable);

  public abstract void merge(Object paramObject);

  @SuppressWarnings("unchecked")
  public abstract String getIdName(Class paramClass);
}