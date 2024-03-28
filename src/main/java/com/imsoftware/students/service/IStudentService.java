package com.imsoftware.students.service;

import java.util.Collection;
import java.util.List;

import com.imsoftware.students.domain.StudentDTO;
import com.imsoftware.students.model.StudentHaveVO;

public interface IStudentService {
	Collection<StudentDTO> findAll();

	List<StudentHaveVO> findAllAndShowIfHaveAPopularSubject();

}
