package com.abc.xyz.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.abc.xyz.common.CoreDTOView;



/**
 * @author amrit
 *
 */
public class UserView  implements CoreDTOView
{
	private long id;
	
	@NotNull
	@Size(min = 10)
	private String username;
	
//	@NotNull
//    @Size(min = 10)
	private String firstName;
	
//	@NotNull
//    @Size(min = 1)
	private String lastName;
	
//	@ValidEmail
//    @NotNull
//    @Size(min = 1)
	private String email;
	
//	@ValidPassword
	private String password;
	
//	@NotNull
//    @Size(min = 1)
	private String matchingPassword;	
	
	private boolean enabled;
	
	private String verificationToken;
	private String passwordResetToken;
	
	private Date verificationTokenDate;
	private Date passwordResetTokenDate;
	
	private List<UserRoleView> userRoleViews = new ArrayList();
	
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	public List<UserRoleView> getUserRoleViews()
	{
		return userRoleViews;
	}

	public void setUserRoleViews(List<UserRoleView> userRole) 
	{
		this.userRoleViews = userRole;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getMatchingPassword()
	{
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword)
	{
		this.matchingPassword = matchingPassword;
	}


	public String getVerificationToken()
	{
		return verificationToken;
	}

	public void setVerificationToken(String verificationToken) 
	{
		this.verificationToken = verificationToken;
	}

	public String getPasswordResetToken()
	{
		return passwordResetToken;
	}

	public void setPasswordResetToken(String passwordResetToken)
	{
		this.passwordResetToken = passwordResetToken;
	}

	public Date getVerificationTokenDate() 
	{
		return verificationTokenDate;
	}

	public void setVerificationTokenDate(Date verificationTokenDate)
	{
		this.verificationTokenDate = verificationTokenDate;
	}

	public Date getPasswordResetTokenDate() 
	{
		return passwordResetTokenDate;
	}

	public void setPasswordResetTokenDate(Date passwordResetTokenDate)
	{
		this.passwordResetTokenDate = passwordResetTokenDate;
	}

	@Override
	public String toString() {
		return "UserView [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", matchingPassword=" + matchingPassword
				+ ", enabled=" + enabled + ", verificationToken=" + verificationToken + ", passwordResetToken="
				+ passwordResetToken + ", verificationTokenDate=" + verificationTokenDate + ", passwordResetTokenDate="
				+ passwordResetTokenDate + ", userRoleViews=" + userRoleViews + "]";
	}

}