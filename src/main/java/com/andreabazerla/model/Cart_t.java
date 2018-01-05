package com.andreabazerla.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.andreabazerla.util.NullValue;

@Entity
@Table(name = "Cart")
public class Cart_t implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = NullValue.NUMBER;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idUser_fk")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private User_t user = (User_t) NullValue.OBJECT;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idProduct_fk")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Product_t product = (Product_t) NullValue.OBJECT;

	public Cart_t() {}

	public Cart_t(int id,
	              User_t user,
	              Product_t product)
	{
		super();
		this.id = id;
		this.user = user;
		this.product = product;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public User_t getUser()
	{
		return user;
	}

	public void setUser(User_t user)
	{
		this.user = user;
	}

	public Product_t getProduct()
	{
		return product;
	}

	public void setProduct(Product_t product)
	{
		this.product = product;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Cart_t other = (Cart_t) obj;
		if (id != other.id)
			return false;
		if (product == null)
		{
			if (other.product != null)
				return false;
		}
		else
			if (!product.equals(other.product))
				return false;
		if (user == null)
		{
			if (other.user != null)
				return false;
		}
		else
			if (!user.equals(other.user))
				return false;
		return true;
	}
	
}
