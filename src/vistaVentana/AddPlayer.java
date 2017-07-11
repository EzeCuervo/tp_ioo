package vistaVentana;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ControladorVentanas;
import modelo.Universo;
import net.miginfocom.swing.MigLayout;

public class AddPlayer extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		JTextField textField;
		ControladorVentanas controlador;
		JButton btnAgregar;
		
		public AddPlayer(){
			setPreferredSize(new Dimension(272, 140));
			setMinimumSize(new Dimension(272, 140));
			setMaximumSize(new Dimension(272, 140));
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Agregar jugador");
			this.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][]"));
			
			JLabel lblNombre = new JLabel("Nombre:");
			this.getContentPane().add(lblNombre, "cell 0 1,alignx trailing");
			
			textField = new JTextField();
			this.getContentPane().add(textField, "cell 1 1,growx");
			textField.setColumns(10);
			
			btnAgregar = new JButton("Agregar");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlador.crearJugador(textField.getText());
					textField.setText(null);
				}
			});
			this.getContentPane().add(btnAgregar, "cell 1 3,alignx center");

		}
		public void setControlador(ControladorVentanas controlador){
			this.controlador=controlador;
		}

}