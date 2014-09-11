package com.o2oweb.dao;


import java.util.List;

import com.o2oweb.entity.Itemattribute;

public interface ItemattributeDao {
	public void save(Itemattribute itemattribute);
	public void remove(Itemattribute itemattribute);
	public void update(Itemattribute itemattribute);
	public Itemattribute getItemAttribute(int itemAttributeId);
	public List<Itemattribute> getAttributes(int itemId);
}
