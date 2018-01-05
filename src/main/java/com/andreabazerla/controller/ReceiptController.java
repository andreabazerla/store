package com.andreabazerla.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.andreabazerla.exception.DeleteUserException;

@Controller
public class ReceiptController extends ParentController
{

	@RequestMapping(value = "/DeleteReceipt", method = RequestMethod.GET, params =
	{ "id" })
	public void deleteReceipt(HttpServletRequest request,
	                       @RequestParam("id") int id) throws DeleteUserException
	{

		getWebFacade().getReceiptService()
		              .delete(id);

	}
	
	

}
