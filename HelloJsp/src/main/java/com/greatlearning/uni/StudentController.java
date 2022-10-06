package com.greatlearning.uni;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.uni.model.Student;
import com.greatlearning.uni.service.*;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService uniService;

	@RequestMapping("/list")
	public String getAllStudents(Model theModel) {
		List<Student> res = uniService.getAllStudents();
		theModel.addAttribute("studentModel", res);
		return "studentlist";
	}

	@RequestMapping("/add")
	public String addStudent(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student", student);
		return "savestudent";
	}

	@RequestMapping("/update")
	public String updateStudent(@RequestParam("id") int id, Model theModel) {
		Student student = uniService.getStudentById(id);
		theModel.addAttribute("student", student);
		return "savestudent";
	}

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id) {
		Student student = uniService.delete(id);
		System.out.println("Deleted Student Id" + student.getId());
		return "redirect:/students/list";
	}

	@PostMapping("/save")
	public String savestudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		Student student;
		if (id != 0) {
			student = uniService.getStudentById(id);
		} else {
			student = new Student(name,  department,  country);
		}
		student.setName(name);
		student.setDepartment(department);
		student.setCountry(country);
		System.out.println(student.toString());
		uniService.save(student);
		return "redirect:/students/list";
	}
}
