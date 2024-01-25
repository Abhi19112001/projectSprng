package edu.cjc.main.service;
import java.util.List;

	import edu.cjc.main.model.Student;

	public interface StudentService {

		public void savestudentDetails(Student st);

		public List<Student> getAllStudent();

		public List<Student> searchStudentBybatchNumberandMode(String batchNumber, String batchMode);

		public Student getSingleStudent(int id);

		public void updateStudentFess(int studentid, float ammount);

		public void removeStudent(int sid);

		public void updateBatchNUmber(int studentid, String batchNumber); 
		
	}


