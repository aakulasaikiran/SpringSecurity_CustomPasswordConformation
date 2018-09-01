package com.lsn.domain;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class Employee {
	
	@NotNull(message = "name should NotNull")
	@NotEmpty(message = "Name not Empty sai")
	private String name;

	@NotNull(message = "email should NotNull")
	@NotEmpty(message = "email should NotEmpty sai")
	@Email(message = "Email should be valid form by sai")
	private String email;

	@Min(value = 18, message = "please enter age greter then 18 years")
	@NotNull(message = "Age should not NULL")
	private Integer age;
	
	@NotNull(message="Dateof birth should not Emplty")
	@Past
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	
	private Date birthday;

	// @NumberFormat
	@NotNull(message = "phonenumber should NotNull")
	@NotEmpty
	@Size(min = 10, max = 11, message = "Phonenumber Must Contain 10 digits")
	private String phone;

	 @NotNull(message = "gender should NotNull")
	// @NotEmpty
	private Gender gender;

	public enum Gender {
		MALE, FEMALE
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
