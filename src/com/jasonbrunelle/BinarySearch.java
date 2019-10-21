package com.jasonbrunelle;

public class BinarySearch {

    public static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static int binarySearchRecursive(int[] arr, int x) {
        return binarySearchRecursive(arr, x, 0, arr.length-1);
    }
    private static int binarySearchRecursive(int[] arr, int x, int low, int high) {
        if (low > high) return - 1;

        int mid = (low + high) / 2;
        if (arr[mid] < x) {
            return binarySearchRecursive(arr, x, mid + 1, high);
        } else if (arr[mid] > x) {
            return binarySearchRecursive(arr, x, low, mid -1);
        } else {
            return mid;
        }
    }

    public static int first(int arr[], int x) {
        return first (arr, x, 0, arr.length - 1);
    }
    /* if x is present in arr[] then returns the index of
    FIRST occurrence of x in arr[0..n-1], otherwise
    returns -1 */
    private static int first(int arr[], int x, int low, int high)
    {
        int n = arr.length;
        if(high >= low)
        {
            int mid = low + (high - low)/2;
            if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
                return mid;
            else if(x > arr[mid])
                return first(arr, x, mid + 1, high);
            else
                return first(arr, x, low, mid -1);
        }
        return -1;
    }

    public static int last(int arr[], int x) {
        return last (arr, x, 0, arr.length - 1);
    }
    /* if x is present in arr[] then returns the index of
    LAST occurrence of x in arr[0..n-1], otherwise
    returns -1 */
    private static int last(int arr[], int x, int low, int high)
    {
        int n = arr.length;
        if (high >= low)
        {
            int mid = low + (high - low)/2;
            if (( mid == n-1 || x < arr[mid+1]) && arr[mid] == x)
                return mid;
            else if (x < arr[mid])
                return last(arr, x, low, mid -1);
            else
                return last(arr, x, mid + 1, high);
        }
        return -1;
    }
}
