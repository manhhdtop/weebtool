package org.webtool.bean;

public class UserResponse
{
	private User user;
	private boolean validate;
	private String errorMessages;
	
	public UserResponse()
	{
		this.user = null;
		this.validate = false;
		this.errorMessages = "";
	}
	
	public UserResponse(User user, boolean validate, String errorMessages)
	{
		super();
		this.user = user;
		this.validate = validate;
		this.errorMessages = errorMessages;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public boolean isValidate()
	{
		return validate;
	}
	
	public void setValidate(boolean validate)
	{
		this.validate = validate;
	}
	
	public String getErrorMessages()
	{
		return errorMessages;
	}
	
	public void setErrorMessages(String errorMessages)
	{
		this.errorMessages = errorMessages;
	}
	
}
