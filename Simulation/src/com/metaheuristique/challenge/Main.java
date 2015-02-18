package com.metaheuristique.challenge;

import java.util.ArrayList;

import com.metaheuristique.utils.Coordinates;
import com.metaheuristique.utils.DistanceTime;
import com.metaheuristique.utils.ExtractData;
import com.metaheuristique.utils.Fichier;
/// merci de commenter
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
		Coordinates coordinates = new Coordinates(ed.readDistTimeCoo());
		
		ArrayList<String> busStopData = ed.readBusStops();
		
		ArrayList<BusStop> busStopList = new ArrayList<BusStop>();
		for (int i = 0; i < busStopData.size(); i++) {
			busStopList.add(new BusStop(busStopData.get(i), coordinates));
		}
		System.out.println(busStopList.toString());
		
		//Extraction du fichier Fleet.csv
		ArrayList<String> feetData = ed.readFleet();
		ArrayList<Shuttle> shuttleList = new ArrayList<Shuttle>();
		ArrayList<Coach> coachList = new ArrayList<Coach>();
		for (int i = 0; i < feetData.size(); i++) {
			if(feetData.get(i).charAt(0) == 'C') 	//identification si on a un bus ou une navette
				coachList.add(new Coach(feetData.get(i), coordinates));
			else
				shuttleList.add(new Shuttle(feetData.get(i), coordinates));
		}
		
		// Ajout des elements dans les listes
		for (int i = 0; i < coachList.size(); i++) {
			for (int j = 0; j < 3; j++) {
				int id = (int) (Math.random() * busStopList.size());
				coachList.get(i).getBusStopTraveled().add(busStopList.get(id).getIdBusStop());
			}
		}
		
		for (int i = 0; i < shuttleList.size(); i++) {
			for (int j = 0; j < 3; j++) {
				int id = (int) (Math.random() * busStopList.size());
				shuttleList.get(i).getBusStopTraveled().add(busStopList.get(id).getIdBusStop());
			}
		}
		
		System.out.println("================================================");
		System.out.println(coachList.toString());
		System.out.println("================================================");
		System.out.println(shuttleList.toString());
		
		//Extraction du fichier DistanceTimesData_COACHES.csv
		ArrayList<String> distTimeCoaData = ed.readDistTimeCoa();
		System.out.println("Longueur = " + distTimeCoaData.size());
		DistanceTime matCoach[][] = new DistanceTime[distTimeCoaData.size()][distTimeCoaData.size()]; //Declaration de la matrice dist/temp pour les bus
																				//c'est une matrice d'objets contenants la distance et le temps
		for (int i = 0; i < matCoach.length; i++) {
			String [] dataRow = distTimeCoaData.get(i).split(";");
			for (int j = 0; j < matCoach[i].length; j++) {
				matCoach[i][j] = new DistanceTime(dataRow[j*2], dataRow[j*2+1]); //On stocke la distance et le temps entre les points i et j
			}
		}
		
		System.out.println("================================================");
		for(int i=0; i<matCoach.length; i++){
			for(int j=0; j<matCoach.length; j++){
				System.out.print(matCoach[i][j].toString()+" ");
			}
			System.out.println("");
		}
		DistanceTime matShut[][] = new DistanceTime[distTimeCoaData.size()][distTimeCoaData.size()];
		/*ArrayList<String> distancetimeCoord = ed.readDistTimeCoo();
		
		for(int i=0; i<busStopList.size(); i++){
			float posX = Float.parseFloat(distancetimeCoord.get(i).substring(0, 1));
			float posY = Float.parseFloat(distancetimeCoord.get(i).substring(2, 3));
			System.out.println();
		}
		
		
		for(int i=0; i<busStopList.size(); i++){
			System.out.print(busStopList.get(i).getPosX()+";"+busStopList.get(i).getPosY()+", ");
		}*/
		
		Population pop = new Population(busStopList, coachList, shuttleList, matCoach, matShut);
		Solution sol = pop.calculSol();
		sol.enregistrement();
		
		Graphic graphic = new Graphic("Carte", busStopList);
	}

}
