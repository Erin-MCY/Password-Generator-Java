package main;

import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Generator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean wantUpper = false;
        boolean wantLower = false;
        boolean wantNumber = false;
        boolean wantSpecial = false;

        System.out.println("Welcome to password generator!");
        System.out.println("Enter yes/no (y/n) to specify the elements that you want to include in your password:");

        String input = "";
        boolean correctPool = false;
        do {
            do {
                System.out.println("Do you want to include uppercase letters? (y/n) ");
                System.out.print(">>> ");
                input = scanner.nextLine();
                if (!input.equals("y") && !input.equals("n"))
                    System.out.println("Please enter y or n!");
                else
                    wantUpper = (input .equals("y"));
            } while (!input.equals("y") && !input.equals("n"));

            do {
                System.out.println("Do you want to include lowercase letters? (y/n) ");
                System.out.print(">>> ");
                input = scanner.nextLine();
                if (!input.equals("y") && !input.equals("n"))
                    System.out.println("Please enter y or n!");
                else
                    wantLower = (input.equals("y"));
            } while (!input.equals("y") && !input.equals("n"));

            do {
                System.out.println("Do you want to include numbers? (y/n) ");
                System.out.print(">>> ");
                input = scanner.nextLine();
                if (!input.equals("y") && !input.equals("n"))
                    System.out.println("Please enter y or n!");
                else
                    wantNumber = (input.equals("y"));
            } while (!input.equals("y") && !input.equals("n"));

            do {
                System.out.println("Do you want to include special characters? (y/n) ");
                System.out.print(">>> ");
                input = scanner.nextLine();
                if (!input.equals("y") && !input.equals("n"))
                    System.out.println("Please enter y or n!");
                else
                    wantSpecial = (input.equals("y"));
            } while (!input.equals("y") && !input.equals("n"));

            // the alphabet pool is not correct if none of the elements are included
            if (!wantUpper && !wantLower && !wantNumber && !wantSpecial) {
                System.out.println("You selected no elements to generate a password, "
                        + "please select at least one of the element above.");
            } else
                correctPool = true;
        } while (!correctPool);

        AlphabetPool pool = new AlphabetPool(wantUpper, wantLower, wantNumber, wantSpecial);

        // System.out.println("Now specify the length of the password you want (8~16): ");
        boolean correctLength = false;
        int length = 0;
        while (!correctLength) {
            System.out.println("Now specify the length of the password you want (8~16, edges included): ");
            System.out.print(">>> ");
            try {
                input = scanner.nextLine();
                length = Integer.parseInt(input);
                if (length >= 8 && length <= 16)
                    correctLength = true;
                else
                    System.out.println("Please enter an integer between 8 and 16, edges included.");
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input, please enter an integer!");
            }
        }

        String password = generatePassword(pool, length);
        System.out.println("The password we generated for you is: " + password);
        System.out.println("Thank you for using the password generator!\n");
    }

    private static String generatePassword(AlphabetPool pool, int length) {
        SecureRandom rand = new SecureRandom();
        int max = pool.get_pool().length();

        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            password.append(pool.get_pool().charAt(rand.nextInt(max)));
        }
        return password.toString();
    }

}
