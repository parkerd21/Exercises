package main.java;
import java.util.*;

public class Sorting {

  // select minimum and swap 
  // ~O(n^2)
  public static int[] selectionSort(int[] arr)
  {
    int n = arr.length;
 
    for (int outer = 0; outer < n - 1; outer++)
    {
      int minValue = arr[outer];
      int minIndex = outer;
      // find next minimum
      for (int i = outer; i < n; i++)
      {
        if (arr[i] < minValue)
        {
          minValue = arr[i];
          minIndex = i;
        }
      }
      // swap
      int temp = arr[outer];
      arr[outer] = arr[minIndex];
      arr[minIndex] = temp;
    }
    return arr;
  }

  // push the max to the last by adjacent swaps
  // avg and worst O(n^2) | best case O(n)
  public static int[] bubbleSort(int[] arr)
  {
    for (int i = 0; i < arr.length - 1; i++)
    {
      boolean swapFlag = false;
      for (int j = 0; j < arr.length - 1 - i; j++)
      {
        if (arr[j] > arr[j + 1])
        {
          // swap
          swapFlag = true;
          int temp = arr[j+1];
          arr[j+1] = arr[j];
          arr[j] = temp;
        }
      }
      if (!swapFlag)
      {
        break;
      }
    }
    return arr;
  }

  // takes an element and places it in its correct order
  // swap going to the left
  // worst and avg O(n^2) | best O(n)
  public static int[] insertionSort(int[] arr)
  {
    for (int i = 0; i < arr.length; i++)
    {
      int j = i;
      while (j > 0 && arr[j] < arr[j-1])
      {
        // swap
        int temp = arr[j-1];
        arr[j-1] = arr[j];
        arr[j] = temp;
        j--;
      }
    }
    return arr;
  }

  // merge sort 
  // divide and merge
  // Time complexity O(n x (log2)n)
  // Space complexity O(n)
  public static void mergeSort(int[] arr, int low, int high)
  {
    if (low >= high) return;
    // play around with index
    int mid = (low + high) / 2;

    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, high);
    merge(arr, low, mid, high);
  }

  private static void merge(int[] arr, int low, int mid, int high)
  {
    int[] merged = new int[high + 1];
    int leftPointer = low;
    int rightPointer = mid + 1;
    int i = 0;
    
    while (leftPointer <= mid && rightPointer <= high) 
    {
      if (arr[leftPointer] <= arr[rightPointer])
      {
        merged[i] = arr[leftPointer];
        leftPointer++;
      } 
      else
      {
        merged[i] = arr[rightPointer];
        rightPointer++;
      }
      i++;
    }

    while (leftPointer <= mid)
    {
      merged[i] = arr[leftPointer];
      leftPointer++;
      i++;
    }

    while (rightPointer <= high)
    {
      merged[i] = arr[rightPointer];
      rightPointer++;
      i++;
    }

    for (int j = low; j <= high; j++)
    {
      arr[j] = merged[j - low];
    }
  }


  // O(n^2) for average and worst case. O(n) for best case
  public static void recursiveBubbleSort(int[] arr, int n)
  {
    if (n == 1) return;
    boolean swapped = false; // not needed but is optimization
    for (int i = 0; i < arr.length - 1; i++)
    {
      if (arr[i] > arr[i + 1])
      {
        int temp = arr[i + 1];
        arr[i+1] = arr[i];
        arr[i] = temp;
        swapped = true;
      }
    }

    // not needed but is optimization
    if (!swapped) return;
    recursiveBubbleSort(arr, n - 1);
  }

  // O(n^2) for worst and average cases
  public static void recursiveInsertionSort(int[] arr, int high, int n)
  {
    if (n == high) return;

    int j = high;
    while (j > 0 && arr[j] < arr[j-1])
    {
      // swap
      int temp = arr[j-1];
      arr[j-1] = arr[j];
      arr[j] = temp;
      j--;
    }

    recursiveInsertionSort(arr, high + 1, n);
  }

  public static void quickSort(int[] arr)
  {
    
  }
}
