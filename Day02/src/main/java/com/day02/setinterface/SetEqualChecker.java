package com.day02.setinterface;

import java.util.HashSet;
import java.util.Set;

public class SetEqualChecker {
    public static boolean setEquality(Set<Integer> set1, Set<Integer> set2){
        if(set1.size()!=set2.size()){
            return false;
        }
        for(var checker: set1){
            if(!set2.contains(checker)){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(10);
        set1.add(20);
        set1.add(30);

        Set<Integer> set2 = new HashSet<>();
        set2.add(10);
        set2.add(30);
        set2.add(20);

        System.out.println(setEquality(set1,set2));
    }
}

