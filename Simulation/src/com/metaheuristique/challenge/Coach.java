package com.metaheuristique.challenge;

import java.util.ArrayList;

import com.metaheuristique.utils.Coordinates;

public class Coach {

	private String idCoach;
	private int coachCapacity;
	private int chRemainTime;
	private int distanceTraveled;
	private int nbStopMade;
	private int nbPassengers;
	private int maxStop;
	private int costKm;
	private float posX;
	private float posY;
	private ArrayList<String> busStopTraveled;
	private int indPos;

	public Coach(){

	}

	public Coach(String data){
		String[] datas = data.split(";");
		this.idCoach = datas[1];
		this.coachCapacity = Integer.parseInt(datas[2]);
		this.chRemainTime = 0;
		this.nbStopMade = 0;
		this.distanceTraveled = 0;
		this.nbPassengers = 0;
		this.maxStop = Integer.parseInt(datas[3]);
		this.costKm = Integer.parseInt(datas[4]);
		this.posX = Float.parseFloat(datas[6]);
		this.posY = Float.parseFloat(datas[7]);
		busStopTraveled = new ArrayList<String>();
	}
	
	public int getDistanceTraveled() {
		return distanceTraveled;
	}

	public void setDistanceTraveled(int distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}

	public Coach(String data, Coordinates coordinates){
		String[] datas = data.split(";");
		this.idCoach = datas[1];
		this.coachCapacity = Integer.parseInt(datas[2]);
		this.chRemainTime = 0;
		this.distanceTraveled = 0;
		this.nbStopMade = 0;
		this.nbPassengers = 0;
		this.maxStop = Integer.parseInt(datas[3]);
		this.costKm = Integer.parseInt(datas[4]);
		this.posX = Float.parseFloat(datas[6]);
		this.posY = Float.parseFloat(datas[7]);
		this.indPos = coordinates.getIndex(posX, posY);
		busStopTraveled = new ArrayList<String>();
	}

	@Override
	public String toString() {
		return "\nId : " + idCoach
				+ "\nCapacity : " + coachCapacity
				+ "\nRemainTime : " + chRemainTime 
				+ "\nStopMade : " + nbStopMade 
				+ "\nNbPassengers : " + nbPassengers 
				+ "\nMaxStop : " + maxStop 
				+ "\nCost/Km : " + costKm 
				+ "\nPosX : " + posX 
				+ "\nPosY : "	+ posY 
				+ "\nBusStopTraveled : " + busStopTraveled
				+ "\nInd Pos : " + indPos ;
	}

	public String getIdCoach() {
		return idCoach;
	}

	public void setIdCoach(String idCoach) {
		this.idCoach = idCoach;
	}

	public int getCoachCapacity() {
		return coachCapacity;
	}

	public void setCoachCapacity(int coachCapacity) {
		this.coachCapacity = coachCapacity;
	}

	public int getChRemainTime() {
		return chRemainTime;
	}

	public void setChRemainTime(int chRemainTime) {
		this.chRemainTime = chRemainTime;
	}

	public int getNbStopMade() {
		return nbStopMade;
	}

	public void setNbStopMade(int nbStopMade) {
		this.nbStopMade = nbStopMade;
	}

	public int getNbPassengers() {
		return nbPassengers;
	}

	public void setNbPassengers(int nbPassengers) {
		this.nbPassengers = nbPassengers;
	}

	public int getMaxStop() {
		return maxStop;
	}

	public void setMaxStop(int maxStop) {
		this.maxStop = maxStop;
	}

	public int getCostKm() {
		return costKm;
	}

	public void setCostKm(int costKm) {
		this.costKm = costKm;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public ArrayList<String> getBusStopTraveled() {
		return busStopTraveled;
	}

	public void setBusStopTraveled(ArrayList<String> busStopTraveled) {
		this.busStopTraveled = busStopTraveled;
	}

	public int getIndPos() {
		return indPos;
	}

	public void setIndPos(int indPos) {
		this.indPos = indPos;
	}	
	
	public int getCost(){
		return costKm * distanceTraveled; 
	}
}
