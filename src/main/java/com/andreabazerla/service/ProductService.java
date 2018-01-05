package com.andreabazerla.service;

import java.util.ArrayList;
import java.util.List;

import com.andreabazerla.bean.BeanProduct;
import com.andreabazerla.bean.BeanSearch;
import com.andreabazerla.model.Product_t;

public interface ProductService extends GenericService<Product_t>
{

	public List<BeanProduct> read(BeanSearch beanSearch);

	public Product_t get(int id);

	public ArrayList<Product_t> load(String search);

	public Product_t unavailable(int idProduct);
	public Product_t sold(int idProduct);

	public void removeFromCart(int userId, int productId);
	public void removeFromShopping(int userId, int productId);


	
}
