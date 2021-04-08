package com.pz.role;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.pz.role.zombie.BaseZombie;
import com.pz.util.GameUtil;
import com.pz.window.GamePanel;

/**
 * Copyright (C), 2006-2011, 
 * FileName: PlantsPanelRole.java
 * 
 * 
 * @author  ls
 * @Date    2012-1-12
 * @version 1.00 
 */
public class CarPanelRole extends BaseRole {

	public CarPanelRole(AnchorPane panel) {
		super(panel);
	}

	private double roleY;
	public void initRole() {
		setRoleX(60);
		setRoleY(roleY);
		setRoleWidth(GameUtil.carPanelImage.getWidth());
		setRoleHeight(GameUtil.carPanelImage.getHeight());
		setMoveLength(15);
	}

	public void paintRole(GraphicsContext g) {
		g.drawImage(GameUtil.carPanelImage, getRoleX(), getRoleY());
	}

	public void action() {
		double moveX=getMoveLength();
		//判断推车与僵尸碰撞
		GamePanel gamePanel=(GamePanel)getPanel();
		List<BaseZombie> zombieList=gamePanel.getZombieRoleList();
		for(int i=0;i<zombieList.size();i++){
			if(GameUtil.checkImpact(this, zombieList.get(i))){
				zombieList.get(i).setZombieType(BaseZombie.ZOMBIE_CAR);
				zombieList.get(i).setHp(0);
				setRunStatus(BaseRole.CAR_RUN);
			}
		}
		if(getRunStatus()==BaseRole.CAR_RUN){
			setRoleX(getRoleX()+moveX);
		}
		if(getRoleX()>1200){
			setRunStatus(ROLE_END);
		}
	}

	public double getRoleY() {
		return roleY;
	}

	public void setRoleY(double roleY) {
		this.roleY = roleY;
	}
}
