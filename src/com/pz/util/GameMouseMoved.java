package com.pz.util;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.effect.Light.Point;
import javafx.scene.input.MouseEvent;

import com.pz.role.BaseRole;
import com.pz.role.plant.CheeryBombRole;
import com.pz.role.plant.PeaShooterRole;
import com.pz.role.plant.PlantRole;
import com.pz.role.plant.PotatoMineRole;
import com.pz.role.plant.SnowPeaRole;
import com.pz.role.plant.SunFlowerRole;
import com.pz.role.plant.WallNutRole;
import com.pz.window.GamePanel;

public class GameMouseMoved implements EventHandler<MouseEvent> {
	/** 游戏主面板 */
	private GamePanel gamePanel;

	public GameMouseMoved(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void handle(MouseEvent e) {

		double x = e.getX();
		double y = e.getY();
		PlantRole selectedPlant = gamePanel.getSelectedPlant();
		// 得到植物在草地上的坐标
		Point plantPoint = GameUtil.computerPosition(x, y);
		// 让被选中的植物跟着鼠标走
		if (selectedPlant != null) {
			selectedPlant.setRoleX(x - 25);
			selectedPlant.setRoleY(y - 35);
			// 如果鼠标进入草地，则plantpoint不为空，生成阴影
			if (plantPoint != null) {
				if (selectedPlant instanceof PeaShooterRole) {
					PeaShooterRole peaShooterRole = new PeaShooterRole(
							gamePanel);
					peaShooterRole.setRoleX(plantPoint.getX());
					peaShooterRole.setRoleY(plantPoint.getY());
					peaShooterRole.setRunStatus(BaseRole.PLANT_TEMP);
					gamePanel.setTempPlant(peaShooterRole);
				} else if (selectedPlant instanceof SunFlowerRole) {
					SunFlowerRole sunFlowerRole = new SunFlowerRole(gamePanel);
					sunFlowerRole.setRoleX(plantPoint.getX());
					sunFlowerRole.setRoleY(plantPoint.getY());
					sunFlowerRole.setRunStatus(BaseRole.PLANT_TEMP);
					gamePanel.setTempPlant(sunFlowerRole);
				} else if (selectedPlant instanceof CheeryBombRole) {
					CheeryBombRole cheeryBombRole = new CheeryBombRole(
							gamePanel);
					cheeryBombRole.setRoleX(plantPoint.getX());
					cheeryBombRole.setRoleY(plantPoint.getY());
					cheeryBombRole.setRunStatus(BaseRole.PLANT_TEMP);
					gamePanel.setTempPlant(cheeryBombRole);
				} else if (selectedPlant instanceof WallNutRole) {
					WallNutRole wallNutRole = new WallNutRole(gamePanel);
					wallNutRole.setRoleX(plantPoint.getX());
					wallNutRole.setRoleY(plantPoint.getY());
					wallNutRole.setRunStatus(BaseRole.PLANT_TEMP);
					gamePanel.setTempPlant(wallNutRole);
				} else if (selectedPlant instanceof PotatoMineRole) {
					PotatoMineRole potatoMineRole = new PotatoMineRole(
							gamePanel);
					potatoMineRole.setRoleX(plantPoint.getX());
					potatoMineRole.setRoleY(plantPoint.getY());
					potatoMineRole.setRunStatus(BaseRole.PLANT_TEMP);
					gamePanel.setTempPlant(potatoMineRole);
				} else if (selectedPlant instanceof SnowPeaRole) {
					SnowPeaRole snowPeaRole = new SnowPeaRole(gamePanel);
					snowPeaRole.setRoleX(plantPoint.getX());
					snowPeaRole.setRoleY(plantPoint.getY());
					snowPeaRole.setRunStatus(BaseRole.PLANT_TEMP);
					gamePanel.setTempPlant(snowPeaRole);
				}
			} else {
				gamePanel.setTempPlant(null);
			}
		}

		if (gamePanel.getShovelPanelRole().getRunStatus() == BaseRole.SHOVEL_SELECTED) {
			gamePanel.getShovelPanelRole().setRoleX(x - 15);
			gamePanel.getShovelPanelRole().setRoleY(y - 65);
		}

		if (x > 780 && x < 890 && y > 0 && y < 46) {
			gamePanel.setCursor(Cursor.HAND);
		} else {
			gamePanel.setCursor(Cursor.DEFAULT);
		}
	}

}
