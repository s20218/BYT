package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("1", 7, 15, new Money(2500, SEK), SweBank, "Alice");
		assertTrue(testAccount.timedPaymentExists("1"));
		testAccount.removeTimedPayment("1");
		assertFalse(testAccount.timedPaymentExists("1"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("1", 2, 2, new Money(2000, SEK), SweBank, "Alice");
		System.out.println(testAccount.getBalance().getAmount());
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();

		assertEquals(Integer.valueOf(10000000 - 2000), testAccount.getBalance().getAmount());
	}

	@Test
	public void testAddWithdraw() {
		testAccount.deposit(new Money(3000, SEK));
		assertEquals(Integer.valueOf(10000000 + 3000), testAccount.getBalance().getAmount());
		testAccount.withdraw(new Money(3000, SEK));
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
	}
	
	@Test
	public void testGetBalance() {
		assertTrue(new Money(10000000, SEK).equals(testAccount.getBalance()));
	}
}
