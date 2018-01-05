package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String type;

	@Column
	private String code;

	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private String email;

	@Column
	private String birthday;

	@Column
	private String city;

	@Column
	private String address;

	@Column
	private String cap;

	@Column
	private String number;

	public User()
	{}

	public User(int id,
	            String type,
	            String code,
	            String username,
	            String password,
	            String name,
	            String surname,
	            String email,
	            String birthday,
	            String city,
	            String address,
	            String cap,
	            String number)
	{
		this.id = id;
		this.type = type;
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

	public static User make(ResultSet resultSet) throws SQLException
	{

		int id = Integer.parseInt(resultSet.getString("id"));
		String type = resultSet.getString("type");
		String code = resultSet.getString("code");
		String name = resultSet.getString("name");
		String surname = resultSet.getString("surname");
		String username = resultSet.getString("username");
		String password = resultSet.getString("password");
		String email = resultSet.getString("email");
		String birthday = resultSet.getString("birthday");
		String city = resultSet.getString("city");
		String address = resultSet.getString("address");
		String cap = resultSet.getString("cap");
		String number = resultSet.getString("number");

		return new User(id,
		                type,
		                code,
		                username,
		                password,
		                name,
		                surname,
		                email,
		                birthday,
		                city,
		                address,
		                cap,
		                number);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
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

	public String getCap()
	{
		return cap;
	}

	public void setCap(String cap)
	{
		this.cap = cap;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}
