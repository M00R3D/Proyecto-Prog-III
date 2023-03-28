
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

public class Ventana extends JFrame{
	private Font fuenteChic = (new Font("Calibri", Font.BOLD, 15));
	private Font fuenteMed = (new Font("Calibri", Font.BOLD, 20));
	private Font fuenteGran = (new Font("Calibri", Font.BOLD, 32));
	private ImageIcon imagenUsuario = new ImageIcon("user.png");
	private ImageIcon aceptar = new ImageIcon("aceptar.png");
	private ImageIcon cancelar = new ImageIcon("cancelar.png");
	private String actual = "panelSplash";
	private String anterior = "panelSplash";
	private JPanel gran_panel = null;
	private String usuarioActual ="";
	private String texoGuardado  ="";
	private int noUsuarios;
	private String n;
	private String a;
	private String m;
	private String p;

	
	
	public Ventana(){
		
		this.setVisible(true);
		this.setSize(700, 500);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.black);
		
		
		
		this.route();

		}
		
	public JMenuBar menuBarraUsuario() {
		JMenuBar menuBarraUsuario = new JMenuBar();
		JMenu menuCuenta = new JMenu("Cuenta");
		menuBarraUsuario.add(menuCuenta);
		JMenu menuUsuario = new JMenu("Usuario");
		menuBarraUsuario.add(menuUsuario);
		JMenu menuAyuda = new JMenu("Ayuda");
		menuBarraUsuario.add(menuAyuda);
		JMenuItem miCuenta = new JMenuItem("Mi Cuenta");
		menuCuenta.add(miCuenta);
		miCuenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				anterior = actual;
				actual = "panelMiCuenta";
				setJMenuBar(menuBarraUsuario());
				route();				
			}});
		JMenuItem mCerrarSesion = new JMenuItem("Cerrar Sesion");
		mCerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				anterior = actual;
				actual = "panelSplash";
				setJMenuBar(null);
				route();
			}});
		menuCuenta.add(mCerrarSesion);
		JMenuItem mListaUsuario = new JMenuItem("Lista de Usuarios");
		mListaUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				anterior = actual;
				actual = "panelTabla";
				route();
				
			}});
		menuUsuario.add(mListaUsuario);
		JMenuItem mpanelUsuario = new JMenuItem("Crear Usuario");
		mpanelUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				anterior = actual;
				actual = "panelUsuario";
				route();
				
				
			}});
		menuUsuario.add(mpanelUsuario);
		JMenuItem mAyuda = new JMenuItem("¿como creo un usuario?");
		mAyuda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				anterior = actual;
				actual = "panelAyuda";
				route();
				
				
			}});
		menuAyuda.add(mAyuda);
		return menuBarraUsuario;
	}
	
	
	
	
	public void route() {

		if(gran_panel!=null) {
			this.remove(gran_panel);
		}

		if(actual.equals("panelSplash")) { 
			gran_panel = panelSplash();  
		}
		if(actual.equals("panelLogin")) { 
			gran_panel = panelLogin();  
		}
		if(actual.equals("menuPrincipal")) { 
			gran_panel = menuPrincipal();  
		}
		if(actual.equals("panelMiCuenta")) { 
			gran_panel = panelMiCuenta();  
		}
		if(actual.equals("panelTabla")) { 
			gran_panel = panelTabla();  
		}
		if(actual.equals("panelUsuario")) { 
			gran_panel = panelUsuario();  
		}
		if(actual.equals("panelAyuda")) { 
			gran_panel = panelAyuda();  
		}
		
		this.add(gran_panel);
		this.revalidate();
		this.repaint(); 
	}	
	
	public int totalUsuarios(FileReader fr, BufferedReader br) throws IOException
	{
		noUsuarios = 0;
		while(br.readLine()!=null) {
		noUsuarios++;
		}
		br.close();		
		return noUsuarios;
	} 
	
	public String[] guardarUsuariosTemp() throws IOException 
	{
		FileReader fr = new FileReader("User.txt");
		BufferedReader br = new BufferedReader(fr);
		String[] str = new String[totalUsuarios(fr, br)];
		fr= new FileReader("User.txt");
		br= new BufferedReader(fr);
		int pos=0;
		String dusuario;
		while((dusuario=br.readLine())!=null) {
		String nombreAEditar = usuarioActual;
			if(dusuario.split(",")[0].equalsIgnoreCase(nombreAEditar))
			{
				String nString = (n+","+a+","+m+","+p+"\n");
				str[pos]=nString;
			}else {
				str[pos]=new String(dusuario.split(",")[0]+","+dusuario.split(",")[1]+","+dusuario.split(",")[2]+","+dusuario.split(",")[3]+"\n");
			}
			pos++;
		}
		new PrintWriter("User.txt").write("");
		new PrintWriter("User.txt").close();
		br.close();
		fr.close();
		return str;
	}
	
	public void actualizarDatosUsuario() 
	{
		FileWriter fr=null;
		BufferedWriter bw=null;
		try {
		String[] usrs=guardarUsuariosTemp();
		fr= new FileWriter("User.txt",true);
		bw= new BufferedWriter(fr);
		for (int i=0; i<usrs.length;i++) {
			bw.write(usrs[i]);
		}
		}catch(IOException ex) {
			System.out.println("sadfa");

		}finally {
			try {
			bw.close();
			fr.close();
			}catch(IOException ex) {
				System.out.println("sadfa");
			}
		}
	}
	
		public JPanel panelSplash() {
		
			JPanel panelSplash = new JPanel();
			panelSplash.setSize(700,500);
			panelSplash.setLayout(null);
			ImageIcon splashGif= new ImageIcon("Splash.gif");
			JLabel splashLogo= new JLabel(splashGif);
			splashLogo.setSize(700,600);
			splashLogo.setLocation(0,-74);
			panelSplash.add(splashLogo);
			Timer timer = new Timer();
			TimerTask remueveSplash = new TimerTask() {

				@Override
				public void run() {
					remove(panelSplash);
					anterior = actual;
					actual = "panelLogin";
					route();
					timer.cancel();
				}};
			timer.schedule(remueveSplash,4*1000,1000);
		return panelSplash;
		}
		
		public JPanel panelLogin(){
		JPanel panelLogin = new JPanel();
		panelLogin.setLayout(null);
		panelLogin.setSize(700,500);
		panelLogin.setBackground(Color.decode("#6BCCE4"));
		
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
		JLabel imgUsr = new JLabel(imagenUsuario);
		imgUsr.setSize(180,158);
		imgUsr.setLocation(270,60);
		JButton acept=new JButton(aceptar);
		acept.setLocation(350,410);
		acept.setSize(120,35);
		acept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String email=tfUsuario.getText();
				
				char[] pw =tfContrasena.getPassword();
				String pass = new String(pw);
				
//				System.out.println(email);
//				System.out.println(pass);
				BufferedReader br; 
				try{
					br = new BufferedReader(new FileReader("User.txt"));
					String linea = br.readLine();
					
					while(linea!=null) 
					{
						String[] datos=null;
						datos=linea.split(",");
						if(datos[2].equals(email) &&
								datos[3].equals(pass))
						{
							JOptionPane.showMessageDialog(null,"Bienvenido Usuario");
							anterior = actual;
							actual = "menuPrincipal";
							setJMenuBar(menuBarraUsuario());
							usuarioActual=datos[0];
							route();	
						}
						linea=br.readLine();
					}
				
				}catch(IOException e1)
				{
					e1.printStackTrace();
					
				}
				
						}
					});
		JButton cancel=new JButton(cancelar);
		cancel.setLocation(150,410);
		cancel.setSize(120,35);
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actual = anterior;
				anterior = "panelSplash";
				route();
			}});
		panelLogin.add(labelContrasena);
		panelLogin.add(labelUsuario);
		panelLogin.add(acept);
		panelLogin.add(cancel);
		panelLogin.add(tfContrasena);
		panelLogin.add(tfUsuario);
		panelLogin.add(imgUsr);
		return panelLogin;
		}

		public JPanel menuPrincipal() {
		
			JPanel menuPrincipal = new JPanel();
			menuPrincipal.setVisible(true);
			menuPrincipal.setSize(700, 500);
			menuPrincipal.setLayout(null);
			JLabel imgUsr2= new JLabel(imagenUsuario);
			imgUsr2.setSize(180,158);
			imgUsr2.setLocation(60,120);
			menuPrincipal.add(imgUsr2);
			String strUsuario="Hola "+usuarioActual;
			JLabel saludo= new JLabel(strUsuario);
			saludo.setSize(60,20);
			saludo.setLocation(260,160);
			saludo.setFont(fuenteMed);
			menuPrincipal.add(saludo);
			menuPrincipal.setBackground(Color.decode("#6BCCE4"));
			
		return menuPrincipal;
		
		}
		
		public JPanel panelMiCuenta()
		{
			JPanel panelMiCuenta = new JPanel();
			panelMiCuenta.setVisible(true);
			panelMiCuenta.setLayout(null);
			panelMiCuenta.setSize(700, 500);
			panelMiCuenta.setBackground(Color.decode("#6BCCE4"));
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
			String strMiCuenta=("Cuenta Personal de " + usuarioActual);
			JLabel micuenta = new JLabel(strMiCuenta);
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
			JPasswordField campoContrasena = new JPasswordField();
			campoContrasena.setSize(200, 40);
			campoContrasena.setLocation(150, 250);
			JButton cancel1 = new JButton("Cancelar");
			cancel1.setSize(100, 35);
			cancel1.setLocation(100, 330);
			cancel1.setOpaque(true);
			cancel1.setBackground(Color.decode("#DC143C"));
			cancel1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					actual = anterior;
					anterior = "panelSplash";
					route();
					
					
				}});
			JButton aceptar1 = new JButton("Actualizar");
			aceptar1.setSize(100, 35);
			aceptar1.setLocation(250, 330);
			aceptar1.setOpaque(true);
			aceptar1.setBackground(Color.decode("#32CD32"));
			aceptar1.addActionListener(new ActionListener() {


				@Override
				public void actionPerformed(ActionEvent e) {
					n=campoNombre.getText();
					a=campoApellido.getText();
					m=campoEmail.getText();
					char[] pas=campoContrasena.getPassword();
					p=new String(pas);
					actualizarDatosUsuario();
					JOptionPane.showMessageDialog(null,"Usuario actualizado correctamente");
					usuarioActual=n;
				}});
			panelMiCuenta.add(nombre);
			panelMiCuenta.add(apellido);
			panelMiCuenta.add(email);
			panelMiCuenta.add(contraseña);
			panelMiCuenta.add(micuenta);
			panelMiCuenta.add(imgUsr3);
			panelMiCuenta.add(campoNombre);
			panelMiCuenta.add(campoApellido);
			panelMiCuenta.add(campoEmail);
			panelMiCuenta.add(campoContrasena);
			panelMiCuenta.add(cancel1);
			panelMiCuenta.add(aceptar1);
			
		return panelMiCuenta;
		
		}
		
		
		public JPanel panelUsuario()
			{
			JPanel panelUsuario = new JPanel();
			panelUsuario.setLayout(null);
			panelUsuario.setSize(700,500);
			panelUsuario.setVisible(true);
			panelUsuario.setBackground(Color.decode("#6BCCE4"));
			JLabel crearNombre = new JLabel("Nombre: ");
			crearNombre.setSize(150, 50);
			crearNombre.setLocation(310, 100);
			crearNombre.setFont(fuenteMed);
			JLabel crearApellido = new JLabel("Apellido: ");
			crearApellido.setSize(400, 50);
			crearApellido.setLocation(310, 150);
			crearApellido.setFont(fuenteMed);
			JLabel crearEmail = new JLabel("Email: ");
			crearEmail.setSize(150, 50);
			crearEmail.setLocation(310, 200);
			crearEmail.setFont(fuenteMed);
			JLabel crearContraseña = new JLabel("Contraseña: ");
			crearContraseña.setSize(150, 50);
			crearContraseña.setLocation(290, 250);
			crearContraseña.setFont(fuenteMed);
			JLabel confirmarContraseña = new JLabel("<html><p> Confirmar<br>Contraseña:<p><html>");
			confirmarContraseña.setSize(250, 50);
			confirmarContraseña.setLocation(290, 295);
			confirmarContraseña.setFont(fuenteMed);
			JLabel micuenta2 = new JLabel("Crear Usuario");
			micuenta2.setSize(200, 50);
			micuenta2.setLocation(90, 70);
			micuenta2.setFont(fuenteMed);
			JLabel imgUsr4= new JLabel(imagenUsuario);
			imgUsr4.setSize(180,158);
			imgUsr4.setLocation(50,120);
			JTextField crerCampoNombre = new JTextField();
			crerCampoNombre.setSize(200, 40);
			crerCampoNombre.setLocation(400, 100);
			JTextField crearCampoApellido = new JTextField();
			crearCampoApellido.setSize(200, 40);
			crearCampoApellido.setLocation(400, 150);
			JTextField crearCampoEmail = new JTextField();
			crearCampoEmail.setSize(200, 40);
			crearCampoEmail.setLocation(400, 200);
			JPasswordField crearCampoContrasena = new JPasswordField();
			crearCampoContrasena.setSize(200, 40);
			crearCampoContrasena.setLocation(400, 250);
			JPasswordField crearConfirmarContraseña1 = new JPasswordField();
			crearConfirmarContraseña1.setSize(200, 40);
			crearConfirmarContraseña1.setLocation(400, 300);
			JButton cancel2 = new JButton("Cancelar");
			cancel2.setSize(100, 45);
			cancel2.setLocation(350, 360);
			cancel2.setOpaque(true);
			cancel2.setBackground(Color.decode("#DC143C"));
			cancel2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					actual = anterior;
					anterior = "panelSplash";
					route();					
				}});
			JButton aceptar2 = new JButton("Aceptar");
			aceptar2.setSize(100, 45);
			aceptar2.setLocation(500, 360);
			aceptar2.setOpaque(true);
			aceptar2.setBackground(Color.decode("#32CD32"));
			aceptar2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					BufferedWriter writer;

					n = crerCampoNombre.getText();
					a = crearCampoApellido.getText();
					m = crearCampoEmail.getText();
					p = new String(crearCampoContrasena.getPassword());

					try {

						 writer = new BufferedWriter(new FileWriter("User.txt",true));

						 writer.newLine();
						 writer.append(n+","+a+","+m+","+p);

						 writer.close();
							JOptionPane.showMessageDialog(null,"Usuario creado exitosamente");


					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}

			});
					
				
			
			panelUsuario.add(micuenta2);
			panelUsuario.add(crearNombre);
			panelUsuario.add(crearApellido);
			panelUsuario.add(crearEmail);
			panelUsuario.add(crearContraseña);
			panelUsuario.add(confirmarContraseña);
			panelUsuario.add(imgUsr4);
			panelUsuario.add(crerCampoNombre);
			panelUsuario.add(crearCampoApellido);
			panelUsuario.add(crearCampoEmail);
			panelUsuario.add(crearCampoContrasena);
			panelUsuario.add(crearConfirmarContraseña1);
			panelUsuario.add(cancel2);
			panelUsuario.add(aceptar2);
			
		return panelUsuario;
		}

		
		public JPanel panelTabla()
		{
			JPanel panelTabla = new JPanel();
			panelTabla.setVisible(true);
			panelTabla.setLayout(null);
			panelTabla.setSize(700, 500);
			panelTabla.setBackground(Color.decode("#6BCCE4"));
			JLabel listaUsuarios = new JLabel("Lista de usuarios");
			listaUsuarios.setSize(160,30);
			listaUsuarios.setLocation(260,60);
			listaUsuarios.setFont(fuenteMed);
			JComboBox<Object> combo = new JComboBox<Object>();
			combo.setSize(240,30);
			combo.setLocation(200,130);
			
			
			JButton editarUsuario = new JButton("editar usuario " + combo.getSelectedItem());
			editarUsuario.setSize(240,30);
			editarUsuario.setLocation(200,180);
			editarUsuario.setBackground(Color.green);
			combo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					editarUsuario.setText("editar usuario " + combo.getSelectedItem());
				}});
			editarUsuario.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String name=(String) combo.getSelectedItem();
					usuarioActual=name;
					BufferedReader br; 
					try{
						br = new BufferedReader(new FileReader("User.txt"));
						String linea = br.readLine();
						
						while(linea!=null) 
						{
							String[] datos=null;
							datos=linea.split(",");
							if(datos[0].equals(name))
							{
								anterior = actual;
								actual = "panelMiCuenta";
								route();	
							}
							linea=br.readLine();
						}
					
					}catch(IOException e1)
					{
						e1.printStackTrace();
						
					}
					
							}
						});
			
			panelTabla.add(listaUsuarios);
			panelTabla.add(combo);
			panelTabla.add(editarUsuario);
			String datos[][]= {{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""}
			,{"","",""},{"","",""},{"","",""},{"","",""}
			,{"","",""},{"","",""},{"","",""}};
			
			
					
					BufferedReader br; 
					try{
						br = new BufferedReader(new FileReader("User.txt"));
						String linea = br.readLine();
						int a=0;
						
						while(linea!=null) 
						{
							String[] data=null;
							data=linea.split(",");
							datos[a][0]=data[0];
							datos[a][1]=data[2];
							combo.addItem(data[0]);
							a++;
							linea=br.readLine();
						}
					
					}catch(IOException e1)
					{
						e1.printStackTrace();
						
					}
			
			String columnas[]= {"Usuario","Correo","Acciones"};
			JTable tabla = new JTable(datos,columnas);
			tabla.setSize(300,140);
			tabla.setVisible(true);
			JScrollPane scrol = new JScrollPane(tabla);
			scrol.setSize(300,140);
			scrol.setLocation(160,240);
			scrol.setVisible(true);
			panelTabla.add(scrol);
			
		return panelTabla;
		}	
		
	
		public JPanel panelAyuda(){
			
			JPanel panelAyuda = new JPanel();
			
			panelAyuda.setLayout(null);
			panelAyuda.setSize(700, 500);
			panelAyuda.setBackground(Color.decode("#6BCCE4"));
			JLabel pregunta1 = new JLabel("¿como crear un usuario?");
			pregunta1.setSize(350,50);
			pregunta1.setLocation(160,80);
			pregunta1.setFont(fuenteGran);
			JLabel respuesta = new JLabel("<html><p>1 Damos click en “usuario” en el menu superior<br>"
					+ "	2	Elegir la opcion Crear Usuario<br>"
					+ "	3	llenar correctamente los campos de texto<br>"
					+ "	4	Aceptamos <p><html>");
			respuesta.setSize(350,150);
			respuesta.setLocation(160,140);
			respuesta.setFont(fuenteChic);
			JButton crearUsuario = new JButton("crear Usuario");
			crearUsuario.setSize(240,30);
			crearUsuario.setLocation(200,280);
			crearUsuario.setBackground(Color.green);
			crearUsuario.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					anterior = actual;
					actual = "panelUsuario";
					route();					
				}});
			panelAyuda.add(pregunta1);
			panelAyuda.add(respuesta);
			panelAyuda.add(crearUsuario);
			
		return panelAyuda;
		}
}