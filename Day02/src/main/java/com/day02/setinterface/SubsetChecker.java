package com.day02.setinterface;

import java.util.HashSet;
import java.util.Set;

public class SubsetChecker {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(2);
        set1.add(3);

        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        boolean isSubset = true;
        for (int num : set1) {
            if (!set2.contains(num)) {
                isSubset = false;
                break;
            }
        }

        System.out.println("Is Set1 a subset of Set2? " + isSubset);
    }
}
