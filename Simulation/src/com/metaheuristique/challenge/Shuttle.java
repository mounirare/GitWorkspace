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
	private ArrayList<String> busStopTraveled;
	private int indPos;
	
	public Shuttle(){

	}

	public Shuttle(String data){
		String[] datas = data.split(";");
		this.idShuttle = datas[1];
		this.shuttleCapacity = Integer.parseInt(datas[2]);
		this.shRemainTime = 0;
		this.distanceTraveled = 0;
		this.nbPassengers = 0;
		this.costKm = Integer.parseInt(datas[4]);
		this.costUsage = Integer.parseInt(datas[5]);
		this.posX = Float.parseFloat(datas[6]);
		this.posY = Float.parseFloat(datas[7]);
		busStopTraveled = new ArrayList<String>();
	}

	@Override
	public String toString() {
		return "\nId : " + idShuttle 
				+ "\nCapacity : " + shuttleCapacity 
				+ "\nRemainTime : " + shRemainTime
				+ "\nDistanceTraveled : " + distanceTraveled 
				+ "\nNbPassengers : " + nbPassengers 
				+ "\nCost/Km : " + costKm 
				+ "\nCost Usage : "+ costUsage 
				+ "\nPosX : " + posX 
				+ "\nPosY : " + posY
				+ "\nBusStopTraveled : " + busStopTraveled;
	}

	public String getIdShuttle() {
		return idShuttle;
	}

	public void setIdShuttle(String idShuttle) {
		this.idShuttle = idShuttle;
	}

	public int getShuttleCapacity() {
		return shuttleCapacity;
	}

	public void setShuttleCapacity(int shuttleCapacity) {
		this.shuttleCapacity = shuttleCapacity;
	}

	public int getShRemainTime() {
		return shRemainTime;
	}

	public void setShRemainTime(int shRemainTime) {
		this.shRemainTime = shRemainTime;
	}

	public int getDistanceTraveled() {
		return distanceTraveled;
	}

	public void setDistanceTraveled(int distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}

	public int getNbPassengers() {
		return nbPassengers;
	}

	public void setNbPassengers(int nbPassengers) {
		this.nbPassengers = nbPassengers;
	}

	public int getCostKm() {
		return costKm;
	}

	public void setCostKm(int costKm) {
		this.costKm = costKm;
	}

	public int getCostUsage() {
		return costUsage;
	}

	public void setCostUsage(int costUsage) {
		this.costUsage = costUsage;
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
	
	
}
