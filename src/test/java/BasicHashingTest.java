package test.java;

import org.junit.Test;
import main.java.BasicHashing;

public class BasicHashingTest {

  @Test 
  public void test_countElementFrequency1()
  {
    int[] input = {10, 5, 10, 15, 10, 5};
    
    BasicHashing.countElementFrequency(input, input.length);
  }

  @Test 
  public void test_countElementFrequency2()
  {
    int[] input = {2, 2, 3, 4, 4, 2};
    BasicHashing.countElementFrequency(input, input.length);
  }

  @Test 
  public void test_countElementFrequency3()
  {
    int[] input = {10, 5, 10, 15, 10, 5};
    
    BasicHashing.countElementFrequency2(input, input.length);
  }

  @Test 
  public void test_countElementFrequency4()
  {
    int[] input = {2, 2, 3, 4, 4, 2};
    BasicHashing.countElementFrequency2(input, input.length);
  }

  @Test
  public void test_bf_findHighAndLowFrequencies1()
  {
    int[] input = {10, 5, 10, 15, 10, 5};
    BasicHashing.bf_findHighAndLowFrequencies(input);
  }

  @Test
  public void test_bf_findHighAndLowFrequencies2()
  {
    int[] input = {2,2,3,4,4,2};
    BasicHashing.bf_findHighAndLowFrequencies(input);
  }


  @Test
  public void test_findHighAndLowFrequencies1()
  {
    int[] input = {10, 5, 10, 15, 10, 5};
    BasicHashing.findHighAndLowFrequencies(input);
  }

  @Test
  public void test_findHighAndLowFrequencies2()
  {
    int[] input = {2,2,3,4,4,2};
    BasicHashing.findHighAndLowFrequencies(input);
  }

  
}
