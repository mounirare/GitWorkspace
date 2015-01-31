package com.metaheuristique.test;

import com.metaheuristique.utils.Fichier;

public class Main {

	public static void main(String[] args) {
		Fichier fichier = new Fichier();
		String montext = "Bonjour les amis.\nBon travail.";
		fichier.ecriture("test.txt", montext);
		fichier.ajout("test.txt", "Hello");
		System.out.println(fichier.lecture("test.txt"));
		System.out.println("Test 1");
	}

}
