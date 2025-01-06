package com.practic;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String document = "ABC XYZ ABC XYZ MNO ABC PQR MNO ABC";
        String[] words = document.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                Integer i = map.get(word);
                map.put(word,i.intValue()+1);
            }else {
                map.put(word,1);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + " -> "+ map.get(key));
        }
    }
}
