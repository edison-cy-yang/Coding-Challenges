package main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if(!map1.containsKey(c)) {
                map1.put(c, 1);
            }
            else {
                map1.put(c, map1.get(c) + 1);
            }
        }
        
        for(int j = 0; j < s2.length(); j++) {
            char c = s2.charAt(j);
            if(!map2.containsKey(c)) {
                map2.put(c, 1);
            }
            else {
                map2.put(c, map2.get(c) + 1);
            }
        }
        
        Set set = map1.entrySet();
        Iterator i  = set.iterator();
        int totalSize = s1.length() + s2.length();
        System.out.println("total size is: " + totalSize);
        
//        Set set2 = map2.entrySet();
//        Iterator i2 = set2.iterator();
        
        int count = 0;
        int charactersProcessed = 0;
        
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            if(map2.containsKey(me.getKey())) {
                count = count + Math.abs((int) me.getValue() - map2.get(me.getKey()));
                System.out.println("s1: " + me.getKey() + " " + (int) me.getValue() + " s2: " + me.getKey() + " " + map2.get(me.getKey()));
                charactersProcessed += Math.abs((int) me.getValue() + map2.get(me.getKey()));
            }
            else {
                count = count + (int) me.getValue();
                charactersProcessed += (int) me.getValue();
            }
        }
        System.out.println("charactersProcesed: " + charactersProcessed);
        System.out.println("differece: " + count);
        
        int notProcessed = totalSize - charactersProcessed;
        
        
        
//        while(i2.hasNext()) {
//            Map.Entry me = (Map.Entry) i2.next();
//            if(map1.containsKey(me.getKey())) {
//                count = count + Math.abs((int) me.getValue() - map1.get(me.getKey()));
//            }
//            else {
//                count = count + (int) me.getValue();
//            }
//        }
        
        //count = count + (origSize1 - set.size() + (origSize2 - set2.size()));
        
        System.out.println(count + notProcessed);
    }
}
