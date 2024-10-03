package com.ns.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ns.entities.Admin;
import com.ns.entities.User;
import com.ns.service.AdminServiceImp;
import com.ns.service.UserServiceImp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private UserServiceImp service;
	@Autowired
	private AdminServiceImp adminService;
	
	@GetMapping("/userlogin")
	public String loginPage(Model m) {
		m.addAttribute("loguser",new User());
		return "login";
	}
	
	@PostMapping("/logform")
	public String getLogin(@ModelAttribute("loguser") User u,Model m) {
		User validUser=this.service.getLogin(u.getEmail(), u.getPassword());
		if(validUser!=null) {
			m.addAttribute("uname",validUser.getName());
			m.addAttribute("passion",validUser.getPassion());
			m.addAttribute("address",validUser.getAddress());
			m.addAttribute("weddingDate",validUser.getWeddingDate());
			m.addAttribute("email",validUser.getEmail());
			m.addAttribute("mob",validUser.getMobNo());
			return "profile";
		}else {
			m.addAttribute("msg","UserName Or Password Incorrect..");
			return "login";
		}
		
	}
	
	@GetMapping("/register")
	public String registerPage(Model m) {
		m.addAttribute("user",new User());
		return "register";
	}
	
	@PostMapping("/regform")
	public String getRegister(@ModelAttribute("user") User cu,Model m) {
		
		if(this.service.insertUser(cu)) {
			
			m.addAttribute("smsg","Insert User Successfully ...");
			return "register";
		}else {
			m.addAttribute("rmsg","SomeThing went wrong ..");
			return "register";
		}
		
	}
	
	
	@GetMapping("/userlogout")
	public String getLogOut(HttpServletRequest req,Model m) {
		HttpSession ses=req.getSession(false);
		if(ses!=null) {
			ses.invalidate();
		}
		m.addAttribute("logmsg","Successfully Log Out ..");
		return "redirect:/userlogin";
	}
	
	
	
	@GetMapping("/adminlogin")
	public String adminLoginPage(Model m) {
		m.addAttribute("admin",new Admin());
		return "admin-login";
	}
	
	@PostMapping("/adminlogform")
	public String getAdminLogin(@ModelAttribute("admin") Admin admin,Model m) {
		Admin validUser=this.adminService.getAdminLogin(admin.getId(), admin.getEmail());
		if(validUser!=null) {
			
			List<User> users=this.service.getAllData();
			m.addAttribute("users",users);
			m.addAttribute("deluser",users);
			
			m.addAttribute("uname",validUser.getAdminName());
			
			
			return "admin-dashboard";
		}else {
			m.addAttribute("msg","UserName Or Password Incorrect..");
			return "admin-login";
		}
		
	}
	
	@GetMapping("/userdelete")
	public String deleteRecord(@ModelAttribute("user1")User user) {
		Boolean f=this.service.deleteUser(user);
		if(f) {
			return "register";
		}else {
		return "redirect:/userlogin";
		}
	}

}
