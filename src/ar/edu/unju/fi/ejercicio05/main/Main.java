package ar.edu.unju.fi.ejercicio05.main;

import ar.edu.unju.fi.ejercicio05.util.Listado;
import ar.edu.unju.fi.ejercicio05.util.Menu;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		Listado.precarga();
		
		menu.generarMenu();
		
		System.out.println("FIN DE PROGRAMA");
	}

}
