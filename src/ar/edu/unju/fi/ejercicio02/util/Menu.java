package ar.edu.unju.fi.ejercicio02.util;

import java.util.InputMismatchException;
import java.util.Scanner;


import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Menu {
	private int opcion;
	
	public void generarMenu() {
		Scanner sc = new Scanner(System.in);
		do {
			imprimirMenu();
			setOpcion(elegirOpcion(sc));
			switch(this.opcion) {
			case 1:
				crearEfemeride(sc);
				break;
			case 2:
				if (!Listado.efemerides.isEmpty()) {
					System.out.println("**LISTADO DE PRODUCTOS**");
					Listado.efemerides.forEach(a -> System.out.println(a.toString()));
				}else {
					System.out.println("ERROR: La lista de efemerides esta vacia.");
				}
				break;
			case 3:
				eliminarEfemeride(sc);
				break;
			case 4:
				modificarEfemeride(sc);
				break;
			case 5:
				sc.close();
				break;
			}
			
		}while(this.opcion != 5);
	}
	
	private void modificarEfemeride(Scanner sc) {
		boolean encontrado = false, valido = false;
		int opc = 0;
		Efemeride modificado = new Efemeride();
		if(!Listado.efemerides.isEmpty()) {
			System.out.print("Ingrese el codigo de la efemeride a modificar: ");
			String buscado = sc.nextLine();
			for(Efemeride a : Listado.efemerides) {
				if(a.getCodigo().equalsIgnoreCase(buscado)) {
					encontrado = true;
					modificado = a;
					System.out.println("**Efemeride encontrada**");
				}
			}
			if(!encontrado) {
				System.out.println("ERROR: El codigo ingresado no pertenece a ninguna efemeride.");
			}else {
				while(!valido) {
					System.out.println("**Atributos modificables**");
					System.out.println("1 - Mes");
					System.out.println("2 - Dia");
					System.out.println("3 - Detalle");
					try {
						System.out.print("Ingrese el atributo que desea modificar: ");
						opc = sc.nextInt();
						sc.nextLine();
						if(opc>=1 && opc <=3) {
							valido = true;
						}else {
							System.out.println("ERROR: Debe ingresar un numero en el rango [1-3]");
						}
					} catch (InputMismatchException e) {
						System.out.println("ERROR: Debe ingresar un numero, intente nuevamente.");
						sc.nextLine();
					}
				}
				switch(opc) {
				case 1:
					modificado.setMes(validarMes(sc));
					break;
				case 2:
					modificado.setDia(validarDia(sc, modificado.getMes()));
					break;
				case 3:
					System.out.print("Ingrese el detalle de la efemeride: ");
					modificado.setDetalle(sc.nextLine());
					break;
				}
				System.out.println("**MODIFICACION REALIZADA CORRECTAMENTE**");
			}
		}else {
			System.out.println("ERROR: La lista de efemerides esta vacia.");
		}
	}
	
	private void eliminarEfemeride(Scanner sc) {
		boolean encontrado = false;
		if(!Listado.efemerides.isEmpty()) {
			System.out.print("Ingrese el codigo de la efemeride a eliminar: ");
			String buscado = sc.nextLine();
			encontrado = Listado.efemerides.removeIf(e -> e.getCodigo().equalsIgnoreCase(buscado));
			if (encontrado) {
				System.out.println("**EFEMERIDE ELIMINADA CORRECTAMENTE**");
			}else {
				System.out.println("ERROR: El codigo ingresado no pertenece a ninguna efemeride.");
			}
		}else {
			System.out.println("ERROR: La lista de efemerides esta vacia.");
		}
	}
	
	private void crearEfemeride(Scanner sc) {
		Efemeride efemeride = new Efemeride();
		boolean repetido = false;
		Mes mes;
		
		do {
			System.out.print("Ingrese codigo de efemeride: ");
			String candidato = sc.nextLine();
			repetido = Listado.efemerides.stream().anyMatch(a -> a.getCodigo().equalsIgnoreCase(candidato));
			efemeride.setCodigo(candidato);
			if(repetido) {
				System.out.println("ERROR: El codigo ingresado ya esta en uso.");
			}
		} while (repetido);
		
		mes = validarMes(sc);
		efemeride.setMes(mes);
		
		efemeride.setDia(validarDia(sc, mes));
		
		System.out.print("Ingrese el detalle de efemeride: ");
		efemeride.setDetalle(sc.nextLine());
		
		Listado.efemerides.add(efemeride);
		System.out.println("**EFEMERIDE AGREGADA CORRECTAMENTE**");
	}
	
	private int validarDia(Scanner sc, Mes mes) {
		byte i = 0;
		boolean valido = false;
		while(!valido) {
			System.out.print("Ingrese el dia de efemeride para el mes "+mes+": ");
			try {
				i = sc.nextByte();
				sc.nextLine();
				if(mes.equals(Mes.ENERO) || mes.equals(Mes.MARZO) || mes.equals(Mes.MAYO) || mes.equals(Mes.JULIO) || mes.equals(Mes.AGOSTO) || mes.equals(Mes.OCTUBRE) || mes.equals(Mes.DICIEMBRE)) {
					if(i >= 1 && i<=31) {
						valido = true;
					}
				}
				if(mes.equals(Mes.ABRIL) || mes.equals(Mes.JUNIO) || mes.equals(Mes.SEPTIEMBRE) || mes.equals(Mes.NOVIEMBRE)) {
					if(i >= 1 && i<=30) {
						valido = true;
					}
				}
				if(mes.equals(Mes.FEBRERO)) {
					if(i >= 1 && i<=29) {
						valido = true;
					}
				}
				if(!valido) {
					System.out.println("ERROR: Debe ingresar un dia valido para el mes "+mes+".");
				}
			} catch (InputMismatchException e) {
	            System.out.println("ERROR: Debe ingresar un numero, intente nuevamente.");
	            sc.nextLine();
	        }
		}
		return i;
	}
	
	private Mes validarMes(Scanner sc) {
		byte i = 0;
		boolean valido = false;
		Mes mes = null;
		while (!valido) {
			System.out.print("Ingresa el mes de la efemeride (rango 1 a 12): ");
			try {
	            i = sc.nextByte();
	            sc.nextLine();
	            if (i >= 1 && i <= 12) {
	                valido = true;
	            } else {
	                System.out.println("ERROR: debe ingresar un numero en el rango [1-12]");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("ERROR: Debe ingresar un numero, intente nuevamente.");
	            sc.nextLine();
	        }
		}
		switch(i) {
		case 1:
			mes = Mes.ENERO;
			break;
		case 2:
			mes = Mes.FEBRERO;
			break;
		case 3:
			mes = Mes.MARZO;
			break;
		case 4:
			mes = Mes.ABRIL;
			break;
		case 5:
			mes = Mes.MAYO;
			break;
		case 6:
			mes = Mes.JUNIO;
			break;
		case 7:
			mes = Mes.JULIO;
			break;
		case 8:
			mes = Mes.AGOSTO;
			break;
		case 9:
			mes = Mes.SEPTIEMBRE;
			break;
		case 10:
			mes = Mes.OCTUBRE;
			break;
		case 11:
			mes = Mes.NOVIEMBRE;
			break;
		case 12:
			mes = Mes.DICIEMBRE;
			break;
		}
		return mes;
	}
	
	private void imprimirMenu() {
		System.out.println("---------------------------");
		System.out.println("** MENU DE OPCIONES **");
		System.out.println("1 – Crear efemeride.");
		System.out.println("2 – Mostrar efemerides.");
		System.out.println("3 – Eliminar efemeride.");
		System.out.println("4 – Modificar efemeride.");
		System.out.println("5 – Salir.");
		System.out.println("---------------------------");
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

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
	
}
