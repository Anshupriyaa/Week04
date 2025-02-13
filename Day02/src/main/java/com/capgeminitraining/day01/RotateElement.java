package com.capgeminitraining.day01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RotateElement {
    public static List<Integer> rotateElements(List<Integer> list1,int rotateBy){
        rotateBy = rotateBy % list1.size();
        int start = 0;
        int end = list1.size()-1;
        reverseList(list1,start,rotateBy-1);
        reverseList(list1,rotateBy,end);
        reverseList(list1,start,end);
        return list1;
    }
    public static List<Integer> reverseList(List<Integer> list,int start, int end){
        while(end>start){
            int temp = list.get(end);
            list.set(end,list.get(start));
            list.set(start,temp);
            start++;
            end--;
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(List.of(10,20,30,40,50));
        System.out.println(rotateElements(arrayList,2));

        List<Integer> linkedList = new LinkedList<>(List.of(10,20,30,40,50));
        System.out.println(rotateElements(linkedList,2));
    }
}

