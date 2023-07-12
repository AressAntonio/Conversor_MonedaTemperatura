package com.mx.conversor.modulos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.BorderLayout;

public class ConversorMoneda extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorMoneda frame = new ConversorMoneda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JComboBox<Moneda> menu;
	private JButton btnConvertir;
	private JLabel textResult;
	private JTextField txt;
	
	/*VARIABLE PARA LA CONVERSION*/
	public double valorInput = 0.00;
	public double Dollar = 17.00;
	public double Euro = 18.79;
	public double Libra = 21.98;
	public double Yen = 0.12;
	public double Won = 0.013;
	
	
	
	/*CREANDO ENUMS PARA TIPO DE MONEDA*/
	public enum Moneda{
		Pesosmx_Dollars,
		Pesosmx_Euros,
		Pesosmx_LibraEsterlina,
		Pesosmx_YenJapones,
		Pesosmx_WonSurCoreano,
		Dollars_Pesosmx,
		Euros_Pesosmx,
		LibraEsterlina_Pesosmx,
		YenJapones_Pesosmx,
		WonSurCoreano_Pesosmx
	};
	
	/**METODO DONDE SE ENCUENTRA TODO EL DISEÑO DE LA PANTALLA CONVERSORMONEDA**/
	void CMGUI() {
		getContentPane().setBackground(new Color(0, 0, 0));
		setClosable(true);
		setFrameIcon(new ImageIcon(ConversorMoneda.class.getResource("/com/mx/icons/moneybox.png")));
		setTitle("Bienvenido al Conversor de Moneda.");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 27);
		panel.setBackground(new Color(184, 134, 11));
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Conversor de Moneda.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione el tipo de conversion:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setBounds(112, 38, 202, 14);
		getContentPane().add(lblNewLabel_1);
		
		menu = new JComboBox<>();
		menu.setBounds(122, 72, 183, 22);
		getContentPane().add(menu);
		menu.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		
		JLabel lblNewLabel_2 = new JLabel("DE");
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setBounds(135, 59, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("A");
		lblNewLabel_2_1.setForeground(Color.GREEN);
		lblNewLabel_2_1.setBounds(253, 59, 46, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Ingrese cantidad a convertir:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(new Color(0, 255, 0));
		lblNewLabel_3.setBounds(18, 105, 194, 31);
		getContentPane().add(lblNewLabel_3);
		
		txt = new JTextField();
		txt.setColumns(10);
		txt.setBounds(20, 132, 140, 20);
		getContentPane().add(txt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Conversion realizada:");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1.setBounds(138, 180, 187, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		textResult = new JLabel("0.00");
		textResult.setHorizontalAlignment(SwingConstants.CENTER);
		textResult.setForeground(new Color(128, 0, 64));
		textResult.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		textResult.setBounds(50, 214, 293, 34);
		getContentPane().add(textResult);
        
		btnConvertir = new JButton("Convertir");
		btnConvertir.setIcon(new ImageIcon(ConversorMoneda.class.getResource("/com/mx/icons/arrow_refresh.png")));
		btnConvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btnConvertir.setForeground(new Color(0, 128, 0));
		btnConvertir.setBackground(new Color(128, 255, 0));
		btnConvertir.setBounds(173, 131, 125, 23);
		getContentPane().add(btnConvertir);
	}

	/**
	 * Create the frame.
	 */
	public ConversorMoneda() {
		CMGUI();
		
		
	}
	
/*METODO DE OPERACIONES MATEMATICAS PARA REALIZAR CONVERCIONES*/
	
	// FUNCION DEL BOTON
		public void Convertir() {
			// VALIDACION DE NUMEROS
			if(validator(txt.getText())) {
				Moneda moneda = (Moneda) menu.getSelectedItem();
				
				switch(moneda) {
				case Pesosmx_Dollars:
					PesosmxAMoneda(Dollar);
					JOptionPane.showMessageDialog(btnConvertir,"La conversion fue realizada a Dollars"
							,"Info.", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case Pesosmx_Euros:
					PesosmxAMoneda(Euro);
					JOptionPane.showMessageDialog(btnConvertir,"La conversion fue realizada a Euros"
							,"Info.", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case Pesosmx_LibraEsterlina:
					PesosmxAMoneda(Libra);
					JOptionPane.showMessageDialog(btnConvertir,"La conversion fue realizada a Libras Esterlinas"
							,"Info.", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case Pesosmx_YenJapones:
					PesosmxAMoneda(Yen);
					JOptionPane.showMessageDialog(btnConvertir,"La conversion fue realizada a Yen Japones"
							,"Info.", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case Pesosmx_WonSurCoreano:
					PesosmxAMoneda(Won);
					JOptionPane.showMessageDialog(btnConvertir,"La conversion fue realizada a Won Sur Coreano"
							,"Info.", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case Dollars_Pesosmx:
					MonedaApesosmx(Dollar);
					JOptionPane.showMessageDialog(btnConvertir,"La conversion fue realizada a PesosMx"
							,"Info.", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case Euros_Pesosmx:
					MonedaApesosmx(Euro);
					JOptionPane.showMessageDialog(btnConvertir,"La conversion fue realizada a PesosMx"
							,"Info.", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case LibraEsterlina_Pesosmx:
					MonedaApesosmx(Libra);
					JOptionPane.showMessageDialog(btnConvertir,"La conversion fue realizada a PesosMx"
							,"Info.", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case YenJapones_Pesosmx:
					MonedaApesosmx(Yen);
					JOptionPane.showMessageDialog(btnConvertir,"La conversion fue realizada a PesosMx"
							,"Info.", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case WonSurCoreano_Pesosmx:
					MonedaApesosmx(Won);
					JOptionPane.showMessageDialog(btnConvertir,"La conversion fue realizada a PesosMx"
							,"Info.", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				default:
					throw new IllegalArgumentException("No se reconoce accion para: "+moneda);
			}
		};
		};	
	/*CREANDO METODO PARA CONVERTIR DE PESOSMX A MONEDA EXTRANJERA*/
		
		public void PesosmxAMoneda(Double moneda) {
		double result = valorInput / moneda;
		textResult.setText(redondeo(result));
	}
	
	/*CREANDO METODO PARA COMVERTIR DE MONEDA EXTRANJERA A PESOSMX*/
	public void MonedaApesosmx(Double moneda) {
		double result = valorInput * moneda;
		textResult.setText(redondeo(result));
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
			textResult.setText("Solo se aceptan numeros");
			return false;
		}
	};
	
	
}
