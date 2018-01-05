package com.andreabazerla.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andreabazerla.dao.ReceiptDao;
import com.andreabazerla.model.Receipt_t;

@Service
@Transactional
public class ReceiptServiceImpl implements ReceiptService
{
	@Autowired
	private ReceiptDao receiptDao;
	
	@Override
	public void create(Receipt_t t) throws SQLException
	{
		
	}
	
	@Override
	public List<Receipt_t> read()
	{
		return null;
	}
	
	@Override
	public Receipt_t get(int id)
	{
		return receiptDao.readReceipt(id);
	}
	
	@Override
	public void update(Receipt_t t) throws SQLException
	{
		
	}

	@Override
	public void delete(int id)
	{
		receiptDao.deleteReceipt(id);
	}

	@Override
	public void printReceipt(int idUser)
	{
		receiptDao.printReceipt(idUser);
	}

}
