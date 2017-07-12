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

public class AddTorreta extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		ControladorVentana controlador;
		JButton btnCrear;
		private JComboBox<String> comboBox;
		private Universo universo;
		private Jugador jugador;
		
		public AddTorreta(Universo universo, Jugador jugador, ControladorVentana controlador){
			setPreferredSize(new Dimension(272, 140));
			setMinimumSize(new Dimension(272, 140));
			setMaximumSize(new Dimension(272, 140));
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Crear Torreta en Planeta");
			this.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][]"));
			this.jugador=jugador;
			this.universo=universo;
			this.controlador=controlador;
			
			JLabel lblPlanetaNaveB = new JLabel("Planeta:");
			this.getContentPane().add(lblPlanetaNaveB, "cell 0 1,alignx trailing");
			
			btnCrear = new JButton("Crear");
			btnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlador.crearTorreta((String)comboBox.getSelectedItem());
					controlador.setJugador(jugador);
					controlador.avanzarTurno();
					setVisible(false);
					
				}
			});
			
			comboBox = new JComboBox<String>();
			for(Planeta p:universo.mostrarPlanetasUser(jugador)){
				comboBox.addItem(p.getNombre());
			}
			getContentPane().add(comboBox, "cell 1 1,growx");
			this.getContentPane().add(btnCrear, "cell 1 3,alignx center");

		}
		public void setControlador(ControladorVentana controlador){
			this.controlador=controlador;
		}

}