package com.metaheuristique.utils;

import java.util.ArrayList;

public class Coordinates {
	private ArrayList<double[]> coordinates;
	
	public Coordinates(ArrayList<String> data){
		coordinates = new ArrayList<double[]>();
		double line[];
		String dataLine[];
		for (int i = 0; i < data.size(); i++) {
			dataLine = data.get(i).split(";");
			if(dataLine.length > 1){
				line = new double[2];
				line[0] = Double.parseDouble(dataLine[0]);
				line[1] = Double.parseDouble(dataLine[1]);
				coordinates.add(line);
			}
		}
	}
	
	public int getIndex(double Xcor, double Ycor){
		for (int i = 0; i < coordinates.size(); i++) {
			if(coordinates.get(i)[0] == Xcor && coordinates.get(i)[1] == Ycor)
				return i;
		}
		return -1;
	}
}
