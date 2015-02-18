package com.metaheuristique.utils;

public class DistanceTime {
	private int distance;
	private int time;

	public DistanceTime(){

	}

	public DistanceTime(String dist, String tim){
		this.distance = Integer.parseInt(dist);
		this.time = Integer.parseInt(tim);
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "(" + distance + ", " + time + ")";
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time; 
	}
}
