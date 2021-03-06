package com.metaheuristique.challenge;

import java.util.ArrayList;
import java.util.Collection;
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
	
	@SuppressWarnings("unchecked")
	public ArrayList<Coach> copieCoach(){
		ArrayList<Coach> coachSol = new ArrayList<Coach>();
		for(int i=0; i<coachs.size(); i++){
			coachSol.add(coachs.get(i).clone());
		}
		return coachSol;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Shuttle> copieShuttle(){
		ArrayList<Shuttle> shuttleSol = new ArrayList<Shuttle>();
		for(int i=0; i<shuttles.size(); i++){
			shuttleSol.add(shuttles.get(i).clone());
		}
		return shuttleSol; 
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<BusStop> copieBusStop(){
		ArrayList<BusStop> BusStopDisp = new ArrayList<BusStop>();
		for(int i=0; i<busStops.size(); i++){
			BusStopDisp.add(busStops.get(i).clone());
		}
		return BusStopDisp; 
	}
	
	public void resetBusStop(ArrayList<BusStop> busStopRest){
		for(int i = 0; i < busStopRest.size(); i++){
			busStopRest.get(i).setNbPassengers(busStopRest.get(i).getTamponPassengers());
			if(busStopRest.get(i).getBusPasse() != null)
				busStopRest.get(i).setBusPasse(null);
		}
	}
	
	public Solution calculSol(){
		ArrayList<BusStop> busStopRest = new ArrayList<BusStop>();
		ArrayList<Coach> coachSol = new ArrayList<Coach>();
		ArrayList<Shuttle> shuttleSol = new ArrayList<Shuttle>();
		busStopRest = copieBusStop();
		resetBusStop(busStopRest);
		busStopRest.remove(0);
		coachSol = copieCoach();
		shuttleSol = copieShuttle();
		Collections.shuffle(coachSol);
		Collections.shuffle(shuttleSol); 
		for(int i= 0; i < coachSol.size(); i++){
			traitementCoach(coachSol.get(i), busStopRest);
		}
		int j=0;
		while(!busStopRest.isEmpty() && j < shuttleSol.size()){
			traitementShuttle(shuttleSol.get(j), busStopRest);
			j++;
		}
		if(busStopRest.isEmpty()){
			//System.out.println(coachSol);
			solutions.add(new Solution(coachSol, shuttleSol));
			solutions.get(solutions.size()-1).calculCout();
			return solutions.get(solutions.size()-1);
		}
		System.out.println("Arret de bus oubli� : "+busStopRest);
		return null;
		
		
	}
	
	public void traitementCoach(Coach c, ArrayList<BusStop> busStopRest){
		//System.out.println("BusStopRest :"+busStopRest);
		ArrayList<BusStop> busStopDisp  = new ArrayList<BusStop>();
		busStopDisp.addAll(busStopRest);
		ArrayList<String> temp;
		Collections.shuffle(busStopDisp);
		Boolean premier = false;
		Boolean hub = false;
		int i = 0;
		//System.out.println("Coach "+c.getIdCoach()+":");
		//System.out.println("Liste : "+busStopDisp);
		while(i < busStopDisp.size() && !premier){
			if(c.getCoachCapacity() > busStopDisp.get(i).getNbPassengers()){
				//System.out.println("1er Bus Stop: "+busStopDisp.get(i).getIdBusStop());
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
			//System.out.println("Arret "+busStopRest.get(i).getIdBusStop()+", NbPassenger: "+busStopRest.get(i).getNbPassengers()+", Tampon: "+busStopRest.get(i).getTamponPassengers());
			if((c.getCoachCapacity()-c.getNbPassengers()) >= busStopDisp.get(i).getNbPassengers() && c.getChRemainTime() >= (matCoach[c.getIndPos()][busStopDisp.get(i).getIndPos()].getTime()+matCoach[busStopDisp.get(i).getIndPos()][indHub].getTime())){
				//System.out.println("Bus Stop: "+busStopDisp.get(i).getIdBusStop());
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
			//System.out.println("Je passe ici!");
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
		ArrayList<BusStop> busStopDisp  = new ArrayList<BusStop>();
		busStopDisp.addAll(busStops);
		ArrayList<String> temp;
		Collections.shuffle(busStopDisp);
		Collections.shuffle(busStopRest);
		Boolean premier = false;
		Boolean dernier = false;
		int i = 0;
		//System.out.println("Coach "+s.getIdShuttle()+":");
		//System.out.println("Liste : "+busStopDisp);
		while(i < busStopRest.size() && !premier){
			if(s.getShuttleCapacity() > busStopRest.get(i).getNbPassengers()){
				if(busStopRest.get(i).getIdBusStop().substring(0, 1).equals("H")){
					i++;
				}else{
					//System.out.println("1er Bus Stop: "+busStopRest.get(i).getIdBusStop());
					premier = true;
					s.setDistanceTraveled(matShut[s.getIndPos()][busStopRest.get(i).getIndPos()].getDistance());
					s.setNbPassengers(busStopRest.get(i).getNbPassengers());
					busStopRest.get(i).setNbPassengers(0);
					temp = s.getBusStopTraveled();
					temp.add(busStopRest.get(i).getIdBusStop());
					s.setBusStopTraveled(temp);
					s.setShRemainTime(busStopRest.get(i).getRemainTime());
					s.setIndPos(busStopRest.get(i).getIndPos());
					busStopDisp.remove(busStopRest.get(i));
					busStopRest.remove(i);
				}
			}
			else{
				i++;
			}
		}
		while (i < busStopDisp.size() && !dernier){
			if((s.getShuttleCapacity() - s.getNbPassengers()) >= busStopDisp.get(i).getNbPassengers() && s.getShRemainTime() >= (matShut[s.getIndPos()][busStopDisp.get(i).getIndPos()].getTime()+matShut[busStopDisp.get(i).getIndPos()][indHub].getTime())){
				if(busStopDisp.get(i).getNbPassengers() != 0){
					//System.out.println("Bus Stop: "+busStopDisp.get(i).getIdBusStop());
					s.setDistanceTraveled(s.getDistanceTraveled() + matShut[s.getIndPos()][busStopDisp.get(i).getIndPos()].getDistance());
					s.setNbPassengers(s.getNbPassengers() + busStopDisp.get(i).getNbPassengers());
					busStopDisp.get(i).setNbPassengers(0);
					temp = s.getBusStopTraveled();
					temp.add(busStopDisp.get(i).getIdBusStop());
					s.setBusStopTraveled(temp);
					if (s.getShRemainTime() - matShut[s.getIndPos()][busStopDisp.get(i).getIndPos()].getTime()< busStopDisp.get(i).getRemainTime())
						s.setShRemainTime(s.getShRemainTime() - matCoach[s.getIndPos()][busStopDisp.get(i).getIndPos()].getTime());
					else
						s.setShRemainTime(busStopDisp.get(i).getRemainTime());
					s.setIndPos(busStopDisp.get(i).getIndPos());
					if(busStopDisp.get(i).getIdBusStop().substring(0, 1).equals("H")){
						dernier = true;
					}
					busStopRest.remove(busStopDisp.get(i));
					busStopDisp.remove(i); 
				}else{
					if(busStopDisp.get(i).getIdBusStop().substring(0, 1).equals("H")){
						dernier = true;
						s.setDistanceTraveled(s.getDistanceTraveled() + matShut[s.getIndPos()][indHub].getDistance());
						temp = s.getBusStopTraveled();
						temp.add(idHub);
						s.setBusStopTraveled(temp);
						s.setShRemainTime(s.getShRemainTime() - matShut[s.getIndPos()][indHub].getTime());
						s.setIndPos(indHub);
					}else{
						if(busStopDisp.get(i).getBusPasse()!= null){
							Coach c = busStopDisp.get(i).getBusPasse();
							if((c.getCoachCapacity()-c.getNbPassengers()) >= s.getNbPassengers() && (((s.getShRemainTime() - matShut[s.getIndPos()][indHub].getTime()) >= busStopDisp.get(i).getRemainTime()) || c.getChRemainTime() >= ((s.getShRemainTime() - matShut[s.getIndPos()][indHub].getTime())- busStopDisp.get(i).getRemainTime()))){
								dernier = true;
								s.setDistanceTraveled(s.getDistanceTraveled() + matShut[s.getIndPos()][busStopDisp.get(i).getIndPos()].getDistance());
								temp = s.getBusStopTraveled();
								temp.add(busStopDisp.get(i).getIdBusStop());
								s.setBusStopTraveled(temp);
								if((s.getShRemainTime() - matShut[s.getIndPos()][indHub].getTime()) < busStopDisp.get(i).getRemainTime())
									c.setChRemainTime(c.getChRemainTime() - (busStopDisp.get(i).getRemainTime() - (s.getShRemainTime() - matShut[s.getIndPos()][indHub].getTime())));
								c.setNbPassengers(c.getNbPassengers() + s.getNbPassengers());
								s.setShRemainTime(s.getShRemainTime() - matShut[s.getIndPos()][busStopDisp.get(i).getIndPos()].getTime());
								s.setIndPos(busStopDisp.get(i).getIndPos());
							}else{
								i++;
							}
						}else{
							i++;
						}
					}
				}
			}else{
				i++;
			}
		}
		if(!dernier){
			s.setDistanceTraveled(s.getDistanceTraveled() + matShut[s.getIndPos()][indHub].getDistance());
			temp = s.getBusStopTraveled();
			temp.add(idHub);
			s.setBusStopTraveled(temp);
			s.setShRemainTime(s.getShRemainTime() - matShut[s.getIndPos()][indHub].getTime());
			s.setIndPos(indHub);
		}
		
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
