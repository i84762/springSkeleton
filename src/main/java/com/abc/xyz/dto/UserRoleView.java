package com.abc.xyz.dto;

import com.abc.xyz.common.CoreDTOView;
import com.abc.xyz.common.UserRoleEnum;

/**
 * @author amrit
 *
 */
public class UserRoleView implements CoreDTOView
{
	private long id;

	private UserRoleEnum role;
	private String description;	
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public UserRoleEnum getRole()
	{
		return role;
	}
	
	public void setRole(UserRoleEnum role)
	{
		this.role = role;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
}