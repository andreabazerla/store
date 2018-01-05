package com.andreabazerla.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.andreabazerla.util.NullValue;

public class PageBeanCart implements Serializable
{

	private static final long serialVersionUID = 1L;

	private List<BeanProduct> beanProductList = new ArrayList<>();
	
	private float total = NullValue.NUMBER;
	
	private int idUser = NullValue.NUMBER;

	public void add(BeanProduct beanProduct)
	{
		beanProductList.add(beanProduct);
	}

	public void remove(BeanProduct beanProduct)
	{
		beanProductList.remove(beanProduct);
	}

	public List<BeanProduct> getBeanProductList()
	{
		return beanProductList;
	}

	public float getTotal()
	{
		return total;
	}

	public void setTotal(float total)
	{
		this.total = total;
	}

	public int getIdUser()
	{
		return idUser;
	}

	public void setIdUser(int idUser)
	{
		this.idUser = idUser;
	}
	
}
