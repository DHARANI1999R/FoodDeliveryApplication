package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Admin;

public interface AdminService 
{
	Admin saveAdmin(Admin admin);
	Admin loginAdmin(Admin admin);
	List<Admin> getAllAdmins();
	Admin getAdminById(int adminId);
	Admin updateAdmin(Admin admin, int adminId);
	void deleteAdmin(int adminId);


}
