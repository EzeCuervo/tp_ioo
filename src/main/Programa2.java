package main;
import java.awt.EventQueue;

import controlador.ControladorVentanas;
import modelo.Jugador;
import modelo.Universo;
import vistaVentana.AddPlayer;
import vistaVentana.Principal;


public class Programa2 {

	public static void main(String[] args) {
		// Instancio todas las clases
		//EventQueue.invokeLater(new Runnable() {// runnable es una interfaz
		//	public void run (){
		Universo universo = new Universo ();
		Principal vistaprincipal = new Principal(universo);
		AddPlayer vistaaddplayer = new AddPlayer();
		ControladorVentanas controladorv = new ControladorVentanas(universo);
		
		//Registro las ventanas en el controlador
		controladorv.setVistaPrincipal(vistaprincipal);
		controladorv.setVistaAddPlayer(vistaaddplayer);
		
		vistaprincipal.setControlador(controladorv);
		vistaaddplayer.setControlador(controladorv);
		
		
		//Registro observadores
		universo.registrarObservador(vistaprincipal);
		
		//Se crean los usuarios de juego (2)
		while(universo.getJugadores().size()<2){
		vistaaddplayer.setVisible(true);
		}
		vistaaddplayer.setVisible(false);
		
		//Se crean los planetas y se asigna 1 a cada jugador
		universo.incializarUniverso();
		
		//Pantalla de inicio
  		vistaprincipal.setJugador(universo.getJugadores().get(0));
  		controladorv.setJugadorControlador(universo.getJugadores().get(0));
  		vistaprincipal.setVisible(true);
  		vistaprincipal.inicioJuegoVentana();
  		//vistaprincipal.menuAccionesVentana();
  		vistaprincipal.leToca();
			}
}
		//	});
  		//controladorv.Ejecutar();

		//Pantalla de fin de juego
		//vista.juegoFinalizado();*/


	