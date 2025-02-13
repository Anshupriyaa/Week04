package com.capgeminitraining.day01;

import java.util.HashMap;
import java.util.Map;

public class ElementFrequency {
    public static HashMap<String,Integer> frequencyCount(String[] str) {
        HashMap<String, Integer> frequency_Count = new HashMap<>();
        for (var strings : str) {
            if (frequency_Count.containsKey(strings)) {
                frequency_Count.put(strings, frequency_Count.get(strings) + 1);
            } else {
                frequency_Count.put(strings, 1);
            }
        }
        return frequency_Count;
    }

    public static void main(String[] args) {
        String[] str = {"Apple","Banana","Orange","Apple","Orange","Apple"};
        System.out.println(frequencyCount(str));
    }
}

