package com.capgeminitraining.day01;

import java.util.*;

public class RemoveDuplicate {
    public static <T> List<Integer> removeDuplicates(List<T> list){
        List<Integer> result = new ArrayList<>();
        Set<Integer> watch = new HashSet<>();
        for(var lists: list){
            if(!watch.contains(lists)){
                watch.add((Integer) lists);
                result.add((Integer) lists);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(List.of(20,20,30,40,30));
        System.out.println(removeDuplicates(arrayList));

        List<Integer> linkedList = new LinkedList<>(List.of(20,20,30,40,30,10,20,20,10));
        System.out.println(removeDuplicates(linkedList));
    }
}
