import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	private GradeBook a,b;
	
	
	@Before
	public void setUp() throws Exception {
		a = new GradeBook(5);
		b = new GradeBook(5);
		
		a.addScore(1.0);
		a.addScore(2.0);
		a.addScore(3.0);
		a.addScore(4.0);
		a.addScore(5.0);
		
		b.addScore(75);
		b.addScore(100);
		b.addScore(68);
		b.addScore(59);
	}

	@After
	public void tearDown() throws Exception {
		a = null;
		b = null;
	}

	@Test
	public void testAddScore() {
		assertEquals("1.0 2.0 3.0 4.0 5.0", a.toString());
		assertEquals("75.0 100.0 68.0 59.0", b.toString());
	}

	@Test
	public void testSum() {
		assertEquals(15.0, a.sum(), .001);
		assertEquals(302.0, b.sum(), .001);
	}

	@Test
	public void testMinimum() {
		assertEquals(1.0, a.minimum(), .001);
		assertEquals(59.0, b.minimum(), .001);
	}

	@Test
	public void testFinalScore() {
		assertEquals(14.0, a.finalScore(), .001);
		assertEquals(243.0, b.finalScore(), .001);

	}

}
