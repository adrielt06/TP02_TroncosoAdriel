package ar.edu.unju.fi.ejercicio05.model;

import ar.edu.unju.fi.ejercicio01.model.Producto;

public class Product extends Producto{
	private boolean estado;
	
	public Product() {
	}

	public Product(boolean estado) {
		this.estado = estado;
	}

	public Product(String codigo, String descripcion, double precioU, OrigenFabricacion origenFabricacion,
			Categoria categoria, boolean estado) {
		super(codigo, descripcion, precioU, origenFabricacion, categoria);
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	private String stock() {
		if(this.estado) {
			return "Disponible";
		}else {
			return "No Disponible";
		}
	}
	
	public void mostrarProduct() {
		System.out.println("--------------------------");
		System.out.println("Codigo: "+super.getCodigo());
		System.out.println("Descripcion: "+super.getDescripcion());
		System.out.println("Precio Unidad: $"+super.getPrecioU());
		System.out.println("Origen de Fabricacion: "+super.getOrigenFabricacion());
		System.out.println("Categoria: "+super.getCategoria());
		System.out.println("Stock: "+stock());
	}
		
}
