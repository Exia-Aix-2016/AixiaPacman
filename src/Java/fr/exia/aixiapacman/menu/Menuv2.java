package fr.exia.aixiapacman.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menuv2 extends JPanel{ 
	JPanel boutonPane = new JPanel();
	JButton boutonSolo = new JButton("Solo");
	JButton boutonQuitter = new JButton("Quitter");
	JButton boutonRetour = new JButton("Retour");
	private Fenetre fen;
	
	  public void paintComponent(Graphics g){
		  Image img;
		try {
			InputStream in = getClass().getResourceAsStream("menu.jpg");
			img = ImageIO.read(in);
			g.setColor(getBackground());
			g.fillRect(0, 0, getWidth(), getHeight());
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		  	Font font = new Font("showcard gothic", Font.BOLD, 50);
		  	g.setFont(font);
		  	g.setColor(Color.red);
		  	g.drawString("PACMAN AIXIA", 570, 195);
		  	
		  	Font font2 = new Font("papyrus", Font.ITALIC, 100);
		  	boutonSolo.setBounds(575, 300, 400, 200);
			this.add(boutonSolo);
			boutonSolo.setVisible(true);
			boutonSolo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					// Faire pacman Solo
				}
			});
			boutonSolo.setFont(font2);
			boutonSolo.setForeground(Color.RED);
			boutonSolo.setOpaque(false);
			boutonSolo.setContentAreaFilled(false);
			boutonSolo.setBorderPainted(false);
		  	
			
			boutonQuitter.setBounds(475, 700, 600, 200);
			this.add(boutonQuitter);
			boutonQuitter.setVisible(true);
			boutonQuitter.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					System.exit(0);
				}
			});
			boutonQuitter.setFont(font2);
			boutonQuitter.setForeground(Color.RED);
			boutonQuitter.setOpaque(false);
			boutonQuitter.setContentAreaFilled(false);
			boutonQuitter.setBorderPainted(false);
		  	
		  	
		  	boutonRetour.setBounds(575, 500, 400, 200);
			this.add(boutonRetour);
			boutonRetour.setVisible(true);
			Menuv2 self = this;
			boutonRetour.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					self.fen.menu1();
				}
			});
			boutonRetour.setFont(font2);
			boutonRetour.setForeground(Color.RED);
			boutonRetour.setOpaque(false);
		  	boutonRetour.setContentAreaFilled(false);
		  	boutonRetour.setBorderPainted(false);
	  }
	  public Menuv2(Fenetre fen) {
			super();
			this.fen = fen;
		}  
}
