package com.cjc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.model.Student;
import com.cjc.repository.HomeRepository;
import com.cjc.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	
	@Autowired
	HomeRepository hr;
	
	
	@Override
	public void saveData(Student s) 
	{
	hr.save(s);
		
	}

	@Override
	public Student loginCheck(String un, String ps) {
		
		return hr.findAllByUnameAndPassword(un, ps);
	}

	@Override
	public List<Student> DisplayAllData() 
	{
		
		return hr.findAll();
	}

	@Override
	public void deletedata(Student s) {
		hr.delete(s);
		
	}

	@Override
	public Student editdata(int uid) {
		
		return hr.findAllByUid(uid) ;
	}

	
	

}
