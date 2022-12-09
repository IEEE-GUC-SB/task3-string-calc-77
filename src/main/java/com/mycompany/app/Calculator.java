package com.mycompany.app;

import java.lang.reflect.Array;
import java.util.*;

public class Calculator {

    public int evaluateString(String s) throws Exception {
        if (s.equals(""))
            return 0;

        if (s.length() == 1)
            return Integer.parseInt(s);
        if (s.length() == 3)
            return Integer.parseInt("" + s.charAt(0)) + Integer.parseInt("" + s.charAt(2));

        int sum = 0;
        ArrayList<String> delimiter = new ArrayList<>();
        delimiter.add(",");

        if (s.charAt(0) == '/') {
            if (s.charAt(2) != '[') {
                delimiter.clear();
                delimiter.add("" + s.charAt(2));
                s = s.substring(4, s.length());
            } else if (s.charAt(2) == '[') {
                delimiter.clear();
                String currentDelimiter = "";
                int i = 3;
                while (s.charAt(i) != '\n') {
                    if (s.charAt(i) != '[' && s.charAt(i) != ']') {
                        currentDelimiter += s.charAt(i);
                    } else if (s.charAt(i) == ']') {
                        delimiter.add(currentDelimiter);
                        currentDelimiter = "";
                    }
                    i++;
                }

                System.out.println((delimiter.toString()) + " delimiter");

                s = s.substring(i + 1, s.length());
            }
        }

        s = s.replace("\n", delimiter.get(0));
        String[] nums = s.split("[" + delimiter + "]");
        System.out.println(Arrays.toString(nums) + " nums");
        HashSet<Integer> negatives = getNegatives(nums);
        if (!negatives.isEmpty())
            throw new Exception("Negatives are not allowed. Negatives found are: " + negatives.toString());

        for (String num : nums) {
            if (num.length() > 0) {
                int number = Integer.parseInt(num);
                sum += number > 1000 ? 0 : number;
            }
        }

        return sum;
    }

    public HashSet<Integer> getNegatives(String[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].length() > 0) {
                int number = Integer.parseInt(nums[i]);
                if (number < 0)
                    hs.add(number);
            }
        }

        return hs;
    }

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        String s = "//[*][%]\n1*2%3";
        System.out.println(calc.evaluateString(s));
    }

}
