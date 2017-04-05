package com.abc.xyz.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.abc.xyz.common.CoreEntity;


/**
 * @author amrit
 *
 */
@Entity
@Table(name = User.TABLE)
public class User implements CoreEntity
{
	public final static String TABLE = "USER";

	@Id()
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name = "VERIFICATION_TOKEN")
	private String verificationToken;
	
	@Column(name = "PASSWORD_RESET_TOKEN")
	private String passwordResetToken;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VERIFICATION_TOKEN_DATE")
	private Date verificationTokenDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PASSWORD_RESET_TOKEN_DATE")
	private Date passwordResetTokenDate;
	
	@Column(name = "enabled")
	private boolean enabled;		

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Review> reviews;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "USER_ROLE_MAPPINGS",
			joinColumns = @JoinColumn(name = "USER_ID"),
			inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
		)
	private List<UserRole> userRoles = new ArrayList();

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
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public boolean isEnabled() 
	{
		return this.enabled;
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
	
	public List<UserRole> getUserRoles()
	{
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRole)
	{
		this.userRoles = userRole;
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

	public List<Review> getReviews() 
	{
		return reviews;
	}

	public void setReviews(List<Review> reviews) 
	{
		this.reviews = reviews;
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
}