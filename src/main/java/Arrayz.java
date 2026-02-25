package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class Arrayz {

  // optimal 
  // O(n)
  public static int largestElementInArray(int[] arr)
  {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++)
    {
      if (arr[i] > max)
      {
        max = arr[i];
      }
    }

    return max;
  }

  // brute force
  // O(nlogn)
  public static int bruteforceLargestElementInArray(int[] arr)
  {
    Arrays.sort(arr);
    return arr[arr.length -1];
  }


  public static int[] secondSmallestAndSecondLargest(int[] arr)
  {
    if ( arr.length < 2)
      return new int[]{-1, -1};
    
    int secondSmallest = Integer.MAX_VALUE;
    int smallest = Integer.MAX_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    int largest = Integer.MIN_VALUE;
    
    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] > largest)
      {
        secondLargest = largest;
        largest = arr[i];
      }
      else if (arr[i] > secondLargest && arr[i] != largest)
      {
        secondLargest = arr[i];
      }
      
      if (arr[i] < smallest)
      {
        secondSmallest = smallest;
        smallest = arr[i];
      }
      else if (arr[i] < secondSmallest && arr[i] != smallest)
      {
        secondSmallest = arr[i];
      }
    }
    return new int[]{secondSmallest, secondLargest};
  }

  // brute force
  // O(n2)
  public static boolean isSorted(int[] arr)
  {
    for (int i = 0; i < arr.length - 1; i++)
    {
      for (int j = i + 1; j < arr.length; j++)
      {
        if (arr[i] > arr[j])
        {
          return false;
        }
      }
    }
    return true;
  }

  // optimal
  // O(n)
  public static boolean isSorted2(int[] arr)
  {
    for (int i = 0; i < arr.length -1; i++)
    {
      if (arr[i + 1] < arr[i])
      {
        return false;
      }
    }
    return true;
  }


  // optimal
  // O(n)
  // brute force would be to use a set and loop through the array.
  public static int removeDuplicates(int[] arr)
  {
    int i = 0;

    if (arr.length == 1)
    {
      return 1;
    }

    for (int j = 1; j < arr.length; j++)
    {
      if (arr[i] != arr[j])
      {
        i++;
        arr[i] = arr[j];
      }
      j++;
    }
    return i + 1;
  }

  // optimal
  // O(n)
  public static void leftRotateByOne(int[] arr)
  {
    int first = arr[0];

    for (int i = 0; i < arr.length - 1; i++)
    {
      arr[i] = arr[i+1];
    }
    arr[arr.length-1] = first;
  }


  // Brute force
  // O(n)
  public static void rotateRightByKelements(int[] arr, int k)
  {
    if (arr.length == 0) return;
    k = k % arr.length;

    int[] tempArr = new int[k];
    int j = 0;

    for (int i = arr.length - k; i < arr.length; i++)
    {
      tempArr[j] = arr[i];
      j++;
    }

    for (int i = arr.length - 1; i >= k; i--)
    {
      arr[i] = arr[i - k];
    }

    for (int i = 0; i < k; i++)
    {
      arr[i] = tempArr[i];
    } 
  }

  public static void rotateLeftByKelements(int[] arr, int k)
  {
    if (arr.length == 0) return;
    k = k % arr.length;

    int[] tempArr = new int[k];
    int j = 0;

    for (int i = 0; i < k; i++)
    {
      tempArr[i] = arr[i];
    }

    for (int i = 0; i < arr.length - k; i++)
    {
      arr[i] = arr[i + k];
    }

    for (int i = arr.length - k; i < arr.length; i++)
    {
      arr[i] = tempArr[j];
      j++;
    }
  }

  public static void optimalRotateLeftByK(int[] arr, int k)
  {
    int n = arr.length;
    k = k % n;

    // reverse the first k elements
    reverseArray(arr, 0, k-1);

    // reverse the remaining n - k elements
    reverseArray(arr, k, n - 1);

    // reverse the entire array
    reverseArray(arr, 0, n-1);
  }

  public static void optimalRotateRightByK(int[] arr, int k)
  {
    int n = arr.length;
    k = k % n;

    // reverse entire array
    reverseArray(arr, 0, n - 1);

    // reverse the first k elements
    reverseArray(arr, 0, k-1);

    // reverse the remaining n-k elements
    reverseArray(arr, k, n-1);
  }

  private static void reverseArray(int[] arr, int start, int end)
  {
    while (start < end)
    {
      int temp = arr[end];
      arr[end] = arr[start];
      arr[start] = temp;
      start++;
      end--;
    }
  }

  // not optimal
  // O(n^2)
  public static void moveAllZerosToEnd(int[] arr)
  {
    for (int i = arr.length-1; i > 0; i--)
    {
      int j = i-1;
      // find a zero
      while (j > 0 && arr[j] != 0)
      {
        j--;
      }
      if (arr[j] == 0)
      {
        // swap to right until we reach i
        while (j < i)
        {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
          j++;
        }
      } else {
        return;
      }
    }
  }

  // O(n) time complexity
  // O(1) space complexity
  public static void optimalMoveAllZerosToEnd(int[] arr)
  {
    // find first zero
    int j = -1;
    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] == 0)
      {
        j = i;
        break;
      }
    }

    // no zeros found
    if (j == -1) return;
    
    for (int i = j+1; i < arr.length; i++)
    {
      if (arr[i] != 0)
      {
        // swap with arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        // move j to next zero
        j++;
      }
    }
  }

  // O(n) time complexity
  // O(1) space complexity
  public static int linearSearch(int[] arr, int num)
  {
    int index = -1;
    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] == num)
      {
       index = i;
       break;
      }
    }
    return index;
  }


  // O(m + n) time complexity 
  // O(m + n) space complexity
  public static List<Integer> unionSortedArrays(int[] arr1, int[] arr2)
  {
    int i = 0, j = 0;

    List<Integer> unionArray = new ArrayList<>();

    while (i < arr1.length && j < arr2.length)
    {
      if (arr1[i] < arr2[j])
      {
        if (unionArray.isEmpty() || unionArray.getLast() != arr1[i])
        {
          unionArray.add(arr1[i]);
        }
        i++;
      }
      else if (arr2[j] < arr1[i])
      {
        if (unionArray.isEmpty() || unionArray.getLast() != arr2[j])
        {
          unionArray.add(arr2[j]);
        }
        j++;
      } 
      else 
      {
        if (unionArray.isEmpty() || unionArray.getLast() != arr1[i])
        {
          unionArray.add(arr1[i]);
        }
        i++;
        j++;
      }
    }

    while (i < arr1.length)
    {
      if (unionArray.isEmpty() || unionArray.getLast() != arr1[i])
      {
        unionArray.add(arr1[i]);
      }
      i++;
    }

    while (j < arr2.length)
    {
      if (unionArray.isEmpty() || unionArray.getLast() != arr2[j])
      {
        unionArray.add(arr2[j]);
      }
      j++;
    }

    return unionArray;
  }

  // // bruteForce
  // // O(n^2)
  // public static int findMissingNumber(int[] arr)
  // {
  //   int n = arr.length + 1;
  //   for (int i = 1; i <= n; i++)
  //   {
  //     boolean found = false;
  //     for(int j = 0; j < n - 1; j++)
  //     {
  //       if (arr[j] == i)
  //       {
  //         found = true;
  //         break;
  //       }
  //     }
  //     if (!found)
  //       return i;
  //   }
  //   return -1;
  // }

  // // better. Uses hash array
  // // O(n) time and space complexity
  // public static int findMissingNumber(int[] arr)
  // {
  //   int n = arr.length+1;
  //   int[] hashArray = new int[n+1];

  //   for (int i = 0; i < n-1; i++)
  //   {
  //     int num = arr[i];
  //     hashArray[num]++;
  //   }

  //   for (int i = 1; i <= n; i++)
  //   {
  //     if (hashArray[i] == 0)
  //     {
  //       return i;
  //     }
  //   }
  //   return -1;
  // }

  // // expected approach. Using sum of n terms formula
  // // O(n) time complexity
  // // O(1) space complexity
  // public static int findMissingNumber(int[] arr)
  // {
  //   // sum of the first n natural numbers is (n * (n+1))/2
  //   int n = arr.length + 1; // We add one cause we're missing a number
  //   int sum = (n * (n+1))/2;
  //   int missingSum = 0;
  //   for (int i = 0; i < n - 1; i++)
  //   {
  //     missingSum += arr[i];
  //   }
  //   return sum - missingSum;
  // }

  // expected approach. Using XOR operation
  // O(n) time complexity
  // O(1) spzce complexity
  public static int findMissingNumber(int[] arr)
  {
    int xor1 = 0, xor2 = 0;
    for (int i = 0; i < arr.length; i++)
    {
      xor1 ^= arr[i];
    }

    for (int i = 1; i <= arr.length + 1; i++)
    {
      xor2 ^= i;
    }

    return xor1 ^ xor2;
  }

  // O(n) time complexity
  // O(1) space complexity
  public static int countMaximumConsecutiveOnes(int[] arr)
  {
    int max = 0, tempMax = 0;

    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] == 1)
      {
        tempMax++;
      }
      else
      {
        tempMax = 0;
      }
      max = Math.max(max, tempMax);
    }
    return max;
  }

  // // O(n) + O(n) time complexity
  // public static int findNumberThatOnlyAppearsOnce(int[] arr)
  // {
  //   Map<Integer, Integer> countMap = new HashMap<>();
  //   for (int i = 0; i < arr.length; i++)
  //   {
  //     countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
  //   }

  //   for (Entry<Integer, Integer> entry : countMap.entrySet())
  //   {
  //     if (entry.getValue() == 1)
  //     {
  //       return entry.getKey();
  //     }
  //   }
  //   return -1;
  // }

  // Optimal
  // O(n) time complexity
  // O(n) space complexity
  // Approach: perform the XOR of all elements of the array and the final XOR will be the answer
  public static int findNumberThatOnlyAppearsOnce(int[] arr)
  {
    int result = 0;
    for (int i = 0; i < arr.length; i++)
    {
      result ^= arr[i];
    }

    return result;
  }
}
