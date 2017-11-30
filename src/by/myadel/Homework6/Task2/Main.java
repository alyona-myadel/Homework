package by.myadel.Homework6.Task2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите размер первого массива: ");
        Scanner inputScanner = new Scanner(System.in);
        int sizeArray = inputScanner.nextInt();
        System.out.print("Введите размер второго массива: ");
        int sizeArrayBig = inputScanner.nextInt();
        if (sizeArray <= 0 || sizeArrayBig <= 0 || sizeArray >= sizeArrayBig) {
            System.out.println("Вы неправильно ввели размер массива. \nРазмер второго массива должен быть больше первого.");
            return;
        }
        int array[] = new int[sizeArray];
        for (int i = 0; i < sizeArray; ++i) {
            array[i] = 1;
        }
        int arrayBig[] = new int[sizeArrayBig];
        for (int i = 0; i < sizeArrayBig; ++i) {
            arrayBig[i] = 0;
        }
        int arrayBigPosition = (arrayBig.length - args.length) / 2 - 1;
        System.out.print(Arrays.toString(array) + "\n");
        System.out.print(Arrays.toString(arrayBig) + "\n");
        System.arraycopy(array, 0, arrayBig, arrayBigPosition, array.length);
        System.out.print(Arrays.toString(arrayBig) + "\n");
    }
}