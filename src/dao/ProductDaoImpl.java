package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Product;

@Repository
public class ProductDaoImpl implements ProductDao
{

	@Autowired
	private SessionFactory sessionFactory;

	public void createProduct(Product product)
	{
		sessionFactory.getCurrentSession()
		              .saveOrUpdate(product);
	}

	@SuppressWarnings("unchecked")
	public List<Product> readProducts()
	{
		return sessionFactory.getCurrentSession()
		                     .createQuery("from Product")
		                     .list();
	}

	public List<Product> searchProduct(String search)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Product> productList = currentSession.createCriteria(Product.class)
		                                          .add(Restrictions.disjunction()
		                                                           .add(Restrictions.ilike("cf",
		                                                                                   search,
		                                                                                   MatchMode.ANYWHERE))
		                                                           .add(Restrictions.ilike("name",
		                                                                                   search,
		                                                                                   MatchMode.ANYWHERE))
		                                                           .add(Restrictions.ilike("surname",
		                                                                                   search,
		                                                                                   MatchMode.ANYWHERE)))

		                                          .list();

		return productList;
	}

	public void deleteProduct(int id)
	{
		Product product = (Product) sessionFactory.getCurrentSession()
		                                          .load(Product.class,
		                                                id);
		if (null != product)
		{
			this.sessionFactory.getCurrentSession()
			                   .delete(product);
		}
	}

	public Product updateProduct(Product product)
	{
		sessionFactory.getCurrentSession()
		              .update(product);
		return product;
	}

	public Product loadProduct(String cf)
	{

		Session currentSession = sessionFactory.getCurrentSession();

		Product product = (Product) currentSession.createCriteria(Product.class)
		                                          .add(Restrictions.eq("cf",
		                                                               cf))
		                                          .uniqueResult();

		return product;
	}

	public Product getProduct(int id)
	{
		return null;
	}

}