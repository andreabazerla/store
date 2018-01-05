package com.andreabazerla.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Factory")
public class Factory_t implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@Column
	private String country;

	@Column
	private String city;

	@Column
	private String address;

	@Column
	private int cap;

	@Column
	private int number;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "factory", cascade = CascadeType.ALL)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Product_t> productList = new ArrayList<>();

	public Factory_t() {}

	public Factory_t(String name)
	{
		this.name = name;
	}

	public Factory_t(int id,
	                 String name,
	                 String country,
	                 String city,
	                 String address,
	                 int cap,
	                 int number,
	                 List<Product_t> productList)
	{
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.city = city;
		this.address = address;
		this.cap = cap;
		this.number = number;
		this.productList = productList;
	}

	public List<Product_t> getProductList()
	{
		return productList;
	}

	public void setProductList(List<Product_t> productList)
	{
		this.productList = productList;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public int getCap()
	{
		return cap;
	}

	public void setCap(int cap)
	{
		this.cap = cap;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + cap;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
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
		Factory_t other = (Factory_t) obj;
		if (address == null)
		{
			if (other.address != null)
				return false;
		}
		else
			if (!address.equals(other.address))
				return false;
		if (cap != other.cap)
			return false;
		if (city == null)
		{
			if (other.city != null)
				return false;
		}
		else
			if (!city.equals(other.city))
				return false;
		if (country == null)
		{
			if (other.country != null)
				return false;
		}
		else
			if (!country.equals(other.country))
				return false;
		if (id != other.id)
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else
			if (!name.equals(other.name))
				return false;
		if (number != other.number)
			return false;
		if (productList == null)
		{
			if (other.productList != null)
				return false;
		}
		else
			if (!productList.equals(other.productList))
				return false;
		return true;
	}
	
}
