package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String status;

	@Column
	private String price;

	@Column
	private String type;

	@Column
	private String console;

	@Column
	private String date;

	@Column
	private String gadge;

	@Column
	private String model;

	@Column
	private String producer;

	@Column
	private String build;

	@Column
	private String genre;

	public Product()
	{}

	public Product(int id,
	               String status,
	               String price,
	               String type,
	               String console,
	               String date,
	               String gadge,
	               String model,
	               String producer,
	               String build,
	               String genre)
	{
		super();
		this.id = id;
		this.status = status;
		this.price = price;
		this.type = type;
		this.console = console;
		this.date = date;
		this.gadge = gadge;
		this.model = model;
		this.producer = producer;
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

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
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

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getGadge()
	{
		return gadge;
	}

	public void setGadge(String gadge)
	{
		this.gadge = gadge;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public String getProducer()
	{
		return producer;
	}

	public void setProducer(String producer)
	{
		this.producer = producer;
	}

	public String getBuild()
	{
		return build;
	}

	public void setBuild(String build)
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

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}
