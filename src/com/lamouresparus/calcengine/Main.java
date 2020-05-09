package com.lamouresparus.calcengine;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        String stringNumber = JOptionPane.showInputDialog("Please input a number");

        if(stringNumber == null) return;
        try{
            long number = Long.parseLong(stringNumber);
            List<Long> fibonacciList = getFibonacci(number);
            StringBuilder builder = new StringBuilder(fibonacciList.size());
            for (int i=0;i<fibonacciList.size();builder.append(fibonacciList.get(i++))) builder.append("\n");
            JOptionPane.showMessageDialog(null, builder.toString(), "The Fibonacci Sequence for " + stringNumber +" is", JOptionPane.INFORMATION_MESSAGE);

        }catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Please Input a Valid Number","Error!", JOptionPane.ERROR_MESSAGE);
            start();
        }

    }

    public static List<Long> getFibonacci(long number){
        List<Long> result = new ArrayList<>();
        result.add(0L);
        result.add(1L);
        long previousNumber = 1;
        long lowestNumber = 0;

        while (true){
            long nextNumber = lowestNumber+previousNumber;
            lowestNumber = previousNumber;
            previousNumber = nextNumber;

            if (nextNumber>number){
                break;
            }
            result.add(nextNumber);

        }
        return result;
    }
}
