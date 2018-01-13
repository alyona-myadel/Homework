package by.myadel.Homework15.Task2;

import java.util.Scanner;

public class Main {
    private final static int numberOfDigit = 100;

    public static void main(String[] args) {
        System.out.println("Введите \"start\" для запука потока: ");
        Scanner inputScanner = new Scanner(System.in);
        String command = inputScanner.next();
        try {
            if (getCommand(command)) {
                Thread1 thread1 = new Thread1();
                thread1.setName("Thread 1");
                Thread2 thread2 = new Thread2();
                thread2.setName("Thread 2");
                thread1.start();
                thread2.start();
            }
        } catch (InvalidCommandException ex) {
            System.out.println("Неправильно введена команда.");
        }
    }

    synchronized static void print10() {

        System.out.print("\n" + Thread.currentThread().getName() + ": ");
        for (int i = 1; i <= numberOfDigit; ++i) {
            System.out.print(i + " ");
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
            if (i / 10 > 0 & i % 10 == 0 & i < numberOfDigit) {
                System.out.println("\n");
                System.out.print(Thread.currentThread().getName() + ": ");
            }
        }
    }

    private static boolean getCommand(String command) throws InvalidCommandException {
        if (command.equals("start")) {
            return true;
        }
        throw new InvalidCommandException();
    }
}
