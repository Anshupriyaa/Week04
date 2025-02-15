package com.tit.regexandjunit.junit.listmanager;
import java.util.List;

public class ListManager {

    public void addElement(List<Integer> list, int element) {
            list.add(element);
    }

    public void removeElement(List<Integer> list, int element) {
        if (list != null) {
            list.remove(Integer.valueOf(element)); // Removes the first occurrence
        }
    }

    public int getSize(List<Integer> list) {
        return (list != null) ? list.size() : 0;
    }
}
