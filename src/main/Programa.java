package main;
import controlador.ControladorTurno;
import vista.VistaUniverso;
import modelo.Universo;


public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Universo universo = new Universo ();
		VistaUniverso vista = new VistaUniverso(universo);
		ControladorTurno controlador = new ControladorTurno (universo, 5);
		
		universo.registrarObservador(vista);
		controlador.Ejecutar();
		System.out.println("a ver si funca esta garchaaaaa");
	}

}
