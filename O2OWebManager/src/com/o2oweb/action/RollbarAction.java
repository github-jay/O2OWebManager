package com.o2oweb.action;

import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.entity.Image;
import com.o2oweb.entity.Rollbar;
import com.o2oweb.service.ImageService;
import com.o2oweb.service.RollbarService;
import com.o2oweb.util.BaseAction;

@Scope("request")
@Service("rollbarAction")
public class RollbarAction extends BaseAction {

	private RollbarService rollbarService;
	private ImageService imageService;

	private Integer rollBarId;
	private Integer imageByRollIconId;
	private Integer pageId;
	private Integer imageByRollImageId;
	private String rollText;

	
}
