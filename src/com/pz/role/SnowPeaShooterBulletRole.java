package com.pz.role;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.pz.role.zombie.BaseZombie;
import com.pz.util.GameUtil;
import com.pz.window.GamePanel;

public class SnowPeaShooterBulletRole extends BaseRole {

	public SnowPeaShooterBulletRole(AnchorPane component) {
		super(component);
	}

	public void initRole() {
		setAttack(2);
		setMoveLength(15);
		setRoleWidth(GameUtil.snowPeaShooterBulletImage.getWidth());
		setRoleHeight(GameUtil.snowPeaShooterBulletImage.getHeight());
	}

	public void paintRole(GraphicsContext g) {
		if (getRunStatus() == ROLE_BOM) {
			g.drawImage(GameUtil.snowPeaShooterBulletBomImage, getRoleX(),
					getRoleY());
		} else {
			g.drawImage(GameUtil.snowPeaShooterBulletImage, getRoleX(),
					getRoleY());
		}
	}

	public void action() {
		double moveX=getMoveLength();
		//判断子弹与僵尸碰撞
		GamePanel gamePanel=(GamePanel)getPanel();
		if(getRunStatus()==ROLE_BOM){
			if(GameUtil.delay(300, this, "bom")){
				setRunStatus(ROLE_END);
			}
		}else{
			List<BaseZombie> zombieList=gamePanel.getZombieRoleList();
			for(int i=0;i<zombieList.size();i++){
				if(GameUtil.checkImpact(this, zombieList.get(i))){
					setRunStatus(BaseRole.ROLE_BOM);
					zombieList.get(i).setMoveLength(3);
					zombieList.get(i).setHp(zombieList.get(i).getHp()-getAttack());
				}
			}
			setRoleX(getRoleX()+moveX);
		}
		if(getRoleX()>900){
			setRunStatus(ROLE_END);
		}
	}

}
