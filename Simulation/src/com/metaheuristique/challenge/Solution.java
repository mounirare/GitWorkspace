package com.metaheuristique.challenge;

import java.util.ArrayList;

public class Solution {

	private ArrayList<Coach> coachList;
	private ArrayList<Shuttle> shuttleList;
	private double totalCost;
	
	public Solution(ArrayList<Coach> coachList, ArrayList<Shuttle> shuttleList){
		this.coachList = coachList;
		this.shuttleList = shuttleList;
		totalCost = 0.0;
	}
	
	public String coachPath(int indice){
		String sol= new String();
		Coach c = coachList.get(indice);
		for(int i=0; i<c.getBusStopTraveled().size(); i++){
			String stop = c.getIdCoach()+";"+i+1+";"+c.getBusStopTraveled().get(i)+";";
			if(c.getBusStopTraveled().get(i).substring(0, 1) == "B")
				stop = stop+"BUSSTOP";
			else
				stop = stop+"HUB";
			sol = sol + stop + "\n";
		}
		return sol;
		
	}
	
	public String shuttlePath(int indice){
		String sol= new String();
		Shuttle s = shuttleList.get(indice);
		for(int i=0; i<s.getBusStopTraveled().size(); i++){
			String stop = s.getIdShuttle()+";"+i+1+";"+s.getBusStopTraveled().get(i)+";";
			if(s.getBusStopTraveled().get(i).substring(0, 1) == "B")
				stop = stop+"BUSSTOP";
			else
				stop = stop+"HUB";
			sol = sol + stop + "\n";
		}
		return sol;
		
	}
}
