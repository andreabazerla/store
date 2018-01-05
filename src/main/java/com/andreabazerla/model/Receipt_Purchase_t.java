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
@Table(name = "Receipt_Purchase")
public class Receipt_Purchase_t implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idUser_fk")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private User_t user = (User_t) NullValue.OBJECT;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idPurchase_fk")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Purchase_t purchase = (Purchase_t) NullValue.OBJECT;

	public Receipt_Purchase_t()
	{}

	public Receipt_Purchase_t(int id,
	                          User_t user,
	                          Purchase_t purchase)
	{
		super();
		this.id = id;
		this.user = user;
		this.purchase = purchase;
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

	public Purchase_t getPurchase()
	{
		return purchase;
	}

	public void setPurchase(Purchase_t purchase)
	{
		this.purchase = purchase;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((purchase == null) ? 0 : purchase.hashCode());
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
		Receipt_Purchase_t other = (Receipt_Purchase_t) obj;
		if (id != other.id)
			return false;
		if (purchase == null)
		{
			if (other.purchase != null)
				return false;
		}
		else
			if (!purchase.equals(other.purchase))
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
