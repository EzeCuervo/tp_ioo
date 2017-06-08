package modelo;
import observer.Observado;
public abstract class ElementoDelJuego extends Observado {
	protected static int ultimoTurno=0;
	protected int turnoActualElemento;
	public void avanzarTurno(){
		this.turnoActualElemento= ultimoTurno;
		ultimoTurno++;
	}

}
