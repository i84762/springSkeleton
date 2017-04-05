package com.abc.xyz.service;

import com.abc.xyz.common.CoreService;
import com.abc.xyz.dao.UserRoleDao;
import com.abc.xyz.dto.UserRoleView;
import com.abc.xyz.dto.mapper.UserRoleMapper;
import com.abc.xyz.model.UserRole;

/**
 * 
 * @author amrit
 * 
 */
public interface UserRoleService extends CoreService<UserRoleView, 
													UserRole, 
													UserRoleDao, 
													UserRoleMapper>
{
	UserRoleView getByRole(com.abc.xyz.common.UserRoleEnum value);
}
