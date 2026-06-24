package com.sortmetrics;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        // 1. Reading from a file (Simulating Data Input)
        try (BufferedReader br = new BufferedReader(new FileReader("input_names.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error: Please create input_names.txt");
            return;
        }

        String[] namesArray = names.toArray(new String[0]);

        // 2. Benchmarking the Algorithm
        long startTime = System.nanoTime();
        bubbleSort(namesArray);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime); // in nanoseconds

        // 3. Outputting Results
        System.out.println("Successfully sorted " + namesArray.length + " names.");
        System.out.println("Performance: " + duration + " nanoseconds.");
        
        saveToFile(namesArray);
    }

    // The Algorithm from your Chapter 2
    public static void bubbleSort(String[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareToIgnoreCase(array[j + 1]) > 0) {
                    // Swap elements
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void saveToFile(String[] array) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("sorted_results.txt"))) {
            for (String name : array) {
                writer.println(name);
            }
            System.out.println("Results saved to sorted_results.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}