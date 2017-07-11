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
import javax.swing.JComboBox;

public class AddNaveB extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		ControladorVentanas controlador;
		JButton btnCrear;
		private JComboBox comboBox;
		
		public AddNaveB(){
			setPreferredSize(new Dimension(272, 140));
			setMinimumSize(new Dimension(272, 140));
			setMaximumSize(new Dimension(272, 140));
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Crear Nave Batalla");
			this.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][]"));
			
			JLabel lblPlanetaNaveB = new JLabel("Planeta:");
			this.getContentPane().add(lblPlanetaNaveB, "cell 0 1,alignx trailing");
			
			btnCrear = new JButton("Crear");
			btnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			
			comboBox = new JComboBox();
			getContentPane().add(comboBox, "cell 1 1,growx");
			this.getContentPane().add(btnCrear, "cell 1 3,alignx center");

		}
		public void setControlador(ControladorVentanas controlador){
			this.controlador=controlador;
		}

}