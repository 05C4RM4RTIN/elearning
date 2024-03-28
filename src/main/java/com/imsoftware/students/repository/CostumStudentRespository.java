package com.imsoftware.students.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.imsoftware.students.entity.Student;
import com.imsoftware.students.entity.Subject;
import com.imsoftware.students.model.ModaVO;
import com.imsoftware.students.model.StudentHaveVO;

public interface CostumStudentRespository extends JpaRepository<Subject, Integer> {
	
	
	@Query ( value = "SELECT SUM( HAVE) AS HAVE,NAME AS NAME FROM (\n" + 
			"SELECT CASE WHEN SUB_ID = ?1\n" + 
			"THEN 1\n" + 
			"ELSE 0\n" + 
			"END HAVE,\n" + 
			"NAME,\n" + 
			"ID\n" + 
			" FROM (\n" + 
			"SELECT S.ID ID,S.NAME NAME,SUB.ID SUB_ID FROM STUDENT S \n" + 
			"JOIN SUBJECT_STUDENT SS \n" + 
			"ON S.ID =SS.STUDENT_ID \n" + 
			"JOIN SUBJECT SUB\n" + 
			"ON SS.SUBJECT_ID = SUB.ID) )\n" + 
			"GROUP BY NAME", nativeQuery = true)
	public List<StudentHaveVO> modeByStudents(int idSubMode);
	
	@Query ( value = "SELECT MODE(SUB.ID ) ID FROM STUDENT S \n" + 
			"JOIN SUBJECT_STUDENT SS \n" + 
			"ON S.ID =SS.STUDENT_ID \n" + 
			"JOIN SUBJECT SUB\n" + 
			"ON SS.SUBJECT_ID = SUB.ID\n" + 
			"ORDER BY ID",nativeQuery = true)
	public int getSubjectMode();
	
	
	@Query ( value = "SELECT MODE(SUB.ID )  ID,MODE(SUB.NAME) NAME FROM STUDENT S\n" + 
			"JOIN SUBJECT_STUDENT SS \n" + 
			"ON S.ID =SS.STUDENT_ID \n" + 
			"JOIN SUBJECT SUB\n" + 
			"ON SS.SUBJECT_ID = SUB.ID\n" + 
			"ORDER BY ID",nativeQuery = true)
	public List<ModaVO> getSubjectModeDesc();

}
