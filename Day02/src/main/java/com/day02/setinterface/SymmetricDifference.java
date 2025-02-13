package com.day02.setinterface;

import java.util.ArrayList;
import java.util.List;

public class SymmetricDifference {
    public static void main(String[] args) {
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

        List<Integer> symDiffSet = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                symDiffSet.add(num);
            }
        }
        for (int num : set2) {
            if (!set1.contains(num)) {
                symDiffSet.add(num);
            }
        }

        System.out.println("Symmetric Difference: " + symDiffSet);
    }
}


