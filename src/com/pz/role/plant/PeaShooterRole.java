package com.pz.role.plant;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.pz.role.BaseRole;
import com.pz.role.PeaShooterBulletRole;
import com.pz.role.zombie.BaseZombie;
import com.pz.util.GameUtil;
import com.pz.window.GamePanel;

public class PeaShooterRole extends PlantRole {
	//设置植物可用状态
	public static final int ROLE_AVAILABLE=100;
	public PeaShooterRole(AnchorPane panel) {
		super(panel);
	}

	@Override
	public void initRole() {
		setHp(8);
		setRoleWidth(GameUtil.peashooterImage.getWidth());
		setRoleHeight(GameUtil.peashooterImage.getHeight());
	}

	@Override
	public void paintRole(GraphicsContext g) {
		g.drawImage(GameUtil.peashooterImage, getRoleX(), getRoleY());
	}

	@Override
	public void action() {
		if(getHp()<=0){
			setRunStatus(ROLE_END);
		}
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
				PeaShooterBulletRole peaShooterBulletRole=new PeaShooterBulletRole(gamePanel);
				peaShooterBulletRole.setRoleX(getRoleX()+30);
				peaShooterBulletRole.setRoleY(getRoleY()+5);
				gamePanel.getPeaShooterBulletList().add(peaShooterBulletRole);
			}
		}
	}

	public static int getRoleAvailable() {
		return ROLE_AVAILABLE;
	}
	
	

}
