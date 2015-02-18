package com.metaheuristique.challenge;

import com.metaheuristique.utils.Coordinates;

public class BusStop {

	private String idBusStop;
	private int postCode;
	private String city;
	private float posX;
	private float posY;
	private int nbPassengers;
	private int remainTime;
	private int indPos;
	
	
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
	
	public BusStop(String data, Coordinates coordinates){
		String[] datas = data.split(";");
		this.idBusStop = datas[1];
		this.postCode = Integer.parseInt(datas[2]);
		this.city = datas[3];
		this.posX = Float.parseFloat(datas[4]);
		this.posY = Float.parseFloat(datas[5]);
		this.nbPassengers = Integer.parseInt(datas[6]);
		this.remainTime = Integer.parseInt(datas[7]);
		this.indPos = coordinates.getIndex(posX, posY);
	}

	@Override
	public String toString() {
		return "\nId : " + idBusStop 
				+ "\nPost Code : " + postCode
				+ "\nCity : " + city 
				+ "\nPosX : " + posX 
				+ "\nPosY : " + posY
				+ "\nNbPassengers : " + nbPassengers 
				+ "\nRemainTime : " + remainTime
				+ "\nInd Pos : " + indPos ;
	}

	public String getIdBusStop() {
		return idBusStop;
	}

	public void setIdBusStop(String idBusStop) {
		this.idBusStop = idBusStop;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public int getNbPassengers() {
		return nbPassengers;
	}

	public void setNbPassengers(int nbPassengers) {
		this.nbPassengers = nbPassengers;
	}

	public int getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(int remainTime) {
		this.remainTime = remainTime;
	}

	public int getIndPos() {
		return indPos;
	}

	public void setIndPos(int indPos) {
		this.indPos = indPos;
	}
	
	
}
