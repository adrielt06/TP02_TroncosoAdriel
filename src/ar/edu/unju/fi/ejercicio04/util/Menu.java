package ar.edu.unju.fi.ejercicio04.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;


public class Menu {
	private int opcion;
	
	public void generarMenu() {
		Scanner sc = new Scanner(System.in);
		do {
			imprimirMenu();
			setOpcion(elegirOpcion(sc));
			switch(this.opcion) {
			case 1:
				altaJugador(sc);
				break;
			case 2:
				if (!Listado.jugadores.isEmpty()) {
					System.out.println("**LISTADO DE JUGADORES**");
					Listado.jugadores.forEach(a -> System.out.println(a.toString()));
				}else {
					System.out.println("ERROR: La lista de jugadores esta vacia.");
				}
				break;
			case 3:
				modificarPosicion(sc);
				break;
			case 4:
				eliminarJugador(sc);
				break;
			case 5:
				sc.close();
				break;
			}
			
		}while(opcion != 5);
	}
	
	private void eliminarJugador(Scanner sc) {
		boolean encontrado = false;
		if(!Listado.jugadores.isEmpty()) {
			System.out.print("Ingrese el nombre del jugador a modificar: ");
			String nombre = sc.nextLine();
			System.out.print("Ingrese el apellido del jugador a modificar: ");
			String apellido = sc.nextLine();
			
			Iterator<Jugador> iterador = Listado.jugadores.iterator();
			while(iterador.hasNext()) {
				Jugador a = iterador.next();
				if(a.getNombre().equalsIgnoreCase(nombre) && a.getApellido().equalsIgnoreCase(apellido)) {
					System.out.println("**JUGADOR ENCONTRADO Y ELIMINADO CORRECTAMENTE**");
					Listado.jugadores.remove(a);
					encontrado = true;
					break;
				}
			}
			if(!encontrado) {
				System.out.println("ERROR: No se ha encontrado el jugador.");
			}
		}else {
			System.out.println("ERROR: La lista de jugadores esta vacia.");
		}
	}
	
	private void modificarPosicion(Scanner sc) {
		boolean encontrado = false;
		Jugador modificado = new Jugador();
		if(!Listado.jugadores.isEmpty()) {
			System.out.print("Ingrese el nombre del jugador a modificar: ");
			String nombre = sc.nextLine();
			System.out.print("Ingrese el apellido del jugador a modificar: ");
			String apellido = sc.nextLine();
			for(Jugador a : Listado.jugadores) {
				if(a.getNombre().equalsIgnoreCase(nombre) && a.getApellido().equalsIgnoreCase(apellido)) {
					encontrado = true;
					modificado = a;
					System.out.println("**Jugador Encontrado**");
				}
			}
			if(!encontrado) {
				System.out.println("ERROR: el nombre y apellido ingresado no pertenece a ningun jugador.");
			}else {
				modificado.setPosicion(validarPosicion(sc));
				System.out.println("**MODIFICACION REALIZADA CORRECTAMENTE**");
			}
		}else {
			System.out.println("ERROR: La lista de jugadores esta vacia.");
		}
	}
	
	private void altaJugador(Scanner sc) {
		Jugador jugador = new Jugador();
		
		System.out.print("Ingrese nombre de jugador: ");
		jugador.setNombre(sc.nextLine());
		
		System.out.print("Ingrese apellido de jugador: ");
		jugador.setApellido(sc.nextLine());
		
		jugador.setFechaNac(validarFecha(sc));
		
		System.out.print("Ingrese nacionalidad de jugador: ");
		jugador.setNacionalidad(sc.nextLine());
		
		jugador.setEstatura(validarEstatura(sc));
		
		jugador.setPeso(validarPeso(sc));
		
		jugador.setPosicion(validarPosicion(sc));
		
		Listado.jugadores.add(jugador);
		
		System.out.println("**JUGADOR AGREGADO CORRECTAMENTE**");
		
	}
	
	private Posicion validarPosicion(Scanner sc) {
		byte i = 0;
		boolean valido = false;
		Posicion posicion = null;
		while (!valido) {
			System.out.println("**POSICIONES**");
	        System.out.println("1- DELANTERO.");
	        System.out.println("2- MEDIO.");
	        System.out.println("3- DEFENSA.");
	        System.out.println("4- ARQUERO.");
	        System.out.print("Ingresa la posicion del jugador: ");
	        try {
	            i = sc.nextByte();
	            if (i >= 1 && i <= 4) {
	                valido = true;
	            } else {
	                System.out.println("ERROR: debe ingresar un numero en el rango [1-4]");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("ERROR: Debe ingresar un numero, intente nuevamente.");
	            sc.nextLine();
	        }
	    }
		switch(i) {
		case 1:
			posicion = Posicion.DELANTERO;
			break;
		case 2:
			posicion = Posicion.MEDIO;
			break;
		case 3:
			posicion = Posicion.DEFENSA;
			break;
		case 4:
			posicion = Posicion.ARQUERO;
			break;
		}
		
		return posicion;
	}
	
	private float validarPeso(Scanner sc) {
		float peso = 0.0f;
		boolean valido = false;
		while (!valido) {
			System.out.print("Ingrese el peso del jugador: ");
			try {
				peso = sc.nextFloat();
				sc.nextLine();
				valido = true;
			} catch (InputMismatchException e) {
				System.out.println("ERROR: Debe ingresar un numero, intente nuevamente.");
				sc.nextLine();
			} 
		}
		return peso;
	}
	
	private float validarEstatura(Scanner sc) {
		float est = 0.0f;
		boolean valido = false;
		while (!valido) {
			System.out.print("Ingrese la estatura del jugador: ");
			try {
				est = sc.nextFloat();
				sc.nextLine();
				valido = true;
			} catch (InputMismatchException e) {
				System.out.println("ERROR: Debe ingresar un numero, intente nuevamente.");
				sc.nextLine();
			}
		}
		return est;
	}
	
	private int elegirOpcion(Scanner sc) {
		int opc;
		try {
			do {
				System.out.print("Elija una opcion: ");
				opc = sc.nextInt();
				sc.nextLine();
				if(opc < 1 || opc > 5) {
					System.out.println("ERROR: Debe ingresar una opcion en el rango [1-4]");
				}
			} while (opc < 1 || opc > 5);
			
		} catch (InputMismatchException e) {
			System.out.println("ERROR: Debe ingresar un numero, intente nuevamente.");
			sc.nextLine();
			return elegirOpcion(sc);
		}
		return opc;
	}
	
	private LocalDate validarFecha(Scanner sc) {
		LocalDate fechaNac = LocalDate.now();
		boolean valido = false;
		while (!valido) {
			System.out.print("Ingrese fecha de nacimiento de jugador(dd/mm/yyyy): ");
			try {
				String fechaNacString = sc.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
				fechaNac = LocalDate.parse(fechaNacString, formatter);
				valido = true;
			} catch (DateTimeParseException e) {
				System.out.println("ERROR: Formato de fecha incorrecto, intente nuevamente.");
			} 
		}
		return fechaNac;
	}
	
	private void imprimirMenu() {
		System.out.println("---------------------------");
		System.out.println("** MENU DE OPCIONES **");
		System.out.println("1 – Alta de Jugador.");
		System.out.println("2 – Mostrar Jugadores.");
		System.out.println("3 – Modificar Posicion de Jugador.");
		System.out.println("4 – Eliminar Jugador.");
		System.out.println("5 – Salir.");
		System.out.println("---------------------------");
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
	
}
