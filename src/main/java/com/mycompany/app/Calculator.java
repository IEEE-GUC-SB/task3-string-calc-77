package com.mycompany.app;

public class Calculator {

    public int evaluateString(String s) {
        if (s.equals(""))
            return 0;

        if (s.length() == 1)
            return Integer.parseInt(s);
        if (s.length() == 3)
            return Integer.parseInt("" + s.charAt(0)) + Integer.parseInt("" + s.charAt(2));

        int sum = 0;
        s = s.replace("\n", ",");
        String[] nums = s.split(",");
        for (String num : nums)
            sum += Integer.parseInt(num);

        return sum;
    }

}
