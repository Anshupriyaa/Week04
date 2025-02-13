package com.capgeminitraining.day01;

import java.util.LinkedList;

public class FindElement {
    public static <T> T elementFound(LinkedList<T> list, int n){
        int fast = 0;
        int slow  = 0;
        int end = list.size() - 1;
        T result;
        if(n>list.size() || n<=0 || list == null){
            return null;
        }
        while(fast<n){
            fast++;
        }
        while(fast<=end){
            fast++;
            slow++;
        }

        return list.get(slow);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list_Of_Integer = new LinkedList<>();
        list_Of_Integer.add(10);
        list_Of_Integer.add(20);
        list_Of_Integer.add(30);
        list_Of_Integer.add(40);
        list_Of_Integer.add(50);
        System.out.println(elementFound(list_Of_Integer,3));

        LinkedList<Character> list_Of_Character = new LinkedList<>();
        list_Of_Character.add('A');
        list_Of_Character.add('B');
        list_Of_Character.add('C');
        list_Of_Character.add('D');
        list_Of_Character.add('E');
        System.out.println(elementFound(list_Of_Character,2));
    }
}

