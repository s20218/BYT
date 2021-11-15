package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals(Integer.valueOf(10000), SEK100.getAmount());
		assertEquals(Integer.valueOf(1000), EUR10.getAmount());
		assertEquals(Integer.valueOf(20000), SEK200.getAmount());
		assertEquals(Integer.valueOf(2000), EUR20.getAmount());
		assertEquals(Integer.valueOf(0), SEK0.getAmount());
		assertEquals(Integer.valueOf(0), EUR0.getAmount());
		assertEquals(Integer.valueOf(-10000), SEKn100.getAmount());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SEK100.getCurrency());
		assertEquals(EUR, EUR10.getCurrency());
		assertEquals(SEK, SEK200.getCurrency());
		assertEquals(EUR, EUR20.getCurrency());
		assertEquals(SEK, SEK0.getCurrency());
		assertEquals(EUR, EUR0.getCurrency());
		assertEquals(SEK, SEKn100.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("20.0 EUR", EUR20.toString());
	}

	@Test
	public void testGlobalValue() {
		assertEquals(Integer.valueOf((int)(1000 * 1.5)), EUR10.universalValue());
	}

	@Test
	public void testEqualsMoney() {
		assertFalse(SEK100.equals(EUR20));
	}

	@Test
	public void testAdd() {
		Money added = SEK200.add(EUR20);
		int sum = (int)((20000) + (2000 * 1.5 / 0.15));
		assertEquals(Integer.valueOf(sum), added.getAmount());
	}

	@Test
	public void testSub() {
		Money subtracted = SEK200.sub(EUR20);
		int result = (int)((20000) - (2000 * 1.5 / 0.15));
		assertEquals(Integer.valueOf(result), subtracted.getAmount());
	}

	@Test
	public void testIsZero() {
		assertFalse(EUR20.isZero());
		assertTrue(SEK0.isZero());
	}

	@Test
	public void testNegate() {
		assertEquals("-20.0 EUR", EUR20.negate().toString());
	}

	@Test
	public void testCompareTo() {
		assertEquals(-1, EUR10.compareTo(EUR20));
		assertEquals(1, SEK200.compareTo(SEK100));
		assertEquals(0, EUR0.compareTo(SEK0));
	}
}
