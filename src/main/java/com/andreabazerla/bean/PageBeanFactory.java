package com.andreabazerla.bean;

import java.io.Serializable;

import com.andreabazerla.util.NullValue;

public class PageBeanFactory implements Serializable
{

	private static final long serialVersionUID = 1L;

	private BeanFactory beanFactory = (BeanFactory) NullValue.OBJECT;

	public BeanFactory getBeanFactory()
	{
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory)
	{
		this.beanFactory = beanFactory;
	}
	
}
