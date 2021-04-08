package com.pz.window;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Dialogs.DialogResponse;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import com.pz.util.BaseDao;
import com.pz.util.GameUtil;
import com.pz.util.UserBean;

public class TitlePanel extends AnchorPane {
	/** 排行榜 */
	private RankPanel rankPanel;

	public TitlePanel(final MainFrame mainFrame) {
		setVisible(false);
		ImageView titleImage = new ImageView(GameUtil.titleImage);
		final ImageView startGameImage = new ImageView(GameUtil.startGameImage);
		startGameImage.setLayoutX(480);
		startGameImage.setLayoutY(40);
		final ImageView miniGameImage = new ImageView(GameUtil.miniGameImage);
		miniGameImage.setLayoutX(475);
		miniGameImage.setLayoutY(145);
		final ImageView passwordModeImage = new ImageView(
				GameUtil.passwordModeImage);
		passwordModeImage.setLayoutX(470);
		passwordModeImage.setLayoutY(230);
		final ImageView survivalModeImage = new ImageView(
				GameUtil.survivalModeImage);
		survivalModeImage.setLayoutX(460);
		survivalModeImage.setLayoutY(310);
		ImageView switchNameImage = new ImageView(GameUtil.switchNameImage);
		switchNameImage.setLayoutX(30);
		switchNameImage.setLayoutY(150);
		ImageView comeBackImage = new ImageView(GameUtil.comeBackImage);
		comeBackImage.setLayoutX(30);
		comeBackImage.setLayoutY(0);
		ImageView exitImage = new ImageView(GameUtil.exitImage);
		exitImage.setLayoutX(810);
		exitImage.setLayoutY(500);
		ImageView rankImage = new ImageView(GameUtil.rankImage);
		rankImage.setLayoutX(640);
		rankImage.setLayoutY(490);
		ImageView helpImage = new ImageView(GameUtil.helpImage);
		helpImage.setLayoutX(730);
		helpImage.setLayoutY(510);
		
		UserBean user = BaseDao.findByName("user");
		final Text nametext=new Text(user.getUserName());
		nametext.setLayoutX(160);
		nametext.setLayoutY(110);
		nametext.setFont(Font.font("宋体", FontWeight.BOLD,22));
		nametext.setFill(Color.WHITE);
		
		UserBean userBean=BaseDao.findByName(nametext.getText());
		mainFrame.setUserBean(userBean);

		rankPanel = new RankPanel(mainFrame);
		rankPanel.setMaxWidth(412);
		rankPanel.setMaxHeight(483);
		rankPanel.setLayoutX(230);
		rankPanel.setLayoutY(50);

		getChildren().addAll(titleImage, startGameImage, miniGameImage,
				passwordModeImage, survivalModeImage, switchNameImage,
				comeBackImage, exitImage, rankImage, helpImage, rankPanel,nametext);

		this.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				double x = e.getX();
				double y = e.getY();
				if (!rankPanel.isVisible()) {
					// 开始游戏
					if (x > 488 && x < 777 && y > 70 && y < 155) {
						mainFrame.switchPanel(mainFrame.getTitlePanel(),
								mainFrame.getGamePanel());
						mainFrame.getGamePanel().startGame();
					}
					// 小游戏
					else if (x > 483 && x < 760 && y > 160 && y < 238) {
						Dialogs.showInformationDialog(mainFrame.getStage(),
								"敬请期待", "提示信息", "提示");
					}
					// 解密模式
					else if (x > 478 && x < 762 && y > 242 && y < 320) {
						Dialogs.showInformationDialog(mainFrame.getStage(),
								"敬请期待", "提示信息", "提示");
					}
					// 生存模式
					else if (x > 473 && x < 750 && y > 325 && y < 428) {
						Dialogs.showInformationDialog(mainFrame.getStage(),
								"敬请期待", "提示信息", "提示");
					}
					// 选择存档
					else if (x > 38 && x < 296 && y > 166 && y < 188) {
						String name = Dialogs.showInputDialog(mainFrame.getStage(),
								"姓名：", "请输入姓名", "提示");
						if(name!=null){
							
						
						nametext.setText(name);
						UserBean userBean=new UserBean();
						userBean.setUserName(name);
						if(name.equals(BaseDao.findByName(name).getUserName()) ){
							userBean.setScore(BaseDao.findByName(name).getScore());
						}
						else{
							BaseDao.add(userBean);
						}
						
						mainFrame.setUserBean(userBean);
						BaseDao.changeUser(name);
						}
					}
					// 退出按钮
					else if (x > 805 && x < 865 && y > 500 && y < 529) {
						DialogResponse s = Dialogs.showConfirmDialog(
								mainFrame.getStage(), "退出,确认？", "提示信息", "提示");
						if (DialogResponse.YES == s) {
							System.exit(0);
						}
					}
					// 帮助按钮
					else if (x > 732 && x < 781 && y > 508 && y < 536) {
						mainFrame.switchPanel(mainFrame.getTitlePanel(),
								mainFrame.getHelpPanel());
					}
					// 排行按钮
					else if (x > 645 && x < 713 && y > 488 && y < 519) {
						rankPanel.setVisible(true);
						List<UserBean> list = BaseDao.rank();
						ObservableList<UserBean> data=FXCollections.observableArrayList(list);
						mainFrame.getTitlePanel().rankPanel.getTable().setItems(data);
					}
				}
			}
		});
		
		this.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				double x = e.getX();
				double y = e.getY();
				DropShadow shadow = new DropShadow();
				shadow.setColor(Color.RED);
				if (!rankPanel.isVisible()) {
					// 开始游戏
					if (x > 488 && x < 777 && y > 70 && y < 155) {
						setCursor(Cursor.HAND);
						startGameImage.setEffect(shadow);
					}
					// 小游戏
					else if (x > 483 && x < 760 && y > 160 && y < 238) {
						setCursor(Cursor.HAND);
						miniGameImage.setEffect(shadow);
					}
					// 解密模式
					else if (x > 478 && x < 762 && y > 242 && y < 320) {
						setCursor(Cursor.HAND);
						passwordModeImage.setEffect(shadow);
					}
					// 生存模式
					else if (x > 473 && x < 750 && y > 325 && y < 428) {
						setCursor(Cursor.HAND);
						survivalModeImage.setEffect(shadow);
					}
					// 选择存档
					else if (x > 38 && x < 296 && y > 166 && y < 188) {
						setCursor(Cursor.HAND);
					}
					// 退出按钮
					else if (x > 805 && x < 865 && y > 500 && y < 529) {
						setCursor(Cursor.HAND);
					}
					// 帮助按钮
					else if (x > 732 && x < 781 && y > 508 && y < 536) {
						setCursor(Cursor.HAND);
					}
					// 排行按钮
					else if (x > 645 && x < 713 && y > 488 && y < 519) {
						setCursor(Cursor.HAND);
					} else {
						startGameImage.setEffect(null);
						miniGameImage.setEffect(null);
						passwordModeImage.setEffect(null);
						survivalModeImage.setEffect(null);
						setCursor(Cursor.DEFAULT);
					}
				} else if (x > 290 && x < 595 && y > 445 && y < 505) {
					rankPanel.getSureImage().setEffect(shadow);
					setCursor(Cursor.HAND);
				} else {
					rankPanel.getSureImage().setEffect(null);
					setCursor(Cursor.DEFAULT);
				}
			}
		});

		

	}
}
