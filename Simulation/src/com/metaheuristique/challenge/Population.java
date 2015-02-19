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
			if (busStop.get(i).getIdBusStop().substring(0, 1).equals("H")){
				idHub = busStop.get(i).getIdBusStop();
				return i;
			}
		}
		return -1;
	}
	
	public Solution calculSol(){
		solutions.add(new Solution(coachs, shuttles));
		ArrayList<BusStop> busStopRest = new ArrayList<BusStop>();
		busStopRest.addAll(busStops);
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
		System.out.println("BusStopRest :"+busStopRest);
		ArrayList<BusStop> busStopDisp  = new ArrayList<BusStop>();
		busStopDisp.addAll(busStopRest);
		ArrayList<String> temp;
		Collections.shuffle(busStopDisp);
		Boolean premier = false;
		Boolean hub = false;
		int i = 0;
		System.out.println("Coach "+c.getIdCoach()+":");
		System.out.println("Liste : "+busStopDisp);
		while(i < busStopDisp.size() && !premier){
			if(c.getCoachCapacity() > busStopDisp.get(i).getNbPassengers()){
				System.out.println("1er Bus Stop: "+busStopDisp.get(i).getIdBusStop());
				premier = true;
				c.setDistanceTraveled(matCoach[c.getIndPos()][busStopDisp.get(i).getIndPos()].getDistance());
				c.setNbPassengers(busStopDisp.get(i).getNbPassengers());
				busStopDisp.get(i).setNbPassengers(0);
				temp = c.getBusStopTraveled();
				temp.add(busStopDisp.get(i).getIdBusStop());
				c.setBusStopTraveled(temp);
				c.setChRemainTime(busStopDisp.get(i).getRemainTime());
				busStopDisp.get(i).setBusPasse(c);
				c.setNbStopMade(1);
				c.setIndPos(busStopDisp.get(i).getIndPos());
				if(busStopDisp.get(i).getIdBusStop().substring(0, 1).equals("H")){
					hub = true;
				}
				busStopRest.remove(busStopDisp.get(i));
				busStopDisp.remove(i);
				
			}
			else{
				i++;
			}
		}
		
		while(c.getNbStopMade()<c.getMaxStop()-1 && i < busStopDisp.size() && !hub){
			if((c.getCoachCapacity()-c.getNbPassengers()) >= busStopDisp.get(i).getNbPassengers() && c.getChRemainTime() >= (matCoach[c.getIndPos()][busStopDisp.get(i).getIndPos()].getTime()+matCoach[busStopDisp.get(i).getIndPos()][indHub].getTime())){
				System.out.println("Bus Stop: "+busStopDisp.get(i).getIdBusStop());
				c.setDistanceTraveled(c.getDistanceTraveled() + matCoach[c.getIndPos()][busStopDisp.get(i).getIndPos()].getDistance());
				c.setNbPassengers(c.getNbPassengers() + busStopDisp.get(i).getNbPassengers());
				busStopDisp.get(i).setNbPassengers(0);
				temp = c.getBusStopTraveled();
				temp.add(busStopDisp.get(i).getIdBusStop());
				c.setBusStopTraveled(temp);
				busStopDisp.get(i).setBusPasse(c);
				if (c.getChRemainTime() - matCoach[c.getIndPos()][busStopDisp.get(i).getIndPos()].getTime()< busStopDisp.get(i).getRemainTime())
					c.setChRemainTime(c.getChRemainTime() - matCoach[c.getIndPos()][busStopDisp.get(i).getIndPos()].getTime());
				else
					c.setChRemainTime(busStopDisp.get(i).getRemainTime());
				c.setNbStopMade(c.getNbStopMade() + 1);
				c.setIndPos(busStopDisp.get(i).getIndPos());
				if(busStopDisp.get(i).getIdBusStop().substring(0, 1).equals("H")){
					hub = true;
				}
				busStopRest.remove(busStopDisp.get(i));
				busStopDisp.remove(i); 
			}
			else{
				i++;
			}
		}
		if(!hub){
			System.out.println("Je passe ici!");
			c.setDistanceTraveled(c.getDistanceTraveled() + matCoach[c.getIndPos()][indHub].getDistance());
			temp = c.getBusStopTraveled();
			temp.add(idHub);
			c.setBusStopTraveled(temp);
			c.setChRemainTime(c.getChRemainTime() - matCoach[c.getIndPos()][indHub].getTime());
			c.setNbStopMade(c.getNbStopMade() + 1);
			c.setIndPos(indHub);
			System.out.println("");
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
