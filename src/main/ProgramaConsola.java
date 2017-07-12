package main;
import controlador.ControladorConsola;
import modelo.Universo;
import vistaConsola.VistaConsola;


public class ProgramaConsola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Universo universo = new Universo ();
		VistaConsola vista = new VistaConsola(universo);
		ControladorConsola controlador = new ControladorConsola (universo);
		universo.registrarObservador(vista);
		
		//Se crean los 2 usuarios de juego
		for(int i=0; i<2;i++){
			vista.mostrarInsertarNombreJugador();
			controlador.crearJugador(universo);
		}
		//Se crean los planetas y se asigna 1 a cada jugador
		universo.incializarUniverso();
		
		//Pantalla de inicio
		vista.inicioJuego();
		vista.menuAcciones();
		controlador.Ejecutar();

		//Pantalla de fin de juego
		vista.juegoFinalizado();

	}
}

	