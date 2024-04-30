package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY(811611, 53219), 
	SALTA(1441351, 155488), 
	TUCUMAN(1448188, 22525), 
	CATAMARCA(367828, 102602), 
	LA_RIOJA(333642, 89680), 
	SANTIAGO_DEL_ESTERO(874006, 136351);
	
	private int cantPoblacion;
	private int superficie;
	
	
	private Provincia(int cantPoblacion, int superficie) {
		this.cantPoblacion = cantPoblacion;
		this.superficie = superficie;
	}


	public int getCantPoblacion() {
		return cantPoblacion;
	}


	public void setCantPoblacion(int cantPoblacion) {
		this.cantPoblacion = cantPoblacion;
	}


	public int getSuperficie() {
		return superficie;
	}


	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public double calcularDensidad() {
		return (double) cantPoblacion / superficie;
	}
	
	public void mostrarProvincia() {
		System.out.println("----------------------");
		System.out.println("Nombre: "+ toString());
		System.out.println("Cantidad de poblacion: "+ cantPoblacion+ " habitantes.");
		System.out.println("Superficie: "+ superficie + " km2.");
		System.out.println("Densidad poblacional: "+ calcularDensidad() + " hab/km2.");
	}
	
}


