package com.mycompany.app;

public class Calculator {

    public int evaluateString(String s) {
        if (s.equals(""))
            return 0;

        if (s.length() == 1)
            return Integer.parseInt(s);
        return -1;
    }

}
