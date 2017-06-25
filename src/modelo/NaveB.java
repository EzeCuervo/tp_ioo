package modelo;

public class NaveB extends NaveEspacial {
	public NaveB(int idOwner, int idPlaneta){
		super(idOwner, idPlaneta);
		this.damNav=600;
		this.damPob=0;
		this.resistencia=500;
		
	}
	public void atacarNaveB(NaveB nav){
		if(nav.resistencia>=0){
		nav.resistencia=nav.resistencia-damNav;
		}
	}

	public String toString() {
		// TODO Auto-generated method stub
		return"Nave de Batalla";
	}
}
