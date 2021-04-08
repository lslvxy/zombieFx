package com.pz.role.plant;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.pz.role.BaseRole;
import com.pz.util.GameUtil;

public class CheeryBombRole extends PlantRole {
	public CheeryBombRole(AnchorPane panel) {
		super(panel);
	}

	public static final int ROLE_AVAILABLE = 150;

	// private int cheeryBombIndex=0;

	public void initRole() {
		setHp(8);
		setRoleWidth(GameUtil.CheeryBombImage.getWidth());
		setRoleHeight(GameUtil.CheeryBombImage.getHeight());
	}

	public void paintRole(GraphicsContext g) {

		if (getRunStatus() == BaseRole.ROLE_BOM) {
			g.drawImage(GameUtil.CheeryBombExplodeImage, getRoleX(), getRoleY());
		} else {
			g.drawImage(GameUtil.CheeryBombImage, getRoleX(), getRoleY());
		}

	}

	public void action() {

		if(getHp()<=0){
			setRunStatus(ROLE_END);
		}
//		if(getRunStatus()!=ROLE_END){
		if(GameUtil.delay(1000, this, "bom")){
//			System.out.println(x+"   "+y);
//			GamePanel gamePanel=(GamePanel) getPanel();
//			for(int i=0;i<gamePanel.getZombieRoleList().size();i++){
//				double x=this.getRoleX();
//				double y=this.getRoleY();
//				if(
//						gamePanel.getZombieRoleList().get(i).getRoleX()<(x+150)
//						&&gamePanel.getZombieRoleList().get(i).getRoleY()<(y+150)
//						&&gamePanel.getZombieRoleList().get(i).getRoleX()>(x-100)
//						&&gamePanel.getZombieRoleList().get(i).getRoleY()>(y-100)
//						){
//					gamePanel.getZombieRoleList().get(i).setHp(0);
//					gamePanel.getZombieRoleList().get(i).setRunStatus(BaseZombie.ROLE_BOM);
////					System.out.println(gamePanel.getZombieRoleList().get(i).getZombieType());
////					gamePanel.getZombieRoleList().get(i).setZombieType(BaseZombie.ZOMBIE_BOOM);
//				}
//			}
			setRunStatus(ROLE_BOM);
		}
		
		if(GameUtil.delay(1500, this, "bomb")){
			setRunStatus(ROLE_END);
		}
	}

}
