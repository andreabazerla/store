package com.andreabazerla.dao;

import java.util.List;

import com.andreabazerla.bean.BeanProduct;
import com.andreabazerla.bean.BeanSearch;
import com.andreabazerla.model.Product_t;

public interface ProductDao extends GenericDao<Product_t> {
	
	public void createProduct(Product_t Product);

	public List<Product_t> readProducts();
	public List<BeanProduct> readProducts(BeanSearch beanSearch);

	public Product_t updateProduct(Product_t Product);

	public boolean deleteProduct(int id);

	public Product_t getProduct(int id);
	public List<Product_t> searchProduct(String pattern);

	public void removeFromCart(int userId, int productId);

	public void removeFromShopping(int userId,
	                        int productId);

	
}
