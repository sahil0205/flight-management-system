package com.cg.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int userId;
	@NotNull
	@Size(min = 1, message = "User Type should not be empty")
	@Column(name = "Type")
	private String userType;
	@NotNull
	@Size(min = 1, message= "User Name should not be empty")
	@Column(name = "Name")
	private String userName;
	@NotNull
	@Size(min = 1, message = "Password should not be empty")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password should contain minimum 8 characters, atleast one digit, uppecase, lower case and special character")
	@Column(name = "Password")
	private String password;
	@NotNull
	@Size(min = 1, message = "Email should not be empty")
	@Email(message = "Email Id should be valid")
	@Column(name = "Email")
	private String email;
	@NotNull
	@Size(min = 1, message = "Mobile Number should not be empty")
	@Pattern(regexp = "^\\d{10}$", message = "Enter valid mobile number")
	@Column(name = "Mobile")
	private String mobileNumber;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public User() {
		super();
	}

	public User(@NotNull(message = "User Type should not be empty") String userType,
			@NotNull(message = "User Name should not be empty") String userName,
			@NotNull(message = "Password should not be empty") String password,
			@NotNull(message = "Email should not be empty") String email,
			@NotNull(message = "Mobile Number should not be empty") String mobileNumber) {
		super();
		this.userType = userType;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public User(int userId, @NotNull(message = "User Type should not be empty") String userType,
			@NotNull(message = "User Name should not be empty") String userName,
			@NotNull(message = "Password should not be empty") String password,
			@NotNull(message = "Email should not be empty") String email,
			@NotNull(message = "Mobile Number should not be empty") String mobileNumber) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
}
