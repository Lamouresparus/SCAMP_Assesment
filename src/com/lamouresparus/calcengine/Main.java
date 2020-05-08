package com.lamouresparus.calcengine;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String stringNumber = JOptionPane.showInputDialog("Please input a number");
        long number = Long.parseLong(stringNumber);
        List<Long> fibonacciList = getFibonacci(number);
//        for(long eachNumber: fibonacciList){
//            System.out.println(eachNumber);
//        }
        StringBuilder builder = new StringBuilder(fibonacciList.size());
        for (int i=0;i<fibonacciList.size();builder.append(fibonacciList.get(i++))) builder.append("\n");
        JTextArea textArea = new JTextArea("Insert your Text here");
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
        JOptionPane.showMessageDialog(null, scrollPane, "dialog test with textarea",
                JOptionPane.YES_NO_OPTION);
        //JOptionPane.showMessageDialog(null, builder.toString(), "Printing results", JOptionPane.INFORMATION_MESSAGE);

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
