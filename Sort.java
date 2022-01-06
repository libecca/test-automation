package com.company;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("11q55555qqq1");
        list.add("q1q");
        list.add("q");
        list.add("q43324q");

        list.sort(new Comparator<String>() {
            public int compare(String String1, String String2) {
                return String1.length() - String2.length();
            }
        });
        System.out.println(list);
    }
}

