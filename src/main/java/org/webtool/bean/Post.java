package org.webtool.bean;

import java.util.ArrayList;
import java.util.Date;

public class Post
{
	int id;
	String title;
	String discription;
	String content;
	String slug;
	Category category;
	ArrayList<Tag> tags;
	Date created;
	Date updated;
	
	public Post()
	{
		this.id = -1;
		this.title = "";
		this.discription = "";
		this.content = "";
		this.slug = "";
		this.category = null;
		this.tags = new ArrayList<>();
		this.created = new Date();
		this.updated = new Date();
	}
	
	public Post(int id, String title, String discription, String content, String slug,
	        Category category, Date created, Date updated)
	{
		this.id = id;
		this.title = title;
		this.discription = discription;
		this.content = content;
		this.slug = slug;
		this.category = category;
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
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getDiscription()
	{
		return discription;
	}
	
	public void setDiscription(String discription)
	{
		this.discription = discription;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public String getSlug()
	{
		return slug;
	}
	
	public void setSlug(String slug)
	{
		this.slug = slug;
	}
	
	public Category getCategory()
	{
		return category;
	}
	
	public void setCategory(Category category)
	{
		this.category = category;
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
