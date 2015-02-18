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
	private int indHub;
	private String idHub;
	
	
	public Population(ArrayList<BusStop> busStop, ArrayList<Coach> coach, ArrayList<Shuttle> shuttle, DistanceTime matCoach[][], DistanceTime matShut[][]){
		busStops = busStop;
		coachs = coach;
		shuttles = shuttle;
		this.matCoach = matCoach;
		this.matShut = matShut;
		solutions = new ArrayList<Solution>();
		indHub = calcIndHub(busStops);
	}
	
	public int calcIndHub(ArrayList<BusStop> busStop){
		for(int i=0; i<busStop.size(); i++){
			if (busStop.get(i).getIdBusStop().substring(0, 1) == "H"){
				idHub = busStop.get(i).getIdBusStop();
				return i;
			}
		}
		return -1;
	}
	
	public Solution calculSol(){
		int indHub;
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
		 * - choisir un arr�t A al�atoirement tel que : P(A) =! 0 , C>P(A)
			- Trest = Trest(A)
			- N-- 
			*- Si A != HUB, alors C = C - P(A), P(A) = 0 sinon finir
			- Si N > 1 continuer sinon aller au HUB et finir
			- chercher A� al�atoirement tel que P(A�) =! 0 et C > P(A�) 
			- Si Trest> T(A,A�)+T(A�,HUB) et Trest(A�) > T(A�, HUB)	//de base la derni�re
				- Se d�placer vers A� (A <- A�)			//condition doit �tre vraie
				- Trest = min(Trest - T(A,A�), Trest(A�))
				- N--
			- Sinon choisir un autre arr�t
			-revenir �  *
		 * 
		 */
		ArrayList<BusStop> busStopDisp = busStopRest;
		ArrayList<String> temp;
		Collections.shuffle(busStopDisp);
		Boolean premier = false;
		Boolean hub = false;
		int i = 0;
		while(i < busStopDisp.size() && !premier){
			if(c.getCoachCapacity() > busStopDisp.get(i).getNbPassengers()){
				premier = true;
				c.setDistanceTraveled(matCoach[c.getIndPos()][busStopDisp.get(i).getIndPos()].getDistance());
				c.setNbPassengers(busStopDisp.get(i).getNbPassengers());
				busStopDisp.get(i).setNbPassengers(0);
				temp = c.getBusStopTraveled();
				temp.add(busStopDisp.get(i).getIdBusStop());
				c.setBusStopTraveled(temp);
				c.setChRemainTime(busStopDisp.get(i).getRemainTime());
				c.setNbStopMade(1);
				c.setIndPos(busStopDisp.get(i).getIndPos());
				if(busStopDisp.get(i).getIdBusStop().substring(0, 1) == "H"){
					hub = true;
				}
				busStopDisp.remove(i);
			}
			else{
				i++;
			}
		}
		
		while(c.getNbStopMade()<c.getMaxStop()-1 && i < busStopDisp.size() && !hub){
			if((c.getCoachCapacity()-c.getNbPassengers()) > busStopDisp.get(i).getNbPassengers() && c.getChRemainTime() >= (matCoach[c.getIndPos()][busStopDisp.get(i).getIndPos()].getTime()+matCoach[busStopDisp.get(i).getIndPos()][indHub].getTime())){
				c.setDistanceTraveled(c.getDistanceTraveled() + matCoach[c.getIndPos()][busStopDisp.get(i).getIndPos()].getDistance());
				c.setNbPassengers(c.getNbPassengers() + busStopDisp.get(i).getNbPassengers());
				busStopDisp.get(i).setNbPassengers(0);
				temp = c.getBusStopTraveled();
				temp.add(busStopDisp.get(i).getIdBusStop());
				c.setBusStopTraveled(temp);
				c.setChRemainTime(c.getChRemainTime() - matCoach[c.getIndPos()][busStopDisp.get(i).getIndPos()].getTime());
				c.setNbStopMade(c.getNbStopMade() + 1);
				c.setIndPos(busStopDisp.get(i).getIndPos());
				if(busStopDisp.get(i).getIdBusStop().substring(0, 1) == "H"){
					hub = true;
				}
				busStopDisp.remove(0);
			}
			else{
				i++;
			}
		}
		if(!hub){
			c.setDistanceTraveled(c.getDistanceTraveled() + matCoach[c.getIndPos()][indHub].getDistance());
			temp = c.getBusStopTraveled();
			temp.add(idHub);
			c.setBusStopTraveled(temp);
			c.setChRemainTime(c.getChRemainTime() - matCoach[c.getIndPos()][indHub].getTime());
			c.setNbStopMade(c.getNbStopMade() + 1);
			c.setIndPos(indHub);
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
