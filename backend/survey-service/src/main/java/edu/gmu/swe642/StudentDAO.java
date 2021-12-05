package edu.gmu.swe642;

import java.util.List;

/**
 * The DAO interface to access the database and perform the operations.
 * 
 * @author Riya & Andrea
 */
public interface StudentDAO {

	/**
	 * Inserts student survey data into table.
	 * 
	 * @param student
	 * @return
	 */
	StudentBean insertStudent(StudentBean student);

	/**
	 * Get all student IDs.
	 * 
	 * @return
	 */
	List<String> getAllStudentIds();

	/**
	 * Get student by ID.
	 * 
	 * @param studentId
	 * @return
	 */
	StudentBean getStudentById(String studentId);

}