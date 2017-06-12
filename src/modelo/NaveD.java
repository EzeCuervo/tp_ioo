package modelo;

public class NaveD extends NaveEspacial {
	public NaveD(int idOwner, int idPlaneta){
		super(idOwner, idPlaneta);
		this.damNav=0;
		this.damPob=5;
		this.resistencia=5000;
		this.poblacion=80;
		
	}
	public void atacarPlaneta(Planeta planeta){
		planeta.poblacion=planeta.poblacion-damPob;
		planeta.cantidadTorretas=planeta.cantidadTorretas-1;
		
		
	}
	@Override
	public void atacarNave(Planeta planeta) {
		// TODO Auto-generated method stub
		
	}
	public void viajar(Planeta destino) {
		// TODO Auto-generated method stub
		
	}
	public String toString() {
		// TODO Auto-generated method stub
		return"Nave de Destructora";
	}

}
