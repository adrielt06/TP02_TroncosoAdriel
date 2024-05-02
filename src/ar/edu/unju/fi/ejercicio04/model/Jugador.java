package ar.edu.unju.fi.ejercicio04.model;

import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaNac;
	private String nacionalidad;
	private float estatura;
	private float peso;
	private Posicion posicion;
	
	public int calcularEdad() {
		int anios;
		Period edad = Period.between(this.fechaNac, LocalDate.now());
		anios = edad.getYears();
		return anios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", nacionalidad="
				+ nacionalidad + ", estatura=" + estatura + ", peso=" + peso + ", posicion=" + posicion + ", edad=" + calcularEdad() +"]";
	}

	
	
}
