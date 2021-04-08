package com.pz.role;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light.Point;
import javafx.scene.layout.AnchorPane;

import com.pz.util.GameUtil;
import com.pz.window.GamePanel;

public class SunSeedRole extends BaseRole {

	private List<Point> pointList;

	public SunSeedRole(AnchorPane component) {
		super(component);
	}

	public void initRole() {
		setMoveLength(5);
		setRoleHeight(GameUtil.sunSeedImage.getHeight());
		setRoleWidth(GameUtil.sunSeedImage.getWidth());
	}

	public void paintRole(GraphicsContext g) {
		g.drawImage(GameUtil.sunSeedImage, getRoleX(), getRoleY());
	}

	public void action() {
		double moveY = getMoveLength();
		// //当太阳种子被点击之后移动的方法
		if (getRunStatus() == SEED_MOVE) {
			if (pointList != null) {
				return;
			}
			new Thread() {
				public void run() {
					pointList = GameUtil.getLinePoint(getRoleX(), getRoleY(),100, 0);
					for (int i = 0; i < pointList.size(); i++) {
						setRoleX(pointList.get(i).getX());
						setRoleY(pointList.get(i).getY());
						GameUtil.sleep(1);
					}
					// 等待2秒后消失
						GameUtil.sleep(200);
						setRunStatus(BaseRole.ROLE_END);
						// 统计分数
						GamePanel gamePanel = (GamePanel) getPanel();
						gamePanel.getPlantsPanelRole().setNumber(gamePanel.getPlantsPanelRole().getNumber() + 25);
				}
			}.start();
		} else
		// 移动到最下方停顿2秒后消失
		if (getRoleY() > 500) {
			// 开始计时
			if (GameUtil.delay(2000, this, "sun")) {
				setRunStatus(ROLE_END);
			}
		} else if (getRunStatus() == SEED_STOP) {
			if (GameUtil.delay(5000, this, "suns")) {
				setRunStatus(ROLE_END);
			}
		} else {
			// 设置太阳种子的Y坐标，使其落下
			setRoleY(getRoleY() + moveY);
		}
	}
}
