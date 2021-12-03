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
	 * @throws ClassNotFoundException
	 */
	int insertStudent(StudentBean student) throws ClassNotFoundException;

	/**
	 * Get all student IDs.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	List<String> getAllStudentIds() throws ClassNotFoundException;

	/**
	 * Get student by ID.
	 * 
	 * @param studentId
	 * @return
	 * @throws ClassNotFoundException
	 */
	StudentBean getStudentById(String studentId) throws ClassNotFoundException;

}