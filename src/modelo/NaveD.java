package modelo;

public class NaveD extends NaveEspacial {
	public NaveD(int idOwner, int idPlaneta){
		super(idOwner, idPlaneta);
		this.damNav=0;
		this.damPob=5;
		this.resistencia=5000;
		
	}
	public void atacarPlaneta(Planeta planeta){
		if(planeta.poblacion>=0){
		planeta.poblacion=planeta.poblacion-damPob;
		}
		if(planeta.cantidadTorretas>=0){
		planeta.cantidadTorretas=planeta.cantidadTorretas-1;
		}
		
	}

	public void viajar(Planeta destino) {
		// TODO Auto-generated method stub
		
	}
	public String toString() {
		// TODO Auto-generated method stub
		return"Nave de Destructora";
	}
	@Override
	public void atacarNaveB(NaveB nav) {
		// TODO Auto-generated method stub
		
	}

}
