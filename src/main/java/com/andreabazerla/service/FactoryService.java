package com.andreabazerla.service;

import java.util.List;

import com.andreabazerla.bean.BeanFactory;
import com.andreabazerla.model.Factory_t;

public interface FactoryService extends GenericService<Factory_t>
{

	public Factory_t get(int id);

	public List<BeanFactory> getAllFactory();

}