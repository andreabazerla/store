package com.andreabazerla.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.andreabazerla.util.NullValue;

@Entity
@Table(name = "Receipt")
public class Receipt_t implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private int code = NullValue.NUMBER;

	@Column
	private Date date = NullValue.DATE;

	@Column
	private float amount = NullValue.NUMBER;

	@Column
	private int flag = NullValue.NUMBER;

	public Receipt_t()
	{}

	public Receipt_t(int id,
	                 int code,
	                 Date date,
	                 float amount,
	                 int flag)
	{
		super();
		this.id = id;
		this.code = code;
		this.date = date;
		this.amount = amount;
		this.flag = flag;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public float getAmount()
	{
		return amount;
	}

	public void setAmount(float amount)
	{
		this.amount = amount;
	}

	public int getFlag()
	{
		return flag;
	}

	public void setFlag(int flag)
	{
		this.flag = flag;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + code;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + flag;
		result = prime * result + id;
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
		Receipt_t other = (Receipt_t) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (code != other.code)
			return false;
		if (date == null)
		{
			if (other.date != null)
				return false;
		}
		else
			if (!date.equals(other.date))
				return false;
		if (flag != other.flag)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
}
