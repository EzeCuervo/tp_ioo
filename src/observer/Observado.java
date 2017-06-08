package observer;
import java.util.*;

public abstract class Observado {
	private List<IObservador> observadores=new ArrayList<IObservador>();
	
	public void registrarObservador(IObservador obs){
		this.observadores.add(obs);
	}
	
	public void quitarObservador (IObservador obs){
		this.observadores.remove(obs);
	}
	public void actualizarObservadores(){
		for(IObservador obs : this.observadores)
			obs.actualizar();
	}

}
