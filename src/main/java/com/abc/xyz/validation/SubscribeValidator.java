package com.abc.xyz.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.google.common.eventbus.Subscribe;
import com.abc.xyz.dto.SubscribeView;
import com.abc.xyz.service.SubscribeService;

/**
 * 
 * @author amrit
 * 
 */
@Component
public class SubscribeValidator implements Validator
{
	private SubscribeView view;
	
	private Errors errors;
	
	@Autowired
	private SubscribeService subscribeService;
	
	@Override
	public boolean supports(Class<?> clazz) 
	{
		return Subscribe.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		this.errors = errors;
		this.view = (SubscribeView) target;
		checkIfEmailInvalid();
		checkIfAlreadySubscribed();		
	}

	private void checkIfEmailInvalid()
	{
			if(!new EmailValidator().isValid(view.getEmail(), null))
				errors.reject("email", "Invalid Email");
	}

	private void checkIfAlreadySubscribed() 
	{
			if(subscribeService.alreadySubscribed(view.getEmail()))
					if(subscribeService.subscriptionStarted(view.getEmail()))
						errors.reject("email", "Subscription service already started for this email");
					else					
						errors.reject("email", "Subscription request already submitted. Please verify email to start service.");					
	}

}
