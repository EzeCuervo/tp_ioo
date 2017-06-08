package vista;
import javax.swing.*;
import modelo.Universo;
import observer.IObservador;

	public class VistaVentana implements IObservador{
		private Universo universo;
		
		public VistaVentana(Universo universo){
			this.universo = universo;
		}

		@Override
		public void actualizar() {
			// TODO Auto-generated method stub
			
		}
}
