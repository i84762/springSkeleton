package com.abc.xyz.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.abc.xyz.common.CoreEntity;
import com.abc.xyz.common.UserRoleEnum;

/**
 * @author amrit
 *
 */
@Entity
@Table(name = UserRole.TABLE)
public class UserRole implements CoreEntity
{	
	public final static String TABLE = "USER_ROLE";	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
		
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ROLE")
	private UserRoleEnum role;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	public long getId() 
	{
		return this.id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public UserRoleEnum getRole()
	{
		return this.role;
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