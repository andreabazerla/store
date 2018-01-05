package com.andreabazerla.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.andreabazerla.util.NullValue;

public class BeanFactory implements Serializable
{

	private static final long serialVersionUID = 1L;

	private int id = NullValue.NUMBER;

	private String name = NullValue.STRING;

	private List<BeanProduct> beanProductList = new ArrayList<>();

	public BeanFactory()
	{
	}

	public BeanFactory(int id, String name)
	{		
		this.id = id;
		this.name = name;
	}

	public void add(BeanProduct beanProduct)
	{
		beanProductList.add(beanProduct);
	}

	public List<BeanProduct> getBeanProductList()
	{
		return beanProductList;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beanProductList == null) ? 0 : beanProductList.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeanFactory other = (BeanFactory) obj;
		if (beanProductList == null)
		{
			if (other.beanProductList != null)
				return false;
		}
		else
			if (!beanProductList.equals(other.beanProductList))
				return false;
		if (id != other.id)
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else
			if (!name.equals(other.name))
				return false;
		return true;
	}

}
