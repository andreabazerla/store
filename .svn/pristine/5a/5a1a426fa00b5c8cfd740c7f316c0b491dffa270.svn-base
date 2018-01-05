package com.andreabazerla.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.andreabazerla.bean.BeanSearch;
import com.andreabazerla.bean.PageBeanHome;
import com.andreabazerla.util.StringUtility;

@Controller
public class GenericController extends ParentController
{

	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) throws IOException
	{
		BeanSearch beanSearch = new BeanSearch();

		String name = request.getParameter("name");
		if (!StringUtility.isStringEmpty(name))
			beanSearch.setName(name);

		String description = request.getParameter("description");
		if (!StringUtility.isStringEmpty(description))
			beanSearch.setDescription(description);

		int factory = 0;
		String factoryString = request.getParameter("factory");
		if (!StringUtility.isStringEmpty(factoryString))
			factory = Integer.parseInt(factoryString);
		beanSearch.setFactory(factory);

		int min = 0;
		int max = 0;
		String priceString = request.getParameter("price");
		if (!StringUtility.isStringEmpty(priceString))
		{
			String price = request.getParameter("price");
			String[] priceStringArray = price.split(",");
			min = Integer.parseInt(priceStringArray[0]);
			max = Integer.parseInt(priceStringArray[1]);
			beanSearch.setMin(min);
			beanSearch.setMax(max);
		}

		PageBeanHome pageBeanHome = getWebFacade().getPageBeanHome(beanSearch);

		return new ModelAndView("home",
		                        "pageBean",
		                        pageBeanHome);
	}

}
