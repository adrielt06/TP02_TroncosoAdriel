package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		if (Converter.isNotNull(gato)) {
			//definición de expresión lambda que define el convertidor de FelinoDomestico a
			//FelinoSalvaje.
			Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());
		
			//se realiza la conversión
			FelinoSalvaje felino1;
			felino1 = converter.convert(gato);
			
			//mostramos los datos del objeto felino salvaje felino1
			converter.mostrarObjeto(felino1);
		}else {
			System.out.println("ERROR: El objeto es nulo.");
		}
		
		//conversión de un objeto felino salvaje a felino doméstico
		
		FelinoSalvaje gato2 = new FelinoSalvaje("Tanner", (byte)20, 186f);
		if (Converter.isNotNull(gato2)) {
			Converter<FelinoSalvaje, FelinoDomestico> converter2 = x -> new FelinoDomestico(x.getNombre(), x.getEdad(),
					x.getPeso());
			FelinoDomestico felino2 = converter2.convert(gato2);
			converter2.mostrarObjeto(felino2);
		}else {
			System.out.println("ERROR: El objeto es nulo.");
		}
	}
}
