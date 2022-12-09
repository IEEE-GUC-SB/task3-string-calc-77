package com.mycompany.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public int evaluateString(String s) throws Exception {
        if (s.equals(""))
            return 0;

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
                StringBuilder currentDelimiter = new StringBuilder();
                int i = 3;
                while (s.charAt(i) != '\n') {
                    if (s.charAt(i) != '[' && s.charAt(i) != ']') {
                        currentDelimiter.append(s.charAt(i));
                    } else if (s.charAt(i) == ']') {
                        delimiter.add(currentDelimiter.toString());
                        currentDelimiter.delete(0, currentDelimiter.length());
                    }
                    i++;
                }

                System.out.println((delimiter.toString()) + " delimiter");

                s = s.substring(i + 1, s.length());
            }
        }

        s = s.replace("\n", delimiter.get(0));
        String[] numbers = s.split("[" + delimiter + "]");
        Set<Integer> negatives = getNegatives(numbers);
        if (!negatives.isEmpty())
            throw new Exception("Negatives are not allowed. Negatives found are: " + negatives.toString());

        for (String num : numbers) {
            if (num.length() > 0) {
                int number = Integer.parseInt(num);
                sum += number > 1000 ? 0 : number;
            }
        }

        return sum;
    }

    public Set<Integer> getNegatives(String[] numbers) {
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].length() > 0) {
                int number = Integer.parseInt(numbers[i]);
                if (number < 0)
                    hs.add(number);
            }
        }

        return hs;
    }

}
