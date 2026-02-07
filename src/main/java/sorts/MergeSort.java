package sorts;

public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Object[] L = new Object[n1];
        Object[] R = new Object[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (((T) L[i]).compareTo((T) R[j]) <= 0) {
                arr[k] = (T) L[i];
                i++;
            } else {
                arr[k] = (T) R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = (T) L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = (T) R[j];
            j++;
            k++;
        }
    }
}
