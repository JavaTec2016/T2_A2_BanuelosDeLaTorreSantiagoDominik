package edu.tecjerez.topicos.figuras.d2;

public class Conico {
	double obtenerArea() {return 0;}
	double obtenerPerimetro() {return 0;}
	
	public class Circulo extends Conico {
		private double r = 0;
		public Circulo(double rd) {
			r=rd;
		}
		@Override
		public double obtenerArea() {
			return r*r*Math.PI;
		}

		@Override
		public double obtenerPerimetro() {
			return 2*Math.PI*r;
		}
		
	}

	public class Elipse extends Conico {
		private double r1 = 0;
		private double r2 = 0;
		public Elipse(double rd1, double rd2) {
			r1=rd1;
			r2=rd2;
		}
		@Override
		public double obtenerArea() {
			return Math.PI*r1*r2;
		}
		public double obtenerH() {
			return Math.pow((r1-r2)/(r1+r2), 2);
		}
		public double obtenerPerimetro() {
			double H = obtenerH();
			return Math.PI*(r2+r1)*(1+(H/10+Math.sqrt(4-3*H)));
		}
		public double obtenerPerimetro2() {
			return 2*Math.PI*(( (r1-r2)/(Math.PI/2) )+r2);
		}
		
	}

}
