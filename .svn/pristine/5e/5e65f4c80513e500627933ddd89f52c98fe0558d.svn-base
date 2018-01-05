package com.andreabazerla.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.andreabazerla.model.Purchase_t;

@Repository
public class PurchaseDaoImpl implements PurchaseDao
{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createPurchase(Purchase_t purchase)
	{
		sessionFactory.getCurrentSession()
		              .saveOrUpdate(purchase);
	}

}