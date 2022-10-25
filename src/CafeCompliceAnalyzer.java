
/*
 * Oscar Primitivo
 * CS 160 Spring 2022
 * Project 1: CAFE Compliance Analyzer
 * 
 * Description. The purpose of this program is to make sure that the cars that are 
 * being manufactured by PFW CS Motors are meeting the new 2011 CAFE regulations by taking 
 * PFW's fleet average fuel economy and comparing it to category targets fuel economy of each 
 * vehicle and PFW's actual production levels of them. 
 * 
 */

import java.util.Scanner;
import java.lang.Math;
public class CafeCompliceAnalyzer {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);	

		System.out.println("Welcome to the 2011 CAFE Compliance Analyzer for CS Motors.");

		System.out.println("Enter vehicle footprint:");
		double footprint = userInput.nextDouble();

		System.out.println("Enter model name for model 1:");
		String v1Name = userInput.next();

		System.out.println("Enter production amount for model 1:");
		int v1Production = userInput.nextInt();

		System.out.println("Enter mpg rating for model 1:");
		double v1Mpg = userInput.nextDouble();

		System.out.println("Enter model name for model 2:");
		String v2Name = userInput.next();

		System.out.println("Enter production amount for model 2:");
		int v2Production = userInput.nextInt();

		System.out.println("Enter mpg rating for model 2:");
		double v2Mpg = userInput.nextDouble();

		System.out.println("Enter model name for model 3:");
		String v3Name = userInput.next();

		System.out.println("Enter production amount for model 3:");
		int v3Production = userInput.nextInt();

		System.out.println("Enter mpg rating for model 3:");
		double v3Mpg = userInput.nextDouble();

		/*Below is a list of variables (a-d, and x) which all hold a specific value used to 
		 * calculate the target fuel economy.
		 */
		
		double a = 30.42; 	//The a variable holds the maximum fuel economy 
		double b = 21.79;	//The b variable holds the minimum fuel economy
		double c = 47.74;	//The c variable holds the vehicle footprint of the fuel economy target is midway between a and b ft^2
		double d = 4.65;	//The d variable holds the rate at which the value targets decline from largest to smallest value
			
		double x = footprint;	//the x variable is the footprint of the vehicle model, ft^2


		
		double targetFuelEconomy = 1/(1/a+(1/b-1/a)*Math.exp((x-c)/d)/(1+Math.exp((x-c)/d)));


		System.out.println("2011 CAFE Compliance Analysis Report for CS Motors");
		System.out.println("--------------------------------------------------");

		System.out.println("Vehicle footprint:" +footprint+ " sq.ft.");
		System.out.println("Target fuel economy: "+targetFuelEconomy + " mpg.\n");


		System.out.println("Model\t\tProduction\tMPG");
		System.out.println("-----\t\t----------\t---");

		System.out.println(v1Name+"\t\t"+v1Production+"\t\t"+v1Mpg+"\n");
		System.out.println(v2Name+"\t\t"+v2Production+"\t\t"+v2Mpg+"\n");
		System.out.println(v3Name+"\t\t"+v3Production+"\t\t"+v3Mpg+"\n");

		//Formula used to calculate the Fleet fuel economy
		
		double totalProduction = v1Production+v2Production+v3Production;
		double fleetFuelEconomy = totalProduction/(v1Production/v1Mpg + v2Production/v2Mpg 
				+v3Production/v3Mpg);
		System.out.println("Fleet fuel economy:"+fleetFuelEconomy+" mpg.");




		

	}

}
