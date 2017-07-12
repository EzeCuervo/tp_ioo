package vistaVentana;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.ControladorVentanas;
import modelo.Jugador;
import modelo.Planeta;
import modelo.Universo;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViajarNaveTC extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		ControladorVentanas controlador;
		JButton btnEnviar;
		private JComboBox<String> comboBoxOrigen;
		private Universo universo;
		private Jugador jugador;
		private JLabel lblPlanetaDestino;
		private JLabel lblTripulantes;
		private JComboBox<String> comboBoxDest;
		private JTextField cantTripulantes;
		
		public ViajarNaveTC(Universo universo, Jugador jugador, ControladorVentanas controlador){
			setPreferredSize(new Dimension(272, 140));
			setMinimumSize(new Dimension(272, 200));
			setMaximumSize(new Dimension(272, 200));
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Crear Nave Transportadora/Colonizadora");
			this.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][][]"));
			this.jugador=jugador;
			this.universo=universo;
			this.controlador=controlador;
			
			JLabel lblPlanetaNaveB = new JLabel("Planeta origen:");
			this.getContentPane().add(lblPlanetaNaveB, "cell 0 1,alignx trailing");
			
			comboBoxOrigen = new JComboBox<String>();
			for(Planeta p:universo.mostrarPlanetasConNTC(jugador)){
				comboBoxOrigen.addItem(p.getNombre());
			}
			getContentPane().add(comboBoxOrigen, "cell 1 1,growx");
			
			btnEnviar = new JButton("Enviar");
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlador.enviarNaveColonizadora((String)comboBoxOrigen.getSelectedItem(), (String)comboBoxDest.getSelectedItem(), Integer.parseInt(cantTripulantes.getText()));
					controlador.setJugador(jugador);
					controlador.avanzarTurno();
					setVisible(false);
					
				}
			});
			
			lblPlanetaDestino = new JLabel("Planeta destino:");
			getContentPane().add(lblPlanetaDestino, "cell 0 2,alignx trailing");
			
			comboBoxDest = new JComboBox<String>();
			for(Planeta p:universo.mostrarPlanetasSinUser()){
				comboBoxDest.addItem(p.getNombre());
			}
			getContentPane().add(comboBoxDest, "cell 1 2,growx");
			
			lblTripulantes = new JLabel("Tripulantes:");
			getContentPane().add(lblTripulantes, "cell 0 3,alignx trailing");
			
			cantTripulantes = new JTextField();
			cantTripulantes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JOptionPane.showMessageDialog(null,"Ingrese la cantidad de integrantes de la nave colonizadora (MIN 1 - MAX " + universo.getPlaneta((String)comboBoxOrigen.getSelectedItem()).getPoblacion() + ")");
				}
			});
			getContentPane().add(cantTripulantes, "cell 1 3,growx");
			cantTripulantes.setColumns(10);
			this.getContentPane().add(btnEnviar, "cell 1 6,alignx center");

		}
		public void setControlador(ControladorVentanas controlador){
			this.controlador=controlador;
		}

}