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
		System.out.println("Tengo "+ Planeta.GetCantidadPlanetas() + "Planetas ");
		for(ElementoDelJuego e: this.universo.getElementos()){
			System.out.println(e.toString());
		}
		System.out.println("********************************************");
	}
	
	public void leerJugadores(){
		System.out.println("********************************************");
		System.out.println("Jugadores");
		System.out.println("********************************************");
		for(Jugador j: this.universo.getJugadores()){
			System.out.println("Jugador: " + j.getNombre().toString());
		}
	}
	public void leerJugador(){
		System.out.println("********************************************");
		System.out.println("Nuevo jugador!");
		System.out.println("********************************************");
	}
	
	public void mostrarInsertarNombreJugador(){
		System.out.println("Por favor ingrese nombre de jugador:");
	}
	
	public void menuAcciones(){
		System.out.println("********************************************");
		System.out.println("Menu de acciones");
		System.out.println("********************************************");
		

	}
		
	public void inicioJuego(){
		System.out.println("********************************************");
		System.out.println("Juego inicializado!");
		System.out.println("********************************************");
		for(Jugador j: this.universo.getJugadores()){
			System.out.println("Jugador: " + j.getNombre().toString());
			for(Planeta pl : j.getLplanetas()){
				System.out.println("Tiene el planeta " + pl.getNombre());
			}
		}
		System.out.println("********************************************");
	}
}
