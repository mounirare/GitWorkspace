package com.metaheuristique.challenge;

import java.util.ArrayList;
import java.util.Collections;

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
		ArrayList<BusStop> busStopRest = busStops;
		Collections.shuffle(coachs);
		Collections.shuffle(shuttles);
		for(int i= 0; i < coachs.size(); i++){
			traitementCoach(coachs.get(i), busStopRest);
		}
		int j=0;
		while(!busStopRest.isEmpty() && j < shuttles.size()){
			traitementShuttle(shuttles.get(j), busStopRest);
			j++;
		}
		solutions.get(solutions.size()-1).calculCout();
		return solutions.get(solutions.size()-1);
		
	}
	
	public void traitementCoach(Coach c, ArrayList<BusStop> busStopRest){
		/*
		 * - choisir un arrêt A aléatoirement tel que : P(A) =! 0 , C>P(A)
			- Trest = Trest(A)
			- N-- 
			*- Si A != HUB, alors C = C - P(A), P(A) = 0 sinon finir
			- Si N > 1 continuer sinon aller au HUB et finir
			- chercher A’ aléatoirement tel que P(A’) =! 0 et C > P(A’) 
			- Si Trest> T(A,A’)+T(A’,HUB) et Trest(A’) > T(A’, HUB)	//de base la dernière
				- Se déplacer vers A’ (A <- A’)			//condition doit être vraie
				- Trest = min(Trest - T(A,A’), Trest(A’))
				- N--
			- Sinon choisir un autre arrêt
			-revenir à  *
		 * 
		 */
		ArrayList<BusStop> busStopDisp = busStopRest;
		while(c.getNbStopMade()<c.getMaxStop()){
			
		}
	}
	
	public void traitementShuttle(Shuttle s, ArrayList<BusStop> busStopRest){
		
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
