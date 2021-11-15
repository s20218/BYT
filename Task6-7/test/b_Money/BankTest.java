package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;

	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank", SweBank.getName());
		assertEquals("Nordea", Nordea.getName());
		assertEquals("DanskeBank", DanskeBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals("SEK", SweBank.getCurrency().getName());
		assertEquals("SEK", Nordea.getCurrency().getName());
		assertEquals("DKK", DanskeBank.getCurrency().getName());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		SweBank.openAccount("Kamil");
		assertTrue(SweBank.accountlist.containsKey("Kamil"));
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		Nordea.deposit("Bob", new Money(5000, SEK));
		assertEquals(Integer.valueOf(5000), Nordea.getBalance("Bob"));
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		//we gonna get an error message, because requested amount is bigger than the balance
		DanskeBank.withdraw("Gertrud", new Money(2000, DKK));
		assertEquals(Integer.valueOf(0), DanskeBank.getBalance("Gertrud"));

		//after depositing money to the account and withdrawing it right after, we're left with 1000
		DanskeBank.deposit("Gertrud", new Money(3000, DKK));
		DanskeBank.withdraw("Gertrud", new Money(2000, DKK));
		assertEquals(Integer.valueOf(1000), DanskeBank.getBalance("Gertrud"));
	}

	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(0), SweBank.getBalance("Ulrika"));
	}

	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(5000, SEK));
		SweBank.transfer("Bob", "Ulrika", new Money(1500, SEK));
		assertEquals(Integer.valueOf(3500), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(1500), SweBank.getBalance("Ulrika"));

		SweBank.transfer("Bob", DanskeBank, "Gertrud", new Money(2500, SEK));
		assertEquals(Integer.valueOf(1000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf((int) (2500 * 0.15 / 0.20)), DanskeBank.getBalance("Gertrud"));
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(3000, SEK));
		SweBank.addTimedPayment("Bob", "1", 4, 0, new Money(1000, SEK), SweBank, "Ulrika");
		SweBank.tick();

		assertEquals(Integer.valueOf(2000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(1000), SweBank.getBalance("Ulrika"));
	}
}
