package com.pz.role.plant;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.pz.role.BaseRole;
import com.pz.util.GameUtil;
public class WallNutRole extends PlantRole {
	public static final int ROLE_AVAILABLE=50;

	public WallNutRole(AnchorPane component) {
		super(component);
	}

	public void initRole() {
		setHp(30);
		setRoleWidth(GameUtil.wallNutImage.getWidth());
		setRoleHeight(GameUtil.wallNutImage.getHeight());
	}

	public void paintRole(GraphicsContext g) {
		if(getRunStatus()==BaseRole.ROLE_SECOND){
			g.drawImage(GameUtil.wallNutCracked1Image, getRoleX(), getRoleY());
		}else if(getRunStatus()==BaseRole.ROLE_THIRD){
			g.drawImage(GameUtil.wallNutCracked2Image, getRoleX(), getRoleY());
		}else{
			g.drawImage(GameUtil.wallNutImage, getRoleX(), getRoleY());
		}
	}

	public void action() {
		if(getHp()<=20){
			setRunStatus(ROLE_SECOND);
		}
		if(getHp()<=10){
			setRunStatus(ROLE_THIRD);
		}
		if(getHp()<=0){
			setRunStatus(ROLE_END);
		}
	}

}
