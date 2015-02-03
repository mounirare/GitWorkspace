package com.metaheuristique.challenge;

import java.util.ArrayList;

public class Coach {

	private String idCoach;
	private int coachCapacity;
	private int chRemainTime;
	private int nbStopMade;
	private int nbPassengers;
	private int maxStop;
	private int costKm;
	private float posX;
	private float posY;
	private ArrayList<Integer> busStopTraveled;

	public Coach(){

	}

	public Coach(String data){
		String[] datas = data.split(";");
		this.idCoach = datas[1];
		this.coachCapacity = Integer.parseInt(datas[2]);
		this.chRemainTime = 0;
		this.nbStopMade = 0;
		this.nbPassengers = 0;
		this.maxStop = Integer.parseInt(datas[3]);
		this.costKm = Integer.parseInt(datas[4]);
		this.posX = Float.parseFloat(datas[6]);
		this.posY = Float.parseFloat(datas[7]);
		busStopTraveled = new ArrayList<Integer>();
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
				+ "\nBusStopTraveled : " + busStopTraveled ;
	}
	
	
}
