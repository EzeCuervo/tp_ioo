package controlador;

import java.io.IOException;
import java.util.Scanner;

import modelo.*;
import vista.VistaConsola;

public class ControladorTurno {
	Scanner sc = new Scanner (System.in);
	Scanner sc2 = new Scanner (System.in);
	Scanner sc3 = new Scanner (System.in);
	private int cantidadTurnos;
	int opcion;
	String stringLeido;
	String stringLeido2;
	public Universo universo;
	
	public ControladorTurno(Universo universo, int turnos){
		super();
		this.cantidadTurnos=turnos;
		this.universo=universo;
	}
	
	public void leerString(){
		this.stringLeido=sc2.nextLine();
	}
	public void leerString2(){
		this.stringLeido2=sc3.nextLine();
	}
	
	public void leerOpcion(){
		this.opcion = sc.nextInt();
	}
	
	public void crearJugador(Universo universo){
		leerString();
		Jugador jug = new Jugador(stringLeido);
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
				j.prodNaveB(j.getPlaneta(stringLeido));
				break;
			case 2:
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.prodNaveD(j.getPlaneta(stringLeido));
				break;
			case 3:
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.prodNaveTC(j.getPlaneta(stringLeido));
				break;
			case 4:
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.prodTorreta(j.getPlaneta(stringLeido));
				break;
			case 5:
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.mejorarProdPlaneta(j.getPlaneta(stringLeido));
				break;
			case 6:
				//Colonizar planeta
				universo.mostrarPlanetasSinUser();
				System.out.println("Ingrese nombre planeta a colonizar:");
				leerString();
				universo.mostrarPlanetasConNTC(j);
				System.out.println("Ingrese planeta de donde sale la nave colonizadora");
				leerString2();
				System.out.println("Ingrese la cantidad de integrantes de la nave colonizadora (MIN 1 - MAX " + universo.getPlaneta(stringLeido2).getPoblacion() + ")");
				leerOpcion();
				j.colonizarPlaneta(universo.getPlaneta(stringLeido), universo.getPlaneta(stringLeido2), opcion);
				break;
			}
			this.universo.avanzarTurno();
			}
		}
			
	}
}

