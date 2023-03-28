
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Ventana extends JFrame{
	public Ventana(){
		
		this.setVisible(true);
		this.setSize(700, 500);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.black);
		
		JPanel splash = new JPanel();
		splash.setSize(700,500);
		splash.setLayout(null);
		ImageIcon splashGif= new ImageIcon("splash.gif");
		JLabel splashLogo= new JLabel(splashGif);
		splashLogo.setSize(700,600);
		splashLogo.setLocation(0,0);
		splash.add(splashLogo);
		this.add(splash);
		
		
		

		JPanel login = new JPanel();
		login.setLayout(null);
		login.setSize(700,500);
		
		JLabel labelUsuario = new JLabel("Nombre de usuario:");
		JLabel labelContrasena = new JLabel("Contraseña de acceso:");
		login.add(labelContrasena);
		login.add(labelUsuario);
		labelUsuario.setSize(220,20);
		labelUsuario.setLocation(60,280);
		labelUsuario.setFont(new Font("Cambria", Font.BOLD, 20));
		labelContrasena.setSize(220,20);
		labelContrasena.setLocation(60,340);
		labelContrasena.setFont(new Font("Cambria", Font.BOLD, 20));
		TextField tfUsuario = new TextField();
		tfUsuario.setSize(240,30);
		tfUsuario.setLocation(300,280);
		JPasswordField tfContrasena = new JPasswordField();
		tfContrasena.setSize(240,30);
		tfContrasena.setLocation(300,340);
		login.setBackground(Color.decode("#6BCCE4"));

		ImageIcon imagenUsuario = new ImageIcon("user.png");
		JLabel imgUsr = new JLabel(imagenUsuario);
		imgUsr.setSize(180,158);
		imgUsr.setLocation(270,60);
				
		ImageIcon aceptar = new ImageIcon("aceptar.png");
		ImageIcon cancelar = new ImageIcon("cancelar.png");
		
		JButton acept=new JButton(aceptar);
		acept.setLocation(350,410);
		acept.setSize(120,35);
		acept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("x");
			}});
		JButton cancel=new JButton(cancelar);
		cancel.setLocation(150,410);
		cancel.setSize(120,35);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("x");
			}});
		
		login.add(acept);
		login.add(cancel);
		login.add(tfContrasena);
		login.add(tfUsuario);
		login.add(imgUsr);
		
		JPanel menuPrincipal = new JPanel();
		menuPrincipal.setVisible(true);
		menuPrincipal.setSize(700, 500);
		menuPrincipal.setBackground(Color.decode("#6BCCE4"));
		
		JMenuBar menuBarraUsuario = new JMenuBar();
		
		JMenu menuCuenta = new JMenu("Cuenta");
		menuBarraUsuario.add(menuCuenta);
		
		JMenu menuUsuario = new JMenu("Usuario");
		menuBarraUsuario.add(menuUsuario);
		
		JMenu menuAyuda = new JMenu("Ayuda");
		menuBarraUsuario.add(menuAyuda);
		
		JMenuItem miCuenta = new JMenuItem("Mi Cuenta");
		menuCuenta.add(miCuenta);
		
		JMenuItem mCerrarSesion = new JMenuItem("Cerrar Sesion");
		menuCuenta.add(mCerrarSesion);
		
		JMenuItem mListaUsuario = new JMenuItem("Lista de Usuarios");
		menuUsuario.add(mListaUsuario);
		
		JMenuItem mCrearUsuario = new JMenuItem("Crear Usuario");
		menuUsuario.add(mCrearUsuario);
		
		JMenuItem mAyuda = new JMenuItem("¿como creo un usuario?");
		menuAyuda.add(mAyuda);
		
		
		
		Timer timer = new Timer();
		
		TimerTask remueveSplash = new TimerTask() {

			@Override
			public void run() {
				remove(splash);
				add(menuPrincipal);
				setJMenuBar(menuBarraUsuario);
				revalidate();
				repaint();
				timer.cancel();
			}};
		timer.schedule(remueveSplash,4*1000,1000);
		
		this.revalidate();
		this.repaint();	
	
	
	}
}