package org.example;

import org.example.model.IntegerArrayList;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
       // IntegerArrayList.arraySortComparator();

        IntegerArrayList integerArrayList = new IntegerArrayList();
        for (int i = 0; i < 100000; i++) {
            integerArrayList.add(new Random().nextInt());
        }
        System.out.println(Arrays.toString(integerArrayList.toArray()));
        System.out.println(integerArrayList.contains(new Random().nextInt()));
    }
}