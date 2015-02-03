package com.metaheuristique.challenge;

import java.util.ArrayList;

public class Shuttle {
 
	private String idShuttle;
	private int shuttleCapacity;
	private int shRemainTime;
	private int distanceTraveled;
	private int nbPassengers;
	private int costKm;
	private int costUsage;
	private float posX;
	private float posY;
	private ArrayList<Integer> busStopTraveled;
	
	public Shuttle(){

	}

	public Shuttle(String data){
		String[] datas = data.split(";");
		if(datas[0].equals("SHUTTLE")){
			this.idShuttle = datas[1];
			this.shuttleCapacity = Integer.parseInt(datas[2]);
			this.costKm = Integer.parseInt(datas[4]);
			this.costUsage = Integer.parseInt(datas[5]);
			this.posX = Float.parseFloat(datas[6]);
			this.posY = Float.parseFloat(datas[7]);
			
		}else{
			System.err.println("Input data Error");
		}
	}
}
