package com.day03.javastream;

import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String filePath = "C:\\Week04\\Day03\\src\\com\\day03\\javastream\\output.txt";

        // HashMap to store word frequency
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Remove punctuation & convert to lowercase
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                String[] words = line.split("\\s+"); // Split by spaces

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort words by frequency (descending order)
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
            sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Sort by value

            // Display total word count
            int totalWords = wordCount.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("Total Words: " + totalWords);

            // Display top 5 most frequent words
            System.out.println("\nTop 5 Most Frequent Words:");
            for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
                System.out.println(sortedWords.get(i).getKey() + " - " + sortedWords.get(i).getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
