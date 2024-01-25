package edu.cjc.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.main.model.Student;
import edu.cjc.main.repository.StudentRepository;
import edu.cjc.main.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository sr;

	@Override
	public void savestudentDetails(Student st) {
		sr.save(st);

	}

	@Override
	public List<Student> getAllStudent() {

		return sr.findAll();

	}

	@Override
	public List<Student> searchStudentBybatchNumberandMode(String batchNumber, String batchMode) {
		List<Student> result=sr.findAllByBatchNumberAndBatchMode(batchNumber, batchMode);
		return result;
	}

	@Override
	public Student getSingleStudent(int id) {
		Optional<Student> opStudent=sr.findById(id);
		
		return opStudent.get();
	}

	@Override
	public void updateStudentFess(int studentid, float ammount) {
		Optional<Student> opStudent=sr.findById(studentid);
		Student st=opStudent.get();
		st.setFeesPaid(st.getFeesPaid()+ammount);
		sr.save(st);
		
		
	}

	@Override
	public void removeStudent(int sid) {
		sr.deleteById(sid);
		
	}

	@Override
	public void updateBatchNUmber(int studentid, String batchNumber) {
		Optional<Student> opStudent=sr.findById(studentid);
		Student st=opStudent.get();
		st.setBatchNumber(batchNumber);
		sr.save(st);
	}

	


}
