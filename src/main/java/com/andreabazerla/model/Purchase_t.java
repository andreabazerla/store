package com.andreabazerla.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.andreabazerla.util.NullValue;

@Entity
@Table(name = "Purchase")
public class Purchase_t implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idPurchase_fk")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<Product_t> productList = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@JoinColumn(name = "idReceipt_fk")
	private Receipt_t receipt = (Receipt_t) NullValue.OBJECT;

	public Purchase_t()
	{}

	public Purchase_t(int id,
	                  List<Product_t> productList,
	                  Receipt_t receipt)
	{
		super();
		this.id = id;
		this.productList = productList;
		this.receipt = receipt;
	}

	public void add(Product_t product_t)
	{
		productList.add(product_t);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public List<Product_t> getProductList()
	{
		return productList;
	}

	public void setProductList(List<Product_t> productList)
	{
		this.productList = productList;
	}

	public Receipt_t getReceipt()
	{
		return receipt;
	}

	public void setReceipt(Receipt_t receipt)
	{
		this.receipt = receipt;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase_t other = (Purchase_t) obj;
		if (id != other.id)
			return false;
		if (productList == null)
		{
			if (other.productList != null)
				return false;
		}
		else
			if (!productList.equals(other.productList))
				return false;
		if (receipt == null)
		{
			if (other.receipt != null)
				return false;
		}
		else
			if (!receipt.equals(other.receipt))
				return false;
		return true;
	}

}
