package com.o2oweb.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

public class BaseAction extends com.o2oweb.common.BaseAction
{
	private static final long serialVersionUID = 1L;

	public final int pageSize = 24;
	public final String SPACE_PAGE = "spacePage";
	public String memorySessionPage;
	public String memorySessionPageSelectedTab;
	public String memorySessionPageSourceIndex;
	public String memorySessionPageSelectedTabName;
	public String memorySessionType;
	public String topMenuType;
	public String leftMenuType;
	protected String failedReason = "";
	private String returnUrl;
	public final String CMS_SUCCESS = "login_success_cms";
	public final String OA_SUCCESS = "login_success_oa";
	public final String WC_SUCCESS = "login_success_client";

	public final String LICENSE_UPLOAD = "licenseUpload";

	private Integer objectIdForCheck;
	private Integer objectTypeForCheck;
	private Integer privilegeCodeForCheck;
	private Integer clientTypeForCheck = Integer.valueOf(0);
	public String ERROR = "error";

	public boolean success = true;
	public boolean timeout = false;
	public String message;

	public void writeResponse(JSONObject obj)
	{
//		obj.put("success", Boolean.valueOf(this.success));
//		obj.put("message", this.message);
		writeResponse(obj.toString());
	}

	public void writeTimeOutResponse()
	{
		this.timeout = true;
		JSONObject result = new JSONObject();
		result.put("timeout", Boolean.valueOf(this.timeout));
		writeResponse(result.toString());
	}

	public void writeResponse()
	{
		JSONObject result = new JSONObject();
		result.put("message", this.message);
		result.put("success", Boolean.valueOf(this.success));
		writeResponse(result);
	}

	public void writeResponse(Boolean flag, String message)
	{
		JSONObject result = new JSONObject();
		result.put("message", message);
		result.put("success", flag);
		writeResponse(result.toString());
	}
	
	public void writeResponse(Boolean flag, String message,int id)
	{
		JSONObject result = new JSONObject();
		result.put("message", message);
		result.put("success", flag);
		result.put("id", id);
		writeResponse(result.toString());
	}

	public boolean writeResponse(String str)
	{
		boolean ret = true;
		try
		{
			str = str.replace("\\r", "");
			str = str.replace("null", "\"\"");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(str);
			pw.close();
		} catch (Exception e)
		{
			ret = false;
			e.printStackTrace();
		}
		return ret;
	}

	public String spacePage()
	{
		return "spacePage";
	}

	public String getFailedReason()
	{
		return this.failedReason;
	}

	public void setFailedReason(String failedReason)
	{
		this.failedReason = failedReason;
	}

	public String execute() throws Exception
	{
		return "success";
	}
	
	public Integer getObjectIdForCheck()
	{
		return this.objectIdForCheck;
	}

	public void setObjectIdForCheck(Integer objectIdForCheck)
	{
		this.objectIdForCheck = objectIdForCheck;
	}

	public Integer getObjectTypeForCheck()
	{
		return this.objectTypeForCheck;
	}

	public void setObjectTypeForCheck(Integer objectTypeForCheck)
	{
		this.objectTypeForCheck = objectTypeForCheck;
	}

	public Integer getPrivilegeCodeForCheck()
	{
		return this.privilegeCodeForCheck;
	}

	public void setPrivilegeCodeForCheck(Integer privilegeCodeForCheck)
	{
		this.privilegeCodeForCheck = privilegeCodeForCheck;
	}

	public void setControlClientForCheck(Integer controlClientForCheck)
	{
		this.clientTypeForCheck = controlClientForCheck;
	}

	public Integer getControlClientForCheck()
	{
		return this.clientTypeForCheck;
	}

	public String getReturnUrl()
	{
		return this.returnUrl;
	}

	public void setReturnUrl(String returnUrl)
	{
		this.returnUrl = returnUrl;
	}
}