package com.westward.mapper;

import java.util.List;
import java.util.Map;

import com.westward.bean.Article;
import com.westward.bean.Users;

public interface UsersOperation {
	Users selectUsers(int id);
	
	List<Users> selectAllUsers();
	
	List<Users> selectAllUsersByResultMap(String name);
	
	int insertUsers(Users users);
	
	int insertUsersWithId(Users users);
	
	int updateUsers(Users users);
	
	int deleteUsers(int id);
	
	//多表查询
	//多对一：1
	List<Article> selectUsersArticleById(int id);
	//多对一：2
	List<Article> selectUsersArticleById2(int id);
	
	//动态sql查询   if
	List<Users> selectUsersIf(Users users);
	
	//动态sql查询   choose
	List<Users> selectUsersChoose(Users users);
	
	//动态sql查询   trim
	List<Users> selectUsersTrim(Users users);
	
	//动态sql查询   where
	List<Users> selectUsersWhere(Users users);
	
	//动态sql查询   set
	int updateUsersSet(Users users);
	
	//动态sql查询   foreach list
	List<Users> selectUserForeach(List<Integer> ids);
	//动态sql查询   foreach array
	List<Users> selectUserForeachArray(int[] ids);
	//动态sql查询   foreach Map
	List<Users> selectUserForeachMap(Map<String, Object> param);
	
}
