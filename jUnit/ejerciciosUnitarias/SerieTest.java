package ejerciciosUnitarias;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SerieTest {

	private Serie serie;	
	
	@BeforeEach
	public void init() {
		serie= new Serie();
	}
	
	@Test
	void testEntregar_Devolver_isEntregado() {
		
		assertEquals(false,serie.isEntregado());
		serie.entregar();
		assertEquals(true,serie.isEntregado());
		serie.devolver();
		assertEquals(false,serie.isEntregado());
	}
	
	@Test
	void testGetsySets() {
		serie.setTitulo("Bojack HorseMan");
		assertEquals("Bojack HorseMan",serie.getTitulo());
		serie.setnumeroTemporadas(4);
		assertEquals(4,serie.getnumeroTemporadas());
		serie.setGenero("Comedia");
		assertEquals("Comedia",serie.getGenero());
		serie.setcreador("Raphael");
		assertEquals("Raphael",serie.getcreador());
	}
	
	@Test
	void testCompareTo() {
		serie.setnumeroTemporadas(10);
		Serie serie2 = new Serie();
		serie2.setnumeroTemporadas(5);
		assertEquals(1,serie.compareTo(serie2));
		serie2.setnumeroTemporadas(12);
		assertEquals(-1,serie.compareTo(serie2));
		serie2.setnumeroTemporadas(10);
		assertEquals(0,serie.compareTo(serie2));
	}
	
	@Test
	void testeToString() {
		serie.setcreador("Raphael");
		serie.setnumeroTemporadas(4);
		serie.setGenero("Comedia");
		serie.setTitulo("Bojack");
		assertEquals(
		"Informacion de la Serie: \n" +
                "\tTitulo: Bojack\n" +
                "\tNumero de temporadas: 4\n" +
                "\tGenero: Comedia\n" +
                "\tCreador: Raphael",serie.toString());
	}
	
	@Test
	void testEqualsSerie() {
		serie.setTitulo("Desencanto");
		serie.setcreador("Matt");
		Serie serie2 = new Serie("Desencanto", "Matt");
		assertTrue(serie.equals(serie2));
		
		Serie serie3 = new Serie("Desencanto", "Juan");
		assertFalse(serie.equals(serie3));
	}
}