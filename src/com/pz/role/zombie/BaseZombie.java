package com.pz.role.zombie;

import java.util.List;

import javafx.scene.layout.AnchorPane;

import com.pz.role.BaseRole;
import com.pz.role.plant.PlantRole;
import com.pz.util.GameUtil;
import com.pz.window.GamePanel;

/**
 * Copyright (C)
 * FileName: BaseZombie.java
 * 所有僵尸的父类
 * 
 * @author  ls
 * @Date    2012-1-18
 * @version 1.00 
 */
public  abstract class BaseZombie extends BaseRole {
	//走路
	public static final int ZOMBIE_WALK=51; 
	//攻击
	public static final int ZOMBIE_ATTACK=52;
	//头掉落
	public static final int ZOMBIE_LOST_HEAD=53;
	//无头走路
	public static final int ZOMBIE_NOHEAD_WALK=54;
	//无头攻击
	public static final int ZOMBIE_NOHEAD_ATTACK=55;
	//死亡
	public static final int ZOMBIE_DEAD=56;
	//无头状态
	public static final int ZOMBIE_NO_HEAD=57;
	
	//爆炸死亡状态
	public static final int ZOMBIE_BOOM=58;

	//推车死亡状态
	public static final int ZOMBIE_CAR=61;
	
	//铁桶僵尸走路的状态
	public static final int BUCKETHEAD_ZOMBIE_WALK=59;
	//铁桶僵尸攻击的状态
	public static final int BUCKETHEAD_ZOMBIE_ATTACK=60;
	
	//僵尸的状态
	private int zombieType;
	//僵尸是否掉头的状态
	private int lostHeadType;
	
	//僵尸的分数
	private int score;
	
	
	
	public void action() {
		GamePanel gamePanel=(GamePanel)(getPanel());
		if(getRoleX()<-50){
			gamePanel.setGameStatus(GAME_ZOMBIE_WON);
		}
//		for(int i=0;i<gamePanel.getZombieRoleList().size();i++){
//		if(gamePanel.getProgressRole().getProgressValue()<=0 
//				&&gamePanel.getZombieRoleList().get(i).getHp()<=0){
//			gamePanel.setGameStatus(GAME_VICTORY);
//		}
//		}
	}
	
	/**
	 * 检测僵尸与植物碰撞
	 */
	
	public  boolean checkZombieAndPlantsImpact(){
		GamePanel gamePanel=(GamePanel) getPanel();
		List<PlantRole> plantRoleList=gamePanel.getPlantRoleList();
		for(int i=0;i<plantRoleList.size();i++){
			if(GameUtil.checkImpact(this, plantRoleList.get(i))){
				if(GameUtil.delay(1000, this, "pea")){
					plantRoleList.get(i).setHp(plantRoleList.get(i).getHp()-this.getAttack());
				}
				return true;
			}
		}
		return false;
	}
	
	
	
	public BaseZombie(AnchorPane component) {
		super(component);
	}
	public int getZombieType() {
		return zombieType;
	}
	public void setZombieType(int zombieType) {
		this.zombieType = zombieType;
	}
	public int getLostHeadType() {
		return lostHeadType;
	}
	public void setLostHeadType(int lostHeadType) {
		this.lostHeadType = lostHeadType;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
}
