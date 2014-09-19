package com.o2oweb.action;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.common.dao.support.Page;
import com.o2oweb.entity.User;
import com.o2oweb.service.UserService;
import com.o2oweb.util.BaseAction;
import com.o2oweb.util.MyJson;

@Scope("request")
@Service("userAction")
public class UserAction extends BaseAction {

	private UserService userService;
	private Integer userId;
	private String userName;
	private String password;
	private String email;
	private String tel;
	private String userQq;
	private String nickName;
	private String userLevel;
	private String score;
	private String iconAddr;
	private Integer power;
	private Integer addrId;

	// 分页参数
	private String rows; // 每页多少行
	private String page; // 当前页码
	private String orderby; // 过滤条件

	// 查询用户
	private String loginMes;
	private char type;

	public void save() {
		User user = new User(userName, password, email, tel, userQq, nickName,
				userLevel, score, iconAddr, power, addrId);

		this.userService.save(user);

		writeResponse(true);
	}

	public void remove() {
		User user = new User();
		user.setUserId(userId);

		this.userService.remove(user);

		writeResponse(true);
	}

	public void update() {
		User user = new User(userName, password, email, tel, userQq, nickName,
				userLevel, score, iconAddr, power, addrId);
		user.setUserId(userId);

		this.userService.update(user);

		writeResponse(true);
	}

	public void getUser() {
		User user = this.userService.getUser(loginMes, type);

		JSONObject obj = JSONObject.fromObject(user);
		writeResponse(obj.toString());
	}

	public void pageQuery() {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		Page p = this.userService.pagedQuery(dc, Integer.valueOf(rows),
				Integer.valueOf(page));

		JSONObject obj = MyJson.page2Jsobj(p);

		writeResponse(obj);
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUserQq() {
		return userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getIconAddr() {
		return iconAddr;
	}

	public void setIconAddr(String iconAddr) {
		this.iconAddr = iconAddr;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
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

	public String getLoginMes() {
		return loginMes;
	}

	public void setLoginMes(String loginMes) {
		this.loginMes = loginMes;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

}
