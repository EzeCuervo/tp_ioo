package vistaVentana;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.ControladorVentanas;
import modelo.Jugador;
import modelo.Planeta;
import modelo.Universo;
import net.miginfocom.swing.MigLayout;

public class ColonizarPlaneta extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		ControladorVentanas controlador;
		JButton btnCrear;
		private JComboBox<String> comboBox;
		private Universo universo;
		private Jugador jugador;
		private Object [] array;
		
		public ColonizarPlaneta(Universo universo, Jugador jugador, ControladorVentanas controlador){
			setPreferredSize(new Dimension(272, 140));
			setMinimumSize(new Dimension(272, 140));
			setMaximumSize(new Dimension(272, 140));
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Colonizar planeta");
			this.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][]"));
			this.jugador=jugador;
			this.universo=universo;
			this.controlador=controlador;
			
			JLabel lblPlanetaNaveB = new JLabel("Planeta:");
			this.getContentPane().add(lblPlanetaNaveB, "cell 0 1,alignx trailing");
			
			btnCrear = new JButton("Colonizar");
			btnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlador.colonizarPlaneta((String) comboBox.getSelectedItem());
					controlador.setJugador(jugador);
					controlador.avanzarTurno();
					setVisible(false);
					
				}
			});
			comboBox = new JComboBox<String>();
			for(Planeta p:universo.mostrarNavesListasColonizar(jugador)){
				comboBox.addItem(p.getNombre());
			}

			getContentPane().add(comboBox, "cell 1 1,growx");
			this.getContentPane().add(btnCrear, "cell 1 3,alignx center");

		}
		public void setControlador(ControladorVentanas controlador){
			this.controlador=controlador;
		}

}