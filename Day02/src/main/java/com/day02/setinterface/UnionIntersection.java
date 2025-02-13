package com.day02.setinterface;

import java.util.HashSet;
import java.util.Set;

public class UnionIntersection {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();


        set1.add(1);
        set1.add(2);
        set1.add(3);


        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);


        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);


        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);
    }
}


