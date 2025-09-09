package HW19;

public class ArrayUtils {

    public static void mergeSort(int[] array){
    if(array==null || array.length<2){
        return;
    } else {
        mergeSortRecursive(array, 0, array.length-1);
    }
    }

    private static void mergeSortRecursive(int[] array, int left, int right) {
        if(left<right){
            int mid = (left+right)/2;
            mergeSortRecursive(array, left, mid);
            mergeSortRecursive(array, mid+1, right);
            merge(array, left, mid, right);
        } else {
            return;
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }

    public static int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
