package com.pz.window;


import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import com.pz.util.GameUtil;

public class HelpPanel extends AnchorPane {

	public HelpPanel(final MainFrame mainFrame) {
		this.setVisible(false);
		ImageView helpBackground=new ImageView(GameUtil.helpBackground);
		ImageView helpListImage=new ImageView(GameUtil.helpListImage);
		helpListImage.setLayoutX(150);
		helpListImage.setLayoutY(50);
		ImageView backImage=new ImageView(GameUtil.backImage);
		backImage.setLayoutX(600);
		backImage.setLayoutY(450);
		Text helpText = new Text("返回");
		helpText.setFont(Font.font("宋体",FontWeight.BLACK,30));
		helpText.setFill(Color.RED);
		helpText.setLayoutX(650);
		helpText.setLayoutY(480);
		
		helpText.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mainFrame.switchPanel(mainFrame.getHelpPanel(), mainFrame.getTitlePanel());
			}
		});
		
		helpText.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setCursor(Cursor.HAND);
			}
		});
		helpText.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setCursor(Cursor.DEFAULT);
			}
		});
		
		
		this.getChildren().addAll(helpBackground,helpListImage,backImage,helpText);
	}

}
