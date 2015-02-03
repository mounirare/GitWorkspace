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
		if(datas[0].equals("COACH")){
			this.idCoach = datas[1];
			this.coachCapacity = Integer.parseInt(datas[2]);
			this.maxStop = Integer.parseInt(datas[3]);
			this.costKm = Integer.parseInt(datas[4]);
			this.posX = Float.parseFloat(datas[6]);
			this.posY = Float.parseFloat(datas[7]);
			
		}else{
			System.err.println("Input data Error");
		}
	}
}
