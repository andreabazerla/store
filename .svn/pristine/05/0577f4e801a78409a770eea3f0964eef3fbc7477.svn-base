package com.andreabazerla.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.andreabazerla.util.NullValue;

@Entity
@Table(name = "Product")
public class Product_t implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFactory_fk", nullable = true)
	private Factory_t factory = (Factory_t) NullValue.OBJECT;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPurchase_fk", nullable = true)
	private Purchase_t purchase = (Purchase_t) NullValue.OBJECT;

	@Column
	private String name = NullValue.STRING;

	@Column
	private String description = NullValue.STRING;

	@Column
	private float price = NullValue.NUMBER;

	@Column
	private String type = NullValue.STRING;

	@Column
	private String console = NullValue.STRING;

	@Column
	private Date date = NullValue.DATE;

	@Column
	private char gadge = NullValue.CHAR;

	@Column
	private int model = NullValue.NUMBER;

	@Column
	private int build = NullValue.NUMBER;

	@Column
	private String genre = NullValue.STRING;

	public Product_t()
	{}
	
	public Product_t(Factory_t factory,
	                 Purchase_t purchase,
	                 String name,
	                 String description,
	                 float price,
	                 String type,
	                 String console,
	                 Date date,
	                 char gadge,
	                 int model,
	                 int build,
	                 String genre)
	{
		super();
		this.factory = factory;
		this.purchase = purchase;
		this.name = name;
		this.description = description;
		this.price = price;
		this.type = type;
		this.console = console;
		this.date = date;
		this.gadge = gadge;
		this.model = model;
		this.build = build;
		this.genre = genre;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Factory_t getFactory()
	{
		return factory;
	}

	public void setFactory(Factory_t factory)
	{
		this.factory = factory;
	}

	public Purchase_t getPurchase()
	{
		return purchase;
	}

	public void setPurchase(Purchase_t purchase)
	{
		this.purchase = purchase;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getConsole()
	{
		return console;
	}

	public void setConsole(String console)
	{
		this.console = console;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public char getGadge()
	{
		return gadge;
	}

	public void setGadge(char gadge)
	{
		this.gadge = gadge;
	}

	public int getModel()
	{
		return model;
	}

	public void setModel(int model)
	{
		this.model = model;
	}

	public int getBuild()
	{
		return build;
	}

	public void setBuild(int build)
	{
		this.build = build;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + build;
		result = prime * result + ((console == null) ? 0 : console.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((factory == null) ? 0 : factory.hashCode());
		result = prime * result + gadge;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + model;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((purchase == null) ? 0 : purchase.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Product_t other = (Product_t) obj;
		if (build != other.build)
			return false;
		if (console == null)
		{
			if (other.console != null)
				return false;
		}
		else
			if (!console.equals(other.console))
				return false;
		if (date == null)
		{
			if (other.date != null)
				return false;
		}
		else
			if (!date.equals(other.date))
				return false;
		if (description == null)
		{
			if (other.description != null)
				return false;
		}
		else
			if (!description.equals(other.description))
				return false;
		if (factory == null)
		{
			if (other.factory != null)
				return false;
		}
		else
			if (!factory.equals(other.factory))
				return false;
		if (gadge != other.gadge)
			return false;
		if (genre == null)
		{
			if (other.genre != null)
				return false;
		}
		else
			if (!genre.equals(other.genre))
				return false;
		if (id != other.id)
			return false;
		if (model != other.model)
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else
			if (!name.equals(other.name))
				return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (purchase == null)
		{
			if (other.purchase != null)
				return false;
		}
		else
			if (!purchase.equals(other.purchase))
				return false;
		if (type == null)
		{
			if (other.type != null)
				return false;
		}
		else
			if (!type.equals(other.type))
				return false;
		return true;
	}
	
}
