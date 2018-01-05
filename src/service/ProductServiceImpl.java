package service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Product;

@Service
public class ProductServiceImpl implements ProductService
{

	@Autowired
	private ProductDao productDao;

	public void create(Product product) throws SQLException
	{
		productDao.createProduct(product);
	}

	public List<Product> read()
	{
		return productDao.readProducts();
	}

	public Product get(int id)
	{
		return productDao.getProduct(id);
	}

	public void update(Product product)
	{
		productDao.updateProduct(product);
	}

	public void delete(int id)
	{
		productDao.deleteProduct(id);
	}

}
