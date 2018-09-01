package com.lsn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Service
public class CustomerServiceImpl implements CustomerService {

	/*@Autowired

	@Qualifier("passwordValidator")

	private Validator validator;

	@InitBinder

	private void initBinder(WebDataBinder binder) {

		binder.setValidator(validator);

	}*/

	public void passwordConformation(String password, String passwordconf) {

	}

}
