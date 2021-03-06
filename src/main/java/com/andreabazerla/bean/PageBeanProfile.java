package com.andreabazerla.bean;

import java.io.Serializable;

import com.andreabazerla.util.NullValue;

public class PageBeanProfile implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	private int id = NullValue.NUMBER;
	
	private String role = NullValue.STRING;

	private String code = NullValue.STRING;

	private String username = NullValue.STRING;

	private String password = NullValue.STRING;

	private String name = NullValue.STRING;

	private String surname = NullValue.STRING;

	private String email = NullValue.STRING;

	private String birthday = NullValue.STRING;

	private String city = NullValue.STRING;

	private String address = NullValue.STRING;

	private int cap = NullValue.NUMBER;

	private int number = NullValue.NUMBER;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public int getCap()
	{
		return cap;
	}

	public void setCap(int cap)
	{
		this.cap = cap;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}
	
}
