package com.imsoftware.students.api;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imsoftware.students.domain.StudentDTO;
import com.imsoftware.students.model.ModaVO;
import com.imsoftware.students.model.StudentHaveVO;
import com.imsoftware.students.service.IStudentService;

@RestController
public class StudentController {

	private final IStudentService studentService;

	public StudentController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/students")
	Collection<StudentDTO> all() {
		return studentService.findAll();
	}
	
	@GetMapping("/modaByStudents")
	List<StudentHaveVO> getModaByStudent() {
		return studentService.findAllAndShowIfHaveAPopularSubject();
	}
	
	@GetMapping("/getSubjectMode")
	List<ModaVO> getSubjectMode() {
		return studentService.getMode();
	}
}
