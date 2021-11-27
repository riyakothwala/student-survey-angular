package edu.gmu.swe642;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SurveyServlet that is front contoller to the
 * app.
 * 
 * @author Riya & Andrea
 */
public class SurveyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StudentDAO studentDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		studentDao = new StudentDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentId = request.getParameter("studentid").trim();
		String nextPage = null;
		try {
			StudentBean studentBean = studentDao.getStudentById(studentId);

			if (studentBean.getStudentId() != null) {
				request.setAttribute("studentid", studentId);
				request.setAttribute("username", studentBean.getUserName());
				request.setAttribute("address", studentBean.getAddress());
				request.setAttribute("state", studentBean.getStates());
				request.setAttribute("city", studentBean.getCity());

				request.setAttribute("zip", studentBean.getZip());
				request.setAttribute("telephone", studentBean.getTelephone());
				request.setAttribute("email", studentBean.getEmail());
				request.setAttribute("url", studentBean.getUrl());
				request.setAttribute("campuslikes", studentBean.getcampuslikes());
				request.setAttribute("interested", studentBean.getInterested());
				request.setAttribute("notes", studentBean.getnotes());
				request.setAttribute("gradmonth", studentBean.getGradmonth());
				request.setAttribute("gradyear", studentBean.getgradyear());
				request.setAttribute("recommend", studentBean.getRecommend());
				request.setAttribute("data", studentBean.getData());
				request.setAttribute("surveydate", studentBean.getSurveydate());

				nextPage = "Student.jsp";
			} else {
				nextPage = "NoSuchStudent.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO: handle all exceptions
			e.printStackTrace();
		}
		// Now, forward request to next JSP page

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentBean studentBean = null;
		String nextPage = null;
		try {
			String studentid = request.getParameter("studentid").trim();
			studentBean = studentDao.getStudentById(studentid);
			if (studentBean.getStudentId() != null) {
				nextPage = "StudentIdAlreadyExist.jsp";
			} else {
				String username = request.getParameter("username").trim();
				String address = request.getParameter("address").trim();
				String city = request.getParameter("city").trim();
				String states = request.getParameter("state").trim();

				String zip = request.getParameter("zip").trim();
				String telephone = request.getParameter("telephone").trim();
				String email = request.getParameter("email").trim();
				String url = request.getParameter("url").trim();
				String[] campuslikes = request.getParameterValues("campuslikes");
				// String campuslikes = request.getParameter("campuslikes").trim();
				String interested = request.getParameter("interested").trim();
				String notes = request.getParameter("notes").trim();
				String gradmonth = request.getParameter("gradmonth").trim();
				String gradyear = request.getParameter("gradyear").trim();
				String recommend = request.getParameter("recommend").trim();
				String data = request.getParameter("data").trim();
				String surveydate = request.getParameter("surveydate").trim();

				String[] inputNumbers = request.getParameter("data").split(",");

				studentBean.setStudentId(studentid);
				studentBean.setUserName(username);
				studentBean.setAddress(address);
				studentBean.setCity(city);
				studentBean.setStates(states);

				studentBean.setZip(zip);
				studentBean.setTelephone(telephone);
				studentBean.setEmail(email);
				studentBean.setUrl(url);
				studentBean.setcampuslikes(String.join(", ", campuslikes));
				studentBean.setInterested(interested);
				studentBean.setnotes(notes);
				studentBean.setGradmonth(gradmonth);
				studentBean.setGradyear(gradyear);
				studentBean.setRecommend(recommend);
				studentBean.setData(data);
				studentBean.setSurveydate(surveydate);

				// 1) uses the studentDAO to store the student data to DB
				studentDao.insertStudent(studentBean);

				// 2)calls a method on DataProcessor to compute mean and standard deviation

				DataProcessor processor = new DataProcessor();
				DataBean dataBean = processor.computeMeanAndDeviation(inputNumbers);

				// assign calculated mean value from processor.
				Double mean = dataBean.getMean();
				String standardDev = dataBean.getStandardDev();

				// Retrieving student data from database
				List datalist = studentDao.getAllStudentIds();

				// Set student data, mean, and standard deviation in the request
				request.setAttribute("data", datalist);
				request.setAttribute("mean", mean);
				request.setAttribute("standardDev", standardDev);

				// Forward request to appropriate JSP page
				if (mean < 90) {
					// Set next page to be simple ack JSP
					nextPage = "SimpleAcknowledgement.jsp";
				} else {
					// Set next page to be winner ack JSP
					nextPage = "WinnerAcknowledgement.jsp";
				}

			}
			// Now, forward request to next JSP page
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle all exceptions
			e.printStackTrace();
		}
	}

}
