package com.mx.conversor.modulos;


import java.awt.EventQueue;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

//import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

public class MenuInicio extends JFrame {

	private JPanel contentPane;
	private JDesktopPane dpPanelprincipal;
	private ConversorMoneda Pcm; /*VARIABLE PARA LLAMAR A LA PANTALLA DE CONVERSORMONEDA*/
	private ConversorTemperatura Pct; /**VARIABLE PARA LLAMAR A LA PANTALLA CONVERSORTEMPERATURA**/
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicio frame = new MenuInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	};
	
	
	
	/*METODO QUE CONTIENE TODO EL DISEÑO DE LA INTERFAZ MENUINICIO*/
	void DiseñoUI(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuInicio.class.getResource("/com/mx/icons/icono-convertir.png")));
		setTitle("Conversor de Moneda y Temperatura.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(184, 134, 11));
		setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Home");
		mnInicio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnInicio.setIcon(new ImageIcon(MenuInicio.class.getResource("/com/mx/icons/house.png")));
		mnInicio.setHorizontalAlignment(SwingConstants.CENTER);
		mnInicio.setForeground(new Color(255, 255, 255));
		menuBar.add(mnInicio);
		
		JMenuItem mntmsalir = new JMenuItem("Salir");
		mntmsalir.setIcon(new ImageIcon(MenuInicio.class.getResource("/com/mx/icons/door_out.png")));
		
		/**EVENTO DEL BOTON PARA CERRAR EL APLICATIVO**/
		mntmsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Desea cerrar la Aplicacion?", 
						"SALIR", JOptionPane.YES_NO_OPTION)==0) {
					System.exit(0);
				}
			};
		});
		mntmsalir.setHorizontalAlignment(SwingConstants.CENTER);
		mntmsalir.setForeground(new Color(255, 255, 255));
		mntmsalir.setBackground(new Color(184, 134, 11));
		mnInicio.add(mntmsalir);
		
		JMenu mnNewMenu_1 = new JMenu("Opciones de Conversor");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnNewMenu_1.setIcon(new ImageIcon(MenuInicio.class.getResource("/com/mx/icons/multitool.png")));
		mnNewMenu_1.setBackground(new Color(184, 134, 11));
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmMoneda = new JMenuItem("Conversor de moneda.");
		/*EVENTO DEL BOTON PARA MOSTRAR LA PANTALLA DEL CONVERSOR DE MONEDA*/
		mntmMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerPantallaMoneda();
			}
		});
		mntmMoneda.setIcon(new ImageIcon(MenuInicio.class.getResource("/com/mx/icons/moneybox.png")));
		mntmMoneda.setForeground(new Color(255, 255, 255));
		mntmMoneda.setBackground(new Color(184, 134, 11));
		mntmMoneda.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu_1.add(mntmMoneda);
		
		/**EVENTO DEL BOTON PARA MOSTRAR PANTALLA CONVERSORTEMPERATURA**/
		JMenuItem mntmTemp = new JMenuItem("Conversor de Temperatura.");
		mntmTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerpantallaTemp();
			}
		});
		mntmTemp.setIcon(new ImageIcon(MenuInicio.class.getResource("/com/mx/icons/temperature_cold.png")));
		mntmTemp.setForeground(new Color(255, 255, 255));
		mntmTemp.setBackground(new Color(184, 134, 11));
		mntmTemp.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu_1.add(mntmTemp);
		
		JMenu mnNewMenu = new JMenu("Info.");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnNewMenu.setIcon(new ImageIcon(MenuInicio.class.getResource("/com/mx/icons/page.png")));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setBackground(new Color(218, 165, 32));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAyuda = new JMenuItem("Sobre el Proyecto.");
		
		/*CREANDO UN BOTON CON UNA VENTANA DE DIALOGO INFORMATIVA*/
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Este proyecto surge del programa de capacitacion\n "
						+ "para obtener las habilidades de un Desarrollador BackEnd,\n "
						+ "Impartido por AluraLatam en cooperacion con Oracle,\n "
						+ "El Conversor es un challenger del curso Java OOP\n "
						+ "en el cual se desafia a los alumnos a investigar \n"
						+ "sobre la creacion de UI utilizando la libreria Swing \n"
						+ "y la libreria JOptionPane para generar ventanas de dialogo\n"
						+ " (Como la ventana que esta leyendo en este momento.).", 
						"Acerca del Proyecto:", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmAyuda.setIcon(new ImageIcon(MenuInicio.class.getResource("/com/mx/icons/page_code.png")));
		mntmAyuda.setHorizontalAlignment(SwingConstants.CENTER);
		mntmAyuda.setBackground(new Color(184, 134, 11));
		mntmAyuda.setForeground(new Color(255, 255, 255));
		mnNewMenu.add(mntmAyuda);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Desarrollador");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Desarrollado por: Antonio Garrido\n"
						+ "ING.Entornos Virtuales y Negocios Digitales.\n"
						+ "Un poco sobre mi; Soy recien egresado de la Ingenieria en Informatica\n"
						+ "en la cual tube la dicha de conocer un poco sobre varias areas de la tecnologia\n"
						+ "gracias a esos 4 años en la universidad logre conocer este gran mundo que es la programacion\n"
						+ "y nacio mi gusto por codear y realizar proyectos web, realidad virtual,\n"
						+ "realidad aumentada y la creacion de videojuegos.\n"
						+ "Redes de contacto:\n"
						+ "GITHUB -> www.github.com/aressantonio\n"
						+ "LINKEDIN -> www.linkedin.com/in/antonio-garrido-9013b7249\n"
						+ "MAIL -> antoniogarrido.contacto@gmail.com",
						"Info. Creador del proyecto", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmNewMenuItem.setBackground(new Color(184, 134, 11));
		mntmNewMenuItem.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem.setIcon(new ImageIcon(MenuInicio.class.getResource("/com/mx/icons/user_bart.png")));
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		dpPanelprincipal = new JDesktopPane();
		dpPanelprincipal.setBackground(new Color(240, 255, 255));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184, 134, 11));
		
		JLabel lblNewLabel = new JLabel("Conversor||2023");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(dpPanelprincipal, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(163))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(dpPanelprincipal, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1 = new JLabel("Para comenzar da click en: ");
		lblNewLabel_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(37, 38, 357, 33);
		dpPanelprincipal.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("OPCIONES DE CONVERSOR,");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(37, 59, 357, 33);
		dpPanelprincipal.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("de la barra de menu superior.");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(184, 134, 11));
		lblNewLabel_1_2.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(37, 82, 357, 33);
		dpPanelprincipal.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("de tu preferencia.");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(new Color(184, 134, 11));
		lblNewLabel_1_3.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(37, 126, 357, 33);
		dpPanelprincipal.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("y selecciona el tipo de conversor,");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1_3_1.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblNewLabel_1_3_1.setBounds(57, 103, 357, 33);
		dpPanelprincipal.add(lblNewLabel_1_3_1);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * METODO QUE GENERA LA VISION GRAFICA DEL MENUINICIO
	 * Create the frame.
	 */
	public MenuInicio() {
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		DiseñoUI();
	};
	
	/*CREANDO METODO PARA MOSTRAR PANTALLA DE CONVERSOR MONEDA*/
	void VerPantallaMoneda() {
		
		if(Pcm == null || Pcm.isClosed()) {
			
			Pcm = new ConversorMoneda();
			dpPanelprincipal.add(Pcm); /*LLAMA A LA PANTALLA DE CONVERSOR MONEDA AL PANEL DEL MENU PRINCIPAL*/
			
			Dimension PConversor = Pcm.getSize();
			
			/*METODO PARA REDIMENCIONARY SENTRAR PANTALLA CONVERSORMONEDA EN PANEL PRINCIPAL DEL MENU INICIO*/
			Pcm.setLocation((dpPanelprincipal.getWidth()-PConversor.width)/2,
					(dpPanelprincipal.getHeight()-PConversor.height)/2);
			
			Pcm.show(); /*HACE QUE SE MUESTRE EN EL PANEL DEL MENU PRINCIPAL LA PANTALLA DEL CONVERSOR MONEDA*/
		}else {
			JOptionPane.showMessageDialog(null, "¡Ya hay una ventana del conversor seleccionado abierta en este momento!",
					"Info.", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	};
	
	/**CREANDO METODO PARA LLAMAR PANTALLA CONVERSORTEMPERATURA**/
	void VerpantallaTemp() {
		
if(Pct == null || Pct.isClosed()) {
			
			Pct = new ConversorTemperatura();
			dpPanelprincipal.add(Pct); /*LLAMA A LA PANTALLA DE CONVERSOR MONEDA AL PANEL DEL MENU PRINCIPAL*/
			
			Dimension PConversor = Pct.getSize();
			
			/*METODO PARA REDIMENCIONAR Y CENTRAR PANTALLA CONVERSORMONEDA EN PANEL PRINCIPAL DEL MENU INICIO*/
			Pct.setLocation((dpPanelprincipal.getWidth()-PConversor.width)/2,
					(dpPanelprincipal.getHeight()-PConversor.height)/2);
			
			Pct.show(); /*HACE QUE SE MUESTRE EN EL PANEL DEL MENU PRINCIPAL LA PANTALLA DEL CONVERSOR MONEDA*/
		}else {
			JOptionPane.showMessageDialog(null, "¡Ya hay una ventana del conversor seleccionado abierta en este momento!",
					"Info.", JOptionPane.INFORMATION_MESSAGE);
		}
		
	};
	
	
	
	
}


