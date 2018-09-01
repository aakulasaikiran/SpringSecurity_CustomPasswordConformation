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
		if (password.getName().equals("")) {
			errors.rejectValue("name", "valid.name");

		}else if (password.getName().length()<=2 || password.getName().length()>=25) {
			errors.rejectValue("name", "valid.namelength");
		}
		if (password.getId()==0||password.getId()<=-1) {
			errors.rejectValue("id", "valid.id");

		}
		
		if (password.getRole().equals("")) {
			errors.rejectValue("role", "valid.role");

		}
		if (!password.getPassword().equals(password.getPasswordconf())) {

			errors.rejectValue("passwordconf", "valid.passwordConfDiff");

		}

	}

}
