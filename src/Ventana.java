
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
import javax.swing.JTextField;

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
		
		Font fuenteMed = (new Font("Calibri", Font.BOLD, 20));
		
		JPanel login = new JPanel();
		login.setLayout(null);
		login.setSize(700,500);
		login.setBackground(Color.decode("#6BCCE4"));
		
		JLabel labelUsuario = new JLabel("Nombre de usuario:");
		JLabel labelContrasena = new JLabel("Contraseña de acceso:");
		labelUsuario.setSize(220,20);
		labelUsuario.setLocation(60,280);
		labelUsuario.setFont(fuenteMed);
		labelContrasena.setSize(220,20);
		labelContrasena.setLocation(60,340);
		labelContrasena.setFont(fuenteMed);
		TextField tfUsuario = new TextField();
		tfUsuario.setSize(240,30);
		tfUsuario.setLocation(300,280);
		JPasswordField tfContrasena = new JPasswordField();
		tfContrasena.setSize(240,30);
		tfContrasena.setLocation(300,340);
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
		login.add(labelContrasena);
		login.add(labelUsuario);
		login.add(acept);
		login.add(cancel);
		login.add(tfContrasena);
		login.add(tfUsuario);
		login.add(imgUsr);
		
		
		
		JPanel modificarUsuario = new JPanel();
		modificarUsuario.add(imgUsr);
		
		
		
		JPanel menuPrincipal = new JPanel();
		menuPrincipal.setVisible(true);
		menuPrincipal.setSize(700, 500);
		menuPrincipal.setLayout(null);
		JLabel imgUsr2= new JLabel(imagenUsuario);
		imgUsr2.setSize(180,158);
		imgUsr2.setLocation(60,120);
		menuPrincipal.add(imgUsr2);
		String strUsuario="";
		JLabel saludo= new JLabel("Hola"+strUsuario);
		saludo.setSize(60,20);
		saludo.setLocation(260,160);
		saludo.setFont(fuenteMed);
		menuPrincipal.add(saludo);
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
		
		JPanel menuMiCuenta = new JPanel();
		menuMiCuenta.setVisible(true);
		menuMiCuenta.setLayout(null);
		menuMiCuenta.setSize(700, 500);
		menuMiCuenta.setBackground(Color.decode("#6BCCE4"));
		
		JLabel nombre = new JLabel("Nombre: ");
		nombre.setSize(150, 50);
		nombre.setLocation(50, 100);
		nombre.setFont(fuenteMed);
		JLabel apellido = new JLabel("Apellido: ");
		apellido.setSize(150, 50);
		apellido.setLocation(50, 150);
		apellido.setFont(fuenteMed);
		JLabel email = new JLabel("Email: ");
		email.setSize(150, 50);
		email.setLocation(50, 200);
		email.setFont(fuenteMed);
		JLabel contraseña = new JLabel("Contraseña: ");
		contraseña.setSize(150, 50);
		contraseña.setLocation(50, 250);
		contraseña.setFont(fuenteMed);
		JLabel micuenta = new JLabel("Mi Cuenta Personal");
		micuenta.setSize(200, 50);
		micuenta.setLocation(420, 50);
		micuenta.setFont(fuenteMed);
		JLabel imgUsr3= new JLabel(imagenUsuario);
		imgUsr3.setSize(180,158);
		imgUsr3.setLocation(410,120);
		
		JTextField campoNombre = new JTextField();
		campoNombre.setSize(200, 40);
		campoNombre.setLocation(150, 100);
		JTextField campoApellido = new JTextField();
		campoApellido.setSize(200, 40);
		campoApellido.setLocation(150, 150);
		JTextField campoEmail = new JTextField();
		campoEmail.setSize(200, 40);
		campoEmail.setLocation(150, 200);
		JPasswordField campoContraseña = new JPasswordField();
		campoContraseña.setSize(200, 40);
		campoContraseña.setLocation(150, 250);
		
		JButton cancel1 = new JButton("cancelar");
		cancel1.setSize(100, 35);
		cancel1.setLocation(100, 330);
		
		JButton aceptar1 = new JButton("aceptar");
		aceptar1.setSize(100, 35);
		aceptar1.setLocation(250, 330);
		
		menuMiCuenta.add(nombre);
		menuMiCuenta.add(apellido);
		menuMiCuenta.add(email);
		menuMiCuenta.add(contraseña);
		menuMiCuenta.add(micuenta);
		menuMiCuenta.add(imgUsr3);
	
		menuMiCuenta.add(campoNombre);
		menuMiCuenta.add(campoApellido);
		menuMiCuenta.add(campoEmail);
		menuMiCuenta.add(campoContraseña);
		
		menuMiCuenta.add(cancel1);
		menuMiCuenta.add(aceptar1);
		
		Timer timer = new Timer();
		
		TimerTask remueveSplash = new TimerTask() {

			@Override
			public void run() {
				remove(splash);
				add(menuMiCuenta);
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