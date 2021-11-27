package edu.gmu.swe642;

/**
 * The bean class to store survey form data.
 * 
 * @author Riya & Andrea
 */
public class StudentBean {
	private String StudentId;
	private String UserName;
	private String Address;
	private String City;
	private String States;

	private String zip;
	private String telephone;
	private String email;
	private String url;
	private String campuslikes;
	private String interested;
	private String notes;
	private String gradmonth;
	private String gradyear;
	private String recommend;
	private String data;
	private String surveydate;

	public String getStudentId() {
		return StudentId;
	}

	public void setStudentId(String studentId) {
		this.StudentId = studentId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public String getStates() {
		return States;
	}

	public void setStates(String states) {
		this.States = states;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getcampuslikes() {
		return campuslikes;
	}

	public void setcampuslikes(String campuslikes) {
		this.campuslikes = campuslikes;
	}

	public String getInterested() {
		return interested;
	}

	public void setInterested(String interested) {
		this.interested = interested;
	}

	public String getnotes() {
		return notes;
	}

	public void setnotes(String notes) {
		this.notes = notes;
	}

	public String getGradmonth() {
		return gradmonth;
	}

	public void setGradmonth(String gradmonth) {
		this.gradmonth = gradmonth;
	}

	public String getgradyear() {
		return gradyear;
	}

	public void setGradyear(String gradyear) {
		this.gradyear = gradyear;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSurveydate() {
		return surveydate;
	}

	public void setSurveydate(String surveydate) {
		this.surveydate = surveydate;
	}
}
