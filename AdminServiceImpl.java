package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;

		
		@Override
		public Admin saveAdmin(Admin admin) {
			System.out.println("admin register service"+admin);

			return adminRepository.save(admin);
		}

		@Override
		public Admin loginAdmin(Admin admin) 
		{
			return this.adminRepository.findByAdminEmailIdAndAdminPassword(admin.adminEmailId, admin.adminPassword).orElseThrow(()->new ResourceNotFoundException("Admin ", "EmaildId",admin.adminEmailId+"and password "+admin.adminPassword));
			
		}

		@Override
		public List<Admin> getAllAdmins() {
			// TODO Auto-generated method stub
			return adminRepository.findAll();
			
		}

		@Override
		public Admin getAdminById(int adminId) {
			// TODO Auto-generated method stub
			return adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
		}

		@Override
		public Admin updateAdmin(Admin admin, int adminId) {
			// TODO Auto-generated method stub
			Admin existingUser = adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
			
			
			existingUser.setAdminEmailId(admin.getAdminEmailId());
			existingUser.setAdminPassword(admin.getAdminPassword());
			existingUser.setAdminUserName(admin.getAdminUserName());
			existingUser.setAdminContactNo(admin.getAdminContactNo());
		
			
			adminRepository.save(existingUser);
			
			return existingUser;
		}

		@Override
		public void deleteAdmin(int adminId) {
			// TODO Auto-generated method stub
			adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
			adminRepository.deleteById(adminId);
			
		}


}
