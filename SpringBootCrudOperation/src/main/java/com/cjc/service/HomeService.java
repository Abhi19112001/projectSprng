package com.cjc.service;

import java.util.List;

import com.cjc.model.Student;

public interface HomeService {

	public void saveData(Student s);
	public Student loginCheck(String un,String ps);
	public List<Student> DisplayAllData();
	public void deletedata(Student s);
	public Student editdata(int uid);
}
