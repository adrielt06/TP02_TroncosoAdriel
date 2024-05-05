package ar.edu.unju.fi.ejercicio07.model;

import ar.edu.unju.fi.ejercicio05.model.Product;

public class Producto extends Product{

	public Producto() {
		super();
		
	}

	public Producto(boolean estado) {
		super(estado);
	
	}

	public Producto(String codigo, String descripcion, double precioU, OrigenFabricacion origenFabricacion,
			Categoria categoria, boolean estado) {
		super(codigo, descripcion, precioU, origenFabricacion, categoria, estado);
		
	}
	
}
