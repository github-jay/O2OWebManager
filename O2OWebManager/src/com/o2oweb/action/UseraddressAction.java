package com.o2oweb.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.entity.Useraddress;
import com.o2oweb.service.UseraddressService;
import com.o2oweb.util.BaseAction;
import com.o2oweb.util.MyJson;

@Scope("request")
@Service("useraddressAction")
public class UseraddressAction extends BaseAction {

	private UseraddressService useraddressService;

	private Integer idUserAddress;
	private String address;
	private String username;
	private String tel;
	private Integer userId;

	// 分页参数
	private String rows; // 每页多少行
	private String page; // 当前页码
	private String orderby; // 过滤条件

	public void save() {
		Date lastuse = new Date();

		Useraddress useraddress = new Useraddress(address, username, tel,
				userId, lastuse);

		this.useraddressService.save(useraddress);

		writeResponse(true);
	}

	public void remove() {
		Useraddress useraddress = new Useraddress();
		useraddress.setIdUserAddress(idUserAddress);

		this.useraddressService.remove(useraddress);

		writeResponse(true);
	}

	public void update() {
		Date lastuse = new Date();

		Useraddress useraddress = new Useraddress(address, username, tel,
				userId, lastuse);
		useraddress.setIdUserAddress(idUserAddress);

		this.useraddressService.update(useraddress);

		writeResponse(true);
	}

	public void getUseraddressByAddId() {
		Useraddress useraddress = this.useraddressService
				.getUseraddress(idUserAddress);

		JSONObject obj = JSONObject.fromObject(useraddress);
		writeResponse(obj.toString());
	}

	public void getUseraddressByUserId() {
		List<Useraddress> list = this.useraddressService.getAddrs(userId);

		JSONArray array = JSONArray.fromObject(list);
		writeResponse(array.toString());
	}

	public void pageQuery() {
		DetachedCriteria dc = DetachedCriteria.forClass(Useraddress.class);
		Page p = this.useraddressService.pagedQuery(dc, Integer.valueOf(rows),
				Integer.valueOf(page));

		JSONObject obj = MyJson.page2Jsobj(p);

		writeResponse(obj);
	}

	public UseraddressService getUseraddressService() {
		return useraddressService;
	}

	@Resource
	public void setUseraddressService(UseraddressService useraddressService) {
		this.useraddressService = useraddressService;
	}

	public Integer getIdUserAddress() {
		return idUserAddress;
	}

	public void setIdUserAddress(Integer idUserAddress) {
		this.idUserAddress = idUserAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
