package com.andreabazerla.service;

import java.sql.SQLException;
import java.util.List;

import com.andreabazerla.exception.DeleteUserException;

public interface GenericService<T>
{

	public void create(T t) throws SQLException;

	public List<T> read();

	public void update(T t) throws SQLException;

	public void delete(int id) throws DeleteUserException;

}
