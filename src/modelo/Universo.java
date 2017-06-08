package modelo;

import java.util.*;

public class Universo extends ElementoDelJuego {
	private List <Planeta> lplanetas;
	private List <ElementoDelJuego> elementos;
	private List <Jugador> jugadores;
	public List<ElementoDelJuego> getElementos(){
		return this.elementos;
	}

	public void avanzarTurno(){
		super.avanzarTurno();
		for (ElementoDelJuego e : this.elementos){
			e.avanzarTurno();
		}
		this.actualizarObservadores();
	}
	
	public Universo(){
		jugadores = new ArrayList<Jugador>();
		lplanetas = new ArrayList<Planeta>();
		elementos = new ArrayList<ElementoDelJuego>();

	}
	
	public Planeta getPlaneta(String nombre){
		for(Planeta p: lplanetas){
			if(nombre==p.getNombre()){
				return p;
			}
			
		}
		return null;
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
		// Se crean 5 planetas
		Planeta tierra = new Terrestre("Tierra");
		Planeta marte = new  Terrestre("Marte");
		Planeta venus =  new Tundra ("Venus");
		Planeta junip = new Lava("Junip");
		Planeta melmack = new Tundra("Melmack");
		this.lplanetas.add(tierra);	
		this.lplanetas.add(marte);
		this.lplanetas.add(venus);
		this.lplanetas.add(junip);
		this.lplanetas.add(melmack);
	}
	
}
