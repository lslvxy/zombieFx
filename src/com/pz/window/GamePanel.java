package com.pz.window;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import com.pz.role.BaseRole;
import com.pz.role.CarPanelRole;
import com.pz.role.MapRole;
import com.pz.role.PeaShooterBulletRole;
import com.pz.role.PlantsCardRole;
import com.pz.role.PlantsPanelRole;
import com.pz.role.ProgressRole;
import com.pz.role.ShovelPanelRole;
import com.pz.role.SnowPeaShooterBulletRole;
import com.pz.role.SunSeedRole;
import com.pz.role.plant.PlantRole;
import com.pz.role.zombie.BaseZombie;
import com.pz.util.BaseDao;
import com.pz.util.GameMouseMoved;
import com.pz.util.GameMousePressed;
import com.pz.util.GameUtil;

public class GamePanel extends AnchorPane  {
	/** 画笔 */
	private GraphicsContext g;
	private Canvas canvas;
	/** 游戏的状态 */
	private int gameStatus;
	/** 游戏的主窗口 */
	private MainFrame frame;
	/** 地图角色 */
	private MapRole mapRole;

	/** 关卡进度角色 */
	private ProgressRole progressRole;

	/** 选择植物角色 */
	private PlantsPanelRole plantsPanelRole;
	/** 推车角色集合 */
	private List<CarPanelRole> carPanelList;
	/** 太阳种子角色集合 */
	private List<SunSeedRole> sunSeedRoleList;
	/** 铲子角色 */
	private ShovelPanelRole shovelPanelRole;
	/** 植物卡片角色集合 */
	private List<PlantsCardRole> plantsCardList;
	/** 所有植物角色集合 */
	private List<PlantRole> plantRoleList;
	/** 被选中的植物对象 */
	private PlantRole selectedPlant;

	/** 植物在草地上的阴影 */
	private PlantRole tempPlant;
	/** 豌豆射手子弹角色集合 */
	private List<PeaShooterBulletRole> peaShooterBulletList;

	/** 寒冰射手子弹角色集合 */
	private List<SnowPeaShooterBulletRole> snowPeaShooterBulletList;

	/** 所有僵尸角色集合 */
	private List<BaseZombie> zombieRoleList;

	public GamePanel(MainFrame mainFrame) {
		this.frame = mainFrame;
		setVisible(false);
		canvas = new Canvas(900, 600); // 构建画布
		g = canvas.getGraphicsContext2D(); // 获取画笔
		startGame();
		getChildren().addAll(canvas);
		GameMousePressed gameMousePressed = new GameMousePressed(this);
		GameMouseMoved gameMouseMoved = new GameMouseMoved(this);
		this.setOnMousePressed(gameMousePressed);
		this.setOnMouseMoved(gameMouseMoved);
	}

	/**
	 * 初始化角色的方法
	 */
	public void init() {
		// 初始化地图
		mapRole = new MapRole(this);
		// 初始化选择植物
		plantsPanelRole = new PlantsPanelRole(this);
		// 初始化铲子
		shovelPanelRole = new ShovelPanelRole(this);
		// 初始化推车
		carPanelList = new ArrayList<CarPanelRole>();
		for (int i = 0; i < 5; i++) {
			CarPanelRole carPanelRole = new CarPanelRole(this);
			carPanelRole.setRoleY(i * 92 + 110);
			carPanelList.add(carPanelRole);
		}
		/*
		 * 初始化植物卡片
		 */
		plantsCardList = new ArrayList<PlantsCardRole>();

		PlantsCardRole peaShootCard = new PlantsCardRole(this);
		peaShootCard.setRoleX(180);
		peaShootCard.setRoleY(10);
		peaShootCard.setPlantsType(PlantsCardRole.PEA_SHOOTER);
		plantsCardList.add(peaShootCard);
		// 太阳花
		PlantsCardRole sunFlowerCard = new PlantsCardRole(this);
		sunFlowerCard.setRoleX(240);
		sunFlowerCard.setRoleY(10);
		sunFlowerCard.setPlantsType(PlantsCardRole.SUN_FLOWER);
		plantsCardList.add(sunFlowerCard);

		// 樱桃炸弹
		PlantsCardRole cheeryBombCard = new PlantsCardRole(this);
		cheeryBombCard.setRoleX(300);
		cheeryBombCard.setRoleY(10);
		cheeryBombCard.setPlantsType(PlantsCardRole.CHEERY_BOMB);
		plantsCardList.add(cheeryBombCard);

		// 坚果墙
		PlantsCardRole nutWallCard = new PlantsCardRole(this);
		nutWallCard.setRoleX(360);
		nutWallCard.setRoleY(10);
		nutWallCard.setPlantsType(PlantsCardRole.WALL_NUT);
		plantsCardList.add(nutWallCard);
		// 土豆雷
		PlantsCardRole patotoBombCard = new PlantsCardRole(this);
		patotoBombCard.setRoleX(420);
		patotoBombCard.setRoleY(10);
		patotoBombCard.setPlantsType(PlantsCardRole.POTATO_MINE);
		plantsCardList.add(patotoBombCard);
		// 寒冰射手
		PlantsCardRole iceShooterCard = new PlantsCardRole(this);
		iceShooterCard.setRoleX(480);
		iceShooterCard.setRoleY(10);
		iceShooterCard.setPlantsType(PlantsCardRole.SNOW_PEA);
		plantsCardList.add(iceShooterCard);

		// 初始化所有植物
		plantRoleList = new ArrayList<PlantRole>();

		// 初始化豌豆射手子弹
		peaShooterBulletList = new ArrayList<PeaShooterBulletRole>();
		// 初始化寒冰射手子弹
		snowPeaShooterBulletList = new ArrayList<SnowPeaShooterBulletRole>();

		progressRole = new ProgressRole(this);
		// 初始化太阳花种子
		sunSeedRoleList = new ArrayList<SunSeedRole>();
		zombieRoleList = new ArrayList<BaseZombie>();

		paint();
	}

	void paint() {
		mapRole.paintRole(g);
		plantsPanelRole.paintRole(g);

		for (CarPanelRole car : carPanelList) {
			car.paintRole(g);
		}
		for (PlantsCardRole plantsCard : plantsCardList) {
			plantsCard.paintRole(g);
		}
		progressRole.paintRole(g);
		// 绘制被选择的植物
		if (selectedPlant != null) {
			selectedPlant.paintRole(g);
		}
		// 绘制植物阴影
		if (tempPlant != null) {
			tempPlant.paintRole(g);
		}
		// 绘制植物
		for (int i = 0; i < plantRoleList.size(); i++) {
			plantRoleList.get(i).paintRole(g);
		}
		// 绘制僵尸
		for (int i = 0; i < zombieRoleList.size(); i++) {
			zombieRoleList.get(i).paintRole(g);
		}
		// 绘制豌豆射手子弹
		for (int i = 0; i < peaShooterBulletList.size(); i++) {
			peaShooterBulletList.get(i).paintRole(g);
		}
		// 绘制寒冰射手子弹
		for (int i = 0; i < snowPeaShooterBulletList.size(); i++) {
			snowPeaShooterBulletList.get(i).paintRole(g);
		}

		// 绘制铲子
		shovelPanelRole.paintRole(g);

		// 绘制太阳种子
		for (int i = 0; i < sunSeedRoleList.size(); i++) {
			sunSeedRoleList.get(i).paintRole(g);
		}
	}

	/**
	 * 开始游戏
	 */
	public void startGame() {
		init();
		gameStatus = BaseRole.GAME_START;
		// 太阳种子落下
		GameUtil.generateSunSeed(this);
		// 产生僵尸
		GameUtil.generateZombie(this);
		initTimeLine();
	}

	

	private void initTimeLine() {
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);

		KeyFrame keyFrame = new KeyFrame(Duration.millis(100),
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {

						// 太阳种子
						for (int i = sunSeedRoleList.size() - 1; i >= 0; i--) {
							sunSeedRoleList.get(i).action();
							if (sunSeedRoleList.get(i).getRunStatus() == BaseRole.ROLE_END) {
								sunSeedRoleList.remove(i);
							}
						}

						// 植物卡片
						for (int i = plantsCardList.size() - 1; i >= 0; i--) {
							plantsCardList.get(i).action();
						}
						// 铲子动作
						shovelPanelRole.action();
						// 草地上的植物动作
						for (int i = plantRoleList.size() - 1; i >= 0; i--) {
							plantRoleList.get(i).action();
							if (plantRoleList.get(i).getRunStatus() == BaseRole.ROLE_END) {
								plantRoleList.remove(i);
							}
						}

						// 推车动作
						for (int i = carPanelList.size() - 1; i >= 0; i--) {
							carPanelList.get(i).action();
							if (carPanelList.get(i).getRunStatus() == BaseRole.ROLE_END) {
								carPanelList.remove(i);
							}
						}
						// 豌豆射手子弹
						for (int i = peaShooterBulletList.size() - 1; i >= 0; i--) {
							peaShooterBulletList.get(i).action();
							if (peaShooterBulletList.get(i).getRunStatus() == BaseRole.ROLE_END) {
								peaShooterBulletList.remove(i);
							}
						}

						// 寒冰射手子弹
						for (int i = snowPeaShooterBulletList.size() - 1; i >= 0; i--) {
							snowPeaShooterBulletList.get(i).action();
							if (snowPeaShooterBulletList.get(i).getRunStatus() == BaseRole.ROLE_END) {
								snowPeaShooterBulletList.remove(i);
							}
						}
						// 僵尸
						for (int i = zombieRoleList.size() - 1; i >= 0; i--) {
							zombieRoleList.get(i).action();
							if (zombieRoleList.get(i).getRunStatus() == BaseRole.ROLE_END) {
								zombieRoleList.remove(i);
							}
						}
						
						BaseDao.update(frame.getUserBean());
						paint();
					}
				});
		
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public int getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(int gameStatus) {
		this.gameStatus = gameStatus;
	}

	public MapRole getMapRole() {
		return mapRole;
	}

	public void setMapRole(MapRole mapRole) {
		this.mapRole = mapRole;
	}

	public ProgressRole getProgressRole() {
		return progressRole;
	}

	public void setProgressRole(ProgressRole progressRole) {
		this.progressRole = progressRole;
	}

	public PlantsPanelRole getPlantsPanelRole() {
		return plantsPanelRole;
	}

	public void setPlantsPanelRole(PlantsPanelRole plantsPanelRole) {
		this.plantsPanelRole = plantsPanelRole;
	}

	public List<CarPanelRole> getCarPanelList() {
		return carPanelList;
	}

	public void setCarPanelList(List<CarPanelRole> carPanelList) {
		this.carPanelList = carPanelList;
	}

	public ShovelPanelRole getShovelPanelRole() {
		return shovelPanelRole;
	}

	public void setShovelPanelRole(ShovelPanelRole shovelPanelRole) {
		this.shovelPanelRole = shovelPanelRole;
	}

	public List<PlantsCardRole> getPlantsCardList() {
		return plantsCardList;
	}

	public void setPlantsCardList(List<PlantsCardRole> plantsCardList) {
		this.plantsCardList = plantsCardList;
	}

	public List<PlantRole> getPlantRoleList() {
		return plantRoleList;
	}

	public void setPlantRoleList(List<PlantRole> plantRoleList) {
		this.plantRoleList = plantRoleList;
	}

	public PlantRole getSelectedPlant() {
		return selectedPlant;
	}

	public void setSelectedPlant(PlantRole selectedPlant) {
		this.selectedPlant = selectedPlant;
	}

	public PlantRole getTempPlant() {
		return tempPlant;
	}

	public void setTempPlant(PlantRole tempPlant) {
		this.tempPlant = tempPlant;
	}

	public List<PeaShooterBulletRole> getPeaShooterBulletList() {
		return peaShooterBulletList;
	}

	public void setPeaShooterBulletList(
			List<PeaShooterBulletRole> peaShooterBulletList) {
		this.peaShooterBulletList = peaShooterBulletList;
	}

	public List<SnowPeaShooterBulletRole> getSnowPeaShooterBulletList() {
		return snowPeaShooterBulletList;
	}

	public void setSnowPeaShooterBulletList(
			List<SnowPeaShooterBulletRole> snowPeaShooterBulletList) {
		this.snowPeaShooterBulletList = snowPeaShooterBulletList;
	}

	public List<SunSeedRole> getSunSeedRoleList() {
		return sunSeedRoleList;
	}

	public void setSunSeedRoleList(List<SunSeedRole> sunSeedRoleList) {
		this.sunSeedRoleList = sunSeedRoleList;
	}

	public List<BaseZombie> getZombieRoleList() {
		return zombieRoleList;
	}

	public void setZombieRoleList(List<BaseZombie> zombieRoleList) {
		this.zombieRoleList = zombieRoleList;
	}

}
