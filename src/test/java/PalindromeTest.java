import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void whenEmptyString_thenAccept() {
		Palindrome palindromeTester = new Palindrome();
		assertTrue(palindromeTester.isPalindrome(""));
	}
	
	@Test
	public void whenPalindrome_thenAccept() {
		Palindrome palindromeTester = new Palindrome();
		assertTrue(palindromeTester.isPalindrome("noon"));
	}
	
	@Test
	public void whenNearPalindrome_thenReject() {
		Palindrome palindromeTester = new Palindrome();
		assertFalse(palindromeTester.isPalindrome("neon"));
	}
}
