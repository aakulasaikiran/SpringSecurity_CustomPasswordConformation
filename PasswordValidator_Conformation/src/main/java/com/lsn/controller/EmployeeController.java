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

import com.lsn.domain.Employee;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	private Map<String, Employee> employees = null;

	public EmployeeController() {
		employees = new HashMap<String, Employee>();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView model) {

		logger.info("home page");
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView saveEmployeePage(ModelAndView model) {
		model.addObject("employee", new Employee());

		model.setViewName("empSave");
		logger.info("Returning employee page");
		return model;
	}

	@RequestMapping(value = "/employeesave", method = RequestMethod.POST)
	public ModelAndView saveEmployeeAction(@ModelAttribute("employee") @Validated Employee employee,
			BindingResult bindingResult, ModelAndView model) {
		if (bindingResult.hasErrors()) {
			logger.info("Returning empSave.jsp page");
			model.setViewName("empSave");
			return model;
		}
		logger.info("Returning empSaveSuccess.jsp page");
		model.addObject("employee", employee);
		employees.put(employee.getEmail(), employee);
		model.setViewName("empSaveSuccess");
		return model;
	}
}