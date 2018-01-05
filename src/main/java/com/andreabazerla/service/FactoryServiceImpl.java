
package com.andreabazerla.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andreabazerla.bean.BeanFactory;
import com.andreabazerla.dao.FactoryDao;
import com.andreabazerla.model.Factory_t;

@Service
@Transactional
public class FactoryServiceImpl implements FactoryService
{

	@Autowired
	private FactoryDao factoryDao;

	@Override
	public void create(Factory_t factory_t)
	{
		factoryDao.createFactory(factory_t);
	}

	@Override
	public List<Factory_t> read()
	{
		return null;
	}

	@Override
	public void update(Factory_t t) throws SQLException
	{

	}

	@Override
	public Factory_t get(int id)
	{
		return factoryDao.readFactory(id);
	}

	@Override
	public void delete(int id)
	{
		factoryDao.deleteFactory(id);
	}

	@Override
	public List<BeanFactory> getAllFactory()
	{
		return factoryDao.getAllFactory();
	}

}
