package com.pz.util;

import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.effect.Light.Point;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import com.pz.role.BaseRole;
import com.pz.role.PlantsCardRole;
import com.pz.role.SunSeedRole;
import com.pz.role.plant.CheeryBombRole;
import com.pz.role.plant.PeaShooterRole;
import com.pz.role.plant.PlantRole;
import com.pz.role.plant.PotatoMineRole;
import com.pz.role.plant.SnowPeaRole;
import com.pz.role.plant.SunFlowerRole;
import com.pz.role.plant.WallNutRole;
import com.pz.window.GamePanel;

/**
 * Copyright (C) FileName: GameControl.java 游戏面板的事件处理类
 * 
 * @author ls
 * @Date 2012-1-13
 * @version 1.00
 */
public class GameMousePressed implements EventHandler<MouseEvent> {

	/** 游戏主面板 */
	private GamePanel gamePanel;

	public GameMousePressed(GamePanel gamePanel) {
		this.gamePanel = gamePanel;

	}

	@Override
	public void handle(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		if (gamePanel.getGameStatus() == BaseRole.GAME_START) {
			if (x > 780 && x < 890 && y > 0 && y < 46) {
				gamePanel.setGameStatus(BaseRole.GAME_END);
				gamePanel.getFrame().switchPanel(gamePanel,
						gamePanel.getFrame().getTitlePanel());
			}

			// 得到植物在草地上的坐标
			Point plantPoint = GameUtil.computerPosition(x, y);
			/*
			 * 判断鼠标是否点击到了某个太阳种子
			 */
			List<SunSeedRole> sunSeedRoleList = gamePanel.getSunSeedRoleList();
			for (int i = 0; i < sunSeedRoleList.size(); i++) {
				if (GameUtil.checkRoleRect(x, y, sunSeedRoleList.get(i))) {
					sunSeedRoleList.get(i).setRunStatus(BaseRole.SEED_MOVE);
				}
			}
			/*
			 * 点击鼠标后植物消失
			 */
			PlantRole selectPlant = gamePanel.getSelectedPlant();
			if (e.getButton() == MouseButton.SECONDARY) {
				gamePanel.setTempPlant(null);
			}
			if (selectPlant != null) {
				gamePanel.setSelectedPlant(null);
			}
			PlantRole tempPlant = gamePanel.getTempPlant();

			if (tempPlant != null) {
				for (int i = 0; i < gamePanel.getPlantRoleList().size(); i++) {
					if (gamePanel.getPlantRoleList().get(i).getRoleX() == plantPoint
							.getX()
							&& gamePanel.getPlantRoleList().get(i).getRoleY() == plantPoint
									.getY()) {
						gamePanel.setTempPlant(null);
					}
				}
				if (gamePanel.getTempPlant() != null) {
					// 当植物安放到草地上时发射子弹
					tempPlant.setRunStatus(BaseRole.NORMAL);
					// 植物添加到草地
					gamePanel.getPlantRoleList().add(tempPlant);
					// 扣除分数
					if (gamePanel.getTempPlant() instanceof PeaShooterRole) {
						gamePanel.getPlantsPanelRole().setNumber(
								gamePanel.getPlantsPanelRole().getNumber()
										- PeaShooterRole.ROLE_AVAILABLE);
					} else if (gamePanel.getTempPlant() instanceof SunFlowerRole) {
						gamePanel.getPlantsPanelRole().setNumber(
								gamePanel.getPlantsPanelRole().getNumber()
										- SunFlowerRole.ROLE_AVAILABLE);
					} else if (gamePanel.getTempPlant() instanceof CheeryBombRole) {
						gamePanel.getPlantsPanelRole().setNumber(
								gamePanel.getPlantsPanelRole().getNumber()
										- CheeryBombRole.ROLE_AVAILABLE);
					} else if (gamePanel.getTempPlant() instanceof WallNutRole) {
						gamePanel.getPlantsPanelRole().setNumber(
								gamePanel.getPlantsPanelRole().getNumber()
										- WallNutRole.ROLE_AVAILABLE);
					} else if (gamePanel.getTempPlant() instanceof PotatoMineRole) {
						gamePanel.getPlantsPanelRole().setNumber(
								gamePanel.getPlantsPanelRole().getNumber()
										- PotatoMineRole.ROLE_AVAILABLE);
					} else if (gamePanel.getTempPlant() instanceof SnowPeaRole) {
						gamePanel.getPlantsPanelRole().setNumber(
								gamePanel.getPlantsPanelRole().getNumber()
										- SnowPeaRole.ROLE_AVAILABLE);
					}
					gamePanel.setTempPlant(null);
				}
			}

			/*
			 * 判断鼠标是否点击到了某个植物卡片
			 */
			List<PlantsCardRole> plantsCardList = gamePanel.getPlantsCardList();
			for (int i = 0; i < plantsCardList.size(); i++) {
				// 判断鼠标是否在某个卡片内
				if (GameUtil.checkRoleRect(x, y, plantsCardList.get(i))) {
					if (plantsCardList.get(i).getPlantsType() == PlantsCardRole.PEA_SHOOTER
							&& gamePanel.getPlantsPanelRole().getNumber() >= PeaShooterRole.ROLE_AVAILABLE) {
						PeaShooterRole peaShooterRole = new PeaShooterRole(
								gamePanel);
						peaShooterRole.setRoleX(x - 25);
						peaShooterRole.setRoleY(y - 35);
						gamePanel.setSelectedPlant(peaShooterRole);
					} else if (plantsCardList.get(i).getPlantsType() == PlantsCardRole.SUN_FLOWER
							&& gamePanel.getPlantsPanelRole().getNumber() >= SunFlowerRole.ROLE_AVAILABLE) {
						SunFlowerRole sunFlowerRole = new SunFlowerRole(
								gamePanel);
						sunFlowerRole.setRoleX(x - 25);
						sunFlowerRole.setRoleY(y - 35);
						gamePanel.setSelectedPlant(sunFlowerRole);
					} else if (plantsCardList.get(i).getPlantsType() == PlantsCardRole.CHEERY_BOMB
							&& gamePanel.getPlantsPanelRole().getNumber() >= CheeryBombRole.ROLE_AVAILABLE) {
						CheeryBombRole cheeryBombRole = new CheeryBombRole(
								gamePanel);
						cheeryBombRole.setRoleX(x - 25);
						cheeryBombRole.setRoleY(y - 35);
						gamePanel.setSelectedPlant(cheeryBombRole);
					} else if (plantsCardList.get(i).getPlantsType() == PlantsCardRole.WALL_NUT
							&& gamePanel.getPlantsPanelRole().getNumber() >= WallNutRole.ROLE_AVAILABLE) {
						WallNutRole wallNutRole = new WallNutRole(gamePanel);
						wallNutRole.setRoleX(x - 25);
						wallNutRole.setRoleY(y - 35);
						gamePanel.setSelectedPlant(wallNutRole);
					} else if (plantsCardList.get(i).getPlantsType() == PlantsCardRole.POTATO_MINE
							&& gamePanel.getPlantsPanelRole().getNumber() >= PotatoMineRole.ROLE_AVAILABLE) {
						PotatoMineRole potatoMineRole = new PotatoMineRole(
								gamePanel);
						potatoMineRole.setRoleX(x - 25);
						potatoMineRole.setRoleY(y - 35);
						gamePanel.setSelectedPlant(potatoMineRole);
					} else if (plantsCardList.get(i).getPlantsType() == PlantsCardRole.SNOW_PEA
							&& gamePanel.getPlantsPanelRole().getNumber() >= SnowPeaRole.ROLE_AVAILABLE) {
						SnowPeaRole snowPeaRole = new SnowPeaRole(gamePanel);
						snowPeaRole.setRoleX(x - 25);
						snowPeaRole.setRoleY(y - 35);
						gamePanel.setSelectedPlant(snowPeaRole);
					}
				}
			}
			// 判断铲子是否点到了植物
			if (gamePanel.getShovelPanelRole().getRunStatus() == BaseRole.SHOVEL_SELECTED) {
				for (PlantRole plant: gamePanel.getPlantRoleList()) {
					if (GameUtil.checkRoleRect(x, y, plant)) {
						plant.setRunStatus(BaseRole.ROLE_END);
					}
				}
			}
			// 铲子初始化到原始位置
			gamePanel.getShovelPanelRole().setRunStatus(BaseRole.NORMAL);
			gamePanel.getShovelPanelRole().setRoleX(540);
			gamePanel.getShovelPanelRole().setRoleY(0);
			//判断鼠标是否点击铲子
			if (GameUtil.checkRoleRect(x, y, gamePanel.getShovelPanelRole())) {
				gamePanel.getShovelPanelRole().setRunStatus(BaseRole.SHOVEL_SELECTED);
				gamePanel.getShovelPanelRole().setRoleX(x - 15);
				gamePanel.getShovelPanelRole().setRoleY(y - 65);
			}

		}
	}

}
