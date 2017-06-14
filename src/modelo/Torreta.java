package modelo;

public class Torreta {
	private int damNave;
	
	public Torreta(){
		this.damNave=600;
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
	
	

}
