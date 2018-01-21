package by.myadel.Homework16.Task2;


public class Main {
    private static volatile Integer VOLATILE_VALUE = 0;

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            Integer value = VOLATILE_VALUE;
            while (value < 5) {
                if (value != VOLATILE_VALUE) {
                    System.out.println( "Первый поток " + VOLATILE_VALUE );
                    value = VOLATILE_VALUE;
                }
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            Integer value = VOLATILE_VALUE;
            while (VOLATILE_VALUE < 5) {
                Integer result = value + 1;
                System.out.println( "Второй поток " + result );
                VOLATILE_VALUE = ++value;
                try {
                    Thread.sleep( 1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
