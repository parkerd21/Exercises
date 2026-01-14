import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class PrintAllDivisionsTest {
  
  @Test
  public void testNumbers()
  {
    String expected = "[]";
    String response = printAllDivisions(0);
    assertEquals(expected, response);

    expected = "[1]";
    response = printAllDivisions(1);
    assertEquals(expected, response);

    expected = "[1, 2]";
    response = printAllDivisions(2);
    assertEquals(expected, response);

    expected = "[1, 3]";
    response = printAllDivisions(3);
    assertEquals(expected, response);

    expected = "[1, 2, 4]";
    response = printAllDivisions(4);
    assertEquals(expected, response);

    expected = "[1, 2, 5, 10]";
    response = printAllDivisions(10);
    assertEquals(expected, response);

    expected = "[1, 2, 3, 4, 6, 9, 12, 18, 36]";
    response = printAllDivisions(36);
    assertEquals(expected, response);


    expected = "[]";
    response = optPrintAllDivisions(0);
    assertEquals(expected, response);

    expected = "[1]";
    response = optPrintAllDivisions(1);
    assertEquals(expected, response);

    expected = "[1, 2]";
    response = optPrintAllDivisions(2);
    assertEquals(expected, response);

    expected = "[1, 3]";
    response = optPrintAllDivisions(3);
    assertEquals(expected, response);

    expected = "[1, 2, 4]";
    response = optPrintAllDivisions(4);
    assertEquals(expected, response);

    expected = "[1, 2, 5, 10]";
    response = optPrintAllDivisions(10);
    assertEquals(expected, response);

    expected = "[1, 2, 3, 4, 6, 9, 12, 18, 36]";
    response = optPrintAllDivisions(36);
    assertEquals(expected, response);
  }

  // brute force
  private String printAllDivisions(int n)
  {
    List<Integer> ls = new ArrayList();

    for (int i = 1; i <= n; i++)
    {
      if (n % i == 0)
      {
       ls.add(i);
      }
    }
    return ls.toString();
  }

  // optimal

  private String optPrintAllDivisions(int n)
  {
    List<Integer> ls = new ArrayList<>();

    // O(sqrt(n))
    for (int i = 1; i * i <= n; i++)
    {
      if (n % i == 0)
      {
        ls.add(i);
        if ((n / i) != i)
        {
          ls.add(n/i);
        }
      }
      
    }
    // O(n log n): n is the nubmer of factors
    Collections.sort(ls);

    // O(number of factors)
    return ls.toString();
  }
}
