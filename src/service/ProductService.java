package service;

import model.Product;

public interface ProductService extends GenericService<Product>
{

	public Product get(int id);

}
