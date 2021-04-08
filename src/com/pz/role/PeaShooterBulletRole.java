package com.pz.role;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.pz.role.zombie.BaseZombie;
import com.pz.util.GameUtil;
import com.pz.window.GamePanel;


public class PeaShooterBulletRole extends BaseRole {

	public PeaShooterBulletRole(AnchorPane component) {
		super(component);
	}
	public void initRole() {
		setAttack(1);
		setMoveLength(15);
		setRoleWidth(GameUtil.peaShooterBulletImage.getWidth());
		setRoleHeight(GameUtil.peaShooterBulletImage.getHeight());
	}

	public void paintRole(GraphicsContext g) {
		if(getRunStatus()==ROLE_BOM){
			g.drawImage(GameUtil.peaShooterBulletBomImage, getRoleX(), getRoleY());
		}else{
			g.drawImage(GameUtil.peaShooterBulletImage, getRoleX(), getRoleY());
		}
	}

	public void action() {
		double moveX=getMoveLength();
		//判断子弹与僵尸碰撞
		GamePanel gamePanel=(GamePanel)getPanel();
		if(getRunStatus()==ROLE_BOM){
			if(GameUtil.delay(100, this, "bom")){
				setRunStatus(ROLE_END);
			}
		}else{
			//检查子弹与僵尸是否碰撞
			List<BaseZombie> zombieList=gamePanel.getZombieRoleList();
			for(int i=0;i<zombieList.size();i++){
				if(GameUtil.checkImpact(this, zombieList.get(i))){
					zombieList.get(i).setHp(zombieList.get(i).getHp()-getAttack());
					setRunStatus(BaseRole.ROLE_BOM);
				}
			}
			setRoleX(getRoleX()+moveX);
		}
		if(getRoleX()>900){
			setRunStatus(ROLE_END);
		}
		
		
	}

}
