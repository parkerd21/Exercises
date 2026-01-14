
import org.junit.Test;

import static org.junit.Assert.*;


public class ArmstrongNumberTest {
  
  @Test
  public void testSingleDigitNumbers() 
  {
    assertTrue(isArmstrong(0));
    assertTrue(isArmstrong(1));
    assertTrue(isArmstrong(5));
    assertTrue(isArmstrong(9));
  }

  @Test
  public void testKnownArmstrongNumbers() 
  {
    assertTrue(isArmstrong(153));
    assertTrue(isArmstrong(370));
    assertTrue(isArmstrong(371));
    assertTrue(isArmstrong(407));
    assertTrue(isArmstrong(1634));
    assertTrue(isArmstrong(9474));
  }

  @Test
  public void testNonArmstrongNumbers() 
  {
    assertFalse(isArmstrong(10));
    assertFalse(isArmstrong(100));
    assertFalse(isArmstrong(152));
    assertFalse(isArmstrong(200));
  }

  @Test
  public void testEdgeCases()
  {
    assertFalse(isArmstrong(-1));
    assertFalse(isArmstrong(-153));
  }


  private boolean isArmstrong(int n) {
    int temp = n;

    int digitCount = String.valueOf(n).length();

    int sum = 0;
    temp = n;

    while (temp > 0)
    {
      int digit = temp % 10;
      sum += Math.pow(digit, digitCount);
      temp /= 10;
    }
      return sum == n;
  }
}
