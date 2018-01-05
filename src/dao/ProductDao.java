package dao;

import java.util.List;

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
