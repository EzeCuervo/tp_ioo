package modelo;

import java.util.*;

public class Universo extends ElementoDelJuego {
	private boolean juegoFinalizado;
	private List <Planeta> lplanetas;
	private List <Jugador> jugadores;
	private List<NaveEspacial> lnavesB;
	private List<NaveEspacial> lnavesD;
	private List<NaveEspacial> lnavesTC;

	public void avanzarTurno(){
		super.avanzarTurno();
		for (Planeta pl : this.lplanetas){
			if(pl.getLnavesB().size()!=0){
				for(NaveEspacial nav: pl.getLnavesB()){
					this.lnavesB.add(nav);
				}
				pl.getLnavesB().clear();
			}
			if(pl.getLnavesD().size()!=0){
				for(NaveEspacial nav: pl.getLnavesD()){
					this.lnavesD.add(nav);
				}
				pl.getLnavesD().clear();
			}
			if(pl.getLnavesTC().size()!=0){
				for(NaveEspacial nav: pl.getLnavesTC()){
					this.lnavesTC.add(nav);					
				}
				pl.getLnavesTC().clear();
			}
			if(lnavesB.size()!=0){
				for(NaveEspacial nav: lnavesB){
					if(nav.getResistencia()<=0){
						lnavesB.remove(nav);
					}
				}
			}
			if(lnavesD.size()!=0){
				for(NaveEspacial nav: lnavesD){
					if(nav.getResistencia()<=0){
						lnavesD.remove(nav);
					}
				}
			}
		pl.avanzarTurno();
		}
		for(Planeta planeta : this.lplanetas){
			for(Jugador j : jugadores){
				if(!j.getLplanetas().contains(planeta) && j.getIdJugador()==planeta.getIdOwner()){
					asignarPlaneta(planeta, j.getIdJugador(), planeta.getPoblacion());
				}
				
			}
		}
		for(Jugador j : jugadores){
			if(j.getLplanetas().size()==3){
				setJuegoFinalizado(true);
			}
			
		}
		this.actualizarObservadores();
	}
	
	public void setLplanetas(List<Planeta> lplanetas) {
		this.lplanetas = lplanetas;
	}

	public Universo(){
		super();
		jugadores = new ArrayList<Jugador>();
		lplanetas = new ArrayList<Planeta>();
		lnavesB = new ArrayList<NaveEspacial>();
		lnavesD = new ArrayList<NaveEspacial>();
		lnavesTC = new ArrayList<NaveEspacial>();

	}
	
	public Planeta getPlaneta(String nombre){
		for(Planeta p: lplanetas){
			if(nombre.equals(p.getNombre())){
				return p;
			}
			
		}
		return null;
	}
	
	public void asignarPlaneta(Planeta p, int idJugador,int poblacionInicial){
		if(p.idOwner == -1){
			for(Jugador j : jugadores){
				if(idJugador==j.getIdJugador()){
					j.getLplanetas().add(p);
					p.idOwner=j.getIdJugador();
					p.poblacion=poblacionInicial;
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
		this.juegoFinalizado=false;
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
		asignarPlaneta(tierra, 0, 2);
		asignarPlaneta(marte,1, 2);
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
	public NaveTC getNaveTC(int idJugador){
		for(NaveEspacial nav : lnavesTC){
			if(nav.getIdOwner()==idJugador){
				return (NaveTC) nav;
			}
		}
		return null;
	}
	public NaveB getNaveB(int idJugador){
		for(NaveEspacial nav : lnavesB){
			if(nav.getIdOwner()==idJugador){
				return (NaveB) nav;
			}
		}
		return null;
	}
	public NaveD getNaveD(int idJugador){
		for(NaveEspacial nav : lnavesD){
			if(nav.getIdOwner()==idJugador){
				return (NaveD) nav;
			}
		}
		return null;
	}
	
	
	public void mostrarNavesListasColonizar(Jugador j){
		for(NaveEspacial nav: lnavesTC){
			if(nav.getIdOwner()==j.getIdJugador()){
				for(Planeta p: lplanetas){
					if(p.idOwner==-1&&p.idPlaneta==nav.getIdPlaneta()){
						System.out.println(getNombrePlaneta(p.idPlaneta));
					}
				}
			}
		}
	}
	public void mostrarNavesDeBatallaListasAtacar(Jugador j){
		for(NaveEspacial nav: lnavesB){
			if(nav.getIdOwner()==j.getIdJugador()){
				for(Planeta p: lplanetas){
					if(p.idOwner!=-1&&p.idPlaneta==nav.getIdPlaneta()&&p.idOwner!=j.getIdJugador()){
						System.out.println(getNombrePlaneta(p.idPlaneta));
					}
				}
			}
		}
	}
	public void mostrarNavesDestructoraListasAtacar(Jugador j){
		for(NaveEspacial nav: lnavesD){
			if(nav.getIdOwner()==j.getIdJugador()){
				for(Planeta p: lplanetas){
					if(p.idOwner!=-1&&p.idPlaneta==nav.getIdPlaneta()&&p.idOwner!=j.getIdJugador()){
						System.out.println(getNombrePlaneta(p.idPlaneta));
					}
				}
			}
		}
	}
	
	public List<NaveEspacial> getLnavesB() {
		return lnavesB;
	}

	public void setLnavesB(List<NaveEspacial> lnavesB) {
		this.lnavesB = lnavesB;
	}

	public List<NaveEspacial> getLnavesD() {
		return lnavesD;
	}

	public void setLnavesD(List<NaveEspacial> lnavesD) {
		this.lnavesD = lnavesD;
	}

	public List<NaveEspacial> getLnavesTC() {
		return lnavesTC;
	}

	public void setLnavesTC(List<NaveEspacial> lnavesTC) {
		this.lnavesTC = lnavesTC;
	}

	public String getNombrePlaneta(int idPlaneta){
		for(Planeta p: lplanetas){
			if(idPlaneta==p.getIdPlaneta()){
				return p.getNombre();
			}
			
		}
		return null;
	}
	
	
	public void mostrarPlanetasUser(Jugador j){
		System.out.println("Tus planetas:");
		for(Planeta pl : getLplanetas()){
			if(j.getIdJugador()==pl.idOwner){
			System.out.println(pl.getNombre());
			}
		}
	}
	public void mostrarPlanetasUserEnemigo(Jugador j){
		System.out.println("Planetas de tu enemigo:");
		for(Planeta pl : getLplanetas()){
			if(j.getIdJugador()!=pl.idOwner&&pl.idOwner!=-1){
				System.out.println(pl.getNombre());
			}
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
		System.out.println("Planetas con naves colonizadoras:");
		for(NaveEspacial nav : lnavesTC){
			if(nav.getIdOwner()==j.getIdJugador()){
				for(Planeta pl: getLplanetas()){
					if(nav.getIdPlaneta()==pl.getIdPlaneta() && nav.getIdOwner()==pl.getIdOwner()){
						System.out.println(pl.getNombre());
					}
				}
			}
		}
	}
	public void mostrarPlanetasConNB(Jugador j){
		System.out.println("Planetas con naves de batalla:");
		for(NaveEspacial nav : lnavesB){
			if(nav.getIdOwner()==j.getIdJugador()){
				for(Planeta pl: getLplanetas()){
					if(nav.getIdPlaneta()==pl.getIdPlaneta() && nav.getIdOwner()==pl.getIdOwner()){
						System.out.println(pl.getNombre());
					}
				}
			}
		}
	}
	public void mostrarPlanetasConND(Jugador j){
		System.out.println("Planetas con naves destructoras:");
		for(NaveEspacial nav : lnavesD){
			if(nav.getIdOwner()==j.getIdJugador()){
				for(Planeta pl: getLplanetas()){
					if(nav.getIdPlaneta()==pl.getIdPlaneta() && nav.getIdOwner()==pl.getIdOwner()){
						System.out.println(pl.getNombre());
					}
				}
			}
		}
	}
	public void mostrarNavesBEnemigasEnOrbita(Jugador j){
		System.out.println("Planetas con naves de batalla enemigas en orbita:");
		for(NaveEspacial nav : lnavesB){
			if(nav.getIdOwner()!=j.getIdJugador()){
				for(Planeta pl: getLplanetas()){
					if(nav.getIdPlaneta()==pl.getIdPlaneta() && nav.getIdOwner()!=pl.getIdOwner()){
						System.out.println(pl.getNombre());
					}
				}
			}
		}
	}
	public void mostrarNavesDEnemigasEnOrbita(Jugador j){
		System.out.println("Planetas con naves destructoras enemigas en orbita:");
		for(NaveEspacial nav : lnavesD){
			if(nav.getIdOwner()!=j.getIdJugador()){
				for(Planeta pl: getLplanetas()){
					if(nav.getIdPlaneta()==pl.getIdPlaneta() && nav.getIdOwner()!=pl.getIdOwner()){
						System.out.println(pl.getNombre());
					}
				}
			}
		}
	}
	public NaveB mostrarNavesBEnemigasTorreteables(Planeta p){
		System.out.println("Planetas con naves de batalla enemigas en orbita:");
		for(NaveEspacial nav: lnavesB){
			if(nav.getIdOwner()!=p.getIdOwner()&&nav.getIdPlaneta()==p.getIdPlaneta()){
				return (NaveB) nav;
			}
		}
		return null;
		
	}
	public NaveD mostrarNavesDEnemigasTorreteables(Planeta p){
		System.out.println("Planetas con naves destructoras enemigas en orbita:");
		for(NaveEspacial nav: lnavesD){
			if(nav.getIdOwner()!=p.getIdOwner()&&nav.getIdPlaneta()==p.getIdPlaneta()){
				return (NaveD) nav;
			}
		}
		return null;
		
	}
	
	
}

