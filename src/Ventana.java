
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	public Ventana(){
		
		this.setVisible(true);
		this.setSize(700, 600);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.black);
		
		JPanel splash = new JPanel();
		splash.setSize(700,600);
		splash.setLayout(null);
		ImageIcon splashGif= new ImageIcon("splash.gif");
		JLabel splashLogo= new JLabel(splashGif);
		splashLogo.setSize(700,600);
		splashLogo.setLocation(0,0);
		splash.add(splashLogo);
		this.add(splash);
		
		
		
		
		JPanel login = new JPanel();
		login.setLayout(null);
		login.setSize(700,600);
		JLabel labelUsuario = new JLabel("usuario:");
		JLabel labelContrasena = new JLabel("contraseña:");
		login.add(labelContrasena);
		login.add(labelUsuario);
		labelUsuario.setSize(60,20);
		labelUsuario.setLocation(160,300);
		labelContrasena.setSize(80,20);
		labelContrasena.setLocation(160,360);
		TextField tfUsuario = new TextField();
		tfUsuario.setSize(120,30);
		tfUsuario.setLocation(300,300);
		TextField tfContrasena = new TextField();
		tfContrasena.setSize(120,30);
		tfContrasena.setLocation(300,360);
		login.setBackground(Color.decode("#6BCCE4"));
		ImageIcon aceptar = new ImageIcon("aceptar.png");
		ImageIcon cancelar = new ImageIcon("cancelar.png");
		JButton acept=new JButton(aceptar);
		acept.setLocation(240,380);
		acept.setSize(60,15);
		JButton cancel=new JButton(cancelar);
		cancel.setLocation(300,380);
		cancel.setSize(60,15);
		login.add(acept);
		login.add(cancel);
		login.add(tfContrasena);
		login.add(tfUsuario);
		
		Timer timer = new Timer();
		
		TimerTask remueveSplash = new TimerTask() {

			@Override
			public void run() {
				remove(splash);
				add(login);
				revalidate();
				repaint();
			}};
		timer.schedule(remueveSplash,4*1000,1000);
		this.revalidate();
		this.repaint();	
	}
	
//	public void paint(Graphics g) {
//		super.paint(g);
//		//NUBES
//		g.setColor(Color.decode("#FFFFFF"));
//		g.fillRoundRect(250, 375, 190, 45, 64 , 92);
//		
//	}
}