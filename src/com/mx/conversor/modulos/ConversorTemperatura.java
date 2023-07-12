package com.mx.conversor.modulos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class ConversorTemperatura extends JInternalFrame {

	/*VARIABLES NECESAFRIAS PARA REALIZAR FORMULAS Y MOSTRAR RESULTADO EN PANTALLA*/
	private JComboBox<Grados> menuTemp;
	private JButton btnTemp;
	private JLabel conversorTemp;
	private JTextField textTemp;
	
	private double valorInput = 0.00;
	private double fahrenheit = 32;
	private double kelvin = 273.15;
	
	
	
	/*CREANDO ENUMS PARA TIPO DE CONVERSION*/
	public enum Grados{
		Celsius__Fahrenheit,
		Celsius__Kelvin,
		Fahrenheit__Celsius,
		Fahrenheit__kelvin,
		kelvin__Celsius,
		kelvin__Fahrenheit
	};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorTemperatura frame = new ConversorTemperatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**METODO GUITEMP QUE CONTIENE TODO EL DISEÑO DE LA PANTALLA CONVERSORTEMPERATURA**/
	void GUITEMP() {
		
	};

	/**
	 * Create the frame.
	 */
	public ConversorTemperatura() {
		setClosable(true);
		
		/**CONTIENE LAS ETIQUETAS LABEL DE TEXTOS EN PANTALLA**/
		getContentPane().setBackground(new Color(0, 0, 0));
		setFrameIcon(new ImageIcon(ConversorTemperatura.class.getResource("/com/mx/icons/temperature_cold.png")));
		setTitle("Bienvenido al Conversor de Temperatura.");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184, 134, 11));
		panel.setBounds(0, 0, 434, 30);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Bienvenido al Conversor de Temperatura.");
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona el tipo de conversion:");
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(123, 41, 182, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("DE");
		lblNewLabel_4.setForeground(Color.GREEN);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblNewLabel_4.setBounds(133, 59, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("A");
		lblNewLabel_5.setForeground(Color.GREEN);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblNewLabel_5.setBounds(209, 58, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Ingrese temperatura a convertir:");
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setBounds(10, 111, 245, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Conversion Realizada:");
		lblNewLabel_3.setForeground(Color.GREEN);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(147, 166, 160, 14);
		getContentPane().add(lblNewLabel_3);
		
		/**ETIQUETA JTEXFILE DONDE EL USUARIO INGRESA LA CIFRA A CONVERTIR**/
		textTemp = new JTextField();
		textTemp.setColumns(10);
		textTemp.setBounds(10, 125, 160, 22);
		getContentPane().add(textTemp);
		
		/**BOTON QUE REALIZA LA CONVERSION**/
		btnTemp = new JButton("convertir");
		btnTemp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btnTemp.setIcon(new ImageIcon(ConversorTemperatura.class.getResource("/com/mx/icons/arrow_refresh.png")));
		btnTemp.setForeground(new Color(245, 255, 250));
		btnTemp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTemp.setBackground(new Color(0, 128, 0));
		btnTemp.setBounds(191, 125, 114, 23);
		getContentPane().add(btnTemp);
		
		/**ETIQUETA LABEL DONDE SE RECIBE Y MUESTRA EL RESULTADO DE LA CONVERSION**/
		conversorTemp = new JLabel("0.00");
		conversorTemp.setHorizontalAlignment(SwingConstants.CENTER);
		conversorTemp.setForeground(new Color(128, 0, 0));
		conversorTemp.setFont(new Font("Tahoma", Font.PLAIN, 26));
		conversorTemp.setBounds(82, 181, 264, 51);
		getContentPane().add(conversorTemp);
		
		/**ETIQUETA COMBOBOX DONDE SE MUESTRA LOS VALORES DEL ENUM CON LOS TIPOS DE CONVERSION**/
		menuTemp = new JComboBox<>();
		menuTemp.setBounds(123, 78, 202, 22);
		menuTemp.setModel(new DefaultComboBoxModel<>(Grados.values()));
		getContentPane().add(menuTemp);
		

	};
	
	/**METODO PARA REALIZAR LA CONVERSION**/
				public void Convertir() {
					// VALIDACION DE NUMEROS
					if(validator(textTemp.getText())) {
						Grados grado = (Grados) menuTemp.getSelectedItem();
						
						switch(grado) {
						case Celsius__Fahrenheit:
							celsiusAFahrenheit(fahrenheit);
							JOptionPane.showMessageDialog(null, "Conversion realizada de Celsius a Fahrenheit.", 
									"Info.", JOptionPane.INFORMATION_MESSAGE);
							break;
						
						case Celsius__Kelvin:
							celsiusAKelvin(kelvin);
							JOptionPane.showMessageDialog(null, "Conversion realizada de Celsius a Kelvin.", 
									"Info.", JOptionPane.INFORMATION_MESSAGE);
							break;
							
						case Fahrenheit__Celsius:
							 FahernACelsius(fahrenheit);
							 JOptionPane.showMessageDialog(null, "Conversion realizada de Fahrenheit a Celsius.", 
										"Info.", JOptionPane.INFORMATION_MESSAGE);
							 break;
							
						case Fahrenheit__kelvin:
							FahernAKelvin(kelvin);
							JOptionPane.showMessageDialog(null, "Conversion realizada de Fahrenheit a Kelvin.", 
									"Info.", JOptionPane.INFORMATION_MESSAGE);
							break;
						
						case kelvin__Celsius:
							KelvinACelsius(kelvin);
							JOptionPane.showMessageDialog(null, "Conversion realizada de Kelvin a Celsius.", 
									"Info.", JOptionPane.INFORMATION_MESSAGE);
							break;
							
						case kelvin__Fahrenheit:
							KelvinAFahren(fahrenheit);
							JOptionPane.showMessageDialog(null, "Conversion realizada de Kelvin a Fahrenheit.", 
									"Info.", JOptionPane.INFORMATION_MESSAGE);
							break;
							
						default:
							throw new IllegalArgumentException("No se reconoce accion para: "+grado);
					};
				};
				};	
				
				/*CREANDO METODO PARA CONVERTIR DE CELSIUS A FAHRENHEIT*/
				public void celsiusAFahrenheit(Double grado){
				    double result = (valorInput*9/5)+grado; /*USANDO FAHRENHEIT DEL ENUM COMO VLOR DE GRADO*/
					conversorTemp.setText(redondeo(result));
				}
				
				/*CREANDO METODO PARA CONVERTIR DE CELSIUS A KELVIN*/
				public void celsiusAKelvin(Double grado) {
					double result = valorInput+grado; /*USANDO KELVIN DEL ENUM COMO VLOR DE GRADO*/
					conversorTemp.setText(redondeo(result));
				}
				
				/*CREANDO METODO FAHRENHEIT A CELSIUS*/
				public void FahernACelsius(Double grado) {
					double result = (valorInput-grado)*5/9; /*USANDO FAHRENHEIT DEL ENUM COMO VALOR DE GRADO*/
					conversorTemp.setText(redondeo(result));
				};
				
				/*CREANDO METODO FAHRENHEIT A KELVIN*/
				public void FahernAKelvin(Double grado) {
					double result = (valorInput-32)*5/9+grado; /*USANDO KELVIN DEL ENUM COMO VALOR DE GRADO*/
					conversorTemp.setText(redondeo(result));
				};
				
				/*CREANDO METODO DE KELVIN A CELSIUS*/
				public void KelvinACelsius(Double grado) {
					double result = valorInput-grado; /*USANDO KELVIN DEL ENUM COMO VALOR DE GRADO*/
					conversorTemp.setText(redondeo(result));
				};
				
				/*CREANDO METODO DE KELVIN A FAHRENHEIT*/
				public void KelvinAFahren(Double grado) {
					double result = (valorInput-273.15)*9/5+grado; /*USANDO FAHRENHEIT DEL ENUM COMO VALOR DE GRADO*/
					conversorTemp.setText(redondeo(result));
				}
				
				
				
				/*CREANDO METODO PARA REDONDEAR RESULTADO*/
				public String redondeo(double valor) {
					DecimalFormat df = new DecimalFormat("0.00");
					df.setRoundingMode(RoundingMode.HALF_UP);
					return df.format(valor);
				};
				
				/*CREANDO METODO DE VALIDACION DE INGRESO DE TEXTO POR USUARIO*/
				public boolean validator(String texto) {
					try {
						double val = Double.parseDouble(texto);
						if(val > 0);
						valorInput = val;
						return true;
					} catch (NumberFormatException e) {
						conversorTemp.setText("Solo se aceptan numeros");
						return false;
					}
				};
}
