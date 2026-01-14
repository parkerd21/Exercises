import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;


public class GreatestCommonDivisorTest {
  
  @Test
  public void test()
  {
      assertEquals(3, findGCF(9, 12));
      assertEquals(1, findGCF(11, 13));
      assertEquals(20, findGCF(20, 40));
  }

  // brute force
  // O(min(num1, num2))
  // public int findGCF(int num1, int num2)
  // {
  //   int gcf = 1;
  //   for (int i = 1; i <= Math.min(num1, num2); i++)
  //   {
  //     if (num1 % i == 0 && num2 % i == 0)
  //     {
  //       gcf = i;
  //     }
  //   }
  //   return gcf;
  // }

  // brute force
  // O(min(num1, num2))
  // public int findGCF(int num1, int num2)
  // {
  //   int gcf = 1;

  //   for (int i = Math.min(num1, num2); i >= 1; i--)
  //   {
  //     if (num1 % i == 0 && num2 % i == 0)
  //     {
  //       gcf = i;
  //       break;
  //     }
  //   }
  //   return gcf;
  // }


  // Euclidean algorithm O(log(min(a,b)))
  // GCD(a, b) = GCD(b, a % b) a > b
  public int findGCF(int a, int b)
  {
    while (a > 0 && b > 0)
    {
      if (a > b) a = a % b;
      else b = b % a;
    }
    if (a == 0) return b;
    else return a;
  }


  






}
