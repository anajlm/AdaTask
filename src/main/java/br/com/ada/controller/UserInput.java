package br.com.ada.controller;

import java.util.Scanner;

public class UserInput {

    public int readInt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer: ");
            }
        }
    }

    public String readString(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }
}
