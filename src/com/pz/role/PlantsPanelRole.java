package com.pz.role;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import com.pz.util.GameUtil;

public class PlantsPanelRole extends BaseRole{
	public PlantsPanelRole(AnchorPane panel) {
		super(panel);
	}

	/**分数*/
	private Integer number;
	
	@Override
	public void initRole() {
		number=500;
		setRoleX(100);
		setRoleY(0);
	}

	@Override
	public void paintRole(GraphicsContext g) {
		g.drawImage(GameUtil.plantsPanelImage, getRoleX(), getRoleY());
		g.setFont(Font.font("宋体", FontWeight.BLACK, 20));
		g.strokeText(number.toString(), 123, 78);
	}

	@Override
	public void action() {
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
