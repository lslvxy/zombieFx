package com.pz.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;


/**
 * 用户积分
 * 
 * @author  ls
 * @Date    2012-2-7
 * @version 1.00 
 */
public class BaseDao {
	
	/**
	 * 连接文件
	 *
	 */
	public static Properties setConnection(){
		Properties pro=new Properties();
		try {
			pro.load(new FileReader("resources/user.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	public static void add(UserBean bean) {
		Properties pro = setConnection();
		try {
			OutputStream ops = new FileOutputStream("resources/user.properties");
            pro.setProperty(bean.getUserName(), bean.getScore()+"");
            pro.store(ops, bean.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
	}
	
	/**更改默认用户
	 * @param userName
	 */
	public static void changeUser(String userName) {
		Properties pro = setConnection();
		try {
			OutputStream ops = new FileOutputStream("resources/user.properties");
            pro.setProperty("user", userName);
            pro.store(ops, "user");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
	}
	
	

	/**
	 * 排行榜
	 */
	public static List<UserBean> rank() {
		List<UserBean> list = new ArrayList<UserBean>();
		Properties pro = setConnection();
		try {
			
			Set<Object> userNames = pro.keySet();
			userNames.remove("user");
			Iterator<Object> it = userNames.iterator();
			while (it.hasNext()) {
				String userName=(String) it.next();
				int score=Integer.parseInt(pro.getProperty(userName));
				UserBean bean=new UserBean();
				bean.setScore(score);
				bean.setUserName(userName);
				if(score!=0){
					list.add(bean);
				}
			}
			//new SortList<UserBean>().Sort(list, "getScore", "desc");
			//System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return list;
	}



	/**
	 * 查询用户
	 * @return
	 */
	public  static UserBean findByName(String name) {
		UserBean bean = new UserBean();
		Properties pro = setConnection();
		try{
			if(pro.containsKey(name)){
				bean.setUserName(name);
				String s=pro.getProperty(name);
				int score=0;
				try {
					score = Integer.parseInt(s);
					bean.setScore(score);
				} catch (Exception e) {
					bean.setUserName(s);
				}				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
		}
		
		return bean;
	}
	
	/**
	 * @���·���
	 */
	public static void update(UserBean bean) {
		Properties pro = setConnection();
		try {
			OutputStream ops = new FileOutputStream("resources/user.properties");
            pro.setProperty(bean.getUserName(), bean.getScore()+"");
            pro.store(ops, bean.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
	}

}
