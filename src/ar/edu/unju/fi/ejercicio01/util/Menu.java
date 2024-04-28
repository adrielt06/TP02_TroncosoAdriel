package ar.edu.unju.fi.ejercicio01.util;

import java.util.InputMismatchException;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;


public class Menu {
	private int opcion;

	public void generarMenu() {
		Scanner sc = new Scanner(System.in);
		do {
			imprimirMenu();
			setOpcion(elegirOpcion(sc));
			switch(this.opcion) {
			case 1:
				crearProducto(sc);
				break;
			case 2:
				if (!Listado.productos.isEmpty()) {
					System.out.println("**LISTADO DE PRODUCTOS**");
					Listado.productos.forEach(a -> System.out.println(a.toString()));
				}else {
					System.out.println("ERROR: La lista de productos esta vacia.");
				}
				break;
			case 3:
				modificarProducto(sc);
				break;
			case 4:
				sc.close();
				break;
			}
			
		}while(this.opcion != 4);
	}
	
	private void modificarProducto(Scanner sc) {
		boolean encontrado = false, valido = false;
		int opc=0;
		Producto modificado = new Producto();
		if(!Listado.productos.isEmpty()) {
			System.out.print("Ingrese el codigo del producto a modificar: ");
			String buscado = sc.nextLine();
			for(Producto a : Listado.productos) {
				if(a.getCodigo().equalsIgnoreCase(buscado)) {
					encontrado = true;
					modificado = a;
					System.out.println("**Producto Encontrado**");
				}
			}
			if(!encontrado) {
				System.out.println("ERROR: el codigo ingresado no pertenece a ningun producto.");
			}else {
				while (!valido) {
					System.out.println("**Atributos modificables**");
					System.out.println("1 - Descripción");
					System.out.println("2 - Precio unitario");
					System.out.println("3 - Origen fabricacion");
					System.out.println("4 - Categoría");
					try {
						System.out.print("Ingrese el atributo que desea modificar: ");
						opc = sc.nextInt();
						sc.nextLine();
						if(opc>=1 && opc <=4) {
							valido = true;
						}else {
							System.out.println("ERROR: Debe ingresar un numero en el rango [1-4]");
						}
					} catch (InputMismatchException e) {
						System.out.println("ERROR: Debe ingresar un numero, intente nuevamente.");
						sc.nextLine();
					}
				}
				switch(opc) {
				case 1:
					System.out.print("Ingrese descripcion para el producto: ");
					modificado.setDescripcion(sc.nextLine());
					break;
				case 2:
					modificado.setPrecioU(validarPrecio(sc));
					break;
				case 3:
					modificado.setOrigenFabricacion(validarOrigen(sc));
					break;
				case 4:
					modificado.setCategoria(validarCategoria(sc));
					break;
				}
				System.out.println("**MODIFICACION REALIZADA CORRECTAMENTE**");
			}
		}else {
			System.out.println("ERROR: La lista de productos esta vacia.");
		}
	}
	
	private void crearProducto(Scanner sc) {
		Producto producto = new Producto();
		boolean repetido=false;
		
		do {
			System.out.print("Ingrese codigo de producto: ");
			String candidato = sc.nextLine();
			repetido = Listado.productos.stream().anyMatch(a -> a.getCodigo().equalsIgnoreCase(candidato));
			producto.setCodigo(candidato);
			if(repetido) {
				System.out.println("ERROR: El codigo ingresado ya esta en uso.");
			}
		} while (repetido);
		
		System.out.print("Ingrese descripcion del producto: ");
		producto.setDescripcion(sc.nextLine());
		
		producto.setPrecioU(validarPrecio(sc));
		
		producto.setOrigenFabricacion(validarOrigen(sc));
		
		producto.setCategoria(validarCategoria(sc));
		
		Listado.productos.add(producto);
		System.out.println("**PRODUCTO AGREGADO CORRECTAMENTE**");
		
	}
	
	private Categoria validarCategoria(Scanner sc) {
		byte i = 0;
		boolean valido = false;
		Categoria categoria = null;
		while (!valido) {
			System.out.println("**CATEGORIAS**");
	        System.out.println("1- TELEFONIA.");
	        System.out.println("2- INFORMATICA.");
	        System.out.println("3- ELECTRO HOGAR.");
	        System.out.println("4- HERRAMIENTAS.");
	        System.out.print("Ingresa la categoria del producto: ");
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
			categoria = Categoria.TELEFONIA;
			break;
		case 2:
			categoria = Categoria.INFORMATICA;
			break;
		case 3:
			categoria = Categoria.ELECTROHOGAR;
			break;
		case 4:
			categoria = Categoria.HERRAMIENTAS;
			break;
		}
		
		return categoria;
	}
	
	private OrigenFabricacion validarOrigen (Scanner sc) {
		byte i = 0;
		boolean valido = false;
		OrigenFabricacion origen = null;
		while (!valido) {
			System.out.println("**ORIGEN DE FABRICACION**");
	        System.out.println("1- ARGENTINA.");
	        System.out.println("2- CHINA.");
	        System.out.println("3- BRASIL.");
	        System.out.println("4- URUGUAY.");
	        System.out.print("Ingrese el pais de origen del producto: ");
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
			origen = OrigenFabricacion.ARGENTINA;
			break;
		case 2:
			origen = OrigenFabricacion.CHINA;
			break;
		case 3:
			origen = OrigenFabricacion.BRASIL;
			break;
		case 4:
			origen = OrigenFabricacion.URUGUAY;
			break;
		}
		
		return origen;
	}
	
	private double validarPrecio(Scanner sc) {
		double precio = 0;
		boolean valido = false;
		while (!valido) {
			System.out.print("Ingrese el precio por unidad del producto: ");
			try {
				precio = sc.nextDouble();
				sc.nextLine();
				valido = true;
			} catch (InputMismatchException e) {
				System.out.println("ERROR: Debe ingresar un numero, intente nuevamente.");
				sc.nextLine();
			} 
		}
		return precio;
	}
	
	
	private void imprimirMenu() {
		System.out.println("---------------------------");
		System.out.println("** MENU DE OPCIONES **");
		System.out.println("1 – Crear Producto.");
		System.out.println("2 – Mostrar productos.");
		System.out.println("3 – Modificar producto.");
		System.out.println("4 – Salir.");
		System.out.println("---------------------------");
	}
	
	private int elegirOpcion(Scanner sc) {
		int opc;
		try {
			do {
				System.out.print("Elija una opcion: ");
				opc = sc.nextInt();
				sc.nextLine();
				if(opc < 1 || opc > 4) {
					System.out.println("ERROR: Debe ingresar una opcion en el rango [1-4]");
				}
			} while (opc < 1 || opc > 4);
			
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
