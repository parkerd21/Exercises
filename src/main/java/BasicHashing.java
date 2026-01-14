package main.java;
import java.util.*;

public class BasicHashing {

  // brute force O(N^2)
  public static void countElementFrequency(int[] arr, int n)
  {
    boolean[] visited = new boolean[n];

    for(int i = 0; i < n; i++)
    {
      if (visited[i])
        continue;

      int count = 1;
      for (int j = i + 1; j < n; j++)
      {
        if (arr[i] == arr[j])
        {
          count++;
          visited[j] = true;
        }
      }

      System.out.println(arr[i] + " " + count);
    }
  }

  // optimal O(N)
  public static void countElementFrequency2(int[] arr, int n)
  {
    Map<Integer, Integer> counts = new HashMap<>();

    for (int i = 0; i < n; i++)
    {
      counts.put(arr[i], counts.getOrDefault(arr[i], 0) + 1);
    }

    for (int key : counts.keySet())
    {
      System.out.println(key + " " + counts.get(key));
    }
  }

  // brute force using hash array
  public static void bf_findHighAndLowFrequencies(int[] arr)
  {
    boolean[] visited = new boolean[arr.length];
    int highestCount = 1;
    int lowestCount = arr.length;
    int highestFreqElement = 0;
    int lowestFreqElement = 0;

    for (int i = 0; i < arr.length; i++)
    {
      if (visited[i])
          continue;
      int count = 1;
  
      for (int j = i + 1; j < arr.length; j++)
      {
        
        if (arr[i] == arr[j]) 
        {
          count++;
          visited[j] = true;
        }
      }
      if (count > highestCount)
      {
        highestCount = count;
        highestFreqElement = arr[i];
      }
      else if (count < lowestCount)
      {
        lowestCount = count;
        lowestFreqElement = arr[i];
      }
    }

    System.out.println(highestFreqElement + ": " + highestCount);
    System.out.println(lowestFreqElement + ": " + lowestCount);
  }

  // using map
  public static void findHighAndLowFrequencies(int[] arr)
  {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++)
    {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    int highValue = Integer.MIN_VALUE;
    int lowValue = Integer.MAX_VALUE;    
    int highKey = 0;
    int lowKey = 0;

    for (Map.Entry<Integer, Integer> entry : map.entrySet())
    {
      if (entry.getValue() > highValue)
      {
        highValue = entry.getValue();
        highKey = entry.getKey();
      } else if (entry.getValue() < lowValue)
      {
        lowValue = entry.getValue();
        lowKey = entry.getKey();
      }
    }

    System.out.println("High is " + highKey);
    System.out.println("Low is " + lowKey);
  }
}
