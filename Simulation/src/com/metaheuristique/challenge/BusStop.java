package com.metaheuristique.challenge;

import java.util.ArrayList;

import com.metaheuristique.utils.Coordinates;

public class BusStop implements Cloneable{

	private String idBusStop;
	private String postCode;
	private String city;
	private float posX;
	private float posY;
	private int nbPassengers;
	private int tamponPassengers;
	private int remainTime;
	private int indPos;
	private Coach busPasse;
	
	
	public Coach getBusPasse() {
		return busPasse;
	}

	public void setBusPasse(Coach busPasse) {
		this.busPasse = busPasse;
	}

	public BusStop(){

	}

	public BusStop(String data){
		String[] datas = data.split(";");
		this.idBusStop = datas[1];
		this.postCode = datas[2];
		this.city = datas[3];
		this.posX = Float.parseFloat(datas[4]);
		this.posY = Float.parseFloat(datas[5]);
		this.nbPassengers = Integer.parseInt(datas[6]);
		this.remainTime = Integer.parseInt(datas[7]);
	}
	
	public BusStop(String data, Coordinates coordinates){
		String[] datas = data.split(";");
		this.idBusStop = datas[1];
		this.postCode = datas[2];
		this.city = datas[3];
		this.posX = Float.parseFloat(datas[4]);
		this.posY = Float.parseFloat(datas[5]);
		this.nbPassengers = Integer.parseInt(datas[6]); 
		this.remainTime = Integer.parseInt(datas[7]);
		this.indPos = coordinates.getIndex(posX, posY);
		this.tamponPassengers = Integer.parseInt(datas[6]);
	}

	public int getTamponPassengers() {
		return tamponPassengers;
	}

	public void setTamponPassengers(int tamponPassengers) {
		this.tamponPassengers = tamponPassengers;
	}

	@Override
	public String toString() {
		return  idBusStop ;
				/*+ "\nPost Code : " + postCode
				+ "\nCity : " + city 
				+ "\nPosX : " + posX 
				+ "\nPosY : " + posY
				+ "\nNbPassengers : " + nbPassengers 
				+ "\nRemainTime : " + remainTime
				+ "\nInd Pos : " + indPos ;*/
	}
	
	public BusStop clone(){
		BusStop c = null;
		try {
			// On r�cup�re l'instance � renvoyer par l'appel de la 
			// m�thode super.clone()
			//System.out.println("Coucou"); 
			c = (BusStop)super.clone();
		} catch(CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous impl�mentons 
			// l'interface Cloneable
			cnse.printStackTrace(System.err);
		}
		
		return c;
	}

	public String getIdBusStop() {
		return idBusStop;
	}

	public void setIdBusStop(String idBusStop) {
		this.idBusStop = idBusStop;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
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
