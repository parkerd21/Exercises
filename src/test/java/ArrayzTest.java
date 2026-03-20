package test.java;

import org.junit.Test;
import static org.junit.Assert.*;
import main.java.Arrayz;
import java.util.List;

public class ArrayzTest {
  
  @Test
  public void test_largestElementInArray()
  {
    int[] input = {2, 5, 1, 3, 0};
    int expected = 5;
    int actual = Arrayz.largestElementInArray(input);

    assertEquals(expected, actual);

    actual = Arrayz.bruteforceLargestElementInArray(input);
    assertEquals(expected, actual);
  }

  @Test
  public void test_secondSmallestAndSecondLargest()
  {
    int[] input = {2, 5, 1, 3, 0};
    int[] expected = {1, 3};
    int[] actual = Arrayz.secondSmallestAndSecondLargest(input);
    
    assertArray(expected, actual);
  }

  @Test
  public void test_secondSmallestAndSecondLargest_smallestArrayThatWorks()
  {
    int[] input = {2, 5, 1};
    int[] expected = {2, 2};
    int[] actual = Arrayz.secondSmallestAndSecondLargest(input);
    
    assertArray(expected, actual);
  }

  @Test
  public void test_secondSmallestAndSecondLargest_arrayTooSmall()
  {
    int[] input = {2, 5};
    int[] expected = {5, 2};
    int[] actual = Arrayz.secondSmallestAndSecondLargest(input);
    
    assertArray(expected, actual);
  }

  @Test
  public void test_isSorted()
  {
    int[] input = {1, 2, 4, 5, 10};
    assertTrue(Arrayz.isSorted(input));

    input = new int[]{1, 2, 3, 10, 4, 6, 5, 7 };
    assertFalse(Arrayz.isSorted(input));

    input = new int[]{1, 2, 3, 10, 4};
    assertFalse(Arrayz.isSorted(input));

    input = new int[]{2, 3, 4, 6, 1 };
    assertFalse(Arrayz.isSorted(input));
  }

  @Test
  public void test_isSorted2()
  {
    int[] input = {1, 2, 4, 5, 10};
    assertTrue(Arrayz.isSorted2(input));

    input = new int[]{1, 2, 3, 10, 4, 6, 5, 7 };
    assertFalse(Arrayz.isSorted2(input));

    input = new int[]{1, 2, 3, 10, 4};
    assertFalse(Arrayz.isSorted2(input));

    input = new int[]{2, 3, 4, 6, 1 };
    assertFalse(Arrayz.isSorted2(input));
  }

  @Test
  public void test_removeDuplicatesSorted()
  {
    int[] input = {1, 1, 2, 2, 2, 3, 3, 4, 5, 5};
    int[] expectedArr = {1, 2, 3, 4, 5, 3, 3, 4, 5, 5};
    int expectedReturn = 5;

    int actualReturn = Arrayz.removeDuplicates(input);

    assertEquals(expectedReturn, actualReturn);
    assertArray(expectedArr, input);


    input = new int[]{1, 1, 1, 1, 1};
    expectedArr = new int[]{1, 1, 1, 1, 1};
    expectedReturn = 1;

    actualReturn = Arrayz.removeDuplicates(input);

    assertEquals(expectedReturn, actualReturn);
    assertArray(expectedArr, input);
  }

  @Test
  public void test_leftRotateByOne()
  {
    int[] input = {1,2,3,4,5};
    int[] expected = {2,3,4,5,1};

    Arrayz.leftRotateByOne(input);
    assertArray(expected, input);
  }

  @Test
  public void test_rotateByKelements()
  {
    int[] input = {1,2,3,4,5,6,7};
    int[] expected = {5,6,7,1,2,3,4};

    Arrayz.rotateRightByKelements(input, 3);
    assertArray(expected, input);

    input = new int[]{1,2,3,4,5,6,7};
    expected = new int[]{3,4,5,6,7,1,2};
    Arrayz.rotateLeftByKelements(input, 2);
    assertArray(expected, input);
  }

  @Test
  public void test_optimalRotateLeftByK()
  {
    int[] input = {1,2,3,4,5};
    int[] expected = {4,5,1,2,3};

    Arrayz.optimalRotateLeftByK(input, 3);
    assertArray(expected, input);
  }

  @Test
  public void test_optimalRotateRightByK()
  {
    int[] input = {1,2,3,4,5};
    int[] expected = {3,4,5,1,2};

    Arrayz.optimalRotateRightByK(input, 3);
    assertArray(expected, input);
  }

  @Test
  public void test_moveAllZerosToEnd()
  {
    int[] input = {1,0,2,3,0,4,0,1};
    int[] expected = {1,2,3,4,1,0,0,0};

    Arrayz.moveAllZerosToEnd(input);
    assertArray(expected, input);
  }

  @Test
  public void test_optimalMoveAllZerosToEnd()
  {
    int[] input = {1,0,2,3,0,4,0,1};
    int[] expected = {1,2,3,4,1,0,0,0};

    Arrayz.optimalMoveAllZerosToEnd(input);
    assertArray(expected, input);
  }

  @Test
  public void test_linearSearch()
  {
    int[] input = {1,2,3,4,5};
    int expected = 2;

    int actual = Arrayz.linearSearch(input, 3);
    assertEquals(expected, actual);
  }

  @Test
  public void test_unionSortedArrays()
  {
    int[] arr1 = {1,2,3,4,5};
    int[] arr2 = {2,3,4,4,5};
    int[] expected = {1,2,3,4,5};

    List<Integer> actual = Arrayz.unionSortedArrays(arr1, arr2);
    assertArray(expected, actual);
  }

  @Test
  public void test_findMissingNumber()
  {
    int[] input = {8,2,4,5,3,7,1};
    int expected = 6;

    int actual = Arrayz.findMissingNumber(input);
    assertEquals(expected, actual);

    input = new int[]{1,2,3,5};
    expected = 4;

    actual = Arrayz.findMissingNumber(input);
    assertEquals(expected, actual);
  }

  @Test
  public void test_countMaximumConsecutiveOnes()
  {
    int[] input = {1,1,0,1,1,1};
    int expected = 3;

    int actual = Arrayz.countMaximumConsecutiveOnes(input);
    assertEquals(expected, actual);
  }

  @Test
  public void test_findNumberThatOnlyAppearsOnce()
  {
    int[] input = {2,2,1};
    int expected = 1;

    int actual = Arrayz.findNumberThatOnlyAppearsOnce(input);
    assertEquals(expected, actual);

    input = new int[]{4,1,2,1,2};
    expected = 4;
    actual = Arrayz.findNumberThatOnlyAppearsOnce(input);
    assertEquals(expected, actual);
  }

  @Test
  public void test_longestSubArrayWithSumK()
  {
    int[] input = {10,5,2,7,1,9};

    int actual = Arrayz.longestSubArrayWithSumK(input, 15);
    assertEquals(4, actual);

    actual = Arrayz.longestSubArrayWithSumK(input, 19);
    assertEquals(4, actual);

    actual = Arrayz.longestSubArrayWithSumK(input, 7);
    assertEquals(2, actual);
  }

  @Test
  public void test_longestSubArrayWithSumZero()
  {
    int[] input = {9, -3, 3, -1, 6, -5};

    int actual = Arrayz.longestSubArrayWithSumZero(input);
    assertEquals(5, actual);
  }

  @Test
  public void test_twoSumVariant1()
  {
    int[] input = {2,6,5,8,11};
    int target = 14;
    String expected = "YES";

    String actual = Arrayz.twoSumExists(input, target);
    assertEquals(expected, actual);
  }

  @Test
  public void test_twoSumVariant2()
  {
    int[] input = {2,6,5,8,11};
    int target = 14;
    int[] expected = new int[] {1,3};

    int[] actual = Arrayz.twoSumIndices(input, target);
    assertArray(expected, actual);
  }

  @Test
  public void test_sortArrayOf012()
  {
    int[] input = {1,0,2,1,0};
    int[] expected = {0,0,1,1,2};

    int[] actual = Arrayz.sortArrayOf012(input);
    assertArray(expected, actual);
  }

  @Test
  public void test_findMajorityElementOccuringMoreThanHalfTimes()
  {
    int[] input = {7,0,0,1,7,7,2,7,7};
    int expected = 7;

    int actual = Arrayz.findMajorityElementOccuringMoreThanHalfTimes(input);
    assertEquals(expected, actual);

    input = new int[]{2};
    expected = 2;
    actual = Arrayz.findMajorityElementOccuringMoreThanHalfTimes(input);
    assertEquals(expected, actual);
  }

   
  private void assertArray(int[] expected, int[] actual)
  {
    assertEquals(expected.length, actual.length);
    for (int i = 0; i < expected.length; i++)
    {
      assertEquals(expected[i], actual[i]);
    }
  }

    private void assertArray(int[] expected, List<Integer> actual)
  {
    assertEquals(expected.length, actual.size());
    for (int i = 0; i < expected.length; i++)
    {
      assertEquals(expected[i], (int)actual.get(i));
    }
  }



}
