package com.westward.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.westward.bean.Article;
import com.westward.bean.Users;
import com.westward.mapper.UsersOperation;

public class Test1 {
	private static SqlSessionFactory sessionFactory= null;
	
	public static void main(String[] args) {
		selectAllUsersByResultMap();
	}
	
	public static void selectAllUsers(){
		
		SqlSession session= null;
		try {
			session= getSession();
			List<Users> userss = session.selectList("com.westward.mapper.UsersOperation.selectAllUsers");
			System.out.println("userss:"+ userss);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (session!=null) {
				session.close();
			}
		}
	}
	
	//以接口的形式
	public static void selectAllUsers2(){
		
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			List<Users> userss= usersOperation.selectAllUsers();
			System.out.println("userss:"+ userss);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if (session!=null) {
				session.close();
			}
		}
	}
	
	public static void selectAllUsersByResultMap(){
		
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			List<Users> userss= usersOperation.selectAllUsersByResultMap("%bob%");//模糊查询
			System.out.println("userss:"+ userss);
			for (Users users : userss) {
				System.out.println(users);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if (session!=null) {
				session.close();
			}
		}
	}
	
	
	
	
	public static void insertUsers(){
		SqlSession session= null;
		try {
			session= getSession();
			int result= session.insert("com.westward.mapper.UsersOperation.insertUsers", new Users(0, "bob", 10,"hebei"));
			session.commit();
			System.out.println("result:"+ result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	//以接口的形式
	public static void insertUsers2(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			int result= usersOperation.insertUsers(new Users(0, "cyen", 11,"anhui"));
//			int result= session.insert("com.westward.mapper.UsersOperation.insertUsers", new Users(0, "bob", 10));
			session.commit();
			System.out.println("result:"+ result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	public static void insertUsersWithId(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			Users users= new Users();
			users.setAge(14);
			users.setName("fyer");
			int result= usersOperation.insertUsersWithId(users);
//			int result= session.insert("com.westward.mapper.UsersOperation.insertUsers", new Users(0, "bob", 10));
			session.commit();
			System.out.println("result:"+ result+ ", id:"+ users.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	
	
	public static void updateUsers(){
		
		SqlSession session= null;
		try {
			session= getSession();
			int result= session.update("com.westward.mapper.UsersOperation.updateUsers", new Users(1, null, 20,"huhhaot"));
			session.commit();
			System.out.println("result:"+ result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	//以接口的形式
	public static void updateUsers2(){
		
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			int result= usersOperation.updateUsers(new Users(5, "cyen", 12,"qingdao"));
//			int result= session.update("com.westward.mapper.UsersOperation.updateUsers", new Users(1, null, 20));
			session.commit();
			System.out.println("result:"+ result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	public static void selectUsers(){

		SqlSession session= null;
		try {
			session= getSession();
			Users users= session.selectOne("com.westward.mapper.UsersOperation.selectUsers", 1);
			System.out.println(users);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	//以接口的形式
	public static void selectUsers2(){
		
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			Users users= usersOperation.selectUsers(1);
			System.out.println(users);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	public static void deleteUsers(){
		SqlSession session= null;
		try {
			session= getSession();
			int result= session.delete("com.westward.mapper.UsersOperation.deleteUsers", 3);
			session.commit();
			System.out.println("result:"+ result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	//以接口的形式
	public static void deleteUsers2(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			int result= usersOperation.deleteUsers(5);
//			int result= session.delete("com.westward.mapper.UsersOperation.deleteUsers", 3);
			session.commit();
			System.out.println("result:"+ result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	public static SqlSession getSession() throws IOException{
		SqlSession session= null;
		if (sessionFactory==null) {
			InputStream inputStream= Resources.getResourceAsStream("config.xml");
			sessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		}
		session= sessionFactory.openSession();
		
		return session;
	}
	
	
	//多表查询
	//配置1
	public static void selectUsersArticleById(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			List<Article> articles= usersOperation.selectUsersArticleById(1);
			System.out.println("result:"+ articles);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	//多表查询
	//配置2
	public static void selectUsersArticleById2(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			List<Article> articles= usersOperation.selectUsersArticleById2(1);
			System.out.println("result:"+ articles);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	//动态sql查询
	public static void selectUsersIf(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			Users users= new Users();
			users.setName("fyer");
			users.setAddress("shenhang");
			List<Users> userss= usersOperation.selectUsersIf(users);
			System.out.println("result:"+ userss);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	//动态sql查询 choose
	public static void selectUsersChoose(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			Users users= new Users();
//			users.setId(1);
//			users.setName("fyer");
			users.setAddress("shenhang");
			List<Users> userss= usersOperation.selectUsersChoose(users);
			System.out.println("result:"+ userss);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	//动态sql查询 trim
	public static void selectUsersTrim(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			Users users= new Users();
//			users.setId(1);
			users.setName("fyer");
			users.setAddress("shenhang");
			List<Users> userss= usersOperation.selectUsersTrim(users);
			System.out.println("result:"+ userss);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	//动态sql查询 where
	public static void selectUsersWhere(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			Users users= new Users();
//			users.setId(1);
			users.setName("fyer");
			users.setAddress("shenhang");
			List<Users> userss= usersOperation.selectUsersWhere(users);
			System.out.println("result:"+ userss);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	//动态sql查询  set
	public static void updateUsersSet(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			Users users= new Users();
			users.setId(7);
			users.setName("fyar");
//			users.setAddress("shenhang");
			int result= usersOperation.updateUsersSet(users);
			session.commit();
			System.out.println("result:"+ result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	//动态sql查询  foreach list
	public static void selectUserForeach(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			List<Integer> ids= new ArrayList<>();
			ids.add(1);
			ids.add(4);
			List<Users> userss= usersOperation.selectUserForeach(ids);
			System.out.println("result:"+ userss);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	//动态sql查询  foreach array
	public static void selectUserForeachArray(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			int[] ids= {1,4};
			List<Users> userss= usersOperation.selectUserForeachArray(ids);
			System.out.println("result:"+ userss);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	//动态sql查询  foreach Map
	public static void selectUserForeachMap(){
		SqlSession session= null;
		try {
			session= getSession();
			UsersOperation usersOperation = session.getMapper(UsersOperation.class);
			Map<String, Object> maps= new HashMap<String, Object>();
			List<Integer> list= new ArrayList<>();
			list.add(1);
			list.add(4);
			maps.put("ids", list);
			List<Users> userss= usersOperation.selectUserForeachMap(maps);
			System.out.println("result:"+ userss);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
	}
	
	
	
	
}
