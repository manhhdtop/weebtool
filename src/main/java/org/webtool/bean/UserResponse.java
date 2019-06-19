package org.webtool.bean;

public class UserResponse
{
	private String token;
	private User user;
	private boolean validate;
	private String messages;
	
	public UserResponse()
	{
		this.user = null;
		this.token = "";
		this.validate = false;
		this.messages = "";
	}
	
	public UserResponse(User user, String token, boolean validate, String messages)
	{
		this.user = user;
		this.token = token;
		this.validate = validate;
		this.messages = messages;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public String getToken()
	{
		return token;
	}
	
	public void setToken(String token)
	{
		this.token = token;
	}
	
	public boolean isValidate()
	{
		return validate;
	}
	
	public void setValidate(boolean validate)
	{
		this.validate = validate;
	}
	
	public String getMessages()
	{
		return messages;
	}
	
	public void setMessages(String messages)
	{
		this.messages = messages;
	}
	
}
