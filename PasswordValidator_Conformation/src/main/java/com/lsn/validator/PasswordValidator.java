package com.lsn.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lsn.domain.Customer;

public class PasswordValidator implements Validator {

	public boolean supports(Class<?> paramClass) {

		return Customer.class.equals(paramClass);

	}

	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordconf", "valid.passwordConf");

		Customer password = (Customer) obj;

		if (!password.getPassword().equals(password.getPasswordconf())) {

			errors.rejectValue("passwordconf", "valid.passwordConfDiff");

		}

	}

}
