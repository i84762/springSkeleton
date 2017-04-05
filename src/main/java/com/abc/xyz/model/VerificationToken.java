package com.abc.xyz.model;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

import com.abc.xyz.common.CoreEntity;

/**
 * 
 * @author amrit
 *
 */
@Entity
@Table(name = "VERIFICATOIN_TOKEN")
public class VerificationToken implements CoreEntity
{

    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "TOKEN")
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "EXPIRY_DATE")
    private Date expiryDate;

    public VerificationToken() 
    {
    	
    }

    public VerificationToken(final String token) 
    {
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    public VerificationToken(final String token, final User user) 
    {
        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
		this.id = id;
	}

	public String getToken() 
    {
        return token;
    }

    public void setToken(final String token) 
    {
        this.token = token;
    }

    public User getUser() 
    {
        return user;
    }

    public void setUser(final User user) 
    {
        this.user = user;
    }

    public Date getExpiryDate() 
    {
        return expiryDate;
    }

    public void setExpiryDate(final Date expiryDate) 
    {
        this.expiryDate = expiryDate;
    }

    private Date calculateExpiryDate(final int expiryTimeInMinutes) 
    {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public void updateToken(final String token) 
    {
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

}