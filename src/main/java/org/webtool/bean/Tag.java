package org.webtool.bean;

import java.util.Date;

public class Tag
{
	int id;
	String name;
	Date created;
	Date updated;
	
	public Tag()
	{
		this.id = -1;
		this.name = "";
		this.created = new Date();
		this.updated = new Date();
	}
	
	public Tag(int id, String name, Date created, Date updated)
	{
		this.id = id;
		this.name = name;
		this.created = created;
		this.updated = updated;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Date getCreated()
	{
		return created;
	}
	
	public void setCreated(Long created)
	{
		this.created = new Date(created);
	}
	
	public void setCreated(Date created)
	{
		this.created = created;
	}
	
	public Date getUpdated()
	{
		return updated;
	}
	
	public void setUpdated(Long updated)
	{
		this.created = new Date(updated);
	}
	
	public void setUpdated(Date updated)
	{
		this.updated = updated;
	}
}
