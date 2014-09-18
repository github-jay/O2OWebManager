package com.o2oweb.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.entity.Itemlevel;
import com.o2oweb.service.ItemLevelService;
import com.o2oweb.util.BaseAction;

@Scope("request")
@Service("itemLevelAction")
public class ItemLevelAction extends BaseAction {

	private ItemLevelService itemLevelService;
	private Integer itemLevelId;
	private Integer surperId = 0;
	private String levelName;
	private Integer levelId;

	public void save() {
		Itemlevel itemLevel = new Itemlevel(surperId, levelName);

		this.itemLevelService.save(itemLevel);

		writeResponse(true);
	}

	public void remove() {
		Itemlevel itemLevel = new Itemlevel();
		itemLevel.setIdItemLevel(itemLevelId);

		this.itemLevelService.remove(itemLevel);

		writeResponse(true);
	}

	public void update() {
		Itemlevel itemLevel = new Itemlevel(surperId, levelName);
		itemLevel.setIdItemLevel(itemLevelId);

		this.itemLevelService.update(itemLevel);

		writeResponse(true);
	}

	public void getItemLevel() {
		Itemlevel itemLevel = this.itemLevelService.getLevel(itemLevelId);

		JSONObject obj = JSONObject.fromObject(itemLevel);
		writeResponse(obj.toString());
	}

	public void getAllLevel() {
		List<Itemlevel> levels = this.itemLevelService.getAllLevel(levelId);

		JSONArray array = JSONArray.fromObject(levels);
		writeResponse(array.toString());
	}

	public void getNextLevels() {
		List<Itemlevel> levels = this.itemLevelService.getNextLevels(levelId);

		JSONArray array = JSONArray.fromObject(levels);
		writeResponse(array.toString());
	}

	public ItemLevelService getItemLevelService() {
		return itemLevelService;
	}

	@Resource
	public void setItemLevelService(ItemLevelService itemLevelService) {
		this.itemLevelService = itemLevelService;
	}

	public Integer getSurperId() {
		return surperId;
	}

	public void setSurperId(Integer surperId) {
		this.surperId = surperId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Integer getItemLevelId() {
		return itemLevelId;
	}

	public void setItemLevelId(Integer itemLevelId) {
		this.itemLevelId = itemLevelId;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}
}
