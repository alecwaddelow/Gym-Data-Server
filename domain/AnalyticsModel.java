package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 * @author Alec Waddelow
 *
 * Performs Logic to compute analytics for the UI
 */
public class AnalyticsModel 
{
	protected TripManager manager = new TripManager();
	protected ArrayList<TripDTO> entries;
	protected ArrayList<Date> listOfDates = new ArrayList<Date>();
	protected ArrayList<Double> listOfLengthOfTrips= new ArrayList<Double>();
	protected ArrayList<Double> listOfLengthOfCardio= new ArrayList<Double>();
	protected ArrayList<Double> listOfLengthOfLifting= new ArrayList<Double>();
	protected ArrayList<Double> listOfLengthOfSauna= new ArrayList<Double>();
	protected ArrayList<Integer> listOfWeights= new ArrayList<Integer>();
	
	/**
	 * Constructor that pulls in data from DB
	 * Separates data into respective lists for analytics to be performed
	 * 
	 * @throws SQLServerException
	 * @throws SQLException
	 */
	public AnalyticsModel()
	{
		try {
			this.entries = manager.getAllEntries();
		} catch (SQLServerException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(TripDTO entry : entries)
		{
			listOfDates.add(entry.getDate());
			listOfLengthOfTrips.add(entry.getLengthOfTrip());
			listOfLengthOfCardio.add(entry.getLengthOfCardio());
			listOfLengthOfLifting.add(entry.getLengthOfLifting());
			listOfLengthOfSauna.add(entry.getLengthOfSauna());
			listOfWeights.add(entry.getWeight());
		}
	}
	
	/**
	 * Finds maximum weight 
	 * 
	 * @return maxWeight
	 */
	public int findMaxWeight()
	{
		int maxWeight = Collections.max(this.listOfWeights);
		return maxWeight;
	}
	
	/**
	 * Finds minimum weight
	 * 
	 * @return minWeight
	 */
	public int findMinWeight()
	{
		int minWeight = Collections.min(this.listOfWeights);
		return minWeight;
	}
	
	/**
	 * Finds average weight over the data set
	 * 
	 * @return average
	 */
	public double findAverageWeight()
	{
		double sum = 0;
		double average = 0;
		for(Integer value : listOfWeights)
		{
			sum += value;
		}
		average = sum / listOfWeights.size();
		return average;
	}
	
	/**
	 * Finds average length of trip to gym
	 * 
	 * @return average
	 */
	public double findAverageLengthOfTrip()
	{
		double sum = 0;
		double average = 0;
		
		for(Double value : listOfLengthOfTrips)
		{
			sum += value;
		}
		average = sum / listOfLengthOfTrips.size();
		return average;
	}
	
	/**
	 * Finds shortest trip to the gym
	 * 
	 * @return min
	 */
	public double findMinLengthOfTrip()
	{
		double min = Collections.min(listOfLengthOfTrips);
		return min;
	}
	
	/**
	 * Finds the longest trip to the gym
	 * 
	 * @return max
	 */
	public double findMaxLengthOfTrip()
	{
		double max = Collections.max(listOfLengthOfTrips);
		return max;
	}
	
	/**
	 * Finds average length of cardio workout
	 * 
	 * @return average
	 */
	public double findAverageLengthOfCardio()
	{
		double sum = 0;
		double average = 0;
		for(Double value : listOfLengthOfCardio)
		{
			sum += value;
		}
		average = sum / listOfLengthOfCardio.size();
		return average;
	}
	
	
	public double findMaxLengthInSauna()
	{
		double max = Collections.max(listOfLengthOfSauna);
		return max;
	}
	
}
