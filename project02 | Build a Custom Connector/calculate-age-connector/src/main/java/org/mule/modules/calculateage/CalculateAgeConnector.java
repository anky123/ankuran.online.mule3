package org.mule.modules.calculateage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import org.mule.modules.calculateage.config.ConnectorConfig;


/**
 * @Author : Ankur BHUYAN
 * @Website : https://ankuran.online/
 * 
 */
@Connector(name="calculate-age", friendlyName="CalculateAge")
public class CalculateAgeConnector {

    @Config
    ConnectorConfig config;

    /**
     * Custom processor
     *
     * @param Given Name to be used to generate a response message.
     * @return A greeting message
     */
    @Processor
    public String calculateAge(String yourName, String dateOfBirth) {
    	System.out.println(validateDate(dateOfBirth));
    		if(validateDate(dateOfBirth)) {
    			
    			String calucatedAge = extractAndCalculeteAge(dateOfBirth);
    			return config.getGreeting() + " " + yourName + ", " + config.getReply() + " " + calucatedAge ;
    		} else {
    			return config.getGreeting() + " " + yourName + ", your given date of birth format is wrong. Please provide in this format : yyyy/MM/dd." ;
    		}		
    }

    /**
     * Validate Date
     *
     * @param Date in string to be used to check for validate date format or not.
     * @return Boolean response
     */
    private static Boolean validateDate(String dateInString) {
 		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
 		try {
 			formatter.parse(dateInString);
 			return true;
 		} catch (ParseException e) {
 			return false;
 		}
    }
    
    /**
     * extractAndCalculeteAge
     *
     * @param Date in string to be used to extract the date, month and year and calculate the Age according to give information.
     * @return String calculated age details
     */
    private static String extractAndCalculeteAge(String dateInString) {
		 String str[] = dateInString.split("/");
		 int year = Integer.parseInt(str[0]);
		 int month = Integer.parseInt(str[1]);
		 int day = Integer.parseInt(str[2]);
		 Period diff = Period.between(LocalDate.of(year, month, day), LocalDate.now()); //difference between the dates is calculated
		 return diff.getYears() + " years, " + diff.getMonths() + " months, " + diff.getDays() + " days";
	 }
    
    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}