package com.abc.xyz.dao;

import com.abc.xyz.common.CoreDao;
import com.abc.xyz.dto.UserView;
import com.abc.xyz.model.User;


public interface UserDao extends CoreDao<User>
{
	User findByUserName(String username);
	User findByEmail(String email);	
	void enableUser(UserView userView, boolean value);
}