package utility;

import java.lang.Math;

public class IntToWord {

    private static final String[] tensNames = {
        "twenty",
        "thirty",
        "forty",
        "fifty",
        "sixty",
        "seventy",
        "eighty",
        "ninety"
    };

    private static final String[] numberNames = {
        "zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "fifteen",
        "sixteen",
        "seventeen",
        "eightteen",
        "nineteen"
    };

    public static String convertIntToWord(int integer){
        String word = null;
        int tens = 0;
        if (integer < 20){
            word = numberNames[integer];
        } else if (integer < 100){
            tens = (int)Math.floor(integer/10) - 2;
            word = tensNames[tens]; 
            if (integer % 10 > 0){
                word += " " + numberNames[integer % 10];
            }
        }
        return word;
    }
    
}
