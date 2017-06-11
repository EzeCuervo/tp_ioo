package modelo;

import java.util.*;

public class Universo extends ElementoDelJuego {
	private boolean juegoFinalizado=true;
	private List <Planeta> lplanetas;
	private List <Jugador> jugadores;
	public List<Planeta> getElementos(){
		return this.lplanetas;
	}

	public void avanzarTurno(){
		super.avanzarTurno();
		for (Planeta pl : this.lplanetas){
			pl.avanzarTurno();
		}
		this.actualizarObservadores();
	}
	
	public Universo(){
		super();
		jugadores = new ArrayList<Jugador>();
		lplanetas = new ArrayList<Planeta>();

	}
	
	public Planeta getPlaneta(String nombre){
		for(Planeta p: lplanetas){
			if(nombre==p.getNombre()){
				return p;
			}
			
		}
		return null;
	}
	
	public void asignarPlaneta(Planeta p, int idJugador){
		if(p.idOwner == -1){
			for(Jugador j : jugadores){
				if(idJugador==j.getIdJugador()){
					j.getLplanetas().add(p);
					p.idOwner=idJugador;
					p.poblacion=2;
				}
			}
		}
	}
	
	public void unirJugador(Jugador jugador){
		jugadores.add(jugador);
		
	}


	public List<Jugador> getJugadores() {
		return jugadores;
	}


	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public void incializarUniverso(){
		// Se crean 4 planetas
		Planeta tierra = new Terrestre("Tierra");
		Planeta marte = new  Terrestre("Marte");
		Planeta junip = new Lava("Junip");
		Planeta melmack = new Tundra("Melmack");
		this.lplanetas.add(tierra);	
		this.lplanetas.add(marte);
		this.lplanetas.add(junip);
		this.lplanetas.add(melmack);
		//Se asigna 1 planeta a cada jugador
		asignarPlaneta(tierra, 0);
		asignarPlaneta(marte,1);
	}

	public boolean isJuegoFinalizado() {
		return juegoFinalizado;
	}

	public void setJuegoFinalizado(boolean juegoFinalizado) {
		this.juegoFinalizado = juegoFinalizado;

	}
	
	public List<Planeta> getLplanetas() {
		return lplanetas;
	}

	public void mostrarPlanetasUser(Jugador j){
		System.out.println("Tus planetas:");
		for(Planeta pl : j.getLplanetas()){
			System.out.println(pl.getNombre());
		}
	}
	public void mostrarPlanetasSinUser(){
		System.out.println("Planetas sin colonizar:");
		for(Planeta pl : getLplanetas()){
			if(pl.getIdOwner()==-1)
			System.out.println(pl.getNombre());
		}
	}
	public void mostrarPlanetasConNTC(Jugador j){
		System.out.println("Planetas naves colonizadoras:");
		for(Planeta pl : j.getLplanetas()){
			if(!pl.getLnavesTC().isEmpty()){
			System.out.println(pl.getNombre());
			}
		}
	}
}

