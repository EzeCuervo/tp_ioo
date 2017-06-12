package modelo;

public class NaveB extends NaveEspacial {
	public NaveB(int idOwner, int idPlaneta){
		super(idOwner, idPlaneta);
		this.damNav=500;
		this.damPob=0;
		this.resistencia=3500;
		this.poblacion=50;
		
	}
	public void atacarNave(Planeta planeta){
		for(NaveEspacial p : planeta.getLnavesB()){
			p.resistencia=resistencia-damNav;
		}
		
	}
	public void viajar(Planeta destino) {
		// TODO Auto-generated method stub
		
	}
	public String toString() {
		// TODO Auto-generated method stub
		return"Nave de Batalla";
	}
}
