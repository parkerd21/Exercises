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

  // // O(n^2) time complexity
  // // O(1) space complexity
  // public static int longestSubArrayWithSumK(int[] arr, int k)
  // {
  //   int maxL = 0;

  //   for (int i = 0; i < arr.length - 1; i++)
  //   {
  //     if (arr[i] > k)
  //       continue;
  //     int sum = arr[i];
  //     for (int j = i + 1; j < arr.length; j++)
  //     {
  //       sum += arr[j];
  //       if (sum > k)
  //         break;
  //       if (sum == k)
  //       {
  //         maxL = Math.max(maxL, j - i + 1);
  //         break;
  //       }
  //     }
  //   }
  //   return maxL;
  // }

  // optimal, use sliding window
  // O(n) time complexity
  // O(1) space complexity
  public static int longestSubArrayWithSumK(int[] arr, int k)
  {
    int i = 0, j = 0;
    int sum = arr[0];
    int maxL = 0;

    while (j < arr.length)
    {
      while (i <= j && sum > k)
      {
        sum -= arr[i];
        i++;
      }
      if (sum == k)
      {
        maxL = Math.max(maxL, j - i + 1);
      }
      j++;
      if (j < arr.length)
      {
        sum += arr[j];
      }
    }
    return maxL;
  }

  // // Brute Force
  // // O(n^2) time complexity
  // // O(1) space complexity
  // public static int longestSubArrayWithSumZero(int[] arr)
  // {
  //   int sum = 0;
  //   int maxL = 0;
  //   for (int i = 0; i < arr.length; i++)
  //   {
  //     for (int j = i; j < arr.length; j++)
  //     {
  //       sum += arr[j];
  //       if (sum == 0)
  //       {
  //         int length = j - i + 1;
  //         maxL = Math.max(maxL, length);
  //       }
  //     }
  //     sum = 0;
  //   }
  //   return maxL;
  // }

  // optimal. prefix sum pattern
  // O(n) time complexity
  // O(1) space complexity
  public static int longestSubArrayWithSumZero(int[] arr)
  {
    Map<Integer, Integer> prefixSumMap = new HashMap<>();
    int maxL = 0;
    int sum = 0;

    for (int i = 0; i < arr.length; i++)
    {
      sum += arr[i];
      if (sum == 0)
      {
        maxL = Math.max(maxL, i + 1);
      }
      else if (prefixSumMap.containsKey(sum))
      {
        maxL = Math.max(maxL, i - prefixSumMap.get(sum));
      }
      else 
      {
        prefixSumMap.put(sum, i);
      }
    }
    return maxL;
  }

  // // brute force
  // // O(n^2) time complexity
  // // O(1) space complexity
  // public static String twoSumExists(int[] arr, int target)
  // {
  //   for (int i = 0; i < arr.length -1; i++)
  //   {
  //     int sum = arr[i];
  //     for (int j = i + 1; j < arr.length; j++)
  //     {
  //       if (sum + arr[j] == target)
  //       {
  //         return "YES";
  //       }
  //     }
  //   }
  //   return "NO";
  // }

  // public static int[] twoSumIndices(int[] arr, int target)
  // {
  //   for (int i = 0; i < arr.length -1; i++)
  //   {
  //     int sum = arr[i];
  //     for (int j = i + 1; j < arr.length; j++)
  //     {
  //       if (sum + arr[j] == target)
  //       {
  //         return new int[] {i, j};
  //       }
  //     }
  //   }
  //   return new int[] {-1, -1};
  // }

  // optimal approach
  // O(n logn) time complexity
  // O(1) space complexity
  public static String twoSumExists(int[] arr, int target)
  {
    // sort arr
    Arrays.sort(arr);

    int i = 0; // left
    int j = arr.length -1; // right

    while (i < j)
    {
      int sum = arr[i] + arr[j];
      if (sum == target)
        return "YES";
      if (sum < target)
        i++;
      else if (sum > target)
        j--;
    }
    return "NO";
  }

  // optimal approach
  // O(n logn) time complexity
  // O(n) space complexity
  public static int[] twoSumIndices(int[] arr, int target)
  {
    int n = arr.length;
    // need to keep track of the value and indices since we will be changing the original order when we sort
    int[][] numsWithIndex = new int[n][2];

    for (int i = 0; i < n; i++)
    {
      numsWithIndex[i] = new int[]{arr[i], i}; // [value, index]
    }

    Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

    int i = 0; // left
    int j = n - 1; // right

    // when i and j cross we are done
    while (i < j)
    {
      int sum = numsWithIndex[i][0] + numsWithIndex[j][0];
      if (sum == target)
        return new int[] {numsWithIndex[i][1], numsWithIndex[j][1]};
      if (sum < target)
        i++;
      else
        j--;
    }
    return new int[] {-1,-1};
  }

  // brute force
  // you can count how many 0s, 1s, and 2s are in the array. Then loop through array again filling in the correct values.
  // O(n) time complexity
  // O(1) space complexity

  // Optimal. Dutch National Flag algorithm
  // O(n) time complexity
  // O(1) space complexity
  public static int[] sortArrayOf012(int[] arr)
  {
    int l = 0, c = 0, r = arr.length-1;
    while (c <= r)
    {
      if (arr[c] == 0)
      {
        int temp = arr[c];
        arr[c] = arr[l];
        arr[l] = temp;
        l++; c++;
      }
      if (arr[c] == 1)
      {
        c++;
      }
      else {
        int temp = arr[r];
        arr[r] = arr[c];
        arr[c] = temp;
        r--;
      }
    }
    return arr;
  }

  // // Better approach
  // // Time complexity O(n)
  // // Space complexity O(n)
  // public static int findMajorityElementOccuringMoreThanHalfTimes(int[] arr)
  // {
  //   Map<Integer, Integer> elementCountMap = new HashMap<>();
  //   int largest = 0;
  //   Integer keyOfLargest = -1;
  //   for (int i = 0; i < arr.length; i++)
  //   {
  //     elementCountMap.put(arr[i], elementCountMap.getOrDefault(arr[i], 0) + 1);
  //     if (elementCountMap.get(arr[i]) > largest)
  //     {
  //       largest = elementCountMap.get(arr[i]);
  //       keyOfLargest = arr[i];
  //     }
  //     if (largest > arr.length/2)
  //     {
  //       return keyOfLargest;
  //     }
  //   }
  //   return keyOfLargest;
  // }

  // Optimal approach
  // Time complexity O(n)
  // Space complexity O(1)
  public static int findMajorityElementOccuringMoreThanHalfTimes(int[] arr)
  {
    int count = 0;
    int element = -1;

    for (int i = 0; i < arr.length; i++)
    {
      if (count == 0)
      {
        element = arr[i];
      }
      if (element == arr[i])
      {
        count++;
      } else 
      {
        count--;
      }
    }
    return element;
  }

  // // better
  // // Time complexity O(n^2)
  // // Space complexity O(1);
  // public static int findMaxSubArraySum(int[] arr)
  // {
  //   int maxSum = Integer.MIN_VALUE;

  //   for (int i = 0; i < arr.length; i++)
  //   {
  //     int tempSum = 0;
  //     for (int j = i; j < arr.length; j++)
  //     {
  //       tempSum += arr[j];
  //       maxSum = Math.max(maxSum, tempSum);
  //     }
  //   }
  //   return maxSum;
  // }

  // optimal. Kadane's Algorithm
  // Time Complexity O(n)
  // Space Complexity O(1)
  public static int findMaxSubArraySum(int[] arr)
  {
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < arr.length; i++)
    {
      if (sum < 0) sum = 0;
      sum += arr[i];
      maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }

  // Follow up question:
  // Can you print the subarray that has the maximum sum?
  public static int[] findMaxSubArraySumIndexes(int[] arr)
  {
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;
    int tempStart = 0;
    int iStart = -1;
    int iEnd = -1;
    for (int i = 0; i < arr.length; i++)
    {
      if (sum <= 0)
      {
        sum = 0;
        tempStart = i;
      }
      sum += arr[i];
      if (sum > maxSum)
      {
        maxSum = sum;
        iStart = tempStart;
        iEnd = i;
      }
    }
    return new int[]{iStart, iEnd};
  }

  // // brute force
  // // time complexity O(n^2)
  // // space complexity O(1)
  // // returns maximum profit you can achieve
  // public static int stockBuyAndSell(int[] arr)
  // {
  //   int maxProfit = 0;
  //   for (int i = 0; i < arr.length -1; i++)
  //   {
  //     for (int j = i + 1; j < arr.length; j++)
  //     {
  //       int tempProfit = arr[j] - arr[i];
  //       maxProfit = Math.max(maxProfit, tempProfit);
  //     }
  //   }
  //   return maxProfit;
  // }

  public static int stockBuyAndSell(int[] arr)
  {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] < minPrice)
      {
        minPrice = arr[i];
      }
      else {
        maxProfit = Math.max(maxProfit, arr[i] - minPrice);
      }
    }
    return maxProfit;
  }
}
