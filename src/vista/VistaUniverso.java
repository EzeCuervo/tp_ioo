package vista;

import observer.IObservador;
import modelo.*;

public class VistaUniverso implements IObservador{
	private Universo universo;
	
	public VistaUniverso(Universo universo){
		this.universo = universo;
	}
	
	public void actualizar(){
		System.out.println("********************************************");
		System.out.println("				Universo");
		System.out.println("********************************************");
		System.out.println("Tengo "+ Planeta.GetCantidadPlanetas() + "Planetas ");
		for(ElementoDelJuego e: this.universo.getElementos()){
			System.out.println(e.toString());
		}
		System.out.println("********************************************");
	}
}
