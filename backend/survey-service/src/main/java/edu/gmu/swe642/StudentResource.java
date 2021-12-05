package edu.gmu.swe642;

import java.util.List;

import edu.gmu.swe642.exception.StudentDataExistsException;
import edu.gmu.swe642.exception.StudentDataNotFoundException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The student resource that handles requests and sends back the appropriate
 * responses.
 * 
 * @author Riya & Andrea
 */
@Path("students")
public class StudentResource {

	private StudentDAO dao = new StudentDAOImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getStudents() {
		return dao.getAllStudentIds();
	}

	@GET
	@Path("{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentBean getStudent(@PathParam("studentId") String studentId) {

		StudentBean studentBean = dao.getStudentById(studentId);
		if (studentBean == null) {
			throw new StudentDataNotFoundException("Student data not found for id " + studentId);
		} else {
			return studentBean;
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public StudentBean insertStudent(StudentBean studentBean) {

		StudentBean existingStudentBean = dao.getStudentById(studentBean.getStudentId());
		if (existingStudentBean != null) {
			throw new StudentDataExistsException("Student data already exists for id " + studentBean.getStudentId());
		} else {
			return dao.insertStudent(studentBean);
		}
	}
}
