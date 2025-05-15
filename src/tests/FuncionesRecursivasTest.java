package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import clases.FuncionesRecursivas;

class FuncionesRecursivasTest {

	@ParameterizedTest
	@MethodSource("sumatorio")
	void testSumatorio(int numero, int expected) {
		int resultado = FuncionesRecursivas.sumatorio(numero);
		assertEquals(expected, resultado);
	}

	private static Stream<Arguments> sumatorio() {
		return Stream.of(
				Arguments.of(1, 1),
				Arguments.of(12, 78),
				Arguments.of(6, 21)
		);
	}

	@ParameterizedTest
	@MethodSource("potencia")
	void testPotencia(double a, int n, double expected) {
		double resultado = FuncionesRecursivas.potencia(a, n);
		assertEquals(expected, resultado);
	}

	private static Stream<Arguments> potencia() {
		return Stream.of(
				Arguments.of(2, 2, 4), 
				Arguments.of(3, 3, 27),
				Arguments.of(2, 5, 32)
		);
	}

	@ParameterizedTest
	@MethodSource("fibonacci")
	void testFibonacci(int numero, int expected) {
		int resultado = FuncionesRecursivas.fibonacci(numero);
		assertEquals(expected, resultado);
	}

	private static Stream<Arguments> fibonacci() {
		return Stream.of(
				Arguments.of(6, 8), 
				Arguments.of(4, 3),
				Arguments.of(3, 2)
		);
	}
}