package com.lsn.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lsn.domain.Customer;
import com.lsn.domain.Employee;
import com.lsn.service.CustomerService;

@Controller
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	private Map<Integer, Customer> customers = null;

	@Autowired
	@Qualifier("passwordValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	public CustomerController() {
		customers = new HashMap<Integer, Customer>();
	}

	
	 /* @RequestMapping(value = "/customer", method = RequestMethod.GET) public
	  ModelAndView saveCustomerPage(ModelAndView model) {
	  model.addObject("customer", new Customer());
	  model.setViewName("custSave"); 
	  return model; 
	  }*/
	 

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String saveCustomerPage(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "custSave";
	}

	
	 /* @RequestMapping(value = "/customersave", method = RequestMethod.POST)
	  public ModelAndView
	  saveEmployeeAction(@ModelAttribute("customer") @Validated Customer
	  customer, BindingResult bindingResult, ModelAndView model) { if
	  (bindingResult.hasErrors()) { 
		  logger.info("Returning custSave.jsp page");
	  model.setViewName("custSave"); 
	  return model; 
	  }
	  model.addObject("customer", customer); 
	  customers.put(customer.getId(),customer); 
	  model.setViewName("custSaveSuccess"); 
	  return model;
	  
	  }*/
	 

	@RequestMapping(value = "/customersave", method = RequestMethod.POST)
	public String saveEmployeeAction(@ModelAttribute("customer") @Validated Customer customer,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			logger.info("Returning custSave.jsp page");

			return "custSave";
		}
		model.addAttribute("customer", customer);

		customers.put(customer.getId(), customer);

		return "custSaveSuccess";

	}

}