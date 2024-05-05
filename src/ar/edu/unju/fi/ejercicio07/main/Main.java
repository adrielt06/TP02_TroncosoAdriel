package ar.edu.unju.fi.ejercicio07.main;

import ar.edu.unju.fi.ejercicio07.util.Listado;
import ar.edu.unju.fi.ejercicio07.util.Menu;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		Listado.precarga();
		
		menu.generarMenu();
		
		System.out.println("FIN DE PROGRAMA");

	}

}
