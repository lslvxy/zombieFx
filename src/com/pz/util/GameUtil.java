package com.pz.util;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.effect.Light.Point;
import javafx.scene.image.Image;

import com.pz.role.BaseRole;
import com.pz.role.SunSeedRole;
import com.pz.role.zombie.BaseZombie;
import com.pz.role.zombie.NormalZombie;
import com.pz.window.GamePanel;

/**
 * Copyright (C), FileName:GameUtil.java 游戏的工具类
 * 
 * @author ls
 * @Date 2012-1-10
 * @version 1.00
 */
public class GameUtil {
	public static Connection con;
	public static PreparedStatement ps;
	public static ResultSet rs;
	/**
	 * 图标
	 */
	public static Image iconImage;
	/** 欢迎界面的图片 */
	public static Image welcomeImage;

	/** 标题界面的背景图片 */
	public static Image titleImage;

	/** 标题界面上开始游戏按钮的图片 */
	public static Image startGameImage;

	/** 标题界面上小游戏按钮的图片 */
	public static Image miniGameImage;
	/** 标题界面上解密模式按钮的图片 */
	public static Image passwordModeImage;
	/** 标题界面上生存模式按钮的图片 */
	public static Image survivalModeImage;
	/** 标题界面上选择用户按钮的图片 */
	public static Image switchNameImage;
	/** 标题界面上欢迎回来按钮的图片 */
	public static Image comeBackImage;
	/** 标题界面上退出按钮的图片 */
	public static Image exitImage;
	/** 标题界面上排行按钮的图片 */
	public static Image rankImage;
	/** 标题界面上帮助按钮的图片 */
	public static Image helpImage;
	/** 排行榜的图片 */
	public static Image rankListImage;
	/** 帮助界面的图片 */
	public static Image helpListImage;
	/** 帮助的图片背景 */
	public static Image helpBackground;
	/** 帮助界面的返回按钮 */
	public static Image backImage;
	/** 排行界面的确定按钮 */
	public static Image sureImage;
	/** 主游戏界面背景 */
	public static Image mapImage;
	/** 僵尸吃掉了你的脑子 */
	public static Image gameOverImage;
	/** 开始游戏准备安放植物 */
	public static Image StartReadyImage;
	public static Image StartPlantImage;
	public static Image StartSetImage;

	/** 主菜单 */
	public static Image menuButtonImage;

	/** 关卡进度条 */
	public static Image flagMeterImage;
	public static Image flagMeterLevelProgressImage;
	public static Image flagMeterParts1Image;
	public static Image flagMeterParts2Image;

	/** 选择植物 */
	public static Image plantsPanelImage;
	/** 推车图片 */
	public static Image carPanelImage;
	/** 太阳种子图片 */
	public static Image sunSeedImage;
	/** 铲子图片 */
	public static Image shovelImage;

	/** 植物卡片图片 */
	public static Image peaShootCard;
	public static Image sunFlowerCard;
	public static Image cheeryBombCard;
	public static Image nutWallCard;
	public static Image patotoBombCard;
	public static Image iceShooterCard;

	/** 豌豆射手图片 */
	public static Image peashooterImage;
	/** 太阳花图片 */
	public static Image sunFlowerImage;
	/** 樱桃炸弹图片 */
	public static Image CheeryBombImage;
	/** 樱桃炸弹爆炸图片 */
	public static Image CheeryBombExplodeImage;
	/** 坚果墙图片 */
	public static Image wallNutImage;
	/** 坚果墙图片2 */
	public static Image wallNutCracked1Image;
	/** 坚果墙图片3 */
	public static Image wallNutCracked2Image;
	/** 土豆雷小图片 */
	public static Image potatoMineNotReadyImage;
	/** 土豆雷图片 */
	public static Image potatoMineImage;
	/** 土豆雷爆炸图片 */
	public static Image potatoMineExplodeImage;
	public static Image potatoMineSpudowImage;

	/** 寒冰射手图片 */
	public static Image snowPeatImage;
	/** 豌豆射手子弹图片 */
	public static Image peaShooterBulletImage;
	/** 豌豆射手子弹爆炸图片 */
	public static Image peaShooterBulletBomImage;

	/** 寒冰射手子弹图片 */
	public static Image snowPeaShooterBulletImage;
	/** 寒冰射手子弹爆炸图片 */
	public static Image snowPeaShooterBulletBomImage;

	/** 普通僵尸走路图片 */
	public static Image normalZombieWarkImage;
	/** 普通僵尸攻击图片 */
	public static Image normalZombieAttackImage;
	/** 普通僵尸脑袋掉落图片 */
	public static Image normalZombieHeadImage;
	/** 普通僵尸无头走路图片 */
	public static Image normalZombieLostHeadWarkImage;
	/** 普通僵尸无头攻击图片 */
	public static Image normalZombieLostHeadAttackImage;
	/** 普通僵尸倒下图片 */
	public static Image normalZombieDeadImage;
	/** 僵尸爆炸图片 */
	public static Image boomDieImage;

	/** 铁桶僵尸走路图片 */
	public static Image bucketheadZombieWalkImage;
	/** 铁桶僵尸攻击图片 */
	public static Image bucketheadZombieAttackImage;

	/** 一大波僵尸 */
	public static Image LargeWaveImage;
	/** 最后一波 */
	public static Image FinalWaveImage;
	/** 胜利 */
	public static Image victoryImage;

	/**
	 * 用于初始化游戏中图片的方法
	 */
	public static void initImage() {
		Map<String, Image> map = GameImage.loadImage(new File(
				"resources/image.xml"));
		iconImage = map.get("iconImage");
		// 欢迎界面图片
		welcomeImage = map.get("welcomeImage");
		// 标题界面图片
		titleImage = map.get("titleImage");
		// 欢迎回来图标
		comeBackImage = map.get("comeBackImage");
		// 排行榜界面图片
		rankListImage = map.get("rankListImage");
		// 帮助界面图片
		helpListImage = map.get("helpListImage");
		// 帮助界面背景
		helpBackground = map.get("helpBackground");
		// 开始游戏按钮
		startGameImage = map.get("startGameImage");
		// 开始安放植物
		StartReadyImage = map.get("StartReadyImage");
		StartPlantImage = map.get("StartPlantImage");
		StartSetImage = map.get("StartSetImage");
		// 小游戏按钮
		miniGameImage = map.get("miniGameImage");
		// 解密模式按钮
		passwordModeImage = map.get("passwordModeImage");
		// 生存模式按钮
		survivalModeImage = map.get("survivalModeImage");
		// 选择存档按钮
		switchNameImage = map.get("switchNameImage");
		// 退出按钮
		exitImage = map.get("exitImage");
		// 排行按钮
		rankImage = map.get("rankImage");
		// 帮助按钮
		helpImage = map.get("helpImage");
		// 帮助界面的返回按钮
		backImage = map.get("backImage");
		// 排行界面的确定
		sureImage = map.get("sureImage");
		// 主游戏界面背景
		mapImage = map.get("mapImage");
		// 主菜单
		menuButtonImage = map.get("menuButtonImage");
		// 僵尸吃掉了你的脑子
		gameOverImage = map.get("gameOverImage");

		// 进度条
		flagMeterImage = map.get("flagMeterImage");
		flagMeterLevelProgressImage = map.get("flagMeterLevelProgressImage");
		flagMeterParts1Image = map.get("flagMeterParts1Image");
		flagMeterParts2Image = map.get("flagMeterParts2Image");

		// 选择植物图片
		plantsPanelImage = map.get("plantsPanelImage");

		// 推车图片
		carPanelImage = map.get("carPanelImage");
		// 太阳种子图片
		sunSeedImage = map.get("sunSeedImage");

		// 铲子图片
		shovelImage = map.get("shovelImage");

		// 植物卡片图片
		peaShootCard = map.get("peaShootCard");
		sunFlowerCard = map.get("sunFlowerCard");
		cheeryBombCard = map.get("cheeryBombCard");
		nutWallCard = map.get("nutWallCard");
		patotoBombCard = map.get("patotoBombCard");
		iceShooterCard = map.get("iceShooterCard");

		// 豌豆射手图片
		peashooterImage = map.get("peashooterImage");
		// 太阳花图片
		sunFlowerImage = map.get("sunFlowerImage");
		// 樱桃炸弹图片
		CheeryBombImage = map.get("CheeryBombImage");
		// 樱桃炸弹爆炸图片
		CheeryBombExplodeImage = map.get("CheeryBombExplodeImage");
		// 坚果墙弹图片
		wallNutImage = map.get("wallNutImage");
		wallNutCracked1Image = map.get("wallNutCracked1Image");
		wallNutCracked2Image = map.get("wallNutCracked2Image");

		// 土豆雷图片
		potatoMineImage = map.get("potatoMineImage");
		potatoMineNotReadyImage = map.get("potatoMineNotReadyImage");
		// 土豆雷爆炸图片
		potatoMineExplodeImage = map.get("potatoMineExplodeImage");
		potatoMineSpudowImage = map.get("potatoMineSpudowImage");

		// 寒冰射手图片
		snowPeatImage = map.get("snowPeatImage");
		// 豌豆射手子弹图片
		peaShooterBulletImage = map.get("peaShooterBulletImage");
		// 豌豆射手子弹爆炸图片
		peaShooterBulletBomImage = map.get("peaShooterBulletBomImage");

		// 寒冰射手子弹图片
		snowPeaShooterBulletImage = map.get("snowPeaShooterBulletImage");
		// 寒冰射手子弹爆炸图片
		snowPeaShooterBulletBomImage = map.get("snowPeaShooterBulletBomImage");

		// 普通僵尸走路图片
		normalZombieWarkImage = map.get("normalZombieWarkImage");

		// 普通僵尸攻击图片
		normalZombieAttackImage = map.get("normalZombieAttackImage");
		// 僵尸头图片
		normalZombieHeadImage = map.get("normalZombieHeadImage");
		// 普通僵尸无头走路图片
		normalZombieLostHeadWarkImage = map
				.get("normalZombieLostHeadWarkImage");
		// 普通僵尸无头攻击路图片
		normalZombieLostHeadAttackImage = map
				.get("normalZombieLostHeadAttackImage");
		// 普通僵尸死亡图片
		normalZombieDeadImage = map.get("normalZombieDeadImage");
		// 僵尸爆炸
		boomDieImage = map.get("boomDieImage");
		// 铁桶僵尸走路图片
		bucketheadZombieWalkImage = map.get("bucketheadZombieWalkImage");
		// 铁桶僵尸攻击图片
		bucketheadZombieAttackImage = map.get("bucketheadZombieAttackImage");

		// 一大波僵尸图片
		LargeWaveImage = map.get("LargeWaveImage");
		// 最后一波图片
		FinalWaveImage = map.get("FinalWaveImage");
		// 胜利图片
		victoryImage = map.get("victoryImage");

	}

	/**
	 * 计算坐标
	 * 
	 * @return
	 */
	public static Point computerPosition(double x, double y) {
		Point point = null;
		if (x > 150 && x < 852 && y > 110 && y < 570) {
			point = new Point();
			double posX = x - 150;
			double posY = y - 110;
			double row = (double) Math.floor(posY / 92);
			double col = (double) Math.floor(posX / 78);
			point.setX(col * 78 + 150);
			point.setY(row * 92 + 110);
		}
		return point;
	}

	/**
	 * 判断鼠标是否进入某个角色的方法
	 * 
	 * @param x
	 * @param y
	 * @param role
	 */
	public static boolean checkRoleRect(double x, double y, BaseRole role) {
		if (x > role.getRoleX() && x < role.getRoleX() + role.getRoleWidth()
				&& y > role.getRoleY()
				&& y < role.getRoleY() + role.getRoleHeight()) {
			return true;
		}
		return false;
	}

	/**
	 * @封装休眠方法
	 */
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 指定延迟时间
	 * 
	 * @param time
	 *            延迟时间
	 * @param obj
	 *            指定在哪个对象的方法中进行延迟
	 * @param symbol
	 *            用于区分同一个对象中的延迟方法调用
	 * @return
	 */
	private static Map<String, Long> timeMap = new HashMap<String, Long>();

	public static boolean delay(long time, Object obj, String symbol) {
		if (!timeMap.containsKey(obj.hashCode() + symbol)) {
			timeMap.put(obj.hashCode() + symbol, time / 50);
		} else {
			long delayTime = timeMap.get(obj.hashCode() + symbol);
			timeMap.put(obj.hashCode() + symbol, --delayTime);
		}
		if (timeMap.get(obj.hashCode() + symbol) <= 0) {
			timeMap.remove(obj.hashCode() + symbol);
			return true;
		}
		return false;
	}

	/**
	 * 计算两点之间所有坐标点
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public static List getLinePoint(double x3, double y3, double x4, double y4) {
		int x1=(int) x3;
		int y1=(int) y3;
		int x2=(int) x4;
		int y2=(int) y4;
		List<Point> list = new ArrayList<Point>();
		    if (x1 == x2) {
		      // Tangent = NaN
		      int from = Math.min(y1, y2);
		      int to = Math.max(y1, y2);
		      for (int y = from; y <= to; y++) {
		        list.add(new Point(x1, y, 0, null));
		      }
		    } else {
		      double slope = ((double) (y2 - y1)) / ((double) (x2 - x1));
		      int step = (x2 > x1) ? 1 : -1;
		      for (int x = x1; x != x2; x += step) {
		        int y = (int)((x - x1) * slope + y1);
		        list.add(new Point(x, y, 0, null));
		      }
		    }
		return list;
	}

	/**
	 * 产生种子的方法
	 */
	public static void generateSunSeed(final GamePanel gamePanel){
		//使用匿名内部类启动线程
		new Thread(){
			public void run(){
				GameUtil.sleep(5000);
				while(gamePanel.getGameStatus() == BaseRole.GAME_START){
					SunSeedRole sunSeedRole=new SunSeedRole(gamePanel);
					sunSeedRole.setRoleX((double)(Math.random()*700+100));
					gamePanel.getSunSeedRoleList().add(sunSeedRole);
					GameUtil.sleep(3000*(int)(Math.random()*4+5));
				}
			}
		}.start();
	}
	
	/**
	 * 产生僵尸的方法
	 */
	public static void generateZombie(final GamePanel gamePanel){
		//使用匿名内部类启动线程
		new Thread(){
			public void run(){
				while(gamePanel.getGameStatus() == BaseRole.GAME_START){
					int radom=(int)(Math.random()*2);
					BaseZombie zombie = radom==0 ? new NormalZombie(gamePanel) : new NormalZombie(gamePanel);
					gamePanel.getZombieRoleList().add(zombie);
					GameUtil.sleep(1000*(int)(Math.random()*6+5));
				}
			}
		}.start();
	}
	
	
	
	/**
	 * 检测两个角色是否碰撞
	 * @param role1
	 * @param role2
	 * @return 发生碰撞则返回TRUE，否则返回false
	 */
	public static boolean checkImpact(BaseRole role1,BaseRole role2){
		if(role1 == null || role2 == null){
			return false;
		}
		if(role1.getRoleX() + role1.getRoleWidth() >= role2.getRoleX() &&
			role1.getRoleY() + role1.getRoleHeight() >= role2.getRoleY() &&
			role2.getRoleX() + role2.getRoleWidth() >= role1.getRoleX() &&
			role2.getRoleY() + role2.getRoleHeight() >= role1.getRoleY()){
			return true;
		}
		return false;
	}
	
}
