package com.metaheuristique.Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.metaheuristique.challenge.BusStop;
import com.metaheuristique.challenge.Coach;
import com.metaheuristique.challenge.Shuttle;

public class DrawComponentsPanel extends JPanel {
	private ArrayList<BusStop> busStopList;
	private ArrayList<Coach> CoachList;
	private ArrayList<Shuttle> shuttleList;
	private float posX, posY, minw, minh;
	private ImageIcon icBusStop;
	private ImageIcon icCoach;
	private ImageIcon icShuttle;
	private Image imgBusStop; 
	private Image imgCoach; 
	private Image imgShuttle;
	private float ratio;
	
	public DrawComponentsPanel(ArrayList<BusStop> bsl, ArrayList<Coach> cl, ArrayList<Shuttle> sl, float _posX, float _posY, float minw, float minh, float ratio) {
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
		this.minw = minw;
		this.minh = minh;
		this.ratio = ratio;
		
		Dimension size = new Dimension(1360, 710); 
		setPreferredSize(size); 
		//setMinimumSize(size); 
		//setMaximumSize(size);
		//setBackground(Color.WHITE);
		//setSize(size); 
		//setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(null);
	}
	
	public void paintComponent(Graphics g){ 
				
		for(int i = 0; i < busStopList.size(); i++){
			float x = busStopList.get(i).getPosX();
			float y = busStopList.get(i).getPosY();
			
			this.icBusStop.paintIcon(this, g, (int)((x-minw)*ratio), (int)((y-minh)*ratio));
			//System.out.println("pos(" + x  + ";" + y + ")");
		}
		
		for(int i = 0; i < shuttleList.size(); i++){
			float x = shuttleList.get(i).getPosX();
			float y = shuttleList.get(i).getPosY();
			this.icShuttle.paintIcon(this, g, (int)((x-minw)*ratio), (int)((y-minh)*ratio));
			//System.out.println("pos(" + (x-minw)*ratio  + ";" + (y-minh)*ratio + ")");
		} 
		
		for(int i = 0; i < CoachList.size(); i++){
			float x = CoachList.get(i).getPosX();
			float y = CoachList.get(i).getPosY();
			this.icCoach.paintIcon(this, g, (int)((x-minw)*ratio), (int)((y-minh)*ratio));
			//System.out.println("pos(" + x  + ";" + y + ")");
		}
		this.icShuttle.paintIcon(this, g, 10, 10);
	}

}