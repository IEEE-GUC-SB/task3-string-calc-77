package com.mycompany.app;

import java.lang.reflect.Array;
import java.util.*;

public class Calculator {

    public int evaluateString(String s) {
        if (s.equals(""))
            return 0;

        if (s.length() == 1)
            return Integer.parseInt(s);
        if (s.length() == 3)
            return Integer.parseInt("" + s.charAt(0)) + Integer.parseInt("" + s.charAt(2));

        int sum = 0;
        String delimiter = ",";

        if (s.charAt(0) == '/') {
            delimiter = "" + s.charAt(2);
            s = s.substring(4, s.length());
        }

        s = s.replace("\n", delimiter);
        String[] nums = s.split(delimiter);
        System.out.println(Arrays.toString(nums) + " " + delimiter);
        for (String num : nums)
            sum += Integer.parseInt(num);

        return sum;
    }

}
