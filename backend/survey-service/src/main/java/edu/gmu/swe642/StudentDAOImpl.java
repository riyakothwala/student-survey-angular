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

import edu.gmu.swe642.exception.DatabaseException;
import edu.gmu.swe642.exception.GenericRuntimeException;
import edu.gmu.swe642.exception.SQLExecutionException;

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

		} catch (IOException e) {
			e.printStackTrace();
			throw new GenericRuntimeException("Trouble loading database credential file.");
		}
	}

	@Override
	public StudentBean insertStudent(StudentBean student) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			throw new DatabaseException("JDBC driver could not be loaded.");
		}

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

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLExecutionException("Trouble executing SQL query.");
		}
		return student;
	}

	@Override
	public List<String> getAllStudentIds() {
		List<String> studentIdList = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			throw new DatabaseException("JDBC driver could not be loaded.");
		}

		try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {

			// Retrieve all student records
			Statement s = connection.createStatement();
			s.executeQuery("select * from students");

			studentIdList = new ArrayList<String>();

			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				// Add records into data list
				studentIdList.add(rs.getString("StudentId"));
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLExecutionException("Trouble executing SQL query.");
		}

		return studentIdList;
	}

	@Override
	public StudentBean getStudentById(String studentId) {
		StudentBean studentBean = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			throw new DatabaseException("JDBC driver could not be loaded.");
		}

		try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {

			// Making results set scrollable in order to count number of records.
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from students WHERE STUDENTID = ? AND ROWNUM = 1", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setString(1, studentId);
			preparedStatement.executeQuery();

			ResultSet rs = preparedStatement.getResultSet();

			int rowCount = 0;
			if (rs.last()) {// make cursor to point to the last row in the ResultSet object
				rowCount = rs.getRow();
				// make cursor to point to the front of the ResultSet object, just before the
				// first row.
				rs.beforeFirst();
			}

			if (rowCount == 0) {
				return null;
			}

			// There shouldn't be more than one record as studentId is the primary key
			rs.next();

			// setting student bean from return
			studentBean = new StudentBean();
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

			preparedStatement.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLExecutionException("Trouble executing SQL query.");
		}

		return studentBean;
	}
}
