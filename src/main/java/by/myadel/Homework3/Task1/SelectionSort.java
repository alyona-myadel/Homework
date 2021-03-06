package by.myadel.Homework3.Task1;

public class SelectionSort implements SortMethod {
    @Override
    public int[] sort(int[] inputArray) {
        int[] array = inputArray.clone();
        for (int i = 0; i < array.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    @Override
    public String getName() {
        return "сортировка выбором";
    }
}
