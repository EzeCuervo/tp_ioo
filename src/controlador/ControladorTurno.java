package controlador;

import java.io.IOException;

import modelo.*;

public class ControladorTurno {
	
	private int cantidadTurnos;
	public Universo universo;
	
	public ControladorTurno(Universo universo, int turnos){
		this.cantidadTurnos=turnos;
		this.universo=universo;
	}

	public void Ejecutar(){
		for(int i=0;i<this.cantidadTurnos; i++){
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.universo.avanzarTurno();
			System.out.println("Probando lo nuevo");
		}
	}
}
