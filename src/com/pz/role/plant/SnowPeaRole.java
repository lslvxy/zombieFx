package com.pz.role.plant;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.pz.role.BaseRole;
import com.pz.role.SnowPeaShooterBulletRole;
import com.pz.role.zombie.BaseZombie;
import com.pz.util.GameUtil;
import com.pz.window.GamePanel;

public class SnowPeaRole extends PlantRole {
	public static final int ROLE_AVAILABLE = 175;

	public SnowPeaRole(AnchorPane component) {
		super(component);
	}

	public void initRole() {
		setHp(8);
		setRoleWidth(GameUtil.snowPeatImage.getWidth());
		setRoleHeight(GameUtil.snowPeatImage.getHeight());
	}

	public void paintRole(GraphicsContext g) {
		g.drawImage(GameUtil.snowPeatImage, getRoleX(), getRoleY());
	}

	public void action() {


		if(getHp()<=0){
			setRunStatus(ROLE_END);
		}
		//植物所在线上有僵尸则发射子弹
		List<BaseZombie> zombieRoleList=((GamePanel) getPanel()).getZombieRoleList();
		for(int i = 0;i < zombieRoleList.size();i++){
			if(zombieRoleList.get(i).getRoleX() < 880
					&& zombieRoleList.get(i).getRoleY() == getRoleY()
					&&getRunStatus()!=ROLE_END
					&&zombieRoleList.get(i).getHp() > 0){
				setRunStatus(SEND_BULLET);
			}
			if(zombieRoleList.get(i).getHp() <= 0
					||zombieRoleList.get(i).getZombieType()==BaseZombie.ZOMBIE_BOOM){
				setRunStatus(NORMAL);
			}
		}
		if(getRunStatus()==BaseRole.SEND_BULLET){
			//每隔多少时间发射一颗子弹
			if(GameUtil.delay(2000, this, "sendbullet")){
				GamePanel gamePanel=(GamePanel)getPanel();
				SnowPeaShooterBulletRole snowPeaShooterBulletRole=new SnowPeaShooterBulletRole(gamePanel);
				snowPeaShooterBulletRole.setRoleX(getRoleX()+30);
				snowPeaShooterBulletRole.setRoleY(getRoleY()+5);
				gamePanel.getSnowPeaShooterBulletList().add(snowPeaShooterBulletRole);
			}
		}
	}

}
