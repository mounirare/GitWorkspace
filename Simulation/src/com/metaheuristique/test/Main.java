package com.metaheuristique.test;

import com.metaheuristique.utils.Coordinates;
import com.metaheuristique.utils.ExtractData;
import com.metaheuristique.utils.Fichier;

public class Main {

	public static void main(String[] args) {
		/*Fichier fichier = new Fichier();
		String montext = "Bonjour les amis.\nBon travail.";
		fichier.ecriture("test.txt", montext);
		fichier.ajout("test.txt", "Hello");
		System.out.println(fichier.lecture("test.txt"));*/
		
		ExtractData ed = new ExtractData();
		Coordinates c = new Coordinates(ed.readDistTimeCoo());
		Fichier fichier = new Fichier();
		String montext = "Bonjour les amis.\nBon travail.";
		fichier.ecriture("toto.txt", montext);
		
		System.out.println(c.getIndex(7, 6));
	}

}
