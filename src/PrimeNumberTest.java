import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PrimeNumberTest {
  
  @Test
  public void testPrimeNumbers()
  {
    assertTrue(isPrime(2));
    assertTrue(isPrime(3));
    assertTrue(isPrime(5));
    assertTrue(isPrime(7));
    assertTrue(isPrime(11));
    assertTrue(isPrime(17));
  }

  @Test
  public void testNotPrimeNumbers()
  {
    assertFalse(isPrime(4));
    assertFalse(isPrime(6));
    assertFalse(isPrime(8));
    assertFalse(isPrime(9));
    assertFalse(isPrime(10));
  }

  @Test
  public void testEdgeCases() {
      System.out.println("Testing edge cases...");
      assertFalse("0 should not be prime", isPrime(0));
      assertFalse("1 should not be prime", isPrime(1));
      assertFalse("-5 should not be prime", isPrime(-5));
  }

  @Test
  public void testLargerPrimes() {
    System.out.println("Testing larger primes...");
    assertTrue("13 should be prime", isPrime(13));
    assertTrue("17 should be prime", isPrime(17));
    assertTrue("23 should be prime", isPrime(23));
    assertTrue("29 should be prime", isPrime(29));
    assertTrue("97 should be prime", isPrime(97));
  }

  @Test
  public void testLargerNonPrimes() {
    System.out.println("Testing larger non-primes...");
    assertFalse("15 should not be prime", isPrime(15));
    assertFalse("21 should not be prime", isPrime(21));
    assertFalse("100 should not be prime", isPrime(100));
  }

  // bruteForce
  // O(n)
  // private boolean isPrime(int n)
  // {
  //   int count = 0;
  //   for (int i = 1; i <= n; i++)
  //   {
  //     if (n % i == 0)
  //       count++;
  //   }
    
  //   return count == 2;
  // }

  
  // optimal
  // O(sqrt(n))
  private boolean isPrime(int n)
  {
    int count = 0;
    for (int i = 1; i * i <= n; i++)
    {
      if (n % i == 0)
      {
        count++;
        if ((n / i) != i)
          count++;
      }
      if (count > 2)
        return false;
    }
    return count == 2;
  }
}
