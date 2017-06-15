package controlador;

import java.util.Scanner;

import modelo.Jugador;
import modelo.Universo;

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
				universo.getNaveTC(j.getIdJugador(), universo.getPlaneta(stringLeido2).getIdPlaneta()).agregarIntegrantes(opcion);
				j.getPlaneta(stringLeido2).setPoblacion(j.getPlaneta(stringLeido2).getPoblacion()-opcion);
				//Hago viajar a la nave al planeta destino
				universo.getNaveTC(j.getIdJugador(), universo.getPlaneta(stringLeido2).getIdPlaneta()).viajar(universo.getPlaneta(stringLeido));
				break;
			case 7:
				//Viaje Nave Batalla
				universo.mostrarPlanetasUserEnemigo(j);
				System.out.println("Ingrese el nombre del planeta de su enemigo al que quiere enviar una nave de batalla");
				leerString();
				universo.mostrarPlanetasConNB(j);
				System.out.println("Ingrese planeta de donde sale la nave de batalla");
				leerString2();
				//Hago viajar a la nave al planeta destino
				universo.getNaveB(j.getIdJugador(), universo.getPlaneta(stringLeido2).getIdPlaneta()).viajar(universo.getPlaneta(stringLeido));
				break;
			case 8:
				//Viaje Nave Destructora
				universo.mostrarPlanetasUserEnemigo(j);
				System.out.println("Ingrese el nombre del planeta de su enemigo al que quiere enviar una nave destructora");
				leerString();
				universo.mostrarPlanetasConND(j);
				System.out.println("Ingrese planeta de donde sale la nave de destructora");
				leerString2();
				//Hago viajar a la nave al planeta destino
				universo.getNaveD(j.getIdJugador(), universo.getPlaneta(stringLeido2).getIdPlaneta()).viajar(universo.getPlaneta(stringLeido));
				break;
			case 9:
				//Colonizar
				universo.mostrarNavesListasColonizar(j);
				System.out.println("Elija planeta a colonizar:");
				leerString();
				universo.getNaveTC(j.getIdJugador(), universo.getPlaneta(stringLeido).getIdPlaneta()).colonizar(universo.getPlaneta(stringLeido));
				universo.getLnavesTC().remove(universo.getNaveTC(j.getIdJugador(), universo.getPlaneta(stringLeido).getIdPlaneta()));	
				break;
			case 10:
				//Nave B ataca Nave B
				universo.mostrarNavesDeBatallaListasAtacar(j);
				System.out.println("Elija el planeta cuyas naves de batalla quiere atacar");
				leerString();
				//Chequear codigo
				//universo.getNaveB(j.getIdJugador(), universo.getPlaneta(stringLeido).getIdPlaneta()).atacarNaveB(universo.getNaveB(universo.getPlaneta(stringLeido).getIdOwner()));
				break;
			case 11:
				//Nave D ataca Planeta
				universo.mostrarNavesDestructoraListasAtacar(j);
				System.out.println("Elija el planeta que desea atacar");
				leerString();
				universo.getNaveD(j.getIdJugador(), universo.getPlaneta(stringLeido).getIdPlaneta()).atacarPlaneta(universo.getPlaneta(stringLeido));
				break;
			case 12:
				//Torreta ataca Nave B
				universo.mostrarNavesBEnemigasEnOrbita(j);
				System.out.println("Elija el planeta que desea defender");
				leerString();
				universo.getPlaneta(stringLeido).getTorreta().atacarNaveB(universo.mostrarNavesBEnemigasTorreteables(universo.getPlaneta(stringLeido)));
				break;
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
				break;	
			}
			this.universo.avanzarTurno();
			}
		}
			
	}
}

