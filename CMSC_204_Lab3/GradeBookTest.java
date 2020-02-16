import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	GradeBook gb1, gb2;
	
	@BeforeEach
	void setUp() throws Exception {
		
		gb1 = new GradeBook(5);
		gb1.addScore(90);
		gb1.addScore(80);

		gb2 = new GradeBook(5);
		gb2.addScore(92);
		gb2.addScore(86);
	}

	@AfterEach
	void tearDown() throws Exception {
		gb1 = gb2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(gb1.toString().equals("90.0 80.0 "));
        assertTrue(gb2.toString().equals("92.0 86.0 "));
	}

	@Test
	void testSum() {
		assertEquals(170, gb1.sum(), .0001);
		assertEquals(178, gb2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(80, gb1.minimum(), .001);
		assertEquals(86, gb2.minimum(), .001);

	}

	@Test
	void testFinalScore() {
		assertEquals(90, gb1.finalScore(), 0.001);
		assertEquals(92, gb2.finalScore(), 0.001);

	}

}
