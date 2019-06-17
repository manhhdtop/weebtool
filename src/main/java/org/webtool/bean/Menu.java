package org.webtool.bean;

import java.util.ArrayList;

public class Menu
{
	private int id;
	private String name;
	private String slug;
	private ArrayList<Menu> child;
	
	public Menu()
	{
		this.id = -1;
		this.name = "";
		this.slug = "";
		this.child = new ArrayList<>();
	}
	
	public Menu(int id, String name, String slug, ArrayList<Menu> child)
	{
		this.id = id;
		this.name = name;
		this.slug = slug;
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
	
	public ArrayList<Menu> getChild()
	{
		return child;
	}
	
	public void setChild(ArrayList<Menu> child)
	{
		this.child = child;
	}
	
}
