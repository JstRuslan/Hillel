package HW19;

import java.util.Arrays;

import static HW19.ArrayUtils.binarySearch;
import static HW19.ArrayUtils.mergeSort;

public class StartApp {

    public static void main(String[] args) {
        int[] array = {12, 5, 11, 0, 12, 1, 3, 17, 6};
        int target = 12;

        System.out.println("Вхідний масив: " + Arrays.toString(array));
        mergeSort(array);
        System.out.println("Відсортований масив: " + Arrays.toString(array));

        int index = binarySearch(array, target);
        if (index != -1) {
            System.out.println("Елемент " + target + " знайдено за індексом " + index);
        } else {
            System.out.println("Елемент " + target + " не знайдено у масиві");
        }
    }
}
