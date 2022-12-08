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
        String delimiter = ",";

        if (s.charAt(0) == '/') {
            if (s.charAt(2) != '[') {
                delimiter = "" + s.charAt(2);
                s = s.substring(4, s.length());
            } else if (s.charAt(2) == '[') {
                delimiter = "";
                int i = 3;
                while (s.charAt(i) != ']') {
                    delimiter += s.charAt(i++);
                }

                s = s.substring(i + 2, s.length());
            }
        }

        s = s.replace("\n", delimiter);
        String[] nums = s.split("[" + delimiter + "]");

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
        String s = "//[***]\n1***2***3";
        System.out.println(calc.evaluateString(s));
    }

}
