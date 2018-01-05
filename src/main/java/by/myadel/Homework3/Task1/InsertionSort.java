package by.myadel.Homework3.Task1;

public class InsertionSort implements SortMethod {
    @Override
    public int[] sort(int[] inputArray) {
        int[] array = inputArray.clone();
        for (int j, i = 1; i < array.length; ++i) {
            int value = array[i];
            for (j = i - 1; j >= 0 && array[j] > value; --j) {
                array[j + 1] = array[j];
            }
            array[j + 1] = value;
        }
        return array;
    }

    @Override
    public String getName() {
        return "сортировка вставками";
    }
}
