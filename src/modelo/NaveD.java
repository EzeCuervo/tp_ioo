package modelo;

public class NaveD extends NaveEspacial {
	public NaveD(){
		super();
		this.damNav=0;
		this.damPob=5;
		this.resistencia=5000;
		this.poblacion=80;
		
	}
	public void atacarPlaneta(Planeta planeta){
		planeta.poblacion=planeta.poblacion-damPob;
		planeta.cantidadTorretas=planeta.cantidadTorretas-1;
		
		
	}

}