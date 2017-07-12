package vistaVentana;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.ControladorVentana;
import modelo.Jugador;
import modelo.Planeta;
import modelo.Universo;
import net.miginfocom.swing.MigLayout;

public class ViajarNaveB extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		ControladorVentana controlador;
		JButton btnEnviar;
		private JComboBox<String> comboBoxOrigen;
		private Universo universo;
		private Jugador jugador;
		private JLabel lblPlanetaDestino;
		private JComboBox<String> comboBoxDest;
		
		public ViajarNaveB(Universo universo, Jugador jugador, ControladorVentana controlador){
			setPreferredSize(new Dimension(272, 140));
			setMinimumSize(new Dimension(272, 200));
			setMaximumSize(new Dimension(272, 200));
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Enviar Nave Batalla");
			this.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][][]"));
			this.jugador=jugador;
			this.universo=universo;
			this.controlador=controlador;
			
			JLabel lblPlanetaNaveB = new JLabel("Planeta origen:");
			this.getContentPane().add(lblPlanetaNaveB, "cell 0 1,alignx trailing");
			
			comboBoxOrigen = new JComboBox<String>();
			for(Planeta p:universo.mostrarPlanetasConNB(jugador)){
				comboBoxOrigen.addItem(p.getNombre());
			}
			getContentPane().add(comboBoxOrigen, "cell 1 1,growx");
			
			btnEnviar = new JButton("Enviar");
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlador.enviarNaveBatalla((String)comboBoxOrigen.getSelectedItem(), (String)comboBoxDest.getSelectedItem());
					controlador.setJugador(jugador);
					controlador.avanzarTurno();
					setVisible(false);
					
				}
			});
			
			lblPlanetaDestino = new JLabel("Planeta destino:");
			getContentPane().add(lblPlanetaDestino, "cell 0 2,alignx trailing");
			
			comboBoxDest = new JComboBox<String>();
			for(Planeta p:universo.mostrarPlanetasUserEnemigo(jugador)){
				comboBoxDest.addItem(p.getNombre());
			}
			getContentPane().add(comboBoxDest, "cell 1 2,growx");
			this.getContentPane().add(btnEnviar, "cell 1 6,alignx center");

		}
		public void setControlador(ControladorVentana controlador){
			this.controlador=controlador;
		}

}