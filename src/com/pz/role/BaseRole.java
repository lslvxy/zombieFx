package com.pz.role;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

public abstract class BaseRole {

	/**角色正常运行的状态*/
	public static final int NORMAL=0;
	/**角色消失的状态*/
	public static final int ROLE_END = 1;
	/**游戏开始的状态*/
	public static final int GAME_START=2;
	/**游戏结束的状态*/
	public static final int GAME_END=3;
	/**太阳种子点击后移动的状态*/
	public static final int SEED_MOVE=4;
	/**太阳种子掉落的状态*/
	public static final int SEED_STOP=5;
	
	/**发射子弹的状态*/
	public static final int SEND_BULLET=6;
	/**阴影状态*/
	public static final int PLANT_TEMP=7;
	/**爆炸状态*/
	public static final int ROLE_BOM=8;
	/**铲子被选中的状态*/
	public static final int SHOVEL_SELECTED=9;
	/**推车运动的状态*/
	public static final int CAR_RUN=10;
	/**是否发射子弹的状态*/
	public static final int SEND=11;
	/**角色第二状态*/
	public static final int ROLE_SECOND=12;
	/**角色第三状态*/
	public static final int ROLE_THIRD=13;
	/**地图移动状态*/
	public static final int MAP_STOP=14;
	/**准备安放植物*/
	public static final int GAME_READY=15;
	public static final int GAME_SET=16;
	public static final int GAME_PLANT=17;
	/**僵尸吃掉了你的脑子*/
	public static final int GAME_ZOMBIE_WON=18;
	/**胜利*/
	public static final int GAME_VICTORY = 19;
	public static final int BULLE_STOP = 20;
	
	
	
	/**角色的x坐标*/
	private double roleX;
	/**角色的y坐标*/
	private double roleY;
	/**角色的宽度*/
	private double roleWidth;
	/**角色的高度*/
	private double roleHeight;
	/**角色的运行状态*/
	private int runStatus;
	/**角色每次的移动距离*/
	private double moveLength;
	/**角色的HP*/
	private double hp;
	/**角色的攻击力*/
	private double attack;
	
	private AnchorPane panel;
	public BaseRole(AnchorPane panel) {
		this.panel=panel;
		initRole();
	}
	/**
	 * 初始化角色属性
	 */
	public abstract void initRole();
	
	/**
	 * 绘制角色
	 * @param g
	 */
	public abstract void paintRole(GraphicsContext g);
	
	/**
	 * 角色执行的动作
	 */
	public abstract void action();
	
	
	
	public double getRoleX() {
		return roleX;
	}
	public void setRoleX(double roleX) {
		this.roleX = roleX;
	}
	public double getRoleY() {
		return roleY;
	}
	public void setRoleY(double roleY) {
		this.roleY = roleY;
	}
	public double getRoleWidth() {
		return roleWidth;
	}
	public void setRoleWidth(double roleWidth) {
		this.roleWidth = roleWidth;
	}
	public double getRoleHeight() {
		return roleHeight;
	}
	public void setRoleHeight(double roleHeight) {
		this.roleHeight = roleHeight;
	}
	public int getRunStatus() {
		return runStatus;
	}
	public void setRunStatus(int runStatus) {
		this.runStatus = runStatus;
	}
	public double getMoveLength() {
		return moveLength;
	}
	public void setMoveLength(double moveLength) {
		this.moveLength = moveLength;
	}
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public double getAttack() {
		return attack;
	}
	public void setAttack(double attack) {
		this.attack = attack;
	}
	public AnchorPane getPanel() {
		return panel;
	}
	public void setPanel(AnchorPane panel) {
		this.panel = panel;
	}

	
	
}
