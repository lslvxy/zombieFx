package com.pz.role;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.pz.util.GameUtil;

public class ProgressRole extends BaseRole {

	private int progressValue;
	private int time;
	
	public ProgressRole(AnchorPane panel) {
		super(panel);
	}

	@Override
	public void initRole() {
		progressValue=150;
		setRoleX(710);
		setRoleY(570);
		time=1000;
		setRoleHeight(GameUtil.flagMeterImage.getHeight());
		setRoleWidth(GameUtil.flagMeterImage.getWidth());
	}

	@Override
	public void paintRole(GraphicsContext g) {
		g.drawImage(GameUtil.flagMeterImage, getRoleX(), getRoleY());
		g.drawImage(GameUtil.flagMeterImage, getRoleX(), getRoleY(),getRoleX()+progressValue, getRoleY()+21,
				0, 0, progressValue, 21);
		g.drawImage(GameUtil.flagMeterLevelProgressImage,getRoleX()+35, getRoleY()+12);
		g.drawImage(GameUtil.flagMeterParts2Image,getRoleX()+80, getRoleY());
		g.drawImage(GameUtil.flagMeterParts2Image,getRoleX()+20, getRoleY());
		g.drawImage(GameUtil.flagMeterParts1Image,getRoleX()+progressValue, getRoleY());
	}

	@Override
	public void action() {
	}

	public int getProgressValue() {
		return progressValue;
	}

	public void setProgressValue(int progressValue) {
		this.progressValue = progressValue;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	
}
