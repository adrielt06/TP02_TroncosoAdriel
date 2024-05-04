package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoTarjeta implements Pago{
	private String numTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	

	public PagoTarjeta(String numTarjeta, LocalDate fechaPago, double montoPagado) {
		this.numTarjeta = numTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}

	@Override
	public void realizarPago(double monto) {
		this.montoPagado = monto + (monto * 0.15);
	}
	
	@Override
	public void imprimirRecibo() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
		System.out.println("----------------------------------------");
		System.out.println("**RECIBO DE PAGO CON TARJETA**");
		System.out.println("Numero de Tarjeta: "+this.numTarjeta);
		System.out.println("Fecha de Pago: "+this.fechaPago.format(formato));
		System.out.println("Monto pagado: $"+this.montoPagado);
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
	
	
}
