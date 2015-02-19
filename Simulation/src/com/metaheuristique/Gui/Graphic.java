package com.metaheuristique.Gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.metaheuristique.challenge.BusStop;
import com.metaheuristique.challenge.Coach;

public class Graphic extends JFrame{
	private ArrayList<BusStop> busStopList;
	private ArrayList<Coach> CoachList;
	private JPanel fond;
	private int width, height;

	public Graphic(String title, ArrayList<BusStop> busStopList, ArrayList<Coach> coachList){
		setTitle(title);
		this.busStopList = busStopList;
		this.CoachList = coachList;
		
		int twidth = 0, theight = 0;
		for (int i = 0; i < busStopList.size(); i++) {
			if(busStopList.get(i).getPosY() > theight)
				theight = (int)busStopList.get(i).getPosY();
			if(busStopList.get(i).getPosX() > twidth)
				twidth = (int)busStopList.get(i).getPosX();
		}
		width = twidth;
		height = theight;
		representation();
		
	}

	public void representation(){
		fond = new JPanel();
		fond.setBackground(Color.white);
		setSize(width*50+20, height*50+20);
		setResizable(false);
		DrawComponentsPanel image = new DrawComponentsPanel(busStopList, CoachList, width, height);
		fond.add(image);
		this.add(fond);
		this.setVisible(true);
	}

	private void ajouterBus(float posX, float posY, ImageIcon image) {
		//Graphics g = new graphics();
		//fond.add(image);
	}
}
