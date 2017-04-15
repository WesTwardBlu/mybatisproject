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
	
	//����ѯ
	//���һ��1
	List<Article> selectUsersArticleById(int id);
	//���һ��2
	List<Article> selectUsersArticleById2(int id);
	
	//��̬sql��ѯ   if
	List<Users> selectUsersIf(Users users);
	
	//��̬sql��ѯ   choose
	List<Users> selectUsersChoose(Users users);
	
	//��̬sql��ѯ   trim
	List<Users> selectUsersTrim(Users users);
	
	//��̬sql��ѯ   where
	List<Users> selectUsersWhere(Users users);
	
	//��̬sql��ѯ   set
	int updateUsersSet(Users users);
	
	//��̬sql��ѯ   foreach list
	List<Users> selectUserForeach(List<Integer> ids);
	//��̬sql��ѯ   foreach array
	List<Users> selectUserForeachArray(int[] ids);
	//��̬sql��ѯ   foreach Map
	List<Users> selectUserForeachMap(Map<String, Object> param);
	
}
