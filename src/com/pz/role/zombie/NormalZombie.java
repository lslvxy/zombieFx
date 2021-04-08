package com.pz.role.zombie;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import com.pz.util.GameUtil;
import com.pz.util.UserBean;
import com.pz.window.GamePanel;

public class NormalZombie extends BaseZombie{
	//头掉落
//	private Image zombieHeadImage;
//	//死亡尸体
//	private Image zombieDeadImage;
//	//爆炸尸体
//	private Image zombieBoomImage;

	public NormalZombie(AnchorPane component) {
		super(component);
	}

	public void initRole() {
		//每个僵尸角色都重新加载一次图片
//		zombieHeadImage=GameUtil.normalZombieHeadImage);
//		zombieDeadImage=GameImage.loadImage(GameUtil.normalZombieDeadImage);
//		zombieBoomImage=GameImage.loadImage(GameUtil.boomDieImage);
		int posX=(int)(Math.random()*150);
		int posY=(int)(Math.random()*5);
		setRoleX(1000+posX);
		setRoleY(posY*92+110);
		setRoleWidth(10);
		setRoleHeight(50);
		setMoveLength(5);
		//设置HP
		setHp(20);
		//设置僵尸的走路状态
		setZombieType(ZOMBIE_WALK);
		//设置攻击力
		setAttack(1);
		//设置分数
		setScore(100);
		
	}

	public void paintRole(GraphicsContext g) {
		if(getZombieType()==ZOMBIE_WALK){
			g.drawImage(GameUtil.normalZombieWarkImage, getRoleX()-80,getRoleY()-60);
		}else
		if(getZombieType()==ZOMBIE_ATTACK){
			g.drawImage(GameUtil.normalZombieAttackImage, getRoleX()-80,getRoleY()-60);
		}else
		if(getZombieType()==ZOMBIE_NOHEAD_WALK || getZombieType()==ZOMBIE_LOST_HEAD){
			g.drawImage(GameUtil.normalZombieLostHeadWarkImage, getRoleX()-80,getRoleY()-60);
		}else
		if(getZombieType()==ZOMBIE_NOHEAD_ATTACK|| getZombieType()==ZOMBIE_LOST_HEAD){
			g.drawImage(GameUtil.normalZombieLostHeadAttackImage, getRoleX()-80,getRoleY()-60);
		}else
		
		if(getZombieType()==ZOMBIE_DEAD){
			g.drawImage(GameUtil.normalZombieDeadImage, getRoleX()-80,getRoleY()-60);
		}else
		if(getZombieType()==ZOMBIE_BOOM){
			g.drawImage(GameUtil.boomDieImage, getRoleX()-80,getRoleY()-60);
		}
		if(getLostHeadType()==ZOMBIE_LOST_HEAD){
			g.drawImage(GameUtil.normalZombieHeadImage, getRoleX()-80,getRoleY()-60);
		}
		
//		g.drawRect(getRoleX(), getRoleY(), getRoleWidth(), getRoleHeight());
	}

	public void action() {
		super.action();
		GamePanel gamePanel=(GamePanel)getPanel();
		if(getZombieType()==ZOMBIE_BOOM){
			UserBean userBean=gamePanel.getFrame().getUserBean();
			userBean.setScore(userBean.getScore()+getScore());
			setScore(0);
			setMoveLength(0);
			if(GameUtil.delay(2000, this, "boom")){
				setRunStatus(ROLE_END);
			}
		}
		
		/*
		 * 僵尸减血
		 */
		if(getHp() < 5 && getHp()>0 ){
			//无头状态
			if(getLostHeadType()!=ZOMBIE_NO_HEAD){
				setLostHeadType(ZOMBIE_LOST_HEAD);
			}
			//头消失
			if(GameUtil.delay(1000, this, "losthead")){
				setLostHeadType(ZOMBIE_NO_HEAD);
				setAttack(0);
			}
			setZombieType(ZOMBIE_NOHEAD_WALK);
		}
		
		//死亡
		if(getHp()<=0 ){
			UserBean userBean=gamePanel.getFrame().getUserBean();
			userBean.setScore(userBean.getScore()+getScore());
			setScore(0);
			if(getRunStatus()==ROLE_BOM){
				setZombieType(ZOMBIE_BOOM);
			}else{
				setZombieType(ZOMBIE_DEAD);
			}
			setRoleHeight(0);
			setRoleWidth(0);
			if(GameUtil.delay(3000, this, "dead")){
				setRunStatus(ROLE_END);
			}
		}else {
			//将侧僵尸是否与植物碰撞
			if(checkZombieAndPlantsImpact()){
				if(getZombieType()==ZOMBIE_WALK){
					setZombieType(ZOMBIE_ATTACK);
				}else if(getZombieType()==ZOMBIE_NOHEAD_WALK){
					setZombieType(ZOMBIE_NOHEAD_ATTACK);
				}else if(getZombieType()==BUCKETHEAD_ZOMBIE_WALK){
					setZombieType(BUCKETHEAD_ZOMBIE_ATTACK);
				}
			}else{
				if(getZombieType()==ZOMBIE_ATTACK){
					setZombieType(ZOMBIE_WALK);
				}else if(getZombieType()==ZOMBIE_NOHEAD_ATTACK){
					setZombieType(ZOMBIE_NOHEAD_WALK);
				}else if(getZombieType()==BUCKETHEAD_ZOMBIE_ATTACK){
					setZombieType(BUCKETHEAD_ZOMBIE_WALK);
				}
				if(GameUtil.delay(200, this, "move")){
					double moveX=-getMoveLength();
					setRoleX(getRoleX()+moveX);
				}
			}
		}
		
	}
	
	
}
