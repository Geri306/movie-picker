package com.codecool.netflix.ui;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputScanner {

    public String getUserInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public Integer getNumericUserInput(String message) {
        Integer result = null;
        while (result == null) {
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            try {
                result = scanner.nextInt();
            } catch (NoSuchElementException e) {
                System.out.println("Invalid input!");
            }
        }
        return result;
    }
}
