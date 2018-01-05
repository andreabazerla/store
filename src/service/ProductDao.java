package service;

import java.util.List;

import dao.GenericDao;
import model.Product;

public interface ProductDao extends GenericDao<Product>
{

	public void createProduct(Product Product);

	public List<Product> readProducts();
	
	public Product getProduct(int id);

	public Product updateProduct(Product Product);

	public void deleteProduct(int id);

	public List<Product> searchProduct(String pattern);

}
