package controlador;

import java.io.IOException;
import java.util.Scanner;

import modelo.*;
import vista.VistaConsola;

public class ControladorTurno {
	Scanner sc = new Scanner (System.in);
	Scanner sc2 = new Scanner (System.in);
	private int cantidadTurnos;
	int opcion;
	String leerString;
	public Universo universo;
	
	public ControladorTurno(Universo universo, int turnos){
		super();
		this.cantidadTurnos=turnos;
		this.universo=universo;
	}
	
	public void leerString(){
		this.leerString=sc2.nextLine();
	}
	
	public void leerOpcion(){
		this.opcion = sc.nextInt();
	}
	
	public void crearJugador(Universo universo){
		leerString();
		Jugador jug = new Jugador(leerString);
		universo.unirJugador(jug);
	}
	
	public void Ejecutar(){
		for(int i=0;i<this.cantidadTurnos; i++){
			System.out.println("Turno: "+ i);
			for(Jugador j: universo.getJugadores()){
				System.out.println("Le toca a " + j.getNombre());
				leerOpcion();
			switch(opcion){
			case 1:
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.prodNaveB(j.getPlaneta(leerString));
				break;
			case 2:
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.prodNaveD(j.getPlaneta(leerString));
				break;
			case 3:
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.prodNaveTC(j.getPlaneta(leerString));
				break;
			case 4:
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.prodTorreta(j.getPlaneta(leerString));
				break;
			case 5:
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.mejorarProdPlaneta(j.getPlaneta(leerString));
				break;
				}
			this.universo.avanzarTurno();
			}
		}
			
	}
}

