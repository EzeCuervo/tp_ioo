package vista;

import observer.IObservador;
import modelo.*;

public class VistaConsola implements IObservador{
	private Universo universo;
	
	public VistaConsola(Universo universo){
		this.universo = universo;
	}
	
	public void actualizar(){
		System.out.println("********************************************");
		System.out.println("Universo");
		System.out.println("********************************************");
		for(Jugador j: this.universo.getJugadores()){
			System.out.println(j.toString());
			for(Planeta pl: this.universo.getLplanetas()){
				if(pl.getIdOwner()==j.getIdJugador()){
				System.out.println(pl.toString());
				for(NaveEspacial navB: this.universo.getLnavesB()){
					if(navB.getIdPlaneta()==pl.getIdPlaneta()){
						System.out.println(navB.toString());
					}
				}
				for(NaveEspacial navD: this.universo.getLnavesD()){
					if(navD.getIdPlaneta()==pl.getIdPlaneta()){
						System.out.println(navD.toString());
					}
				}
				for(NaveEspacial navTC: this.universo.getLnavesTC()){
					if(navTC.getIdPlaneta()==pl.getIdPlaneta()){
						System.out.println(navTC.toString());
					}
				}
			}
			}
		}
		System.out.println("********************************************");
		menuAcciones();
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
	
	public void menuAcciones(){
		System.out.println("********************************************");
		System.out.println("Menu de acciones posibles");
		System.out.println("********************************************");
		System.out.println("1  - Producir nave de Batalla");
		System.out.println("2  - Producir nave de Destructor");
		System.out.println("3  - Producir nave colonizadora");
		System.out.println("4  - Producir torreta");
		System.out.println("5  - Mejorar produccion de planeta");
		System.out.println("6  - Enviar Nave Colonizadora a Planeta");
		System.out.println("7  - Enviar Nave Batalla a Planeta");
		System.out.println("8  - Enviar Nave Destructora a Planeta");
		System.out.println("9  - Colonizar Planeta");
		System.out.println("10 - Atacar Nave");
		System.out.println("11 - Atacar Planeta");
		System.out.println("Seleccione una opcion:");

	}
		
	public void inicioJuego(){
		System.out.println("********************************************");
		System.out.println("Juego inicializado!");
		System.out.println("********************************************");
		for(Jugador j: this.universo.getJugadores()){
			System.out.println("Jugador: " + j.getNombre().toString());
			for(Planeta pl : universo.getLplanetas()){
				if(j.getIdJugador()==pl.getIdOwner())
				System.out.println("Tiene el planeta " + pl.getNombre());
			}
		}
	}

}

