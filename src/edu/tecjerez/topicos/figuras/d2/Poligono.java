package edu.tecjerez.topicos.figuras.d2;

public interface Poligono {

	double obtenerArea();
	double obtenerPerimetro();
	
	public class Rombo implements Poligono {
		double d1 = 0;
		double d2 = 0;
		
		
		public Rombo(double D1, double D2) {
			d1 = D1;
			d2 = D2;
		}
		@Override
		public double obtenerArea() {
			
			return d1*d2/2;
		}
		double getLado() {
			double r1 = d1/2;
			double r2 = d2/2;
			return Math.sqrt(r1*r1 + r2*r2);
		}
		@Override
		public double obtenerPerimetro() {
			
			return getLado()*4;
		}
		
		
	}
}

