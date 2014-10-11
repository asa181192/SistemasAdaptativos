import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Interfaz {

	private JFrame frame;
	private JTextField textField;
	private JLabel label;
	private JTextField textField_1;
    static	char crcter  [];
    static int nodos [][] ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAlgoritmoDeFuerza = new JLabel("Algoritmo de Fuerza Bruta ");
		lblAlgoritmoDeFuerza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlgoritmoDeFuerza.setBounds(98, 11, 256, 14);
		frame.getContentPane().add(lblAlgoritmoDeFuerza);
		
	 
		JLabel lblNumeroDeCiudades = new JLabel("ingresa los nodos ejemplo(abcd)");
		lblNumeroDeCiudades.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroDeCiudades.setBounds(23, 49, 235, 19);
		frame.getContentPane().add(lblNumeroDeCiudades);
		
		textField_1 = new JTextField();
		textField_1.setBounds(250, 50, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Empezar Fuerza Bruta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {  
				Grafo g=new Grafo(textField_1.getText());
				crcter = textField_1.getText().toCharArray();
				nodos = new int [crcter.length][crcter.length];
				
			for (int i = 0; i < crcter.length; i++) {
				
				for(int j=1; j<crcter.length;j++){
		
				if (i!=j && i<j){
int distancia= Integer.parseInt(JOptionPane.showInputDialog("Ingrese distancia entre la ciudad "+crcter[i]+"-"+crcter[j]));
					
					g.agregarRuta(crcter[i], crcter[j], distancia);
				}
				}
		
			}
			char inicio = JOptionPane.showInputDialog("introdusca la letra de la ciudad donde empezara").charAt(0);
			char fin = JOptionPane.showInputDialog("introdusca la letra donde finalizara la ciudad").charAt(0);
			g.encontrarRutaMinimaFuerzaBruta(inicio, fin);
			}
		});
		btnNewButton.setBounds(126, 143, 163, 33);
		frame.getContentPane().add(btnNewButton);
		
	
	}
}
