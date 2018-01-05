package com.andreabazerla.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andreabazerla.bean.BeanProduct;
import com.andreabazerla.bean.BeanSearch;
import com.andreabazerla.dao.ProductDao;
import com.andreabazerla.model.Product_t;

@Service
@Transactional
public class ProductServiceImpl implements ProductService
{

	@Autowired
	private ProductDao productDao;

	@Override
	public void create(Product_t product) throws SQLException
	{
		productDao.createProduct(product);
	}

	@Override
	public List<Product_t> read()
	{
		return productDao.readProducts();
	}
	
	@Override
	public List<BeanProduct> read(BeanSearch beanSearch)
	{
		return productDao.readProducts(beanSearch);
	}

	@Override
	public Product_t get(int id)
	{
		return productDao.getProduct(id);
	}

	@Override
	public ArrayList<Product_t> load(String search)
	{
		return (ArrayList<Product_t>) productDao.searchProduct(search);
	}

	@Override
	public void delete(int id)
	{
		productDao.deleteProduct(id);
	}

	@Override
	public void update(Product_t product)
	{
		productDao.updateProduct(product);
	}

	@Override
	public Product_t unavailable(int idProduct)
	{
		Product_t product = get(idProduct);

		return product;

	}

	@Override
	public Product_t sold(int idProduct)
	{
		Product_t product = get(idProduct);

		return product;

	}

	@Override
	public void removeFromShopping(int userId,
	                               int productId)
	{
		productDao.removeFromShopping(userId,
		                              productId);
	}

	@Override
	public void removeFromCart(int userId,
	                           int productId)
	{
		productDao.removeFromCart(userId,
		                          productId);
	}

}
