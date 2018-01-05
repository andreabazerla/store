package com.andreabazerla.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.andreabazerla.util.NullValue;

public class BeanPurchase implements Serializable
{

	private static final long serialVersionUID = 1L;

	private int id = NullValue.NUMBER;

	private BeanReceipt beanReceipt = (BeanReceipt) NullValue.OBJECT;

	private List<BeanProduct> beanProductPreviewList = new ArrayList<>();

	public void add(BeanProduct beanProductPreview)
	{
		beanProductPreviewList.add(beanProductPreview);
	}

	public int getId()
	{
		return id;
	}

	public void setBeanReceipt(BeanReceipt beanReceipt)
	{
		this.beanReceipt = beanReceipt;
	}

	public BeanReceipt getBeanReceipt()
	{
		return beanReceipt;
	}

	public List<BeanProduct> getBeanProductPreviewList()
	{
		return beanProductPreviewList;
	}

}
