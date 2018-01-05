package com.andreabazerla.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.andreabazerla.bean.PageBeanFactory;
import com.andreabazerla.exception.DeleteUserException;

@Controller
public class FactoryController extends ParentController
{

	@RequestMapping(value = "/Factory", method = RequestMethod.GET)
	public ModelAndView getFactory(HttpServletRequest request) throws SQLException, IOException
	{

		int idFactory = Integer.parseInt(request.getParameter("id"));

		PageBeanFactory pageBeanFactory = getWebFacade().getPageBeanFactory(idFactory);

		return new ModelAndView("factory",
		                        "pageBean",
		                        pageBeanFactory);

	}

	@RequestMapping(value = "/DeleteFactory", method = RequestMethod.POST)
	public ModelAndView deleteFactory(HttpServletRequest request) throws DeleteUserException
	{

		int idFactory = Integer.parseInt(request.getParameter("id-factory"));

		getWebFacade().getFactoryService()
		              .delete(idFactory);

		return new ModelAndView("redirect:/Home");

	}

}
