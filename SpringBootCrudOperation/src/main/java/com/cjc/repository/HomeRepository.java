package com.cjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.Student;

@Repository
public interface HomeRepository extends JpaRepository<Student, Integer> {

	
	public Student findAllByUnameAndPassword(String un,String ps);
	public Student findAllByUid(int uid);
	
}
