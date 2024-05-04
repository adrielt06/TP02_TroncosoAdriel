package ar.edu.unju.fi.ejercicio05.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio05.model.Product;

public class Listado {
	public static List<Product> productos = new ArrayList<Product>();
	
	public static void precarga() {
		Product p01 = new Product("P-01", "Lapiz", 100, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true);
		Product p02 = new Product("P-02", "Computadora", 400000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true);
		Product p03 = new Product("P-03", "Telefono Celular", 100000, OrigenFabricacion.CHINA, Categoria.TELEFONIA, false);
		Product p04 = new Product("P-03", "Heladera", 500000, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true);
		Product p05 = new Product("P-04", "Martillo", 5000, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, true);
		Product p06 = new Product("P-06", "Calefactor", 20000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false);
		Product p07 = new Product("P-07", "Hacha", 15000, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true);
		Product p08 = new Product("P-08", "Tarjeta SIM", 1000, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true);
		Product p09 = new Product("P-09", "Notebook", 300000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Product p10 = new Product("P-10", "Destornillador", 3000, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, true);
		Product p11 = new Product("P-11", "Tablet", 120000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Product p12 = new Product("P-12", "Cinta Metrica", 15000, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true);
		Product p13 = new Product("P-13", "Cocina", 400000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true);
		Product p14 = new Product("P-14", "Teclado", 12000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true);
		Product p15 = new Product("P-15", "Sierra electrica", 60000, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		
		productos = Arrays.asList(p01,p02,p03,p04,p05,p06,p07,p08,p09,p10,p11,p12,p13,p14,p15);
	}
	
	public static List<Product> filtrarDisponibles(){
		return productos.stream().filter(p->p.isEstado()).collect(Collectors.toList());
	}
}
