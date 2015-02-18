package com.metaheuristique.challenge;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphic extends JFrame{
	private ArrayList<BusStop> busStopList;
	private JPanel fond;
	private int width, height;

	public Graphic(String title, ArrayList<BusStop> busStopList){
		setTitle(title);
		this.busStopList = busStopList;
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
		this.setVisible(true);
	}

	public void representation(){
		fond = new JPanel();
		setSize(width*50, height*50);
		BufferedImage myPicture;

		for(int i = 0; i < busStopList.size(); i++){
			int x = (int) (busStopList.get(i).getPosX());
			int y = (int) (busStopList.get(i).getPosY());
			ImagePanel image = new ImagePanel(x, y);
			image.paint(getGraphics());
			fond.add(image);
		}

		this.add(fond);
	}

	private void ajouterBus(float posX, float posY, ImageIcon image) {
		//Graphics g = new graphics();
		//fond.add(image);
	}
}
