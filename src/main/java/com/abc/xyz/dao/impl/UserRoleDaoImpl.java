package com.abc.xyz.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abc.xyz.common.DaoSupport;
import com.abc.xyz.dao.UserRoleDao;
import com.abc.xyz.model.UserRole;

/**
 * 
 * @author amrit
 * 
 */
@Repository
@Transactional
public class UserRoleDaoImpl extends DaoSupport<UserRole> implements UserRoleDao
{
	@Override
	public Class<UserRole> getEntity()
	{
		return UserRole.class;
	}
	
	@Override
	public UserRole getByRole(com.abc.xyz.common.UserRoleEnum value) 
	{
		return findByParam("role", value);
	}
}
