package modelo;

public class NaveTC extends NaveEspacial{
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
	
	public void colonizar(Planeta planeta, int integrantes){
		planeta.setPoblacion(integrantes);
		planeta.setIdOwner(idOwner);
		this.poblacion=0;
	}

	@Override
	public void atacarNave(Planeta planeta) {
		// TODO Auto-generated method stub
		
	}

}
