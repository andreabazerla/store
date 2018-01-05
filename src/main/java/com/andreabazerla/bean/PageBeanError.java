package com.andreabazerla.bean;

import java.io.Serializable;

import com.andreabazerla.util.NullValue;

public class PageBeanError implements Serializable
{

	private static final long serialVersionUID = 1L;

	BeanError beanError = (BeanError) NullValue.OBJECT;

	public BeanError getBeanError()
	{
		return beanError;
	}

	public void setBeanError(BeanError beanError)
	{
		this.beanError = beanError;
	}
	
}
