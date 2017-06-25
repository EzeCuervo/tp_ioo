package vista;
import javax.swing.JFrame;

import modelo.Universo;
import observer.IObservador;

	public class VistaVentana implements IObservador{
		private Universo universo;
		private JFrame f;
		
		public VistaVentana(Universo universo){
			this.universo = universo;
			f = new JFrame();
			
		}

		@Override
		public void actualizar() {
			// TODO Auto-generated method stub
			
		}
}
