package com.capgeminitraining.day01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.addAll;
import static java.util.Collections.list;

public class ListReverse {
    public <T> T reverseList(List<T> list){
        int i = list.size() - 1;
        int j = 0;
        while(i>j){
            T temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i--;
            j++;
        }
        return (T)list;
    }

    public static void main(String[] args) {
        ListReverse obj = new ListReverse();
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(3);
        System.out.println(obj.reverseList(arrayList));

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(3);
        System.out.println(obj.reverseList(linkedList));


    }
}
