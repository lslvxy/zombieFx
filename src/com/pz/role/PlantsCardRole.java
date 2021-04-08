package com.pz.role;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.pz.util.GameUtil;

public class PlantsCardRole extends BaseRole{
	/** 豌豆射手*/
	public static final int PEA_SHOOTER=0;
	/**太阳花*/
	public static final int SUN_FLOWER=1;
	/**樱桃炸弹*/
	public static final int CHEERY_BOMB=2;
	/**坚果墙*/
	public static final int WALL_NUT=3;
	/**土豆雷*/
	public static final int POTATO_MINE=4;
	/**寒冰射手*/
	public static final int SNOW_PEA=5;
	
	/**
	 * 植物卡片的类型
	 */
	private int plantsType;
	
	
	public PlantsCardRole(AnchorPane panel) {
		super(panel);
	}

	@Override
	public void initRole() {
		setRoleWidth(GameUtil.peaShootCard.getWidth());
		setRoleHeight(GameUtil.peaShootCard.getHeight());
	}

	@Override
	public void paintRole(GraphicsContext g) {
		if(plantsType==PEA_SHOOTER){
			g.drawImage(GameUtil.peaShootCard, getRoleX(), getRoleY());
			   
		}else if(plantsType==SUN_FLOWER){
			g.setEffect(null);
			g.drawImage(GameUtil.sunFlowerCard, getRoleX(), getRoleY());
			
		}else if(plantsType==CHEERY_BOMB){
			g.drawImage(GameUtil.cheeryBombCard, getRoleX(), getRoleY());
			
		}else if(plantsType==WALL_NUT){
			g.drawImage(GameUtil.nutWallCard, getRoleX(), getRoleY());
			
		}else if(plantsType==POTATO_MINE){
			g.drawImage(GameUtil.patotoBombCard, getRoleX(), getRoleY());
			
		}else if(plantsType==SNOW_PEA){
			g.drawImage(GameUtil.iceShooterCard, getRoleX(), getRoleY());
			
		}
	}
	
	
	//设置阴影
	public  void  available(GraphicsContext g){
	}


	@Override
	public void action() {
	}

	public int getPlantsType() {
		return plantsType;
	}

	public void setPlantsType(int plantsType) {
		this.plantsType = plantsType;
	}

	
}
