package com.o2oweb.dao.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.o2oweb.common.dao.HibernateEntityDao;
import com.o2oweb.dao.ItemattributeDao;
import com.o2oweb.entity.Itemattribute;

@Component("itemAttributeDao")
public class ItemAttributeDaoImpl extends HibernateEntityDao<Itemattribute>
		implements ItemattributeDao {

	public void save(Itemattribute itemattribute) {
		List<Itemattribute> result = super.find(
				"from Itemattribute i where i.itemId=?",
				new Object[] { itemattribute.getItemId() });
		if (result.size() != 0) {
			Itemattribute temp = result.get(result.size() - 1);
			itemattribute.setFatherId(temp.getItemAttributeId());
		}
		super.merge(itemattribute);
	}

	public void remove(Itemattribute itemattribute) {
		Itemattribute temp = super.findUniqueBy("fatherId",
				itemattribute.getItemAttributeId());
		if (temp != null) {
			temp.setFatherId(itemattribute.getFatherId());
			super.merge(temp);
		}
		super.remove(itemattribute);
	}

	public void update(Itemattribute itemattribute) {
		super.merge(itemattribute);
	}

	public Itemattribute getItemAttribute(int itemAttributeId) {
		return super.findUniqueBy("itemAttributeId", itemAttributeId);
	}

	public List<Itemattribute> getAttributes(int itemId) {
		// List result=
		// super.find("from Itemattribute where Itemattribute.itemId =?", new
		// Object[]{itemId});
		List<Itemattribute> result = super.find("from Itemattribute o where o.itemId=?",
				new Object[] { itemId });
		Comparator<Itemattribute> comparatorlist = new Comparator<Itemattribute>() {

			public int compare(Itemattribute o1, Itemattribute o2) {
				return o1.getFatherId() - o2.getFatherId();
			}
		};
		Collections.sort(result, comparatorlist);
		return result;
	}

}
