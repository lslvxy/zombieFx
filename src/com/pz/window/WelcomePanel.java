package com.pz.window;


import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import com.pz.util.GameUtil;

public class WelcomePanel extends AnchorPane  {
	private MainFrame mainFrame;
	public WelcomePanel(MainFrame frame) {
		this.mainFrame=frame;
		ImageView imageView=new ImageView(GameUtil.welcomeImage);
		this.getChildren().add(imageView);
		imageView.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				double x=e.getX();
				double y=e.getY();
				if(x>280 && x<615 && y>545 &&y<570){
					mainFrame.switchPanel(mainFrame.getWelcomePanel(), mainFrame.getTitlePanel());
				}
			}
		});
		imageView.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				double x=e.getX();
				double y=e.getY();
				if(x>280 && x<615 && y>545 &&y<570){
					setCursor(Cursor.HAND);
				}else{
					setCursor(Cursor.DEFAULT);
				}
			}
		});
	}
}
