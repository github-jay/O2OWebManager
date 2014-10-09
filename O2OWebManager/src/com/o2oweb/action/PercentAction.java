package com.o2oweb.action;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.util.BaseAction;

@Scope("request")
@Service("percentAction")
public class PercentAction extends BaseAction {

	public void getExcelPercent() {
		HttpSession session = getSession();
		Double percent = (Double) session.getAttribute("percent");
		if (percent == null) {
			percent = 0.0;
		}
		percent *= 100;
		String msg = percent.toString();
		if (percent >= 100) {
			session.setAttribute("percent", 0.0);
		}

		writeResponse(msg);
	}
}
