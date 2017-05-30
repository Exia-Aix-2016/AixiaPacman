package fr.exia.aixiapacman.menu;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	JPanel container = new JPanel();
	int selection = 0;
	Menu menu;
	Menuv2 menuv2;
	public Fenetre(){
	    this.setTitle("PacMan AixiA");
	    this.setSize(1500, 1000);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    this.menu = new Menu(this);
	    this.menuv2 = new Menuv2(this);
	    
	    this.setContentPane(this.menu);
	    this.setVisible(true);
	}
	public void menu1(){
		this.setContentPane(this.menu);
	    this.setVisible(true);
	}
	public void menu2(){
		this.setContentPane(menuv2);
	    this.setVisible(true);
	}
}