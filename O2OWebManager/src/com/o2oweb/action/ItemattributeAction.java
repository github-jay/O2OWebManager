package com.o2oweb.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.entity.Itemattribute;
import com.o2oweb.service.ItemattributeService;
import com.o2oweb.util.BaseAction;

@Scope("request")
@Service("itemAttributeAction")
public class ItemattributeAction extends BaseAction {

	private ItemattributeService itemAttributeService;
	private Integer itemAttributeId;
	private String attributeDetail;
	private Integer itemId;
	private Integer fatherId = 0;

	public void save() {
		Itemattribute itemAttribute = new Itemattribute();
		itemAttribute.setAttributeDetail(attributeDetail);
		itemAttribute.setFatherId(fatherId);
		itemAttribute.setItemId(itemId);

		this.itemAttributeService.save(itemAttribute);

		writeResponse("true");
	}

	public void remove() {
		Itemattribute itemAttribute = new Itemattribute();
		itemAttribute.setItemAttributeId(itemAttributeId);

		this.itemAttributeService.remove(itemAttribute);

		writeResponse("true");
	}

	public void update() {
		Itemattribute itemAttribute = new Itemattribute();
		itemAttribute.setItemAttributeId(itemAttributeId);
		itemAttribute.setAttributeDetail(attributeDetail);
		itemAttribute.setFatherId(fatherId);
		itemAttribute.setItemId(itemId);

		this.itemAttributeService.update(itemAttribute);

		writeResponse("true");
	}

	public void getItemAttribute() {
		Itemattribute itemAttribute = this.itemAttributeService
				.getItemattribute(itemAttributeId);

		JSONObject obj = JSONObject.fromObject(itemAttribute);
		writeResponse(obj.toString());
	}

	public void getAttributesByItemId() {
		List<Itemattribute> attributes = this.itemAttributeService
				.getAttributes(itemId);

		JSONArray array = JSONArray.fromObject(attributes);
		writeResponse(array.toString());
	}

	public ItemattributeService getItemAttributeService() {
		return itemAttributeService;
	}

	@Resource
	public void setItemAttributeService(
			ItemattributeService itemAttributeService) {
		this.itemAttributeService = itemAttributeService;
	}

	public Integer getItemAttributeId() {
		return itemAttributeId;
	}

	public void setItemAttributeId(Integer itemAttributeId) {
		this.itemAttributeId = itemAttributeId;
	}

	public String getAttributeDetail() {
		return attributeDetail;
	}

	public void setAttributeDetail(String attributeDetail) {
		this.attributeDetail = attributeDetail;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getFatherId() {
		return fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

}
