package com.pz.role.plant;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.pz.role.SunSeedRole;
import com.pz.util.GameUtil;
import com.pz.window.GamePanel;

public class SunFlowerRole extends PlantRole {
	public static final int ROLE_AVAILABLE = 50;

	public SunFlowerRole(AnchorPane component) {
		super(component);
	}

	public void initRole() {
		setHp(8);
		setRoleWidth(GameUtil.sunFlowerImage.getWidth());
		setRoleHeight(GameUtil.sunFlowerImage.getHeight());
	}

	public void paintRole(GraphicsContext g) {
		g.drawImage(GameUtil.sunFlowerImage, getRoleX(), getRoleY());
	}

	public void action() {

		if (getHp() <= 0) {
			setRunStatus(ROLE_END);
		}

		if (GameUtil.delay(1000 * ((int) (Math.random() * 6 + 8)), this, "sun")) {
			GamePanel gamePanel = (GamePanel) getPanel();
			SunSeedRole sunSeedRole = new SunSeedRole(gamePanel);
			sunSeedRole.setRoleX(getRoleX());
			sunSeedRole.setRoleY(getRoleY()+50);
			sunSeedRole.setRunStatus(SEED_STOP);
			gamePanel.getSunSeedRoleList().add(sunSeedRole);
		}
	}

}
