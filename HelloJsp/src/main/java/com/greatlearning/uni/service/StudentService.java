package com.greatlearning.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.uni.model.Student;


@Service
public interface StudentService {
	public List<Student> getAllStudents();
	public void save(Student student);
	public Student delete(int id);
	public Student getStudentById(int id);


}
