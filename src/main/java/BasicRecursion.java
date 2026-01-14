package main.java;

public class BasicRecursion {

  public static void print1ToN(int n)
  {
    if (n <= 0)
      return;
    print1ToN(n - 1);
    System.out.println(n);
  }

  public static void printNTo1(int n)
  {
    if (n <= 0)
      return;
    System.out.println(n);
    printNTo1(n-1);
  }

  // parameterized way
  public static int sumOfFirstN_numbers(int n, int sum)
  {
    if (n < 1)
    {
      return sum;
    }
    return sumOfFirstN_numbers(n - 1, sum + n);
  }

  // functional way
  public static int sumOfFirstN_numbersF(int n)
  {
    if (n == 1)
      return 1;

    return n + sumOfFirstN_numbersF(n - 1);
  }

  // Factorial of n Numbers
  public static int factorial(int n)
  {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
  }

  public static int[] reverseArray(int[] array, int left, int right)
  {
    if (left >= right)
    {
      return array;
    }

    // swap
    int temp = array[right];
    array[right] = array[left];
    array[left] = temp;

    return reverseArray(array, left + 1, right - 1);
  }

  public static int[] reverseArray(int[] array, int left)
  {
    int right = array.length - 1 - left;
    if (left >= right)
    {
      return array;
    }

    // swap
    int temp = array[right];
    array[right] = array[left];
    array[left] = temp;

    return reverseArray(array, left + 1);
  }

  public static boolean isPalindrome(String s)
  {

    // return isPalindrome(s, 0, s);
    return isPalindrome(s, 0);
  }

  // first attempt
  private static boolean isPalindrome(String original, int left, String reversed)
  {
    int right = original.length() - 1 - left;
    if (left >= right)
    {
      return original.equals(reversed);
    }

    char[] reversedCharArray = reversed.toCharArray();
    char temp = reversedCharArray[right];
    reversedCharArray[right] = reversedCharArray[left];
    reversedCharArray[left] = temp;

    return isPalindrome(original, left + 1, new String(reversedCharArray));
  }

  // second attempt
  private static boolean isPalindrome(String original, int left)
  {
    int right = original.length() - 1 - left;
    
    if (left >= original.length() /2)
      return true;
    if (original.charAt(left) != original.charAt(right))
    {
      return false;
    }
    return isPalindrome(original, left + 1);
  }

  // first attempt
  public static void printNfibonacci(int n, int n1, int n2)
  {
    System.out.print(n1 + " ");
    if (n == 0)
      return;
    printNfibonacci(n - 1, n2, n1 + n2);
  }

  // using multiple recursion calls
  public static int printNfibonacci(int n)
  {
    if (n <= 1)
      return n;

    int last = printNfibonacci(n-1);
    int slast = printNfibonacci(n-2);

    return last + slast;
  }
}
