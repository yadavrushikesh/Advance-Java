package com.jspiders.springmvc.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvc.POJO.AdminPOJO;
import com.jspiders.springmvc.POJO.StudentPOJO;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/home")
	public String home(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		if(admin!=null) {
			return "Home";
		}
		map.addAttribute("msg","Session inactive.Login to Proceed Further!!");
		return "Login";
	}
	
	@GetMapping("/remove")
	public String remove(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		if (admin != null) {
		List<StudentPOJO> students = service.findAllStudents();
		//Success
		if (!students.isEmpty()) {
			map.addAttribute("students", students);
			return "Remove";
		}
		map.addAttribute("msg", "No data present..!");
		return "Remove";
	}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Remove student Controller
		@PostMapping("/remove")
		public String removeStudent(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,
									ModelMap map) {
			if (admin != null) {
			StudentPOJO pojo = service.removeStudent(id);
			List<StudentPOJO> students = service.findAllStudents();
			
			//Success flow
			if (pojo != null) {
				map.addAttribute("msg", "Data removed successfully..!");
				map.addAttribute("students", students);
				return "Remove";
			}
			//Failure flow
			map.addAttribute("msg", "Data does not exist..!");
			map.addAttribute("students", students);
			return "Remove";
		}
			map.addAttribute("msg", "Session inactive. Login to proceed..!");
			return "Login";
		}
	
		//Update page 
	@GetMapping("/update")
	public String update(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		if (admin != null) {
		List<StudentPOJO> students = service.findAllStudents();
		map.addAttribute("students", students);
		return "Update";
	}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	  // Update form 
	@PostMapping("/update")
	public String update(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,
			               ModelMap map) {
		if (admin != null) {
		StudentPOJO pojo = service.searchStudent(id);
		
		//Success Flow
		if (pojo != null) {
			map.addAttribute("student",pojo);
			return "Update";
		}
		//Failure Flow
		
		List<StudentPOJO> students = service.findAllStudents();
		map.addAttribute("students", students);
		map.addAttribute("msg", "Student data not found..!");
		return "Update";
		
	}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	
	//Update Student Form
	@PostMapping("/updateStudent")
	public String updateStudent(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam long contact,
			@RequestParam String address,
			ModelMap map) {
		if(admin != null) {
		StudentPOJO pojo = service.updateStudent(id, name, email, contact, address);
		
		//Success Flow
		if (pojo != null) {
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("msg", "Data updated successfully..!");
			map.addAttribute("students", students);
			return "Update";
		}
		List<StudentPOJO> students = service.findAllStudents();
		map.addAttribute("msg", "Data not updated..!");
		map.addAttribute("students", students);
		return "Update";
		
	}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	// Add student Page
	@GetMapping("/add")
	public String add(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		
		if(admin != null) {
		List<StudentPOJO> students = service.findAllStudents();
		if (!students.isEmpty()) {
			map.addAttribute("students", students);
			return "Add";
		}
		return "Add";
		}
		map.addAttribute("msg","Session inactive .Login to proceed!!");
		return "Login";
	}
	
	// Add student controller
	@PostMapping("/add")
	public String addStudent(@SessionAttribute(name = "login", required = false)AdminPOJO admin,
			                  @RequestParam String name,
			                  @RequestParam String email,
			                  @RequestParam long contact,
			                  @RequestParam String address,
			                 ModelMap map) {
		
		if(admin != null) {
		StudentPOJO pojo=service.addStudent(name,email,contact,address);
		
		          //Success
		if (pojo != null) {
			map.addAttribute("msg","Data inserted successfully!!!");
			
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("students",students);
			return "Add";
			
		}
		
		//Failure
		map.addAttribute("msg","Data not inserted..!");
		List<StudentPOJO> students = service.findAllStudents();
		if (!students.isEmpty()) {
			map.addAttribute("students", students);
		}
		return "Add";
		
		
	}
		map.addAttribute("msg","Session inactive .login to Proceed!!");
		return"Login";
	}
	
	
	@GetMapping("/search")
	public String search(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	@PostMapping("/search")
	public String searchStudent(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,
			               ModelMap map) {
		if(admin !=null) {
		StudentPOJO pojo = service.searchStudent(id);
		        //Success
		if (pojo != null) {
			map.addAttribute("student",pojo);
			map.addAttribute("msg","Student data found..!");
			return "Search";
		}
		       //Failure
		map.addAttribute("msg", "Student data not found..!");
		return "Search";
	}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
//	@GetMapping("/logout")
//	public String logout() {
//		return "Login";
//	}
		
	

}
