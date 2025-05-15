package tests;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import clases.Cadenas;

class CadenasTest {
	
	static Cadenas cadena;

	@ParameterizedTest
	@MethodSource("cuentaEspacios")
	void testCuentaEspacios(String frase, int expected) {
		Cadenas cadena = new Cadenas(frase);
		int resultado = cadena.cuentaEspacios();
		assertEquals(expected, resultado);
	}
	
	private static Stream<Arguments> cuentaEspacios() {
		return Stream.of(
				Arguments.of("Hola", 0),
				Arguments.of("Hoy hay examen de entorno", 4),
				Arguments.of("A segunda hora toca entorno de desarrollo", 6)
		);
	}	
	
	@ParameterizedTest
	@MethodSource("delReves")
	void testDelReves(String frase, String expected) {
		Cadenas cadena = new Cadenas(frase);
		String resultado = cadena.delReves();
		assertEquals(expected, resultado);
	}
	
	private static Stream<Arguments> delReves() {
		return Stream.of(
				Arguments.of("amor", "roma"),
				Arguments.of("hola", "aloh"),
				Arguments.of("ojo", "ojo")
		);
	}	
	
	@ParameterizedTest
	@MethodSource("contarPalabra")
	void testContarPalabra(String frase, String palabra, int expected) {
		Cadenas cadena = new Cadenas(frase);
		int resultado = cadena.contarPalabra(palabra);
		assertEquals(expected, resultado);
	}
	
	private static Stream<Arguments> contarPalabra() {
		return Stream.of(
				Arguments.of("Buenas tardes yo soy Angel", "tardes", 1),
				Arguments.of("Hoy hay examen de entorno y examen de programacion", "examen", 2),
				Arguments.of("A segunda hora y a tercera hora toca entorno de desarrollo", "hora", 2)
		);
	}	
}