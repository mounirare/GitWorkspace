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
	private float width, height, minWidth, minHeight;

	public Graphic(String title, ArrayList<BusStop> bsl, ArrayList<Coach> cl, ArrayList<Shuttle> sl){
		setTitle(title);
		this.busStopList = bsl;
		this.coachList = cl;
		this.shuttleList = sl;
		float minW = 100, minH = 100;
		
		float twidth = 0, theight = 0;
		for (int i = 0; i < busStopList.size(); i++) {
			if(busStopList.get(i).getPosY() > theight)
				theight = busStopList.get(i).getPosY();
			if(busStopList.get(i).getPosX() > twidth)
				twidth = busStopList.get(i).getPosX();
			if(busStopList.get(i).getPosY() < minH)
				minH = busStopList.get(i).getPosY();
			if(busStopList.get(i).getPosX() < minW)
				minW = busStopList.get(i).getPosX();
		}
		
		for (int i = 0; i < shuttleList.size(); i++) {
			if(shuttleList.get(i).getPosY() > theight)
				theight = shuttleList.get(i).getPosY();
			if(shuttleList.get(i).getPosX() > twidth)
				twidth = shuttleList.get(i).getPosX();
			if(shuttleList.get(i).getPosY() < minH)
				minH = shuttleList.get(i).getPosY();
			if(shuttleList.get(i).getPosX() < minW)
				minW = shuttleList.get(i).getPosX();
		}
		
		for (int i = 0; i < coachList.size(); i++) {
			if(coachList.get(i).getPosY() > theight)
				theight = coachList.get(i).getPosY();
			if(coachList.get(i).getPosX() > twidth)
				twidth = coachList.get(i).getPosX();
			if(coachList.get(i).getPosY() < minH)
				minH = coachList.get(i).getPosY();
			if(coachList.get(i).getPosX() < minW)
				minW = coachList.get(i).getPosX();
		}
		minWidth = minW;
		minHeight = minH;
		width = twidth;
		height = theight;
		System.out.println("minw : " + minW);
		System.out.println("minh : " + minH);
		representation();
		
	}

	public void representation(){
		fond = new JPanel();
		fond.setBackground(Color.YELLOW);
		float ratio = 60;
		setSize(1370, 740);
		setResizable(false);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		if((this.getSize().width/width) > (this.getSize().width/height))
			ratio = 740 / (height - minHeight);
		else
			ratio = this.getSize().width / (width - minWidth);
		
		System.out.println("Ratio : " + ratio);
		System.out.println("maxw : " + width);
		System.out.println("maxh : " + height);
		//ratio = 50;
		ratio = ratio * 9/10;
		DrawComponentsPanel image = new DrawComponentsPanel(busStopList, coachList, shuttleList, width, height, minWidth, minHeight, ratio);
		fond.add(image);
		this.add(fond);
		this.setVisible(true);
	}

	private void ajouterBus(float posX, float posY, ImageIcon image) {
		//Graphics g = new graphics();
		//fond.add(image);
	}
}
