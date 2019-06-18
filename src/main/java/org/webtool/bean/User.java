package org.webtool.bean;

public class User
{
	String username;
	String name;
	String avatar;
	String password;
	String salt;
	int role;
	
	public User()
	{
		this.username = "";
		this.name = "";
		this.avatar = "";
		this.password = "";
		this.salt = "";
		this.role = -1;
	}
	
	public User(String username, String name, String avatar, String password, String salt, int role)
	{
		this.username = username;
		this.name = name;
		this.avatar = avatar;
		this.password = password;
		this.salt = salt;
		this.role = role;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getAvatar()
	{
		return avatar;
	}
	
	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getSalt()
	{
		return salt;
	}
	
	public void setSalt(String salt)
	{
		this.salt = salt;
	}
	
	public int getRole()
	{
		return role;
	}
	
	public void setRole(int role)
	{
		this.role = role;
	}
	
}
