package edu.cjc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cjc.main.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findAllByBatchNumberAndBatchMode(String batchNumber,String batchMode);
}
