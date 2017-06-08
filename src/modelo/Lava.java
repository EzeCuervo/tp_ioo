package modelo;

public class Lava extends Planeta {
		
		public Lava(String nombre) {
			super(nombre);
			// TODO Auto-generated constructor stub
		}

		public String toString() {
			// TODO Auto-generated method stub
			return"El Planeta " + this.nombre + " es Lava" + 
					"con " + this.poblacion + " habitantes.";
		}

		public void avanzarTurno(){
			super.avanzarTurno();
			//En el planeta lava de la poblacion crece linealmente
			this.poblacion = this.turnoActualElemento *3;
		}
}
