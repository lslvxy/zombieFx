package com.pz.role.plant;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.pz.role.BaseRole;
import com.pz.util.GameUtil;
import com.pz.window.GamePanel;

public class PotatoMineRole extends PlantRole {
	public static final int ROLE_AVAILABLE=25;

	public PotatoMineRole(AnchorPane  component) {
		super(component);
	}

	public void initRole() {
		setHp(3);
		setRoleWidth(GameUtil.potatoMineImage.getWidth());
		setRoleHeight(GameUtil.potatoMineImage.getHeight());
//		setRunStatus(BaseRole.ROLE_NOT_READY);
		setAttack(0);
	}

	public void paintRole(GraphicsContext g) {
		if(getRunStatus()==BaseRole.ROLE_BOM){
			g.drawImage(GameUtil.potatoMineExplodeImage, getRoleX(), getRoleY());
			g.drawImage(GameUtil.potatoMineSpudowImage, getRoleX(), getRoleY());
		}else if(getRunStatus()==BaseRole.ROLE_SECOND){
			g.drawImage(GameUtil.potatoMineImage, getRoleX(), getRoleY());
		}else {
			g.drawImage(GameUtil.potatoMineNotReadyImage, getRoleX(), getRoleY());
		}
	}

	public void action() {

		if(getHp()<=0){
			setRunStatus(ROLE_END);
		}
		GamePanel gamePanel=(GamePanel) getPanel();
			if(GameUtil.delay(10000, this, "notready")){
				setRunStatus(BaseRole.ROLE_SECOND);
				setAttack(1);
			}
		
//		for(int i=0;i<gamePanel.getZombieRoleList().size();i++){
//			if(GameUtil.checkImpact(this, gamePanel.getZombieRoleList().get(i))==true
//					&&getAttack()==1){
//				setRunStatus(ROLE_BOM);
//				GameMusic.playSingleMusic(GameMusic.EXPLOSION);
//				gamePanel.getZombieRoleList().get(i).setHp(0);
//				gamePanel.getZombieRoleList().get(i).setRunStatus(BaseZombie.ROLE_BOM);
//				if(GameUtil.delay(500, this, "bom")){
//					setRunStatus(ROLE_END);
//				}
//			}
//		}
	}

}
