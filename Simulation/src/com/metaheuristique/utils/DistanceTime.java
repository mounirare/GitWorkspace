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
}
