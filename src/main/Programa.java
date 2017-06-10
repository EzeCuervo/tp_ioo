package main;
import controlador.ControladorTurno;
import vista.VistaConsola;
import modelo.Universo;


public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Universo universo = new Universo ();
		VistaConsola vista = new VistaConsola(universo);
		ControladorTurno controlador = new ControladorTurno (universo, 3);
		universo.registrarObservador(vista);
		//Se crean los 2 usuarios de juego
		for(int i=0; i<2;i++){
			vista.mostrarInsertarNombreJugador();
			controlador.crearJugador(universo);
		}
		//Se crean los planetas y se asigna 1 a cada jugador
		universo.incializarUniverso();
		while(universo.isJuegoFinalizado()){
			vista.inicioJuego();
			vista.menuAcciones();
			controlador.Ejecutar();
		}
	
		//vista.leerJugadores();
		//controlador.Ejecutar();

	}
}
