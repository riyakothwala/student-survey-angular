package edu.gmu.swe642;

/**
 * The bean class to store derived mean and standard deviation.
 * 
 * @author Riya & Andrea
 */
public class DataBean {
	private Double mean;
	private String standardDev;

	public Double getMean() {
		return mean;
	}

	public void setMean(Double mean) {
		this.mean = mean;
	}

	public String getStandardDev() {
		return standardDev;
	}

	public void setStandardDev(String standardDev) {
		this.standardDev = standardDev;
	}
}
