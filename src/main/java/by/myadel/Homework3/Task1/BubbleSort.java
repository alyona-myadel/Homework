package by.myadel.Homework3.Task1;

public class BubbleSort implements SortMethod {

    @Override
    public int[] sort(int[] inputArray) {
        int[] array = inputArray.clone();
        for (int i = array.length - 1; i >= 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    @Override
    public String getName() {
        return "сортировка пузырьком";
    }


}
