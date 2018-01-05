package com.andreabazerla.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageBeanHome implements Serializable
{

	private static final long serialVersionUID = 1L;

	private List<BeanProduct> beanProductList = new ArrayList<>();
	
	private BeanSearch beanSearch = new BeanSearch();

	public void add(BeanProduct beanProduct)
	{
		beanProductList.add(beanProduct);
	}

	public List<BeanProduct> getBeanProductList()
	{
		return beanProductList;
	}

	public BeanSearch getBeanSearch()
	{
		return beanSearch;
	}

	public void setBeanSearch(BeanSearch beanSearch)
	{
		this.beanSearch = beanSearch;
	}
	
}
