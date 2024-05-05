package ar.edu.unju.fi.ejercicio07.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio07.model.Producto;

public class Listado{
	public static List<Producto> productos = new ArrayList<Producto>();
	
	public static void precarga() {
		Producto p01 = new Producto("P-01", "Lapiz", 100, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true);
		Producto p02 = new Producto("P-02", "Computadora", 400000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true);
		Producto p03 = new Producto("P-03", "Telefono Celular", 100000, OrigenFabricacion.CHINA, Categoria.TELEFONIA, false);
		Producto p04 = new Producto("P-04", "Heladera", 500000, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true);
		Producto p05 = new Producto("P-05", "Martillo", 5000, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, true);
		Producto p06 = new Producto("P-06", "Calefactor", 20000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false);
		Producto p07 = new Producto("P-07", "Hacha", 15000, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true);
		Producto p08 = new Producto("P-08", "Tarjeta SIM", 1000, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true);
		Producto p09 = new Producto("P-09", "Notebook", 300000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Producto p10 = new Producto("P-10", "Destornillador", 3000, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, true);
		Producto p11 = new Producto("P-11", "Tablet", 120000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Producto p12 = new Producto("P-12", "Cinta Metrica", 15000, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true);
		Producto p13 = new Producto("P-13", "Cocina", 400000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true);
		Producto p14 = new Producto("P-14", "Teclado", 12000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true);
		Producto p15 = new Producto("P-15", "Sierra electrica", 60000, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		
		productos = Arrays.asList(p01,p02,p03,p04,p05,p06,p07,p08,p09,p10,p11,p12,p13,p14,p15);
	}
	
	public static void mostrarDisponibles(){
		Consumer<Producto> mostrar = p -> {
				if(p.isEstado());
				p.mostrarProduct();
		};
		
		Listado.productos.forEach(mostrar);
	}
	
	public static void mostrarNoDisponibles(){
		Predicate<Producto> condicion = p -> !p.isEstado();
		productos.stream().filter(condicion).forEach(a -> a.mostrarProduct());
	}
	
	public static List<Producto> aumentarPrecio(){
		Function<Producto, Producto> nuevoPrecio = p -> {
			p.setPrecioU(p.getPrecioU()*(double)1.2);
			return p;
		};
		
		return productos.stream().map(nuevoPrecio).collect(Collectors.toList());
	}
	
	public static void mostrarElecrohogarDisponibles() {
		Predicate<Producto> condicion = p -> p.getCategoria().equals(Categoria.ELECTROHOGAR) && p.isEstado();
		productos.stream().filter(condicion).forEach(a -> a.mostrarProduct());
	}
	
	public static List<Producto> ordenarPorPrecio(){
		Comparator<Producto> comparador = Comparator.comparing(Producto :: getPrecioU).reversed();
		productos.sort(comparador);
		return productos;
	}
	
	public static void mostrarEnMayus() {
		Function<Producto, Producto> convertirMayus = p -> {
			Producto copiaProducto = new Producto(p.getCodigo(), p.getDescripcion(), p.getPrecioU(), p.getOrigenFabricacion(), p.getCategoria(), p.isEstado());
			copiaProducto.setDescripcion(copiaProducto.getDescripcion().toUpperCase());
			return copiaProducto;
		};
		
		productos.stream().map(convertirMayus).forEach(a -> a.mostrarProduct());
	}
	
}
