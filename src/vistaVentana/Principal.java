package vistaVentana;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controlador.ControladorVentana;
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
		private ControladorVentana controlador;
		public TextArea textArea;
		private Jugador jugador;
		private AddNaveB vistanb;
		private AddNaveD vistand;
		private AddNaveTC vistantc;
		private AddTorreta	vistator;
		private MejorarPlaneta vistamejorar;
		private ViajarNaveTC vistaviajarntc;
		private ViajarNaveB vistaviajarnaveb;
		private ViajarNaveD vistaviajarnaved;
		private ColonizarPlaneta vistacolonizar;
		private AtacarNaveB vistaatacarnavb;
		private AtacarPlaneta vistaatacarplan;
		private AtacarNaveBCT vistaatacarnavbct;
		private AtacarNaveDCT vistaatacarnavdct;
		private boolean juegoFinalizado = false;
		
		public Principal(Universo universo){
			setMinimumSize(new Dimension(790, 450));
			setMaximumSize(new Dimension(790, 450));
			setPreferredSize(new Dimension(790, 450));
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Juego - Universo");
			this.universo = universo;
			this.jugador=null;
			this.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][][][][grow]"));

			
			JLabel lblSeleccioneUnaOpcion = new JLabel("Seleccione una opcion:");
			this.getContentPane().add(lblSeleccioneUnaOpcion, "cell 0 0");
			
			JButton btnProducirNaveBatalla = new JButton("Producir Nave Batalla");
			btnProducirNaveBatalla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vistanb = new AddNaveB(universo, jugador, controlador);
					vistanb.setVisible(true);

				}
			});
			this.getContentPane().add(btnProducirNaveBatalla, "cell 0 1,growx");
			
			JButton btnProducirNaveDestructora = new JButton("Producir Nave Destructora");
			btnProducirNaveDestructora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vistand = new AddNaveD(universo, jugador, controlador);
					vistand.setVisible(true);

				}
			});
			this.getContentPane().add(btnProducirNaveDestructora, "cell 0 2,growx");
			
			JButton btnProducirNaveColonizadora = new JButton("Producir Nave Colonizadora");
			btnProducirNaveColonizadora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vistantc = new AddNaveTC(universo, jugador, controlador);
					vistantc.setVisible(true);

				}
			});
			this.getContentPane().add(btnProducirNaveColonizadora, "cell 0 3,growx");
			
			JButton btnProducirTorreta = new JButton("Producir Torreta");
			btnProducirTorreta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vistator = new AddTorreta(universo, jugador, controlador);
					vistator.setVisible(true);

				}
			});
			this.getContentPane().add(btnProducirTorreta, "cell 0 4,growx");
			
			JButton btnMejorarProduccionPlaneta = new JButton("Mejorar Produccion Planeta");
			btnMejorarProduccionPlaneta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 vistamejorar = new MejorarPlaneta(universo, jugador, controlador);
					 vistamejorar.setVisible(true);
				}
			});
			this.getContentPane().add(btnMejorarProduccionPlaneta, "cell 0 5,growx");
			
			JButton btnEnviarNaveColonizadora = new JButton("Enviar Nave Colonizadora a Planeta");
			btnEnviarNaveColonizadora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vistaviajarntc = new ViajarNaveTC(universo, jugador, controlador);
					vistaviajarntc.setVisible(true);
				}
			});
			this.getContentPane().add(btnEnviarNaveColonizadora, "cell 0 6,growx");
			
			JButton btnEnviarNaveBatalla = new JButton("Enviar Nave Batalla a Planeta");
			btnEnviarNaveBatalla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 vistaviajarnaveb = new ViajarNaveB(universo, jugador, controlador);
					 vistaviajarnaveb.setVisible(true);
				}
			});
			this.getContentPane().add(btnEnviarNaveBatalla, "cell 0 7,growx");
			
			JButton btnEnviarNaveDestructora = new JButton("Enviar Nave Destructora a Planeta");
			btnEnviarNaveDestructora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 vistaviajarnaved = new ViajarNaveD(universo, jugador, controlador);
					 vistaviajarnaved.setVisible(true);
				}
			});
			this.getContentPane().add(btnEnviarNaveDestructora, "cell 0 8,growx");
			
			JButton btnColonizarPlaneta = new JButton("Colonizar Planeta");
			btnColonizarPlaneta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 vistacolonizar = new ColonizarPlaneta(universo, jugador, controlador);
					 vistacolonizar.setVisible(true);
				}
			});
			this.getContentPane().add(btnColonizarPlaneta, "cell 0 9,growx");
			
			JButton btnAtacarNave = new JButton("Atacar Nave");
			btnAtacarNave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vistaatacarnavb = new AtacarNaveB(universo, jugador, controlador);
					vistaatacarnavb.setVisible(true);
				}
			});
			this.getContentPane().add(btnAtacarNave, "cell 0 10,growx");
			
			JButton btnAtacarPlaneta = new JButton("Atacar Planeta");
			btnAtacarPlaneta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					vistaatacarplan = new AtacarPlaneta(universo, jugador, controlador);
					vistaatacarplan.setVisible(true);
				}
			});
			this.getContentPane().add(btnAtacarPlaneta, "cell 0 11,growx");
			
			JButton btnAtacarNaveBatalla = new JButton("Atacar Nave Batalla con Torreta");
			btnAtacarNaveBatalla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					vistaatacarnavbct = new AtacarNaveBCT(universo, jugador, controlador);
					vistaatacarnavbct.setVisible(true);
				}
			});
			this.getContentPane().add(btnAtacarNaveBatalla, "cell 0 12,growx");
			
			JButton btnAtacarNaveDestructora = new JButton("Atacar Nave Destructora con Torreta");
			btnAtacarNaveDestructora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					vistaatacarnavdct = new AtacarNaveDCT(universo, jugador, controlador);
					vistaatacarnavdct.setVisible(true);
				}
			});
			this.getContentPane().add(btnAtacarNaveDestructora, "cell 0 13,growx");
			
			this.textArea = new TextArea();
			textArea.setEditable(false);
			this.getContentPane().add(textArea, "cell 1 1 1 13,grow");
			
		}
		
		public void setJugador(Jugador j){
			this.jugador=j;
		}
		
		public void setControlador(ControladorVentana controlador){
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
			this.textArea.append("********************************************\n");
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
		public void leToca(){
			this.textArea.append("Le toca a " + jugador.getNombre() + "\n");
			this.textArea.append("Elija una opcion \n");
		}
		
		
		
		public void actualizar(){
			
			if(controlador.finalizarJuego()){
				this.textArea.append("El Juego ha finalizado.\n");
				JOptionPane.showMessageDialog(null,"JUEGO FINALIZADO\n Ganador: " + jugador.getNombre());
				System.exit(0);
			}
			if(!controlador.finalizarJuego()){
			jugador=controlador.getJugador();
			this.textArea.append("*******************************************\n");
			this.textArea.append("********************************************\n");
			this.textArea.append("Universo\n");
			this.textArea.append("********************************************\n");
			for(Jugador j: this.universo.getJugadores()){
				this.textArea.append(j.toString()+"\n");
				for(Planeta pl: this.universo.getLplanetas()){
					int cantNB=0, cantND=0, cantNTC=0;
					if(pl.getIdOwner()==j.getIdJugador()){
						this.textArea.append(pl.toString()+"\n");
						for(NaveEspacial navB: this.universo.getLnavesB()){
							
							if(navB.getIdPlaneta()==pl.getIdPlaneta() && navB.getIdOwner() == j.getIdJugador() && !navB.isEnTransito()){
								cantNB++;
								//System.out.println(navB.toString());
							}
							if(navB.isEnTransito() && navB.getIdOwner()==j.getIdJugador()){
								this.textArea.append("Nave Batalla esta viajando a " + universo.getNombrePlaneta(navB.getIdPlanetaDest()) +"\n");
							}
							if(!navB.isEnTransito() && navB.getIdOwner()==j.getIdJugador() && navB.getIdPlanetaDest()!=-1){
								this.textArea.append("Nave de Batalla lista para atacar naves en " + universo.getNombrePlaneta(navB.getIdPlaneta())+"\n");
							}
						}
						
						if(cantNB!=0)
							this.textArea.append(cantNB + " Nave/s Batalla en " + pl.getNombre()+"\n");
						
						for(NaveEspacial navD: this.universo.getLnavesD()){
							if(navD.getIdPlaneta()==pl.getIdPlaneta() && navD.getIdOwner() == j.getIdJugador() && !navD.isEnTransito()){
								cantND++;
								//System.out.println(navB.toString());
							}
							if(navD.isEnTransito() && navD.getIdOwner()==j.getIdJugador()){
								this.textArea.append("Nave Destructora esta viajando a " + universo.getNombrePlaneta(navD.getIdPlanetaDest())+"\n");
							}
							if(!navD.isEnTransito() && navD.getIdOwner()==j.getIdJugador() && navD.getIdPlanetaDest()!=-1){
								this.textArea.append("Nave Destructora lista para atacar " + universo.getNombrePlaneta(navD.getIdPlaneta())+"\n");
							}
						}
						if(cantND!=0)
							this.textArea.append(cantND + " Nave/s Destructora en " + pl.getNombre()+"\n");
						for(NaveEspacial navTC: this.universo.getLnavesTC()){
							if(navTC.getIdPlaneta()==pl.getIdPlaneta() && navTC.getIdOwner() == j.getIdJugador() && !navTC.isEnTransito()){
								cantNTC++;
								//System.out.println(navTC.toString());
							}
							if(navTC.isEnTransito() && navTC.getIdOwner()==j.getIdJugador()){
								this.textArea.append("Nave Transporte/Colonizadora esta viajando a " + universo.getNombrePlaneta(navTC.getIdPlanetaDest())+"\n");
							}
							if(!navTC.isEnTransito() && navTC.getIdOwner()==j.getIdJugador() && navTC.getIdPlanetaDest()!=-1){
								this.textArea.append("Nave Transporte/Colonizadora lista para colonizar " + universo.getNombrePlaneta(navTC.getIdPlaneta())+"\n");
							}
						
						}
						if(cantNTC!=0)
							this.textArea.append(cantNTC + " Nave/s Colonizadora/Transportadora en " + pl.getNombre()+"\n");
					}
				}
			}
			this.textArea.append("********************************************"+"\n");
			leToca();
			}
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