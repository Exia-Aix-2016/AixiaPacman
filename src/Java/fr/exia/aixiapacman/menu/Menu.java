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
import javax.swing.JLabel;

public class Menu extends JPanel{ 
		public JLabel label = new JLabel("JLabel");
		JButton boutonJouer = new JButton("Jouer");
		JButton boutonQuitter = new JButton("Quitter");
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
			
			this.setLayout(null);
			boutonJouer.setBounds(600, 300, 350, 200);
			this.add(boutonJouer);
			boutonJouer.setVisible(true);
			Menu self = this;
			boutonJouer.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					self.fen.menu2();
				}
			});
		  	Font font2 = new Font("papyrus", Font.ITALIC, 100);
		  	boutonJouer.setFont(font2);
		  	boutonJouer.setForeground(Color.RED);
		  	boutonJouer.setOpaque(false);
		  	boutonJouer.setContentAreaFilled(false);
		  	boutonJouer.setBorderPainted(false);
		  	

		    boutonQuitter.setBounds(575, 725, 400, 200);
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
	  }
	public Menu(Fenetre fen) {
		super();
		this.fen = fen;
	}  
}
