package com.andreabazerla.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.andreabazerla.util.NullValue;

public class BeanSearch implements Serializable
{

	private static final long serialVersionUID = 1L;

	private String name = NullValue.STRING;

	private String description = NullValue.STRING;
	
	private int factory = NullValue.NUMBER;
	
	private int min = NullValue.NUMBER;
	private int max = NullValue.NUMBER;

	private Set<BeanFactory> beanFactorySet = new HashSet<>();
	
	public void add(BeanFactory beanFactory) {
		beanFactorySet.add(beanFactory);
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
	
	public int getFactory()
	{
		return factory;
	}

	public void setFactory(int factory)
	{
		this.factory = factory;
	}

	public int getMin()
	{
		return min;
	}

	public void setMin(int min)
	{
		this.min = min;
	}

	public int getMax()
	{
		return max;
	}

	public void setMax(int max)
	{
		this.max = max;
	}

	public Set<BeanFactory> getBeanFactorySet()
	{
		return beanFactorySet;
	}

}
