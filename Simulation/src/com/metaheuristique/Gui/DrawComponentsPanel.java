package com.metaheuristique.Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.metaheuristique.challenge.BusStop;
import com.metaheuristique.challenge.Coach;

public class DrawComponentsPanel extends JPanel {
	private ArrayList<BusStop> busStopList;
	private ArrayList<Coach> CoachList;
	private int posX, posY;
	private ImageIcon icBusStop;
	private ImageIcon icCoach;
	private Image imgBusStop; 
	private Image imgCoach; 
	
	public DrawComponentsPanel(ArrayList<BusStop> bsl, ArrayList<Coach> cl, int _posX, int _posY) {
		this.icBusStop = new ImageIcon("Exemple/bus.png");
		this.imgBusStop = icBusStop.getImage(); 
		this.icCoach = new ImageIcon("Exemple/tr-bus.png");
		this.imgCoach = icBusStop.getImage(); 
		
		busStopList = bsl;
		CoachList = cl;
		this.posX = _posX;
		this.posY = _posY;
		
		Dimension size = new Dimension(posX*50, posY*50); 
		setPreferredSize(size); 
		setMinimumSize(size); 
		setMaximumSize(size);
		setBackground(Color.white);
		setSize(size); 
		setLayout(null);
	}
	
	public void paintComponent(Graphics g){ 
		for(int i = 0; i < CoachList.size(); i++){
			int x = (int) (CoachList.get(i).getPosX());
			int y = (int) (CoachList.get(i).getPosY());
			//g.drawImage(img, x*50, y*50, null);
			this.icCoach.paintIcon(this, g, x*50, y*50);
		}
		
		for(int i = 0; i < busStopList.size(); i++){
			int x = (int) (busStopList.get(i).getPosX());
			int y = (int) (busStopList.get(i).getPosY());
			//g.drawImage(img, x*50, y*50, null);
			this.icBusStop.paintIcon(this, g, x*50, y*50);
		}
		
	}

}