package edu.gmu.swe642;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * The DAO implementation to access the database and perform the operations.
 * 
 * @author Riya & Andrea
 */
public class StudentDAOImpl implements StudentDAO {

	private static String URL;
	private static String USER_NAME;
	private static String PASSWORD;

	static {
		try (InputStream input = StudentDAOImpl.class.getClassLoader().getResourceAsStream("db-config.properties")) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			URL = prop.getProperty("db.url");
			USER_NAME = prop.getProperty("db.user");
			PASSWORD = prop.getProperty("db.password");

		} catch (IOException ex) {
			// TODO: handle scenario when failed to read file
			ex.printStackTrace();
		}
	}

	@Override
	public int insertStudent(StudentBean student) throws ClassNotFoundException {
		int result = 0;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);) {

			// Insert student data into database
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into students (STUDENTID, USERNAME, ADDRESS, CITY, STATES, ZIP, TELEPHONE, EMAIL, URL, CAMPUSLIKES, INTERESTED, NOTES, GRADMONTH, GRADYEAR, RECOMMEND, DATA, SURVEYDATE) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, student.getStudentId());
			preparedStatement.setString(2, student.getUserName());
			preparedStatement.setString(3, student.getAddress());
			preparedStatement.setString(4, student.getCity());
			preparedStatement.setString(5, student.getStates());

			preparedStatement.setString(6, student.getZip());
			preparedStatement.setString(7, student.getTelephone());
			preparedStatement.setString(8, student.getEmail());
			preparedStatement.setString(9, student.getUrl());
			preparedStatement.setString(10, student.getcampuslikes());
			preparedStatement.setString(11, student.getInterested());
			preparedStatement.setString(12, student.getnotes());
			preparedStatement.setString(13, student.getGradmonth());
			preparedStatement.setString(14, student.getgradyear());
			preparedStatement.setString(15, student.getRecommend());
			preparedStatement.setString(16, student.getData());
			preparedStatement.setString(17, student.getSurveydate());

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle sql exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<String> getAllStudentIds() throws ClassNotFoundException {
		List<String> studentIdList = new ArrayList<String>();

		Class.forName("oracle.jdbc.driver.OracleDriver");

		try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {

			// Retrieve all student records
			Statement s = connection.createStatement();
			s.executeQuery("select * from students");
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				// Add records into data list
				studentIdList.add(rs.getString("StudentId"));
			}
			rs.close();

			s.close();
		} catch (SQLException e) {
			// TODO: handle sql exception
			e.printStackTrace();
		}

		return studentIdList;
	}

	@Override
	public StudentBean getStudentById(String studentId) throws ClassNotFoundException {
		StudentBean studentBean = new StudentBean();

		Class.forName("oracle.jdbc.driver.OracleDriver");

		try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {

			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from students WHERE STUDENTID = ? AND ROWNUM = 1");
			preparedStatement.setString(1, studentId);
			preparedStatement.executeQuery();

			ResultSet rs = preparedStatement.getResultSet();
			while (rs.next()) {
				// setting student bean from return
				studentBean.setStudentId(studentId);
				studentBean.setUserName(rs.getString("username"));
				studentBean.setAddress(rs.getString("address"));
				studentBean.setCity(rs.getString("city"));
				studentBean.setStates(rs.getString("states"));

				studentBean.setZip(rs.getString("zip"));
				studentBean.setTelephone(rs.getString("telephone"));
				studentBean.setEmail(rs.getString("email"));
				studentBean.setUrl(rs.getString("url"));
				studentBean.setcampuslikes(rs.getString("campuslikes"));
				studentBean.setInterested(rs.getString("interested"));
				studentBean.setnotes(rs.getString("notes"));
				studentBean.setGradmonth(rs.getString("gradmonth"));
				studentBean.setGradyear(rs.getString("gradyear"));
				studentBean.setRecommend(rs.getString("recommend"));
				studentBean.setData(rs.getString("data"));
				studentBean.setSurveydate(rs.getString("surveydate"));

			}
			preparedStatement.close();
			rs.close();

		} catch (SQLException e) {
			// TODO: handle sql exception
			e.printStackTrace();
		}

		return studentBean;
	}
}
