package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Jugador;
import modelo.Universo;
import vistaVentana.AddPlayer;
import vistaVentana.Principal;

public class ControladorVentanas {
	public Universo universo;
	private AddPlayer vistadd;
	private Principal vistaprin;
	private Jugador jugador;

	public ControladorVentanas(Universo universo){
		super();
		this.universo=universo;
	}
	public void setVistaPrincipal(Principal principal){
		this.vistaprin=principal;
	}
	
	public void setVistaAddPlayer(AddPlayer add){
		this.vistadd=add;
	}
	
	public void crearJugador(String nombre){
		Jugador jug = new Jugador(nombre);
		universo.unirJugador(jug);

	}
	
	public void crearNaveB(String nombre){
		this.jugador.getPlaneta(nombre).prodNaveB();
	}
	public void crearNaveD(String nombre){
		this.jugador.getPlaneta(nombre).prodNaveD();
	}
	public void crearNaveTC(String nombre){
		this.jugador.getPlaneta(nombre).prodNaveTC();
	}
	public void crearTorreta(String nombre){
		this.jugador.getPlaneta(nombre).construirTorretas();
	}
	public void mejorarPlaneta(String nombre){
		this.jugador.getPlaneta(nombre).mejorarPlaneta();
	}

	public void setJugador(Jugador actual){
		for(Jugador j: universo.getJugadores()){
			if(j!=actual){
				this.jugador=j;
			}
		}
	}
	
	public void enviarNaveColonizadora(String planetaOrigen, String planetaDestino, int cantTripulantes){
		universo.getNaveTC(this.jugador.getIdJugador(), universo.getPlaneta(planetaOrigen).getIdPlaneta()).agregarIntegrantes(cantTripulantes);
		this.jugador.getPlaneta(planetaOrigen).setPoblacion(this.jugador.getPlaneta(planetaOrigen).getPoblacion()-cantTripulantes);
		universo.getNaveTC(this.jugador.getIdJugador(), universo.getPlaneta(planetaOrigen).getIdPlaneta()).viajar(universo.getPlaneta(planetaDestino));
	}
	
	public void enviarNaveBatalla(String planetaOrigen, String planetaDestino){
		universo.getNaveB(this.jugador.getIdJugador(), universo.getPlaneta(planetaOrigen).getIdPlaneta()).viajar(universo.getPlaneta(planetaDestino));	
	
	}
	
	public void enviarNaveDestructora(String planetaOrigen, String planetaDestino){
		universo.getNaveD(this.jugador.getIdJugador(), universo.getPlaneta(planetaOrigen).getIdPlaneta()).viajar(universo.getPlaneta(planetaDestino));
	
	}
	
	public void colonizarPlaneta(String planetaOrigen){
		universo.getNaveTC(this.jugador.getIdJugador(), universo.getPlaneta(planetaOrigen).getIdPlaneta()).colonizar(universo.getPlaneta(planetaOrigen));
		universo.getLnavesTC().remove(universo.getNaveTC(this.jugador.getIdJugador(), universo.getPlaneta(planetaOrigen).getIdPlaneta()));
	}

	public void atacarNaveB(String planetaOrigen){
		universo.getNaveB(jugador.getIdJugador(), universo.getPlaneta(planetaOrigen).getIdPlaneta()).atacarNaveB(universo.getNaveB(universo.getPlaneta(planetaOrigen).getIdOwner(),universo.getPlaneta(planetaOrigen).getIdPlaneta()));
		
	}
	public void atacarPlaneta(String planetaOrigen){
		universo.getNaveD(jugador.getIdJugador(), universo.getPlaneta(planetaOrigen).getIdPlaneta()).atacarPlaneta(universo.getPlaneta(planetaOrigen));
		
	}
	public void atacarNaveBconTorreta(String planetaOrigen){
		universo.getPlaneta(planetaOrigen).getTorreta().atacarNaveB(universo.mostrarNavesBEnemigasTorreteables(universo.getPlaneta(planetaOrigen)));
	}
	public void atacarNaveDconTorreta(String planetaOrigen){
		universo.getPlaneta(planetaOrigen).getTorreta().atacarNaveD(universo.mostrarNavesDEnemigasTorreteables(universo.getPlaneta(planetaOrigen)));
	}

	public void setJugadorControlador(Jugador j){
		this.jugador=j;
		
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	public void avanzarTurno(){
		this.universo.avanzarTurno();
	}
	public boolean finalizarJuego(){
		for(Jugador j: universo.getJugadores()){
			if(j.getLplanetas().size()==3){
				universo.isJuegoFinalizado();
				return true;
			}
		}
		return false;
	}
	
	public void Ejecutar(){
		for(int i=0;!universo.isJuegoFinalizado(); i++){
				this.vistaprin.textArea.append("Turno: "+ i);
				for(Jugador j: universo.getJugadores()){
					
					this.vistaprin.textArea.append("Le toca a " + j.getNombre());
				
				/*
				case 13:
					//Torreta ataca Nave D
					universo.mostrarNavesBEnemigasEnOrbita(j);
					System.out.println("Elija el planeta que desea defender");
					leerString();
					universo.getPlaneta(stringLeido).getTorreta().atacarNaveD(universo.mostrarNavesDEnemigasTorreteables(universo.getPlaneta(stringLeido)));
					break;
				default:
					System.out.println("La opcion seleccionada no existe en el menu, trate otra vez: ");
					leerOpcion();
					break;	*/
				}
				this.universo.avanzarTurno();
				}
		}	
	}


