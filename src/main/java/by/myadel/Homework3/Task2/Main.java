package by.myadel.Homework3.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberOfNews = askNumberOfNews();
        int numberPerPage = askNumberPerPage();
        if (numberPerPage <= 0 || numberOfNews < 0) {
            System.out.println("Error");
            return;
        }
        System.out.println("Количество страниц для вывода " + numberOfNews + " новостей: " + determineTheNumberOfNewsPages(numberOfNews, numberPerPage));
    }

    private static int askNumberOfNews() {
        System.out.println("Количество новостей: ");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }

    private static int askNumberPerPage() {
        System.out.println("Количество новостей на странице: ");
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }

    private static int determineTheNumberOfNewsPages(int numberOfNews, int numberPerPage) {
        int numberOfNewsPage = (int) Math.ceil((double) (numberOfNews) / numberPerPage);
        return numberOfNewsPage;
    }
}
