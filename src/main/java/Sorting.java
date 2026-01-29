package main.java;
import java.util.*;

public class Sorting {

  // select minimum and swap 
  // ~O(n^2)
  public static int[] selectionSort(int[] arr)
  {
    for (int i = 0; i < arr.length - 1; i++)
    {
      int minimum = arr[i];
      int minIndex = i;
      for(int j = i + 1; j < arr.length; j++)
      {
        if (arr[j] < minimum)
        {
          minimum = arr[j];
          minIndex = j;
        }
      }
      // swap
      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
    return arr;
  }

  // push the max to the last by adjacent swaps
  // avg and worst O(n^2) | best case O(n)
  public static int[] bubbleSort(int[] arr)
  {
    for (int i = arr.length - 1; i > 0; i--)
    {
      boolean swapOccurred = false;
      for (int j = 0; j < i; j++)
      {
        if (arr[j] > arr[j+1])
        {
          int temp = arr[j+1];
          arr[j+1] = arr[j];
          arr[j] = temp;
          swapOccurred = true;
        }
      }
      if (!swapOccurred) break;
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
      while (j > 0 && arr[j-1] > arr[j])
      {
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

    int mid = (low + high) / 2;

    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, high);
    merge(arr, low, mid, high);
  }

  private static void merge(int[] arr, int low, int mid, int high)
  {
    int leftPointer = low;
    int rightPointer = mid + 1;
    int[] merged = new int[high + 1];
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
      arr[j] = merged[j-low];
    }
  }

  // O(n^2) for average and worst case. O(n) for best case
  public static void recursiveBubbleSort(int[] arr, int n)
  {
    if (n == 1) return;
    boolean swapped = false;

    for (int j = 0; j < n - 1; j++)
    {
      if (arr[j] > arr[j+1])
      {
        int temp = arr[j+1];
        arr[j+1] = arr[j];
        arr[j] = temp;
        swapped = true;
      }
    }
    if (!swapped) return;

      recursiveBubbleSort(arr, n - 1);
  }

  // takes an element and places it in its correct order
  // swap going to the left
  // O(n^2) for worst and average cases
  public static void recursiveInsertionSort(int[] arr, int high, int n)
  {
    if (high == n) return;
    int j = high;
    while(j > 0 && arr[j-1] > arr[j])
    {
      int temp = arr[j];
      arr[j] = arr[j-1];
      arr[j-1] = temp;
      j--;
    }
    recursiveInsertionSort(arr, high + 1, n);
  }

  // similar time complexity to merge sort O(n logn) | worst case is O(n^2) when the pivot choices consistently lead to unbalanced partitions.
  // but the space complexity is better, O(1) - doesn't use any extra temporary arrays
  public static void quickSort(int[] arr, int low, int high)
  {
    if (low < high)
    {
      // 1. pick a pivot and place it in its correct place in the sorted array
      int pivotIndex = pivot(arr, low, high);
      quickSort(arr, low, pivotIndex - 1);
      quickSort(arr, pivotIndex + 1, high);
    }
  }

  public static int pivot(int[] arr, int low, int high)
  {
    int i = low;
    int j = high;
    int pivot = arr[low];

    // 2. Smaller on the left. Larger on the right
    while (i < j)
    {
      while (arr[i] <= pivot && i <= high - 1)
      {
        i++;
      }
      while (arr[j] > pivot && j >= low + 1)
      {
        j--;
      }
      // swap arr[i] and arr[j]
      if (i < j)
      {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
    // swap pivot and arr[j]
    int temp = arr[j];
    arr[j] = arr[low];
    arr[low] = temp;

    return j;
  }
}
