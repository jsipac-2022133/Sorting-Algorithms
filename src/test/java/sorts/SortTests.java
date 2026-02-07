package sorts;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class SortTests {

    // 🔹 Método para verificar que esté ordenado
    private boolean isSorted(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // ================= GNOME =================

    @Test
    void testGnomeSortUnsorted() {
        Integer[] arr = {5, 3, 8, 1, 2};
        GnomeSort.sort(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void testGnomeSortSorted() {
        Integer[] arr = {1, 2, 3, 4, 5};
        GnomeSort.sort(arr);
        assertTrue(isSorted(arr));
    }

    // ================= SELECTION =================

    @Test
    void testSelectionSortDuplicates() {
        Integer[] arr = {4, 2, 2, 8, 1};
        SelectionSort.sort(arr);
        assertTrue(isSorted(arr));
    }

    // ================= QUICK =================

    @Test
    void testQuickSortSingleElement() {
        Integer[] arr = {7};
        QuickSort.sort(arr);
        assertTrue(isSorted(arr));
    }

    // ================= MERGE =================

    @Test
    void testMergeSortEmpty() {
        Integer[] arr = {};
        MergeSort.sort(arr);
        assertTrue(isSorted(arr));
    }

    // ================= RADIX =================

    @Test
    void testRadixSortUnsorted() {
        Integer[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort.sort(arr);
        assertTrue(isSorted(arr));
    }
}
