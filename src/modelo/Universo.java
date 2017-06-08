package modelo;

import java.util.*;

public class Universo extends ElementoDelJuego {
	private List <Planeta> lplanetas = new ArrayList<Planeta>();
	private List <ElementoDelJuego> elementos = new ArrayList<ElementoDelJuego>();
	
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
		Planeta tierra = new Terrestre("Tierra");
		Planeta marte = new  Tundra("Marte");
		Planeta venus =  new Tundra ("Venus");
		lplanetas.add(marte);
		lplanetas.add(tierra);
		lplanetas.add(venus);

	}
	
	public Planeta getPlaneta(String nombre){
		for(Planeta p: lplanetas){
			if(nombre==p.getNombre()){
				return p;
			}
			
		}
		return null;
	}
	
}
