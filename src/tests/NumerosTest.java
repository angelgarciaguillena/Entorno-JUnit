package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import clases.Numeros;

class NumerosTest {

	@ParameterizedTest
	@MethodSource("esPrimo")
	void testEsPrimo(int numero, boolean expected) {
		Numeros numeros = new Numeros(numero);
		boolean resultado = numeros.esPrimo();
		assertEquals(expected, resultado);
	}

	private static Stream<Arguments> esPrimo() {
		return Stream.of(
				Arguments.of(8, false),
				Arguments.of(1, false),
				Arguments.of(102, false),
				Arguments.of(11, true)
		);
	}
	
	@ParameterizedTest
	@MethodSource("esCapicua")
	void testEsCapicua(int numero, boolean expected) {
		Numeros numeros = new Numeros(numero);
		boolean resultado = numeros.esCapicua();
		assertEquals(expected, resultado);
	}

	private static Stream<Arguments> esCapicua() {
		return Stream.of(
				Arguments.of(-12, false),
				Arguments.of(101, true),
				Arguments.of(123, false)
		);
	}
}