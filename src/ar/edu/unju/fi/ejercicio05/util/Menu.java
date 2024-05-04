package ar.edu.unju.fi.ejercicio05.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Product;




public class Menu {
	private int opcion;
	
	public void generarMenu() {
		Scanner sc = new Scanner(System.in);
		do {
			List<Product> disponibles = Listado.filtrarDisponibles();
			imprimirMenu();
			setOpcion(elegirOpcion(sc));
			switch(this.opcion) {
			case 1:
				System.out.println("**LISTADO DE PRODUCTOS**");
				Listado.productos.forEach(a -> a.mostrarProduct());
				break;
			case 2:
				realizarCompra(sc, disponibles);
				break;
			case 3:
				sc.close();
				break;

			}
			
		}while(opcion != 3);
	}
	
	private void realizarCompra(Scanner sc, List<Product> disponibles) {
		boolean continuar = true, agregado = false, valido = false;
		double total = 0;
		int opc = 0;
		List<Product> carrito = new ArrayList<Product>();
		
		System.out.println("**LISTADO DE PRODUCTOS DISPONIBLES**");
		disponibles.forEach(a -> a.mostrarProduct());
		while(continuar) {
			agregado = false;
			
			if(!carrito.isEmpty()) {
				System.out.println("**PRODUCTOS EN EL CARRITO**");
				carrito.forEach(a -> a.mostrarProduct());
			}
			
			System.out.println("------------------------------------------");
			System.out.println("Total en carrito: $"+total);
			System.out.print("Ingrese el codigo del producto a comprar('N' para finalizar): ");
			String codigo = sc.nextLine();
			
			for(Product p : disponibles) {
				if(p.getCodigo().equalsIgnoreCase(codigo)) {
					total += p.getPrecioU();
					carrito.add(p);
					agregado = true;
					System.out.println("**Producto Agregado al Carrito**");
				}
			}
			if(!agregado && !codigo.equalsIgnoreCase("N")) {
				System.out.println("ERROR: El codigo ingresado no pertenece a ningun producto o no hay stock del producto.");
			}
			
			if(codigo.equalsIgnoreCase("N")) {
				continuar = false;
			}
		}
		
		while (!valido) {
			System.out.println("**MEDIOS DE PAGO**");
			System.out.println("1 - Pago Efectivo.");
			System.out.println("2 - Pago con tarjeta.");
			try {
				System.out.print("Ingrese el medio de pago deseado: ");
				opc = sc.nextInt();
				sc.nextLine();
				if(opc>=1 && opc <=2) {
					valido = true;
				}else {
					System.out.println("ERROR: Debe ingresar un numero en el rango [1-2]");
				}
			} catch (InputMismatchException e) {
				System.out.println("ERROR: Debe ingresar un numero, intente nuevamente.");
				sc.nextLine();
			}
		}
		
		switch(opc) {
		case 1:
			PagoEfectivo efectivo = new PagoEfectivo(total, LocalDate.now());
			efectivo.realizarPago(total);
			efectivo.imprimirRecibo();
			break;
		case 2:
			System.out.print("Ingrese el numero de tarjeta: ");
			String numTarjeta = sc.nextLine();
			PagoTarjeta tarjeta = new PagoTarjeta(numTarjeta, LocalDate.now(), total);
			tarjeta.realizarPago(total);
			tarjeta.imprimirRecibo();
		}
		
		System.out.println("**PAGO REALIZADO CON EXITO**");
	}
	
	private void imprimirMenu() {
		System.out.println("---------------------------");
		System.out.println("** MENU DE OPCIONES **");
		System.out.println("1 – Mostrar Productos.");
		System.out.println("2 – Realizar Compra.");
		System.out.println("3 – Salir.");
		System.out.println("---------------------------");
	}
	
	private int elegirOpcion(Scanner sc) {
		int opc;
		try {
			do {
				System.out.print("Elija una opcion: ");
				opc = sc.nextInt();
				sc.nextLine();
				if(opc < 1 || opc > 3) {
					System.out.println("ERROR: Debe ingresar una opcion en el rango [1-3]");
				}
			} while (opc < 1 || opc > 3);
			
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
