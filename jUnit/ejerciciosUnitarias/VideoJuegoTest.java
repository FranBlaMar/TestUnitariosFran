package ejerciciosUnitarias;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class VideoJuegoTest {
	private Videojuego v;
	
	@BeforeEach
	public void init() {
	 v = new Videojuego();
	}
	
	@Test
	void testEntregar_Devolver_isEntregado() {
		
		assertEquals(false,v.isEntregado());
		v.entregar();
		assertEquals(true,v.isEntregado());
		v.devolver();
		assertEquals(false,v.isEntregado());
		
	}

	@Test
	void testGetsYSets() {
		v.setcompañia("EA");
		assertEquals("EA",v.getcompañia());
		v.setGenero("Shooter");
		assertEquals("Shooter",v.getGenero());
		v.setHorasEstimadas(50);
		assertEquals(50,v.getHorasEstimadas());
		v.setTitulo("Final Fantasy");
		assertEquals("Final Fantasy",v.getTitulo());
	}
	
	@Test
	void testCompareTo() {
		v.setHorasEstimadas(200);
		Videojuego v2 = new Videojuego();
		
		v2.setHorasEstimadas(100);
		assertEquals(1,v.compareTo(v2));
		
		v.setHorasEstimadas(50);
		assertEquals(-1,v.compareTo(v2));
		
		v.setHorasEstimadas(100);
		assertEquals(0,v.compareTo(v2));
	}

	@Test
	void testToString() {
		v.setTitulo("GTA V");
		v.setGenero("ACCION");
		v.setcompañia("RockStar");
		v.setHorasEstimadas(300);
		assertEquals("Informacion del videojuego: \n" +
	               "\tTitulo: GTA V\n" +
	               "\tHoras estimadas: 300\n" +
	               "\tGenero: ACCION\n" +
	               "\tcompaÃ±ia: RockStar",v.toString());
	}

	@Test
	void testEqualsJuego() {
		v.setTitulo("GTA V");
		v.setcompañia("RockStar");
		Videojuego v2 = new Videojuego("GTA V", "RockStar");
		assertTrue(v.equals(v2));
		
		Videojuego v3 = new Videojuego("GTA V", "Yo");
		assertFalse(v.equals(v3));
	}
}
