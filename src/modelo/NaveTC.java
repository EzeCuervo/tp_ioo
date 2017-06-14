package modelo;

public class NaveTC extends NaveEspacial{
	private int poblacion;

	public NaveTC(int idOwner, int idPlaneta){
		super(idOwner, idPlaneta);
		this.damNav=0;
		this.damPob=0;
		this.resistencia=100;
		this.poblacion=0;
	}
	
	public void agregarIntegrantes(int integrantes){
		this.poblacion=integrantes;
	}
	
	public void colonizar(Planeta planeta){
		planeta.setPoblacion(this.poblacion);
		planeta.setIdOwner(idOwner);
		this.poblacion=0;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return"Nave de Transportadora/Colonizadora";
	}

}
