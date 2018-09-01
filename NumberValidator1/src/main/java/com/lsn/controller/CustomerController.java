package com.lsn.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lsn.domain.Customer;
import com.lsn.domain.Employee;

@Controller
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	private Map<Integer, Customer> customers = null;

	public CustomerController() {
		customers = new HashMap<Integer, Customer>();
	}

	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ModelAndView saveCustomerPage(ModelAndView model) {
		model.addObject("customer", new Customer());

		model.setViewName("custSave");
		logger.info("Returning CustomerPage");
		return model;
	}

	@RequestMapping(value = "/customersave", method = RequestMethod.POST)
	public ModelAndView saveEmployeeAction(@ModelAttribute("customer")Customer customer,
			BindingResult bindingResult, ModelAndView model) {
		if (bindingResult.hasErrors()) {
			logger.info("Returning custSave.jsp page");
			model.setViewName("custSave");
			return model;
		}
		logger.info("Returning custSaveSuccess.jsp page");
		model.addObject("customer", customer);
		customers.put(customer.getId(), customer);
		model.setViewName("custSaveSuccess");
		return model;
	}
}