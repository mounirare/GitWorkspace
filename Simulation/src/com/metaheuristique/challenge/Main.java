package com.metaheuristique.challenge;

import com.metaheuristique.utils.ExtractData;
import com.metaheuristique.utils.Fichier;

public class Main {

	public static double[] ExtractFleetData(String in){
		String[] dataIn = in.split(";");
		double datas[] = new double[dataIn.length - 1];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = Double.parseDouble(dataIn[i + 1]);
		}
		return datas;
	}
	
	public static void main(String[] args) {
		Fichier f = new Fichier();
		/*
		String fleet = f.lecture("data/Fleet.txt");
		String tabFleet[] = fleet.split("\n");
		for (int i = 1; i < tabFleet.length; i++) { // Debuter à la deuxieme ligne, sauter les descriptions
			//System.out.println(tabFleet[i]);
			String oneFleet[] = tabFleet[i].split(" ;");
			if(oneFleet[0].equals("COACH")){
				System.out.println("Bus");
				double[] data = ExtractFleetData(tabFleet[i]); // Extration des données de la ligne
				for (int j = 0; j < data.length; j++) {
					System.out.print(data[j] + "**");
				}
				System.out.println();
			}
			else{
				System.out.println("Navette");
				double[] data = ExtractFleetData(tabFleet[i]); // Extration des données de la ligne
				for (int j = 0; j < data.length; j++) {
					System.out.print(data[j] + " ** ");
				}
				System.out.println();
			}
		}*/
		
		ExtractData ed = new ExtractData();
		System.out.println(ed.readBusStops());
		System.out.println(ed.readFleet());
		System.out.println(ed.readDistTimeCoa());
		System.out.println(ed.readDistTimeCoo());
		System.out.println(ed.readDistTimeShu());
	}

}
