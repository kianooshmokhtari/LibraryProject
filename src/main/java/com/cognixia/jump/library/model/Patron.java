package com.cognixia.jump.library.model;

public class Patron {
	
	private String id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private boolean accountFrozen;
	public Patron(String id, String firstName, String lastName, String userName, String password
			) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.accountFrozen = false;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public boolean isAccountFrozen() {
		return accountFrozen;
	}
	public void setAccountFrozen(boolean accountFrozen) {
		this.accountFrozen = accountFrozen;
	}

}
