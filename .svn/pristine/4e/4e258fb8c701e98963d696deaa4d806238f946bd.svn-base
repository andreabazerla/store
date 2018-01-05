package com.andreabazerla.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.andreabazerla.bean.BeanFactory;
import com.andreabazerla.model.Factory_t;

@Repository
public class FactoryDaoImpl implements FactoryDao
{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createFactory(Factory_t factory_t)
	{
		sessionFactory.getCurrentSession()
		              .saveOrUpdate(factory_t);

	}

	@SuppressWarnings("deprecation")
	public Factory_t readFactory(int id)
	{

		Session session = sessionFactory.getCurrentSession();

		return (Factory_t) session.createCriteria(Factory_t.class)
		                          .add(Restrictions.eq("id",
		                                               id))
		                          .uniqueResult();
	}

	@Override
	public Factory_t getFactory(int id)
	{

		return (Factory_t) sessionFactory.getCurrentSession()
		                                 .get(Factory_t.class,
		                                      id);

	}

	public boolean deleteFactory(int id)
	{
		Factory_t factory_t = (Factory_t) sessionFactory.getCurrentSession()
		                                                .load(Factory_t.class,
		                                                      id);
		if (null != factory_t)
		{
			this.sessionFactory.getCurrentSession()
			                   .delete(factory_t);
			return true;
		}
		return false;
	}

	@SuppressWarnings(
	{ "unchecked", "deprecation" })
	@Override
	public List<BeanFactory> getAllFactory()
	{

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Factory_t.class);

		criteria = criteria.setProjection(Projections.projectionList()
		                                             .add(Projections.property("id"),
		                                                  "id")
		                                             .add(Projections.property("name"),
		                                                  "name"))
		                   .setResultTransformer(new AliasToBeanResultTransformer(BeanFactory.class));

		List<BeanFactory> beanFactoryList = criteria.list();

		return beanFactoryList;
	}

}
