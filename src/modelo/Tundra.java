package modelo;

public class Tundra extends Planeta{
	
	public Tundra(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		// TODO Auto-generated method stub
		return"El Planeta " + this.nombre + " es una tundra" + 
				"con " + this.poblacion + " habitantes.";
	}

	public void avanzarTurno(){
		super.avanzarTurno();
		//En el planeta tundra de la poblacion crece linealmente
		this.poblacion = this.turnoActualElemento *2;
	}

}
