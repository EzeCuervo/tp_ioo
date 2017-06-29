package modelo;

public class Torreta {
	private int damNave;
	private int idPlaneta;
	
	public Torreta(int idPlaneta){
		this.damNave=1000;
		this.setIdPlaneta(idPlaneta);
	}
	

	public int getDamNave() {
		return damNave;
	}
	public void setDamNave(int damNave) {
		this.damNave = damNave;
	}
	public void atacarNaveB(NaveB nav){
		if(nav.resistencia>=0){
			nav.resistencia=nav.resistencia-damNave;
		}
	}
	public void atacarNaveD(NaveD nav){
		if(nav.resistencia>=0){
			nav.resistencia=nav.resistencia-damNave;
		}
	}


	public int getIdPlaneta() {
		return idPlaneta;
	}


	public void setIdPlaneta(int idPlaneta) {
		this.idPlaneta = idPlaneta;
	}
	
	

}
;