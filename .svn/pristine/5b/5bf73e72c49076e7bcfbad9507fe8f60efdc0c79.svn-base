package com.andreabazerla.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.andreabazerla.facade.WebFacade;

public class ParentController
{

	@Autowired
	private WebFacade webFacade;

	public WebFacade getWebFacade()
	{
		return webFacade;
	}

	protected boolean checkData(String cf,
	                            String name,
	                            String surname)
	{
		return (cf != null && !cf.isEmpty()
		        && cf.trim()
		             .length() > 0)
		       && (name != null && !name.isEmpty()
		           && name.trim()
		                  .length() > 0)
		       && (surname != null && !surname.isEmpty()
		           && surname.trim()
		                     .length() > 0);
	}

	public boolean ifNull(String string)
	{
		if (string != null && !string.isEmpty()
		    && string.trim()
		             .length() > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
