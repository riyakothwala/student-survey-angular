package edu.gmu.swe642;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {

	private StudentDAO dao = new StudentDAOImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getStudents() {

		try {
			return dao.getAllStudentIds();
		} catch (ClassNotFoundException cnfe) {
			return new ArrayList<String>();
		}

	}

	@GET
	@Path("{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentBean getStudent(@PathParam("studentId") String studentId) {

		try {
			return dao.getStudentById(studentId);
		} catch (ClassNotFoundException cnfe) {
			return null;
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public int insertStudent(StudentBean studentBean) {
		try {
			return dao.insertStudent(studentBean);
		} catch (ClassNotFoundException cnfe) {
			return -1;
		}
	}
}
