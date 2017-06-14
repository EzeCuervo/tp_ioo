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
				int cantND=0, cantNB=0, cantNTC=0;
				if(pl.getIdOwner()==j.getIdJugador()){
					System.out.println(pl.toString());
					for(NaveEspacial navB: this.universo.getLnavesB()){
						if(navB.getIdPlaneta()==pl.getIdPlaneta()){
							cantNB++;
							//System.out.println(navB.toString());
						}
						if(navB.isEnTransito()){
							System.out.println("Nave Batalla esta viajando a " + universo.getNombrePlaneta(navB.getIdPlanetaDest()));
						}
					}
					for(NaveEspacial navD: this.universo.getLnavesD()){
						if(navD.getIdPlaneta()==pl.getIdPlaneta()){
							cantND++;
							//System.out.println(navB.toString());
						}
						if(navD.isEnTransito()){
							System.out.println("Nave Destructora esta viajando a " + universo.getNombrePlaneta(navD.getIdPlanetaDest()));
						}
					}
					for(NaveEspacial navTC: this.universo.getLnavesTC()){
						if(navTC.getIdPlaneta()==pl.getIdPlaneta()){
							cantNTC++;
							//System.out.println(navTC.toString());
						}
						if(navTC.isEnTransito()){
							System.out.println("Nave Transporte/Colonizadora esta viajando a " + universo.getNombrePlaneta(navTC.getIdPlanetaDest()));
						}
					}
					if(cantNB!=0)
					System.out.println(cantNB + " Nave/s Batalla");
					if(cantND!=0)
					System.out.println(cantND + " Nave/s Destructora");
					if(cantNTC!=0)
					System.out.println(cantNTC + " Nave/s Colonizadora/Transportadora");
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
		System.out.println("12 - Atacar Nave Batalla con Torreta");
		System.out.println("13 - Atacar Nave Destructora con Torreta");
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
	public void juegoFinalizado(){
		System.out.println("********************************************");
		System.out.println("Juego Finalizado!");
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



