 package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin_table")
public class Admin 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admin_id")
	private int adminId;
	
	@Column(name="user_name")
	@NotEmpty
	@Size(min=6 , message="Username must contain atleast 6 characters")
	public String adminUserName;
	
	@Column(name="password")
	@NotEmpty
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String adminPassword;
	
	@Column(name="contact_no")
	@NotEmpty
	@Size(min=5 , message="ContactNo must contain atleast 5 characters")
	public String adminContactNo;
	
	@Column(name="email_id",unique=true)
	@NotEmpty
	@Email(message="Email  is not valid!")
	public String adminEmailId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminContactNo() {
		return adminContactNo;
	}

	public void setAdminContactNo(String adminContactNo) {
		this.adminContactNo = adminContactNo;
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	
	
	

}
