package test.java;
import org.junit.Test;
import static org.junit.Assert.*;
import static main.java.BasicRecursion.*;


public class BasicRecursionTest {
  
  @Test
  public void test_Print1ToN()
  {
    print1ToN(5);
    System.out.println();
    print1ToN(20);
  }

  @Test
  public void test_printNTo1()
  {
    printNTo1(5);
    System.out.println();
    printNTo1(20);
  }

  @Test
  public void test_sumOfFirstN_numbers()
  {
    int result = sumOfFirstN_numbers(1, 0);
    assertEquals(1, result);

    result = sumOfFirstN_numbers(10, 0);
    assertEquals(55, result);
  }

  @Test
  public void test_sumOfFirstN_numbersF()
  {
    int result = sumOfFirstN_numbersF(1);
    assertEquals(1, result);

    result = sumOfFirstN_numbersF(10);
    assertEquals(55, result);
  }

  @Test
  public void test_factorial()
  {
    int result = factorial(1);
    assertEquals(1, result);

    result = factorial(3);
    assertEquals(6, result);

    result = factorial(5);
    assertEquals(120, result);
  }

  // 3 parameters
  @Test
  public void test_reverseArray()
  {
    int[] expected1 = {1};
    int[] actual1 = reverseArray(expected1, 0, expected1.length - 1);  
    assertEquals(expected1.length, actual1.length);
    assertEquals(expected1[0], actual1[0]);

    int[] initial = {1,2,3,4,5,2};
    int[] expected2 = {2,5,4,3,2,1};
    int[] actual2 = reverseArray(initial, 0, expected2.length - 1);
    assertEquals(expected2.length, actual2.length);
    for (int i = 0; i < expected2.length; i++)
    {
      assertEquals(expected2[i], actual2[i]);
    }

  }

  // 2 parameters
  @Test
  public void test_reverseArray2()
  {
    int[] expected1 = {1};
    int[] actual1 = reverseArray(expected1, 0);  
    assertEquals(expected1.length, actual1.length);
    assertEquals(expected1[0], actual1[0]);

    int[] initial = {1,2,3,4,5,2};
    int[] expected2 = {2,5,4,3,2,1};
    int[] actual2 = reverseArray(initial, 0);
    assertEquals(expected2.length, actual2.length);
    for (int i = 0; i < expected2.length; i++)
    {
      assertEquals(expected2[i], actual2[i]);
    }
  }

  @Test
  public void test_isPalindrome()
  {
    assertTrue(isPalindrome("a"));
    assertTrue(isPalindrome("madam"));
    assertFalse(isPalindrome("abc"));
    assertFalse(isPalindrome("abab"));
    assertFalse(isPalindrome("ababe"));
  }

  @Test
  public void test_printFibonacci()
  {
    printNfibonacci(5, 0, 1);

    System.out.println();
    printNfibonacci(6, 0, 1);
  }

  @Test
  public void test_printNFibonacci()
  {
    assertEquals(0, printNfibonacci(0));
    assertEquals(1, printNfibonacci(1));
    assertEquals(1, printNfibonacci(2));
    assertEquals(2, printNfibonacci(3));
    assertEquals(3, printNfibonacci(4));
    assertEquals(5, printNfibonacci(5));
    assertEquals(8, printNfibonacci(6));
  }
}
