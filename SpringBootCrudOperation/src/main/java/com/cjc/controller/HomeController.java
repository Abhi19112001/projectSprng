package com.cjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.model.Student;
import com.cjc.service.HomeService;

@Controller
public class HomeController {

	
	@Autowired
	HomeService hs;

	@RequestMapping("/")
	public String prelogin()
	{
		return "login";
	}
	
	@RequestMapping("/reg")
	public String preRegister()
	{
		return "register";
	}
	
	@RequestMapping("/register")
	public String regData(@ModelAttribute Student s)
	{
		hs.saveData(s);
		return "login";
	}
	
	@RequestMapping("/log")
	public String loginCheck(@RequestParam("uname") String un,@RequestParam("password") String ps,Model m )
	{
		
		Student s=hs.loginCheck(un,ps);
		if(s!=null) {
List<Student> list=hs.DisplayAllData();
			
			m.addAttribute("data", list);
			return "success";
		}else {
			m.addAttribute("Data", "Username or password Wrong");
			return "login";
		}
	}
	@RequestMapping("/delete")
	public String deletedata(@ModelAttribute Student s,Model m) {
		hs.deletedata(s);

		Iterable<Student> list=hs.DisplayAllData();
		
		m.addAttribute("data", list);
		return "success";
	}
	@RequestMapping("/edit")
	public String editdata(@RequestParam("uid")int uid,Model m) {
		Student s=hs.editdata(uid);
		m.addAttribute("data", s);
		
		
		return "edit";
		
	}
	@RequestMapping("/updatestu")
	public String updatedata(@ModelAttribute Student s,Model m) { 
		hs.saveData(s);

		Iterable<Student> list=hs.DisplayAllData();
		
		m.addAttribute("data", list);
		return "success";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "login";
	}
}
