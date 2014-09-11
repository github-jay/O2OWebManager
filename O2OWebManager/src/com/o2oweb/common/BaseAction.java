package com.o2oweb.common;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

public class BaseAction extends ActionSupport implements ServletResponseAware,
		ServletRequestAware, Preparable {
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(BaseAction.class);
	private String action;
	private String returnUrl;
	private HttpServletResponse response;
	private HttpServletRequest request;

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getReturnUrl() {
		return this.returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return this.response;
	}

	public HttpServletRequest getRequest() {
		return this.request;
	}

	public HttpSession getSession() {
		try {
//			if(this.request == null){
//				this.request = (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
//			}
			if(this.request == null){
				this.request = ServletActionContext.getRequest();
			}
			return this.request.getSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getRealPath() {
		return this.request.getSession().getServletContext().getRealPath("/");
	}

	public String getRemoteAddr() {
		return this.request.getRemoteAddr();
	}

	public Integer getRemotePort() {
		return Integer.valueOf(this.request.getRemotePort());
	}

	public void prepare() throws Exception {
	}

}