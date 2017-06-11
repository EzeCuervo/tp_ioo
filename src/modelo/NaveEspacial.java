package modelo;

public abstract class NaveEspacial extends ElementoDelJuego{
	protected int idOwner;
	protected int idPlaneta;
	protected int resistencia;
	protected int damNav;
	protected int damPob;
	protected int poblacion;
	private boolean enTransito = false;
	
	
	public String toString() {
		// TODO Auto-generated method stub
		return "Soy una nave que transita el espacio en";
	}

	public abstract void atacarNave(Planeta planeta);
	
	public void avanzarTurno() {
		super.avanzarTurno();

	}
	public NaveEspacial(int idOwner, int idPlaneta){
		this.resistencia=resistencia;
		this.damNav=damNav;
		this.idOwner=idOwner;
		this.idPlaneta=idPlaneta;

	}


	public int getResistencia() {
		return resistencia;
	}


	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}



	public int getDamNav() {
		return damNav;
	}


	public void setDamNav(int damNav) {
		this.damNav = damNav;
	}


	public boolean isEnTransito() {
		return enTransito;
	}


	public void setEnTransito(boolean enTransito) {
		this.enTransito = enTransito;
	}
	
}
