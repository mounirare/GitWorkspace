package com.metaheuristique.challenge;

import java.util.ArrayList;

import com.metaheuristique.utils.Fichier;

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
			String stop = c.getIdCoach()+";"+(i+1)+";"+c.getBusStopTraveled().get(i)+";";
			if(c.getBusStopTraveled().get(i).substring(0, 1).equals("B"))
				stop = stop+"BUSSTOP";
			else
				stop = stop+"HUB";
			sol = sol + stop + "\n";
		}
		return sol;
	}
	
	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String shuttlePath(int indice){
		String sol= new String();
		Shuttle s = shuttleList.get(indice);
		for(int i=0; i<s.getBusStopTraveled().size(); i++){
			String stop = s.getIdShuttle()+";"+(i+1)+";"+s.getBusStopTraveled().get(i)+";";
			if(s.getBusStopTraveled().get(i).substring(0, 1).equals("B"))
				stop = stop+"BUSSTOP";
			else
				stop = stop+"HUB";
			sol = sol + stop + "\n";
		}
		return sol;
	}
	
	public void calculCout(){
		totalCost = 0.0;
		for(int i=0; i<coachList.size(); i++){
			totalCost += coachList.get(i).getCost();
		}
		for(int i=0; i<shuttleList.size(); i++){
			totalCost += shuttleList.get(i).getCost();
		}
	}
	
	public void enregistrement(){
		Fichier fichier = new Fichier();
		String ecriture = "VEHICLE_ID;TOUR_POSITION;LOCATION_ID;LOCATION_TYPE\n";
		String fleet = new String();
		for(int i=0; i<coachList.size(); i++){
			fleet = coachPath(i);
			ecriture = ecriture + fleet +"\n";
		}
		for(int i=0; i<shuttleList.size(); i++){
			if(shuttleList.get(i).getDistanceTraveled()!= 0){
				fleet = shuttlePath(i);
				ecriture = ecriture + fleet+"\n";
			}
		}
		fichier.ecriture("Solution.txt", ecriture);
	}
}
