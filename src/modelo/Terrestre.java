package modelo;

public class Terrestre extends Planeta{
	public Terrestre(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	public void avanzarTurno(){
		super.avanzarTurno();
		//En el planeta terrestre de la poblacion crece en forma cuadratica
		this.poblacion = this.poblacion * 2;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return"El Planeta " + this.nombre + " es un terrestre con " + this.poblacion + " habitantes. Su dueño es " + getIdOwner();
	}

}
