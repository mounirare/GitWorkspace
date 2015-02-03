package com.metaheuristique.challenge;

import java.util.ArrayList;

import com.metaheuristique.utils.DistanceTime;
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
		/*System.out.println(ed.readBusStops());
		System.out.println(ed.readFleet());
		System.out.println(ed.readDistTimeCoa());
		System.out.println(ed.readDistTimeCoo());
		System.out.println(ed.readDistTimeShu());*/
		
		//Extraction du fichier Busstops.csv
		ArrayList<String> data = ed.readBusStops();
		
		ArrayList<BusStop> busStopList = new ArrayList<BusStop>();
		for (int i = 0; i < data.size(); i++) {
			busStopList.add(new BusStop(data.get(i)));
		}
		System.out.println(busStopList.toString());
		
		//Extraction du fichier Fleet.csv
		data = ed.readFleet();
		ArrayList<Shuttle> shuttleList = new ArrayList<Shuttle>();
		ArrayList<Coach> coachList = new ArrayList<Coach>();
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).charAt(0) == 'C') 	//identification si on a un bus ou une navette
				coachList.add(new Coach(data.get(i)));
			else
				shuttleList.add(new Shuttle(data.get(i)));
		}
		System.out.println("================================================");
		System.out.println(coachList.toString());
		System.out.println("================================================");
		System.out.println(shuttleList.toString());
		
		//Extraction du fichier DistanceTimesData_COACHES.csv
		data = ed.readDistTimeCoa();
		System.out.println("Longueur = " + data.size());
		DistanceTime matCoach[][] = new DistanceTime[data.size()][data.size()]; //Declaration de la matrice dist/temp pour les bus
																				//c'est une matrice d'objets contenants la distance et le temps
		for (int i = 0; i < matCoach.length; i++) {
			String [] dataRow = data.get(i).split(";");
			for (int j = 0; j < matCoach[i].length; j++) {
				matCoach[i][j] = new DistanceTime(dataRow[j*2], dataRow[j*2+1]); //On stocke la distance et le temps entre les points i et j
			}
		}
	}

}
