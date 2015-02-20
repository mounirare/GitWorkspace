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
import com.metaheuristique.challenge.Shuttle;

public class DrawComponentsPanel extends JPanel {
	private ArrayList<BusStop> busStopList;
	private ArrayList<Coach> CoachList;
	private ArrayList<Shuttle> shuttleList;
	private int posX, posY;
	private ImageIcon icBusStop;
	private ImageIcon icCoach;
	private ImageIcon icShuttle;
	private Image imgBusStop; 
	private Image imgCoach; 
	private Image imgShuttle; 
	
	public DrawComponentsPanel(ArrayList<BusStop> bsl, ArrayList<Coach> cl, ArrayList<Shuttle> sl, int _posX, int _posY) {
		this.icBusStop = new ImageIcon("Exemple/bus.png");
		this.imgBusStop = icBusStop.getImage(); 
		this.icCoach = new ImageIcon("Exemple/tr-bus.png");
		this.imgCoach = icBusStop.getImage();
		this.icShuttle = new ImageIcon("Exemple/tr-shu.png");
		this.imgShuttle = icShuttle.getImage();
		
		
		busStopList = bsl;
		CoachList = cl;
		shuttleList = sl;
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
		
		for(int i = 0; i < shuttleList.size(); i++){
			int x = (int) (shuttleList.get(i).getPosX());
			int y = (int) (shuttleList.get(i).getPosY());
			//g.drawImage(img, x*50, y*50, null);
			this.icShuttle.paintIcon(this, g, x*50, y*50);
		}
		
	}

}