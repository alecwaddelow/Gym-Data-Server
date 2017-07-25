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
	protected TripManager manager;
	protected ArrayList<TripDTO> entries;
	protected ArrayList<Date> listOfDates;
	protected ArrayList<Double> listOfLengthOfTrips;
	protected ArrayList<Double> listOfLengthOfCardio;
	protected ArrayList<Double> listOfLengthOfLifting;
	protected ArrayList<Double> listOfLengthOfSauna;
	protected ArrayList<Integer> listOfWeights;
	
	/**
	 * Constructor that pulls in data from DB
	 * Separates data into respective lists for analytics to be performed
	 * 
	 * @throws SQLServerException
	 * @throws SQLException
	 */
	public AnalyticsModel() throws SQLServerException, SQLException
	{
		this.entries = manager.getAllEntries();
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
	 * @return maxWeight
	 */
	public int findMaxWeight()
	{
		int maxWeight = Collections.max(this.listOfWeights);
		return maxWeight;
	}
	
	/**
	 * Finds minimum weight
	 * @return minWeight
	 */
	public int findMinWeight()
	{
		int minWeight = Collections.min(this.listOfWeights);
		return minWeight;
	}
	
	/**
	 * Finds average weight over the data set
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
}
