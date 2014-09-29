package com.o2oweb.action;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.entity.Sailer;
import com.o2oweb.service.SailerService;
import com.o2oweb.util.BaseAction;
import com.o2oweb.util.MyJson;

@Scope("request")
@Service("sailerAction")
public class SailerAction extends BaseAction {

	private SailerService sailerService;
	private Integer sailerId;
	private String name;
	private String address;
	private Integer addCode;
	private String conName;
	private String conTel;

	// 分页参数
	private String rows; // 每页多少行
	private String page; // 当前页码
	private String orderby; // 过滤条件

	public void save() {
		Sailer sailer = new Sailer(name, address, addCode, conName, conTel);

		this.sailerService.save(sailer);

		writeResponse(true);
	}

	public void remove() {
		Sailer sailer = new Sailer();
		sailer.setSailerid(sailerId);

		this.sailerService.remove(sailer);

		writeResponse(true);
	}

	public void update() {
		Sailer sailer = new Sailer(name, address, addCode, conName, conTel);
		sailer.setSailerid(sailerId);

		this.sailerService.update(sailer);

		writeResponse(true);
	}

	public void getsailer() {
		Sailer sailer = this.sailerService.getsailer(sailerId);

		JSONObject obj = JSONObject.fromObject(sailer);
		writeResponse(obj.toString());
	}

	public void pageQuery() {
		DetachedCriteria dc = DetachedCriteria.forClass(Sailer.class);
		Page p = this.sailerService.pagedQuery(dc, Integer.valueOf(rows),
				Integer.valueOf(page));

		JSONObject obj = MyJson.page2Jsobj(p);

		writeResponse(obj);
	}

	public SailerService getSailerService() {
		return sailerService;
	}

	@Resource
	public void setSailerService(SailerService sailerService) {
		this.sailerService = sailerService;
	}

	public Integer getSailerId() {
		return sailerId;
	}

	public void setSailerId(Integer sailerId) {
		this.sailerId = sailerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAddCode() {
		return addCode;
	}

	public void setAddCode(Integer addCode) {
		this.addCode = addCode;
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public String getConTel() {
		return conTel;
	}

	public void setConTel(String conTel) {
		this.conTel = conTel;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

}
