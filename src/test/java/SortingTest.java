package test.java;

import org.junit.Test;
import main.java.Sorting;
import static org.junit.Assert.*;

public class SortingTest {

  @Test
  public void test_selectionSort()
  {
    int[] input = {13, 46, 24, 52, 20, 9};
    int[] expected = {9, 13, 20, 24, 46, 52};

    int[] actual = Sorting.selectionSort(input);

    for (int i = 0; i < expected.length; i++)
    {
      assertEquals(expected[i], actual[i]);
    }
  }

  @Test
  public void test_bubbleSort()
  {
    int[] input = {13, 46, 24, 52, 20, 9};
    int[] expected = {9, 13, 20, 24, 46, 52};

    int[] actual = Sorting.bubbleSort(input);

    for (int i = 0; i < expected.length; i++)
    {
      assertEquals(expected[i], actual[i]);
    }
  }

  @Test
  public void test_insertionSort()
  {
    int[] input = {13, 46, 24, 52, 20, 9};
    int[] expected = {9, 13, 20, 24, 46, 52};

    int[] actual = Sorting.insertionSort(input);

    for (int i = 0; i < expected.length; i++)
    {
      assertEquals(expected[i], actual[i]);
    }
  }

  @Test
  public void test_mergeSort()
  {
    int[] input = {13, 46, 24, 52, 20, 9};
    int[] expected = {9, 13, 20, 24, 46, 52};

    Sorting.mergeSort(input, 0, input.length -1);

    for (int i = 0; i < expected.length; i++)
    {
      assertEquals(expected[i], input[i]);
    }
  }

  @Test
  public void test_recursiveBubbleSort()
  {
    int[] input = {13, 46, 24, 52, 20, 9};
    int[] expected = {9, 13, 20, 24, 46, 52};

    Sorting.recursiveBubbleSort(input, input.length);

    for (int i = 0; i < expected.length; i++)
    {
      assertEquals(expected[i], input[i]);
    }
  }

  @Test
  public void test_recursiveInsertionSort()
  {
    int[] input = {13, 46, 24, 52, 20, 9};
    int[] expected = {9, 13, 20, 24, 46, 52};

    Sorting.recursiveInsertionSort(input, 0, input.length);

    for (int i = 0; i < expected.length; i++)
    {
      assertEquals(expected[i], input[i]);
    }
  }

    @Test
  public void test_quickSort()
  {
    int[] input = {13, 46, 24, 52, 20, 9};
    int[] expected = {9, 13, 20, 24, 46, 52};

    Sorting.quickSort(input);

    for (int i = 0; i < expected.length; i++)
    {
      assertEquals(expected[i], input[i]);
    }
  }
  
}
