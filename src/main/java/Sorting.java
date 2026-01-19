package main.java;
import java.util.*;

public class Sorting {

  // select minimum and swap 
  // ~O(n^2)
  public static int[] selectionSort(int[] arr)
  {
    return null;
  }

  // push the max to the last by adjacent swaps
  // avg and worst O(n^2) | best case O(n)
  public static int[] bubbleSort(int[] arr)
  {
    return null;
  }

  // takes an element and places it in its correct order
  // swap going to the left
  // worst and avg O(n^2) | best O(n)
  public static int[] insertionSort(int[] arr)
  {
    return null;
  }

  // merge sort 
  // divide and merge
  // Time complexity O(n x (log2)n)
  // Space complexity O(n)
  public static void mergeSort(int[] arr, int low, int high)
  {

  }

  // O(n^2) for average and worst case. O(n) for best case
  public static void recursiveBubbleSort(int[] arr, int n)
  {

  }

  // O(n^2) for worst and average cases
  public static void recursiveInsertionSort(int[] arr, int high, int n)
  {

  }

  // similar time complexity to merge sort O(n logn) | worst case is O(n^2) when the pivot choices consistently lead to unbalanced partitions.
  // but the space complexity is better, O(1) - doesn't use any extra temporary arrays
  public static void quickSort(int[] arr, int low, int high)
  {
    // 1. pick a pivot and place it in its correct place in the sorted array
    // 2. Smaller on the left. Larger on the right
  }

}
