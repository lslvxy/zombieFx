package com.pz.role;

import com.pz.util.GameUtil;
import com.pz.window.GamePanel;
import com.pz.window.MainFrame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MapRole extends BaseRole{

	public MapRole(AnchorPane panel) {
		super(panel);
	}

	@Override
	public void initRole() {
	}

	@Override
	public void paintRole(GraphicsContext g) {
		g.drawImage(GameUtil.mapImage, -120, 0);
		//绘制主菜单
		g.drawImage(GameUtil.menuButtonImage, 780, 0);
		g.setFont(Font.font("楷体", FontWeight.BOLD, 33));
		g.strokeText("主菜单", 780, 35);
		//绘制玩家姓名和分数
		g.setFont(Font.font("楷体", FontWeight.BOLD, 22));
		g.setStroke(Color.RED);
		MainFrame frame = ((GamePanel)getPanel()).getFrame();
		g.strokeText("玩家:"+frame.getUserBean().getUserName()+"      分数:"+frame.getUserBean().getScore(), 50, 595);
		g.setStroke(Color.BLACK);	
		
		
		
	}

	@Override
	public void action() {
	}

}
