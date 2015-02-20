package com.metaheuristique.utils;

import java.util.ArrayList;

public class ExtractData {
	Fichier file = new Fichier();
	//String directory = "Instance 1/";
	String directory = "Exemple/";
	String fileName;
	
	public ArrayList<String> readBusStops(){
		fileName = "Busstops.csv";
		String stream;
		
		stream = file.lecture(directory+fileName);
		
		String[] streamTab = stream.split("\n");
		
		ArrayList<String> busStops = new ArrayList<String>();
		for (int i = 1; i < streamTab.length; i++){
			busStops.add(streamTab[i]);
		}
		
		return busStops;
	}
	
	public ArrayList<String> readFleet(){
		fileName = "Fleet.csv";
		String stream;
		
		stream = file.lecture(directory+fileName);
		
		String[] streamTab = stream.split("\n");
		
		ArrayList<String> busStops = new ArrayList<String>();
		for (int i = 1; i < streamTab.length; i++) {
			busStops.add(streamTab[i]);
		}
		
		return busStops;
	}
	
	public ArrayList<String> readDistTimeCoo(){
		fileName = "DistanceTimesCoordinates.csv";
		String stream;
		
		stream = file.lecture(directory+fileName);
		
		String[] streamTab = stream.split("\n");
		
		ArrayList<String> busStops = new ArrayList<String>();
		for (int i = 1; i < streamTab.length; i++) {
			busStops.add(streamTab[i]);
		}
		
		return busStops;
	}
	
	public ArrayList<String> readDistTimeCoa(){
		fileName = "DistanceTimesData_COACHES.csv";
		String stream;
		
		stream = file.lecture(directory+fileName);
		
		String[] streamTab = stream.split("\n");
		
		ArrayList<String> busStops = new ArrayList<String>();
		for (int i = 1; i < streamTab.length; i++) {
			busStops.add(streamTab[i]);
		}
		
		return busStops;
	}
	
	public ArrayList<String> readDistTimeShu(){
		fileName = "DistanceTimesData_SHUTTLES.csv";
		String stream;
		
		stream = file.lecture(directory+fileName);
		
		String[] streamTab = stream.split("\n");
		
		ArrayList<String> busStops = new ArrayList<String>();
		for (int i = 1; i < streamTab.length; i++) {
			busStops.add(streamTab[i]);
		}
		
		return busStops;
	}

	public String[] spliter(String in){
		return in.split(";");
	}
}
