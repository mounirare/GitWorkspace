package com.metaheuristique.challenge;

public class BusStop {

	private String idBusStop;
	private int postCode;
	private String city;
	private float posX;
	private float posY;
	private int nbPassengers;
	private int remainTime;
	
	
	public BusStop(){

	}

	public BusStop(String data){
		String[] datas = data.split(";");
		this.idBusStop = datas[1];
		this.postCode = Integer.parseInt(datas[2]);
		this.city = datas[3];
		this.posX = Float.parseFloat(datas[4]);
		this.posY = Float.parseFloat(datas[5]);
		this.nbPassengers = Integer.parseInt(datas[6]);
		this.remainTime = Integer.parseInt(datas[7]);
	}

	@Override
	public String toString() {
		return "\nId : " + idBusStop 
				+ "\nPost Code : " + postCode
				+ "\nCity : " + city 
				+ "\nPosX : " + posX 
				+ "\nPosY : " + posY
				+ "\nNbPassengers : " + nbPassengers 
				+ "\nRemainTime : " + remainTime;
	}
	
	
}
