package edu.tecjerez.topicos.figuras.d3;

public abstract interface Voluminoso {
	default double obtenerVolumen() {
		return 0;
	}
	
	public class Cono implements Voluminoso {
		private double r = 0;
		private double h = 0;
		public Cono(double rd, double ht) {
			r = rd;
			h = ht;
		}
		@Override
		public double obtenerVolumen() {
			// TODO Auto-generated method stub
			return r*r*Math.PI*(1.0/3.0)*h;
		}
	}
	
	public class Piramide implements Voluminoso {
		private double l = 0;
		private double n = 0;
		private double h = 0;
		
		
		public Piramide(double ld, double ht) {
			l=ld;
			h=ht;
		}
		
		@Override
		public double obtenerVolumen() {
			// TODO Auto-generated method stub
			
			return 1.0/3.0 * l*l * h;
		}
	}
}



