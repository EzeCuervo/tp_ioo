package controlador;

import java.io.IOException;
import java.util.Scanner;

import modelo.*;
import vista.VistaConsola;

public class ControladorTurno {
	Scanner sc = new Scanner (System.in);
	Scanner sc2 = new Scanner (System.in);
	Scanner sc3 = new Scanner (System.in);
	private int cantidadTurnos=1000;
	int opcion;
	String stringLeido;
	String stringLeido2;
	public Universo universo;
	
	public ControladorTurno(Universo universo){
		super();
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
				//Producir nave Batalla
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.getPlaneta(stringLeido).prodNaveB();
				break;
			case 2:
				//Producir nave Destructora
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.getPlaneta(stringLeido).prodNaveD();
				break;
			case 3:
				//Producir nave Transportadora/Colonizadora
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.getPlaneta(stringLeido).prodNaveTC();
				break;
			case 4:
				//Producir torreta
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.getPlaneta(stringLeido).construirTorretas();
				break;
			case 5:
				//Mejorar produccion Planeta
				universo.mostrarPlanetasUser(j);
				System.out.println("Ingrese nombre planeta: ");
				leerString();
				j.getPlaneta(stringLeido).mejorarPlaneta();
				break;
			case 6:
				//Viajar Nave Colonizadora
				universo.mostrarPlanetasSinUser();
				System.out.println("Ingrese nombre planeta al que quiere enviar la nave colonizadora:");
				leerString();
				universo.mostrarPlanetasConNTC(j);
				System.out.println("Ingrese planeta de donde sale la nave colonizadora");
				leerString2();
				System.out.println("Ingrese la cantidad de integrantes de la nave colonizadora (MIN 1 - MAX " + universo.getPlaneta(stringLeido2).getPoblacion() + ")");
				leerOpcion();
				//Agrego los tripulantes
				universo.getNaveTC(j.getIdJugador()).agregarIntegrantes(opcion);
				j.getPlaneta(stringLeido2).setPoblacion(j.getPlaneta(stringLeido2).getPoblacion()-opcion);
				//Hago viajar a la nave al planeta destino
				universo.getNaveTC(j.getIdJugador()).viajar(universo.getPlaneta(stringLeido2));
				break;
			case 9:
				//Colonizar
				universo.mostrarNavesListasColonizar(j);
				System.out.println("Elija planeta a colonizar:");
				leerString();
				universo.getNaveTC(j.getIdJugador()).colonizar(universo.getPlaneta(stringLeido));
				universo.getLnavesTC().remove(universo.getNaveTC(j.getIdJugador()));	
				break;
			}
			this.universo.avanzarTurno();
			}
		}
			
	}
}

