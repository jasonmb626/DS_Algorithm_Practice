package com.jasonbrunelle;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    static int[] readIntArrayFromFile(String localFileName) {
        List<Integer> list = new ArrayList<Integer>();
        File file = new File(localFileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                String[] strs = text.trim().split("\\s+");

                for (int i = 0; i < strs.length; i++) {
                    list.add(Integer.parseInt(strs[i]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        //print out the list
        int[] intArray = new int[list.size()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = list.get(i);
        }
        return intArray;
    }

    static boolean testArrInOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i+1] + " " + arr[i] + " " + i);
            if (arr[i+1] < arr[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = readIntArrayFromFile("input10.txt");

        //Uncomment the line below to test that implementation

        //MergeSort.mergeSort(arr);
        //BubbleSort.bubbleSort(arr);
        //QuickSort.quickSort(arr);
        SelectionSort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(testArrInOrder(arr) ? "Array in order" : "Array NOT in order");
        int find = 60;
        int first = BinarySearch.first(arr, find);
        int last = BinarySearch.last(arr, find);
        int nonRecur = BinarySearch.binarySearch(arr, find);
        int recur = BinarySearch.binarySearchRecursive(arr, find);
        System.out.println("First occurence of " + find + " is " + first + "(" + arr[first] + ")\nPrevious element: " + arr[first-1]);
        System.out.println("Last occurence of " + find + " is " + last + "(" + arr[last] + ")\nNext element: " + arr[last+1]);
        System.out.println("Random occurence of " + find + "(non-recursive) is " + nonRecur + "(" + arr[nonRecur] + ")");
        System.out.println("Random occurence of " + find + "(recursive) is " + recur + "(" + arr[recur] + ")");
    }
}
