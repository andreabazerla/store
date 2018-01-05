package com.andreabazerla.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.andreabazerla.bean.BeanError;
import com.andreabazerla.bean.PageBeanError;

@Controller
public class ErrorController extends ParentController
{

	@RequestMapping(value = "/Error", method = RequestMethod.POST)
	public ModelAndView deleteUser(HttpServletRequest request)
	{
		
		int errorCode = Integer.parseInt(request.getParameter("errorCode"));
		
		PageBeanError pageBeanError = new PageBeanError();
		
		BeanError beanError = new BeanError();
		beanError.setCode(errorCode);
		
		pageBeanError.setBeanError(beanError);
		
		return new ModelAndView("error", "pageBean", pageBeanError);
	}

}
