package com.abc.xyz.dao;

import com.abc.xyz.common.CoreDao;
import com.abc.xyz.model.UserRole;

/**
 * 
 * @author amrit
 * 
 */
public interface UserRoleDao extends CoreDao<UserRole>
{
	UserRole getByRole(com.abc.xyz.common.UserRoleEnum value);
}
