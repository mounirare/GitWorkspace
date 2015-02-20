package com.metaheuristique.Gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.metaheuristique.challenge.BusStop;
import com.metaheuristique.challenge.Coach;
import com.metaheuristique.challenge.Shuttle;

public class Graphic extends JFrame{
	private ArrayList<BusStop> busStopList;
	private ArrayList<Coach> coachList;
	private ArrayList<Shuttle> shuttleList;
	private JPanel fond;
	private int width, height;

	public Graphic(String title, ArrayList<BusStop> bsl, ArrayList<Coach> cl, ArrayList<Shuttle> sl){
		setTitle(title);
		this.busStopList = bsl;
		this.coachList = cl;
		this.shuttleList = sl;
		
		int twidth = 0, theight = 0;
		for (int i = 0; i < busStopList.size(); i++) {
			if(busStopList.get(i).getPosY() > theight)
				theight = (int)busStopList.get(i).getPosY();
			if(busStopList.get(i).getPosX() > twidth)
				twidth = (int)busStopList.get(i).getPosX();
		}
		
		for (int i = 0; i < shuttleList.size(); i++) {
			if(shuttleList.get(i).getPosY() > theight)
				theight = (int)shuttleList.get(i).getPosY();
			if(shuttleList.get(i).getPosX() > twidth)
				twidth = (int)shuttleList.get(i).getPosX();
		}
		
		for (int i = 0; i < coachList.size(); i++) {
			if(coachList.get(i).getPosY() > theight)
				theight = (int)coachList.get(i).getPosY();
			if(coachList.get(i).getPosX() > twidth)
				twidth = (int)coachList.get(i).getPosX();
		}
		width = twidth;
		height = theight;
		representation();
		
	}

	public void representation(){
		fond = new JPanel();
		fond.setBackground(Color.YELLOW);
		setSize(width*50+20, height*50+20);
		setResizable(false);
		DrawComponentsPanel image = new DrawComponentsPanel(busStopList, coachList, shuttleList, width, height);
		fond.add(image);
		this.add(fond);
		this.setVisible(true);
	}

	private void ajouterBus(float posX, float posY, ImageIcon image) {
		//Graphics g = new graphics();
		//fond.add(image);
	}
}
