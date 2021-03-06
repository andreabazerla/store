package com.andreabazerla.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.andreabazerla.util.NullValue;

@Entity
@Table(name = "Users")
public class User_t implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = NullValue.NUMBER;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinTable(name = "Cart", joinColumns = @JoinColumn(name = "idUser_fk"), inverseJoinColumns = @JoinColumn(name = "idProduct_fk"))
	private List<Product_t> productCartList = new ArrayList<>();

	@SuppressWarnings("deprecation")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Receipt_Purchase", joinColumns = @JoinColumn(name = "idUser_fk"), inverseJoinColumns = @JoinColumn(name = "idPurchase_fk"))
	@MapKey(name = "receipt")
	@Cascade(value = {org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Map<Receipt_t, Purchase_t> receiptPurchaseMap = new HashMap<>();

	@Column
	private String role = NullValue.STRING;

	@Column
	private String code = NullValue.STRING;

	@Column
	private String username = NullValue.STRING;

	@Column
	private String password = NullValue.STRING;

	@Column
	private String name = NullValue.STRING;

	@Column
	private String surname = NullValue.STRING;

	@Column
	private String email = NullValue.STRING;

	@Column
	private String birthday = NullValue.STRING;

	@Column
	private String city = NullValue.STRING;

	@Column
	private String address = NullValue.STRING;

	@Column
	private int cap = NullValue.NUMBER;

	@Column
	private int number = NullValue.NUMBER;

	public User_t()
	{}

	public User_t(int id,
	              String role,
	              String code,
	              String username,
	              String password,
	              String name,
	              String surname,
	              String email,
	              String birthday,
	              String city,
	              String address,
	              int cap,
	              int number)
	{
		super();
		this.id = id;
		this.role = role;
		this.code = code;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birthday = birthday;
		this.city = city;
		this.address = address;
		this.cap = cap;
		this.number = number;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public List<Product_t> getProductCartList()
	{
		return productCartList;
	}

	public void setProductCartList(List<Product_t> productCartList)
	{
		this.productCartList = productCartList;
	}

	public Map<Receipt_t, Purchase_t> getReceiptPurchaseMap()
	{
		return receiptPurchaseMap;
	}

	public void setReceiptPurchaseMap(Map<Receipt_t, Purchase_t> receiptPurchaseMap)
	{
		this.receiptPurchaseMap = receiptPurchaseMap;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
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
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + cap;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((productCartList == null) ? 0 : productCartList.hashCode());
		result = prime * result + ((receiptPurchaseMap == null) ? 0 : receiptPurchaseMap.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User_t other = (User_t) obj;
		if (address == null)
		{
			if (other.address != null)
				return false;
		}
		else
			if (!address.equals(other.address))
				return false;
		if (birthday == null)
		{
			if (other.birthday != null)
				return false;
		}
		else
			if (!birthday.equals(other.birthday))
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
		if (code == null)
		{
			if (other.code != null)
				return false;
		}
		else
			if (!code.equals(other.code))
				return false;
		if (email == null)
		{
			if (other.email != null)
				return false;
		}
		else
			if (!email.equals(other.email))
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
		if (password == null)
		{
			if (other.password != null)
				return false;
		}
		else
			if (!password.equals(other.password))
				return false;
		if (productCartList == null)
		{
			if (other.productCartList != null)
				return false;
		}
		else
			if (!productCartList.equals(other.productCartList))
				return false;
		if (receiptPurchaseMap == null)
		{
			if (other.receiptPurchaseMap != null)
				return false;
		}
		else
			if (!receiptPurchaseMap.equals(other.receiptPurchaseMap))
				return false;
		if (role == null)
		{
			if (other.role != null)
				return false;
		}
		else
			if (!role.equals(other.role))
				return false;
		if (surname == null)
		{
			if (other.surname != null)
				return false;
		}
		else
			if (!surname.equals(other.surname))
				return false;
		if (username == null)
		{
			if (other.username != null)
				return false;
		}
		else
			if (!username.equals(other.username))
				return false;
		return true;
	}
	
}
