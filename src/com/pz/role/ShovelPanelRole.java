package com.pz.role;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.pz.util.GameUtil;

public class ShovelPanelRole extends BaseRole{

	public ShovelPanelRole(AnchorPane panel) {
		super(panel);
	}

	@Override
	public void initRole() {
		setRoleX(540);
		setRoleWidth(GameUtil.shovelImage.getWidth());
		setRoleHeight(GameUtil.shovelImage.getHeight());
	}

	@Override
	public void paintRole(GraphicsContext g) {
		g.drawImage(GameUtil.shovelImage, getRoleX(), getRoleY());
	}

	@Override
	public void action() {
	}

}
