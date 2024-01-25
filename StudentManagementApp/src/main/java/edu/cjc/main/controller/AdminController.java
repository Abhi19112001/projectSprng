package edu.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.main.model.Student;
import edu.cjc.main.service.StudentService;

@Controller
public class AdminController {

	@Autowired
	StudentService ss;

	@RequestMapping("/")
	public String prelogin() {

		return "login";
	}

	@RequestMapping("/login")
	public String onlogin(@RequestParam String username, @RequestParam String password, Model m) {
		if (username.equals("admin") && password.equals("admin123")) {
			List<Student> list = ss.getAllStudent();
			m.addAttribute("data", list);
			return "adminscreen";

		} else {
			m.addAttribute("login_fail", "Enter Valid Login detail");
			return "login";
		}
	}

	@RequestMapping("/enroll_student")
	public String SaveStudent(@ModelAttribute Student s, Model m) {

		ss.savestudentDetails(s);
		List<Student> list = ss.getAllStudent();
		m.addAttribute("data", list);
		return "adminscreen";
	}

	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam String batchNumber,@RequestParam String batchMode,Model m) {
		List<Student> list=ss.searchStudentBybatchNumberandMode(batchNumber,batchMode);
		if(list.size()>0) {
			m.addAttribute("data", list);
		}
		else if(batchNumber.equals("#")) {
			List<Student> list1 = ss.getAllStudent();
			m.addAttribute("data", list1);
			m.addAttribute("message", "No batch number is selected");
		}
		else if(batchMode.equals("#")) {
			List<Student> list1 = ss.getAllStudent();
			m.addAttribute("data", list1);
			m.addAttribute("message", "NO batch Mode Silected");
		}
		else if(batchNumber.equals("#")&& batchMode.equals("#")) {
			List<Student> list1 = ss.getAllStudent();
			m.addAttribute("data", list1);
			m.addAttribute("message", "NO batch Mode and no batch no is Selected");
		}
		else {
			List<Student> list1 = ss.getAllStudent();
			m.addAttribute("data", list1);
			m.addAttribute("message", "No Record are available for the batch'"+batchNumber+"'and mode'"+batchMode+"'....!");
		}
		return "adminscreen";
		
	}
	@RequestMapping("/fees")
	public String onFees(@RequestParam int sid,Model m) {
		
		Student st=ss.getSingleStudent(sid);
		m.addAttribute("st", st);
		return "fees";
		
	}
	
	@RequestMapping("payfees")
	public String payFees(@RequestParam int studentid,@RequestParam float ammount,Model m) {
		ss.updateStudentFess(studentid,ammount);
		List<Student> students=ss.getAllStudent();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	@RequestMapping("/remove")
	public String removeStudent(@RequestParam int sid,Model m) {
		ss.removeStudent(sid);
		List<Student> students=ss.getAllStudent();
		m.addAttribute("data", students);
		return "adminscreen";
	}

	@RequestMapping("/batch")
	public String onbatch(@RequestParam int sid,Model m) {
	Student st=ss.getSingleStudent(sid);
	m.addAttribute("st", st);
	return "Batch";
	}
	
	@RequestMapping("shiftBatch")
	public String ShiftBatch(@RequestParam int studentid,@RequestParam String batchNumber,Model m) {
		ss.updateBatchNUmber(studentid,batchNumber);
		List<Student> students=ss.getAllStudent();
		m.addAttribute("data", students);
		return "adminscreen";
	}
}
