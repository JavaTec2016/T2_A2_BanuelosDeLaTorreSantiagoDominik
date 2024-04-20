
/*
 * PAQUETES EN JAVA
 * 
 * 	Son DIRECTORIOS (carpetas) sin comprirmir o comprimidos (JAR) dentro de un proyecto
 * 	y que contienen basicamente archivos tipo BYTECODE para la ejecucion de programas
 * 	en Java
 * 
 * Pueden contener otros archivos como imagenes, sonido, iconos, documentos, etc.
 * 
 * 
 * 	Para crear una estructura de paquetes se utiliza un convencion:
 * 
 * 		- Dominio del sitio web de la institucion/empresa, pero a la inversa
 * 
 * 			Ejemplo:
 * 				Dominio web:  tecjerez.edu.mx
 * 				
 * 				Paquete: edu.tecjerez.nombrePaquete
 * 
 * 						 edu.tecjerez.topicos.modelo
 * 
 * 
 *  Cuando se crean paquetes se debe indicar con la palabra reservada PACKAGE 
 *  como primer linea del codigo fuente
 * 
 */

package edu.tecjerez.topicos;


import javax.swing.SwingUtilities;

import edu.tecjerez.topicos.vista.VentanaInicio;


public class PruebaPaquetes {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new VentanaInicio();
			}
		});
	}
}
