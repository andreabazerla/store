package com.andreabazerla.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andreabazerla.dao.PurchaseDao;
import com.andreabazerla.model.Purchase_t;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService
{

	@Autowired
	private PurchaseDao purchaseDao;
	
	@Override
	public void create(Purchase_t purchase)
	{
		purchaseDao.createPurchase(purchase);
	}

	@Override
	public List<Purchase_t> read()
	{
		return null;
	}

	@Override
	public void update(Purchase_t t) throws SQLException
	{

	}

	@Override
	public void delete(int id)
	{

	}

}
