package org.webtool.bean;

import java.util.ArrayList;

public class Category
{
	private int id;
	private String name;
	private String slug;
	private String discription;
	private ArrayList<Category> child;
	
	public Category()
	{
		this.id = -1;
		this.name = "";
		this.slug = "";
		this.discription = "";
		this.child = new ArrayList<>();
	}
	
	public Category(int id, String name, String slug, String discription, ArrayList<Category> child)
	{
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.discription = discription;
		this.child = child;
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
	
	public String getSlug()
	{
		return slug;
	}
	
	public void setSlug(String slug)
	{
		this.slug = slug;
	}
	
	public String getDiscription()
	{
		return discription;
	}
	
	public void setDiscription(String discription)
	{
		this.discription = discription;
	}
	
	public ArrayList<Category> getChild()
	{
		return child;
	}
	
	public void setChild(ArrayList<Category> child)
	{
		this.child = child;
	}
}
