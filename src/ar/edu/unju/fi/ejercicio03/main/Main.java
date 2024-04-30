package ar.edu.unju.fi.ejercicio03.main;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Provincia [] provincias = Provincia.values();
		
		System.out.println("**LISTADO DE PROVINCIAS**");
		for (Provincia p : provincias) {
			p.mostrarProvincia();
		}
	}

}
