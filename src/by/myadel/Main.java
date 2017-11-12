package by.myadel;

public class Main {

    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        System.out.println("Task 1:");
        String string = "Эта строка поделена пополам";
        int size = string.length();
        System.out.println("Количество символов в строке = " + size);
        int middleIndex = size / 2;
        String stringLeft = string.substring(0, middleIndex);
        String stringRight = string.substring(middleIndex, size);
        System.out.println("Левая половина строки = " + stringLeft);
        System.out.println("Правая половина строки = " + stringRight);
    }
}
