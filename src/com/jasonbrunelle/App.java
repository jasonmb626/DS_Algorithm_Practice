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

        System.out.println(Arrays.toString(arr));
        System.out.println(testArrInOrder(arr) ? "Array in order" : "Array NOT in order");
    }
}
