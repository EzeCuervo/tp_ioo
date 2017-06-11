package modelo;

import java.util.List;
import java.util.ArrayList;

public class Jugador extends ElementoDelJuego{
	private static int ultimoJugador=0;
	private int idJugador;
	private String nombre;
	private List<Planeta> lplanetas;
	private List<NaveEspacial> lnaves;
	
	public Jugador(String nombre){
		this.idJugador=ultimoJugador;
		ultimoJugador++;
		this.nombre=nombre;
		lplanetas=new ArrayList<Planeta>();
		lnaves=new ArrayList<NaveEspacial>();
	}

	public int getIdJugador() {
		return idJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Planeta> getLplanetas() {
		return lplanetas;
	}
	
	public void prodNaveB(Planeta planeta){
		planeta.prodNaveB();
	}
	public void prodNaveD(Planeta planeta){
		planeta.prodNaveD();
	}
	public void prodNaveTC(Planeta planeta){
		planeta.prodNaveTC();
	}
	public void prodTorreta(Planeta planeta){
		planeta.construirTorretas();
	}
	public void mejorarProdPlaneta(Planeta planeta){
		planeta.mejorarPlaneta();
	}
	public void atacarPlaneta(Planeta planeta1, Planeta planeta2){
		
	}
	public void colonizarPlaneta(Planeta origen, Planeta destino, int integrantes){
		origen.getNaveTC(getLnaves()).agregarIntegrantes(integrantes);
		origen.viajarColonizar(destino,origen.getNaveTC(getLnaves()));
		//origen.getNaveTC(getLnaves()).colonizar(destino, integrantes);
	}

	public List<NaveEspacial> getLnaves() {
		return lnaves;
	}

	public void setLnaves(List<NaveEspacial> lnaves) {
		this.lnaves = lnaves;
	}
	
	public Planeta getPlaneta(String nombre){
		for(Planeta p: this.lplanetas){
			if(p.nombre.equals(nombre)){
				return p;
			}
		}
		return null;
	}
}

