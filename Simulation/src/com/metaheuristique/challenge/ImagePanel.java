package com.metaheuristique.challenge;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private BufferedImage image;
	private int posX, posY;
	private ImageIcon ic;
	
	public ImagePanel() {
		ic = new ImageIcon("Exemple/bus.png");
	}
	
	public ImagePanel(int posX, int posY) {
		this.posX = posX;
		this.posY = posX;
		ic = new ImageIcon("Exemple/bus.png");
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ic.paintIcon(this, g, posX, posY);
	}
}
