package vistaVentana;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import controlador.ControladorVentanas;
import modelo.Jugador;
import modelo.NaveEspacial;
import modelo.Planeta;
import modelo.Universo;
import net.miginfocom.swing.MigLayout;
import observer.IObservador;

	public class Principal extends JFrame implements IObservador{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Universo universo;
		private ControladorVentanas controlador;
		public TextArea textArea;
		
		public Principal(Universo universo){
			setMinimumSize(new Dimension(790, 450));
			setMaximumSize(new Dimension(790, 450));
			setPreferredSize(new Dimension(790, 450));
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Juego - Universo");
			this.universo = universo;
			this.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][][][][grow]"));
			
			JLabel lblSeleccioneUnaOpcion = new JLabel("Seleccione una opcion:");
			this.getContentPane().add(lblSeleccioneUnaOpcion, "cell 0 0");
			
			JButton btnProducirNaveBatalla = new JButton("Producir Nave Batalla");
			btnProducirNaveBatalla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			this.getContentPane().add(btnProducirNaveBatalla, "cell 0 1");
			
			JButton btnProducirNaveDestructora = new JButton("Producir Nave Destructora");
			this.getContentPane().add(btnProducirNaveDestructora, "cell 0 2");
			
			JButton btnProducirNaveColonizadora = new JButton("Producir Nave Colonizadora");
			this.getContentPane().add(btnProducirNaveColonizadora, "cell 0 3");
			
			JButton btnProducirTorreta = new JButton("Producir Torreta");
			this.getContentPane().add(btnProducirTorreta, "cell 0 4");
			
			JButton btnMejorarProduccionPlaneta = new JButton("Mejorar Produccion Planeta");
			this.getContentPane().add(btnMejorarProduccionPlaneta, "cell 0 5");
			
			JButton btnEnviarNaveColonizadora = new JButton("Enviar Nave Colonizadora a Planeta");
			this.getContentPane().add(btnEnviarNaveColonizadora, "cell 0 6");
			
			JButton btnEnviarNaveBatalla = new JButton("Enviar Nave Batalla a Planeta");
			this.getContentPane().add(btnEnviarNaveBatalla, "cell 0 7");
			
			JButton btnEnviarNaveDestructora = new JButton("Enviar Nave Destructora a Planeta");
			this.getContentPane().add(btnEnviarNaveDestructora, "cell 0 8");
			
			JButton btnColonizarPlaneta = new JButton("Colonizar Planeta");
			this.getContentPane().add(btnColonizarPlaneta, "cell 0 9");
			
			JButton btnAtacarNave = new JButton("Atacar Nave");
			this.getContentPane().add(btnAtacarNave, "cell 0 10");
			
			JButton btnAtacarPlaneta = new JButton("Atacar Planeta");
			btnAtacarPlaneta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			this.getContentPane().add(btnAtacarPlaneta, "cell 0 11");
			
			JButton btnAtacarNaveBatalla = new JButton("Atacar Nave Batalla con Torreta");
			btnAtacarNaveBatalla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			this.getContentPane().add(btnAtacarNaveBatalla, "cell 0 12");
			
			JButton btnAtacarNaveDestructora = new JButton("Atacar Nave Destructora con Torreta");
			this.getContentPane().add(btnAtacarNaveDestructora, "cell 0 13");
			
			this.textArea = new TextArea();
			this.getContentPane().add(textArea, "cell 1 1 1 13,grow");
			
		}
		
		public void setControlador(ControladorVentanas controlador){
			this.controlador=controlador;
		}

		public void inicioJuegoVentana(){
			this.textArea.append("********************************************\n");
			this.textArea.append("Juego inicializado!\n");
			this.textArea.append("********************************************\n");
			for(Jugador j: this.universo.getJugadores()){
				this.textArea.append("Jugador: " + j.getNombre().toString() + "\n");
				for(Planeta pl : universo.getLplanetas()){
					if(j.getIdJugador()==pl.getIdOwner())
						this.textArea.append("Tiene el planeta " + pl.getNombre() + "\n");
				}
			}
		}
		public void menuAccionesVentana(){
			this.textArea.append("********************************************\n");
			this.textArea.append("Menu de acciones posibles\n");
			this.textArea.append("********************************************\n");
			this.textArea.append("1  - Producir nave de Batalla\n");
			this.textArea.append("2  - Producir nave de Destructor\n");
			this.textArea.append("3  - Producir nave colonizadora\n");
			this.textArea.append("4  - Producir torreta\n");
			this.textArea.append("5  - Mejorar produccion de planeta\n");
			this.textArea.append("6  - Enviar Nave Colonizadora a Planeta\n");
			this.textArea.append("7  - Enviar Nave Batalla a Planeta\n");
			this.textArea.append("8  - Enviar Nave Destructora a Planeta\n");
			this.textArea.append("9  - Colonizar Planeta\n");
			this.textArea.append("10 - Atacar Nave\n");
			this.textArea.append("11 - Atacar Planeta\n");
			this.textArea.append("12 - Atacar Nave Batalla con Torreta\n");
			this.textArea.append("13 - Atacar Nave Destructora con Torreta\n");
			this.textArea.append("Seleccione una opcion:\n");

		}
		
		public void actualizar(){
			this.textArea.append("*******************************************\n");
			this.textArea.append("********************************************\n");
			this.textArea.append("Universo\n");
			this.textArea.append("********************************************\n");
			for(Jugador j: this.universo.getJugadores()){
				this.textArea.append(j.toString()+"\n");
				for(Planeta pl: this.universo.getLplanetas()){
					int cantNB=0, cantND=0, cantNTC=0;
					if(pl.getIdOwner()==j.getIdJugador()){
						System.out.println(pl.toString()+"\n");
						for(NaveEspacial navB: this.universo.getLnavesB()){
							
							if(navB.getIdPlaneta()==pl.getIdPlaneta() && navB.getIdOwner() == j.getIdJugador() && !navB.isEnTransito()){
								cantNB++;
								//System.out.println(navB.toString());
							}
							if(navB.isEnTransito() && navB.getIdOwner()==j.getIdJugador()){
								System.out.println("Nave Batalla esta viajando a " + universo.getNombrePlaneta(navB.getIdPlanetaDest()) +"\n");
							}
							if(!navB.isEnTransito() && navB.getIdOwner()==j.getIdJugador() && navB.getIdPlanetaDest()!=-1){
								System.out.println("Nave de Batalla lista para atacar naves en " + universo.getNombrePlaneta(navB.getIdPlaneta())+"\n");
							}
						}
						
						if(cantNB!=0)
						System.out.println(cantNB + " Nave/s Batalla en " + pl.getNombre());
						
						for(NaveEspacial navD: this.universo.getLnavesD()){
							if(navD.getIdPlaneta()==pl.getIdPlaneta() && navD.getIdOwner() == j.getIdJugador() && !navD.isEnTransito()){
								cantND++;
								//System.out.println(navB.toString());
							}
							if(navD.isEnTransito() && navD.getIdOwner()==j.getIdJugador()){
								System.out.println("Nave Destructora esta viajando a " + universo.getNombrePlaneta(navD.getIdPlanetaDest()));
							}
							if(!navD.isEnTransito() && navD.getIdOwner()==j.getIdJugador() && navD.getIdPlanetaDest()!=-1){
								System.out.println("Nave Destructora lista para atacar " + universo.getNombrePlaneta(navD.getIdPlaneta()));
							}
						}
						if(cantND!=0)
						System.out.println(cantND + " Nave/s Destructora en " + pl.getNombre());
						for(NaveEspacial navTC: this.universo.getLnavesTC()){
							if(navTC.getIdPlaneta()==pl.getIdPlaneta() && navTC.getIdOwner() == j.getIdJugador() && !navTC.isEnTransito()){
								cantNTC++;
								//System.out.println(navTC.toString());
							}
							if(navTC.isEnTransito() && navTC.getIdOwner()==j.getIdJugador()){
								System.out.println("Nave Transporte/Colonizadora esta viajando a " + universo.getNombrePlaneta(navTC.getIdPlanetaDest()));
							}
							if(!navTC.isEnTransito() && navTC.getIdOwner()==j.getIdJugador() && navTC.getIdPlanetaDest()!=-1){
								System.out.println("Nave Transporte/Colonizadora lista para colonizar " + universo.getNombrePlaneta(navTC.getIdPlaneta()));
							}
						
						}
						if(cantNTC!=0)
						System.out.println(cantNTC + " Nave/s Colonizadora/Transportadora en " + pl.getNombre());
					}
				}
			}
			System.out.println("********************************************");
			this.textArea.append("Elija una opcion\n");
		}
		
		public void leerJugadores(){
			System.out.println("********************************************");
			System.out.println("Jugadores");
			System.out.println("********************************************");
			for(Jugador j: this.universo.getJugadores()){
				System.out.println("Jugador: " + j.getNombre().toString());
			}
		}
		
		public void mostrarInsertarNombreJugador(){
			System.out.println("Por favor ingrese nombre de jugador:");
		}
			
		public void juegoFinalizadoVentana(){
			System.out.println("********************************************\n");
			System.out.println("Juego Finalizado!\n");
			System.out.println("********************************************\n");
			for(Jugador j: this.universo.getJugadores()){
				System.out.println("Jugador: " + j.getNombre().toString()+"\n");
				for(Planeta pl : universo.getLplanetas()){
					if(j.getIdJugador()==pl.getIdOwner())
					System.out.println("Tiene el planeta " + pl.getNombre()+"\n");
				}
			}
		}
	}