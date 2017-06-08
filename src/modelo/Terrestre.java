package modelo;

public class Terrestre extends Planeta{
	public Terrestre(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	public void avanzarTurno(){
		super.avanzarTurno();
		//En el planeta terrestre de la poblacion crece en forma cuadratica
		this.poblacion = this.turnoActualElemento *this.turnoActualElemento;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return"El Planeta " + this.nombre + " es una terrestre" + 
				"con una poblacion de " + this.poblacion + " habitantes.";
	}

}
