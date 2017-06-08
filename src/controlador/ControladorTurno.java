package controlador;

import java.io.IOException;
import java.util.Scanner;

import modelo.*;

public class ControladorTurno {
	Scanner sc = new Scanner (System.in);
	private int cantidadTurnos;
	private String nombreUsuario;
	public Universo universo;
	
	public ControladorTurno(Universo universo, int turnos){
		super();
		this.cantidadTurnos=turnos;
		this.universo=universo;
	}
	
	public void leerNombreUsuario(){
		this.nombreUsuario=sc.nextLine();
	}
	public void crearJugador(Universo universo){
		leerNombreUsuario();
		Jugador jug = new Jugador(nombreUsuario);
		universo.unirJugador(jug);
	}
	
	public void Ejecutar(){
		for(int i=0;i<this.cantidadTurnos; i++){
			try {
				System.out.println("Turno: "+ i);
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.universo.avanzarTurno();
		}
	}
}
