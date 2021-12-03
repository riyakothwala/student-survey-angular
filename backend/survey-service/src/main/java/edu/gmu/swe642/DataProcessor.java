package edu.gmu.swe642;

import java.util.Formatter;

/**
 * The data processor class to compute mean and standard deviation.
 * 
 * @author Riya & Andrea *
 */
public class DataProcessor {
	DataBean dataBean = new DataBean();

	public DataProcessor() {
	}

	public DataBean computeMeanAndDeviation(String[] inputNumbersString) {

		int[] inputNumbers = new int[inputNumbersString.length];

		for (int i = 0; i < inputNumbersString.length; i++) {
			// remove all white spaces between commas and numbers before converting to
			// number array
			inputNumbers[i] = Integer.parseInt(inputNumbersString[i].replaceAll("\\s+", ""));
		}

		int length = inputNumbers.length;
		double sum = 0.0;
		double standardDeviation = 0.0;

		for (double num : inputNumbers) {
			sum += num;
		}

		double mean = sum / length;

		this.dataBean.setMean(mean);

		for (double num : inputNumbers) {
			standardDeviation += Math.pow(num - mean, 2);
		}

		double deviation = Math.sqrt(standardDeviation / length);
		Formatter formatterStaDev = new Formatter();
		formatterStaDev.format("%.2f", deviation);

		this.dataBean.setStandardDev(formatterStaDev.toString());
		formatterStaDev.close();
		return this.dataBean;
	}

}
