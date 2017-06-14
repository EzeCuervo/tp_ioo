package modelo;

public abstract class NaveEspacial extends ElementoDelJuego{
	protected static int tiempoDeViaje=1;
	protected int falta=tiempoDeViaje;
	protected int idOwner;
	protected int idPlaneta;
	protected int idPlanetaDest;
	protected int resistencia;
	protected int damNav;
	protected int damPob;
	private boolean enTransito;
	
	public abstract String toString();
	
	public void avanzarTurno() {
		super.avanzarTurno();
		if(this.enTransito){
			if(falta==0){
				this.idPlaneta=this.idPlanetaDest;
				this.enTransito=false;
				this.idPlaneta=-1;
			}else{
				this.falta--;
				this.idPlaneta=-1;
			}
		}
		

	}
	public int getIdPlaneta() {
		return idPlaneta;
	}

	public void setIdPlaneta(int idPlaneta) {
		this.idPlaneta = idPlaneta;
	}

	public int getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(int idOwner) {
		this.idOwner = idOwner;
	}

	public NaveEspacial(int idOwner, int idPlaneta){
		super();
		this.resistencia=resistencia;
		this.damNav=damNav;
		this.idOwner=idOwner;
		this.idPlaneta=idPlaneta;
		this.idPlanetaDest=-1;
		this.enTransito=false;

	}


	public int getIdPlanetaDest() {
		return idPlanetaDest;
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

	public void viajar(Planeta destino){
		this.enTransito=true;
		this.idPlanetaDest=destino.getIdPlaneta();
	}
	
}
