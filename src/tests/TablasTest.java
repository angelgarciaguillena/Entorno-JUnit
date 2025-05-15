package tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import clases.Tablas;

class TablasTest {

	@ParameterizedTest
	@MethodSource("esMagica")
	void testEsMagica(int tabla[][], boolean expected) {
		boolean resultado = Tablas.esMagica(tabla);
		assertEquals(expected, resultado);
	}

	private static Stream<Arguments> esMagica() {
		return Stream.of(
				Arguments.of(new int[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} }, false),
				Arguments.of(new int[][] { {4, 9, 2}, {3, 5, 7}, {8, 1, 6} }, true),
				Arguments.of(new int[][] { {2, 2, 2}, {2, 2, 2}, {2, 2, 2} }, true)
		);
	}	
	
	@ParameterizedTest
	@MethodSource("gira90")
	void testGira90(int tabla[][], int expected[][]) {
		int resultado[][] = Tablas.gira90(tabla);
		assertArrayEquals(expected, resultado);
	}
	
	private static Stream<Arguments> gira90() {
		return Stream.of(
				Arguments.of(null, null),
				Arguments.of(new int[2][8], null),
				Arguments.of(new int[][] { {1, 2} , {3, 4} }, new int[][] { {3, 1}, {4, 2} })
		);
	}
}