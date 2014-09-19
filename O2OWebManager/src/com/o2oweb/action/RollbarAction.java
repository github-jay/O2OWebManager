package com.o2oweb.action;

import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.o2oweb.entity.Image;
import com.o2oweb.entity.Index3ainfo;
import com.o2oweb.entity.Rollbar;
import com.o2oweb.service.ImageService;
import com.o2oweb.service.Index3ainfoService;
import com.o2oweb.service.RollbarService;
import com.o2oweb.util.BaseAction;

@Scope("request")
@Service("rollbarAction")
public class RollbarAction extends BaseAction {

	private RollbarService rollbarService;
	private ImageService imageService;
	private Index3ainfoService index3ainfoService;

	private Integer rollBarId;
	private Integer imageByRollIconId;
	private Integer pageId;
	private Integer imageByRollImageId;
	private String rollText;

	public void save() {

		Image imageIcon = this.imageService.getImage(imageByRollIconId);
		Image imageImg = this.imageService.getImage(imageByRollImageId);
		Index3ainfo index3ainfo = this.index3ainfoService
				.getIndex3ainfo(pageId);
		Date createTime = new Date();

		Rollbar rollbar = new Rollbar(imageIcon, index3ainfo, imageImg,
				rollText, createTime);

		this.rollbarService.save(rollbar);

		writeResponse(true);
	}

	public void remove() {
		Rollbar rollbar = new Rollbar();
		rollbar.setRollBarId(rollBarId);

		this.rollbarService.remove(rollbar);

		writeResponse(true);
	}

	public void update() {
		Image imageIcon = this.imageService.getImage(imageByRollIconId);
		Image imageImg = this.imageService.getImage(imageByRollImageId);
		Index3ainfo index3ainfo = this.index3ainfoService
				.getIndex3ainfo(pageId);
		Date createTime = new Date();

		Rollbar rollbar = new Rollbar(imageIcon, index3ainfo, imageImg,
				rollText, createTime);
		rollbar.setRollBarId(rollBarId);

		this.rollbarService.update(rollbar);

		writeResponse(true);
	}

	public void getrollbar() {
		Rollbar rollbar = this.rollbarService.getRollbar(rollBarId);

		JSONObject obj = JSONObject.fromObject(rollbar);
		writeResponse(obj.toString());
	}

	public RollbarService getRollbarService() {
		return rollbarService;
	}

	@Resource
	public void setRollbarService(RollbarService rollbarService) {
		this.rollbarService = rollbarService;
	}

	public ImageService getImageService() {
		return imageService;
	}

	@Resource
	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	public Index3ainfoService getIndex3ainfoService() {
		return index3ainfoService;
	}

	@Resource
	public void setIndex3ainfoService(Index3ainfoService index3ainfoService) {
		this.index3ainfoService = index3ainfoService;
	}

	public Integer getRollBarId() {
		return rollBarId;
	}

	public void setRollBarId(Integer rollBarId) {
		this.rollBarId = rollBarId;
	}

	public Integer getImageByRollIconId() {
		return imageByRollIconId;
	}

	public void setImageByRollIconId(Integer imageByRollIconId) {
		this.imageByRollIconId = imageByRollIconId;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public Integer getImageByRollImageId() {
		return imageByRollImageId;
	}

	public void setImageByRollImageId(Integer imageByRollImageId) {
		this.imageByRollImageId = imageByRollImageId;
	}

	public String getRollText() {
		return rollText;
	}

	public void setRollText(String rollText) {
		this.rollText = rollText;
	}

}
