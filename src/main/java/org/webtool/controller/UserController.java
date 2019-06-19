package org.webtool.controller;

import java.sql.SQLException;

import org.webtool.DBUtil.DBUtil;
import org.webtool.Utils.Constant;
import org.webtool.bean.User;
import org.webtool.bean.UserResponse;
import org.webtool.cryptography.Encrypt;
import org.webtool.jwt.JwtToken;

public class UserController
{
	public UserResponse login(String username, String password)
	{
		UserResponse response = new UserResponse();
		User user = null;
		
		try
		{
			user = DBUtil.getUser(username);
		}
		catch (ClassNotFoundException | NullPointerException | SQLException e)
		{
			response.setValidate(false);
			response.setMessages(Constant.ERROR_500);
			e.printStackTrace();
		}
		
		if (user == null)
		{
			response.setValidate(false);
			response.setMessages(Constant.ERROR_USER_NOT_FOUND);
		}
		else
		{
			if (user.getTmpPassword().equals(""))
			{
				if (Encrypt.verifyPassword(password, user.getPassword(), user.getSalt()))
				{
					response.setUser(user);
					response.setToken(JwtToken.createJWT(username));
					response.setValidate(true);
					response.setMessages(Constant.LOGIN_SUCCESS);
				}
				else
				{
					response.setValidate(false);
					response.setMessages(Constant.ERROR_PASWORD_NOT_MATCH);
				}
			}
			else
			{
				if (Encrypt.verifyPassword(password, user.getPassword(), user.getSalt()))
				{
					try
					{
						DBUtil.updatePassword(user.getUsername(), user.getPassword(),
						        user.getSalt());
					}
					catch (ClassNotFoundException | NullPointerException | SQLException e)
					{
						response.setValidate(false);
						response.setMessages(Constant.ERROR_500);
						e.printStackTrace();
					}
					response.setUser(user);
					response.setToken(JwtToken.createJWT(username));
					response.setValidate(true);
					response.setMessages(Constant.LOGIN_SUCCESS);
				}
				else
				{
					if (Encrypt.verifyPassword(password, user.getTmpPassword(), user.getTmpSalt()))
					{
						try
						{
							DBUtil.updatePassword(user.getUsername(), user.getTmpPassword(),
							        user.getTmpSalt());
						}
						catch (ClassNotFoundException | NullPointerException | SQLException e)
						{
							response.setValidate(false);
							response.setMessages(Constant.ERROR_500);
							e.printStackTrace();
						}
						response.setUser(user);
						response.setToken(JwtToken.createJWT(username));
						response.setValidate(true);
						response.setMessages(Constant.LOGIN_SUCCESS);
					}
					else
					{
						response.setValidate(false);
						response.setMessages(Constant.ERROR_PASWORD_NOT_MATCH);
					}
				}
			}
		}
		
		return response;
	}
	
	public boolean logout(String token)
	{
		JwtToken.removeToken(token);
		return true;
	}
}
