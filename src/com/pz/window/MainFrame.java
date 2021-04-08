package com.pz.window;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import com.pz.util.GameUtil;
import com.pz.util.UserBean;

public class MainFrame extends Application {

	private TitlePanel titlePanel;
	private WelcomePanel welcomePanel ;
	private HelpPanel helpPanel;
	private GamePanel gamePanel;
	/**
	 * 玩家对象
	 */
	private UserBean userBean;
	

	private StackPane stack = new StackPane();
	private Stage stage;
	

	public MainFrame() {
		GameUtil.initImage();
	}

	@Override
	public void start(Stage stage) {
		this.stage =stage;
		Scene scene = new Scene(stack, 900, 600);
		scene.getStylesheets().add("file:resources/DarkTheme.css");
		stage.setResizable(false);
		scene.setFill(Color.WHITE);
		stage.setTitle("植物大战僵尸");
		stage.getIcons().add(GameUtil.iconImage);

		titlePanel = new TitlePanel(this);
		welcomePanel = new WelcomePanel(this);
		helpPanel = new HelpPanel(this);
		gamePanel=new GamePanel(this);
		stack.getChildren().addAll(titlePanel, welcomePanel,helpPanel,gamePanel);
		stack.setAlignment(Pos.CENTER_RIGHT);

		stage.setScene(scene);
		stage.show();

	}

	
	public void switchPanel(AnchorPane fromPanel,AnchorPane toPanel) {
		// 卡片布局管理器中切换面板的方法
		fromPanel.setVisible(false);
		toPanel.setVisible(true);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	
	

	public TitlePanel getTitlePanel() {
		return titlePanel;
	}

	public void setTitlePanel(TitlePanel titlePanel) {
		this.titlePanel = titlePanel;
	}

	public WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}

	public void setWelcomePanel(WelcomePanel welcomePanel) {
		this.welcomePanel = welcomePanel;
	}

	public HelpPanel getHelpPanel() {
		return helpPanel;
	}

	public void setHelpPanel(HelpPanel helpPanel) {
		this.helpPanel = helpPanel;
	}
	
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
}
