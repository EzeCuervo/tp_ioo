package modelo;

public class NaveTC extends NaveEspacial{
	public NaveTC(int idOwner, int idPlaneta){
		super(idOwner, idPlaneta);
		this.damNav=0;
		this.damPob=0;
		this.resistencia=8000;
		this.poblacion=600;
	}
	
	private void idOwner(int idPlaneta) {
		// TODO Auto-generated method stub
		
	}

	public void colonizar(Planeta planeta){
		
	}

	@Override
	public void atacarNave(Planeta planeta) {
		// TODO Auto-generated method stub
		
	}

}
