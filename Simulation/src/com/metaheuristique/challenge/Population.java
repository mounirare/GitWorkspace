package com.metaheuristique.challenge;

import java.util.ArrayList;

import com.metaheuristique.utils.DistanceTime;

public class Population {

	private ArrayList<BusStop> busStops;
	private ArrayList<Coach> coachs;
	private ArrayList<Shuttle> shuttles;
	private ArrayList<Solution> solutions;
	private DistanceTime matCoach[][];
	private DistanceTime matShut[][];
	
	public Population(ArrayList<BusStop> busStop, ArrayList<Coach> coach, ArrayList<Shuttle> shuttle, DistanceTime matCoach[][], DistanceTime matShut[][]){
		busStops = busStop;
		coachs = coach;
		shuttles = shuttle;
		this.matCoach = matCoach;
		this.matShut = matShut;
		solutions = new ArrayList<Solution>();
	}
	
	public Solution calculSol(){
		solutions.add(new Solution(coachs, shuttles));
		
		return null;
		
	}
	
	public void traitementCoach(){
		
	}
	
	public void traitementShuttle(){
		
	}

	public ArrayList<BusStop> getBusStops() {
		return busStops;
	}

	public void setBusStops(ArrayList<BusStop> busStops) {
		this.busStops = busStops;
	}

	public ArrayList<Coach> getCoachs() {
		return coachs;
	}

	public void setCoachs(ArrayList<Coach> coachs) {
		this.coachs = coachs;
	}

	public ArrayList<Shuttle> getShuttles() {
		return shuttles;
	}

	public void setShuttles(ArrayList<Shuttle> shuttles) {
		this.shuttles = shuttles;
	}

	public ArrayList<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(ArrayList<Solution> solutions) {
		this.solutions = solutions;
	}

	public DistanceTime[][] getMatCoach() {
		return matCoach;
	}

	public void setMatCoach(DistanceTime[][] matCoach) {
		this.matCoach = matCoach;
	}

	public DistanceTime[][] getMatShut() {
		return matShut;
	}

	public void setMatShut(DistanceTime[][] matShut) {
		this.matShut = matShut;
	}
	
}
