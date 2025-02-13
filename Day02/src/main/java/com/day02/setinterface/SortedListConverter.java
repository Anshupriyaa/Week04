package com.day02.setinterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortedListConverter {
    public static void main(String[] args) {
        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(5);
        numberSet.add(3);
        numberSet.add(9);
        numberSet.add(1);

        List<Integer> sortedList = new ArrayList<>();
        for (int num : numberSet) {
            int i = 0;
            while (i < sortedList.size() && sortedList.get(i) < num) {
                i++;
            }
            sortedList.add(i, num);
        }

        System.out.println("Sorted List: " + sortedList);
    }
}