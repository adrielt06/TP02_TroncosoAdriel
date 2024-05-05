package ar.edu.unju.fi.ejercicio07.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	private int opcion;
	
	public void generarMenu() {
		Scanner sc = new Scanner(System.in);
		do {
			imprimirMenu();
			setOpcion(elegirOpcion(sc));
			switch(this.opcion) {
			case 1:
				System.out.println("**LISTADO DE PRODUCTOS DISPONIBLES**");
				Listado.mostrarDisponibles();
				break;
			case 2:
				System.out.println("**LISTADO DE PRODUCTOS NO DISPONIBLES**");
				Listado.mostrarNoDisponibles();
				break;
			case 3:
				Listado.productos = Listado.aumentarPrecio();
				System.out.println("**SE HA AUMENTADO EL PRECIO DE LOS PRODUCTOS CORRECTAMETNE**");
				break;
			case 4:
				System.out.println("**MOSTRANDO LISTA DE PRODUCTOS ELECTROHOGAR DISPONIBLES**");
				Listado.mostrarElecrohogarDisponibles();
				break;
			case 5:
				Listado.productos= Listado.ordenarPorPrecio();
				Listado.productos.forEach(a -> a.mostrarProduct());
				System.out.println("**SE HA ORDENADO LA LISTA POR PRECIO**");
				break;
			case 6:
				System.out.println("**LISTADO DE PRODUCTOS CON NOMBRE EN MAYUSCULA**");
				Listado.mostrarEnMayus();
				break;
			case 7:
				sc.close();
				break;
			}
			
		}while(opcion != 7);
	}
	
	private static void imprimirMenu() {
		System.out.println("---------------------------");
		System.out.println("** MENU DE OPCIONES **");
		System.out.println("1 – Mostrar productos disponibles.");
		System.out.println("2 – Mostrar los productos faltantes.");
		System.out.println("3 – Incrementar los precios de los productos en un 20%.");
		System.out.println("4 – Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles.");
		System.out.println("5 – Ordenar los productos por precio de forma descendente.");
		System.out.println("6 - Mostrar los productos con los nombres en mayúsculas.");
		System.out.println("7 - Salir");
	}
	
	private static int elegirOpcion(Scanner sc) {
		int opc;
		try {
			do {
				System.out.print("Elija una opcion: ");
				opc = sc.nextInt();
				sc.nextLine();
				if(opc < 1 || opc > 7) {
					System.out.println("ERROR: Debe ingresar una opcion en el rango [1-7]");
				}
			} while (opc < 1 || opc > 7);
			
		} catch (InputMismatchException e) {
			System.out.println("ERROR: Debe ingresar un numero, intente nuevamente.");
			sc.nextLine();
			return elegirOpcion(sc);
		}
		return opc;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
	
}
