package com.andreabazerla.bean;

import java.util.Date;

import com.andreabazerla.model.Factory_t;
import com.andreabazerla.model.User_t;
import com.andreabazerla.util.NullValue;

public class PageBeanProductDetails
{

	private int id = NullValue.NUMBER;

	private User_t user = (User_t) NullValue.OBJECT;

	private Factory_t factory = (Factory_t) NullValue.OBJECT;

	private String name = NullValue.STRING;

	private String description = NullValue.STRING;

	private float price = NullValue.NUMBER;

	private String type = NullValue.STRING;

	private String console = NullValue.STRING;

	private Date date = NullValue.DATE;

	private char gadge = NullValue.CHAR;

	private int model = NullValue.NUMBER;

	private int build = NullValue.NUMBER;

	private String genre = NullValue.STRING;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public User_t getUser()
	{
		return user;
	}

	public void setUser(User_t user)
	{
		this.user = user;
	}

	public Factory_t getFactory()
	{
		return factory;
	}

	public void setFactory(Factory_t factory)
	{
		this.factory = factory;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getConsole()
	{
		return console;
	}

	public void setConsole(String console)
	{
		this.console = console;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public char getGadge()
	{
		return gadge;
	}

	public void setGadge(char gadge)
	{
		this.gadge = gadge;
	}

	public int getModel()
	{
		return model;
	}

	public void setModel(int model)
	{
		this.model = model;
	}

	public int getBuild()
	{
		return build;
	}

	public void setBuild(int build)
	{
		this.build = build;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

}
