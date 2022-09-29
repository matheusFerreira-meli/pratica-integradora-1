package com.praticaintegradora1.constructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ConvertConstructor {
    private final static String INVALID_NUMBER = "Não é possível converter esse valor";
    private final static String VERY_BIG_NUMBER = "Não é possível converter valores maiores que 3999 ou menores que 1";

    @GetMapping("/{numberInput}")
    public String convertNumbersToRoman(@PathVariable String numberInput) {
        try {
            int number = Integer.parseInt(numberInput);
            if (number > 3999 || number < 1) return VERY_BIG_NUMBER;

            // https://pt.stackoverflow.com/questions/247563/converter-n%C3%BAmeros-romanos-em-java
            int[] vaNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

            String[] vaRom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            StringBuilder a = new StringBuilder();

            while (true) {
                int i = 0;
                while (number > 0) {
                    if (number >= vaNum[i]) {
                        a.append(vaRom[i]);
                        number -= vaNum[i];
                    } else {
                        i++;
                    }
                }
                return a.toString();
            }
        } catch (NumberFormatException e) {
            return INVALID_NUMBER;
        }
    }
}
