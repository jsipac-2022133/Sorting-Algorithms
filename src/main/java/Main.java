import java.util.Arrays;

import sorts.GnomeSort;
import sorts.MergeSort;
import sorts.QuickSort;
import sorts.RadixSort;
import sorts.SelectionSort;
import utils.NumberFileGenerator;
import utils.NumberFileReader;

public class Main {

    public static void main(String[] args) {

        String filename = "numeros.txt";
        int[] sizes = {3000, 3000, 3000, 3000, 3000};


        NumberFileGenerator.generateAndSaveNumbers(filename, 3000);

        for (int rep = 0; rep < 20; rep++) {
            for (int size : sizes) {

            System.out.println("\n===== PRUEBA CON " + size + " NÚMEROS =====");

            Integer[] originalData = NumberFileReader.readNumbersFromFile(filename);
            Integer[] data = Arrays.copyOf(originalData, size);

            testAllSorts(data.clone(), "Desordenado");

            Arrays.sort(data);
            testAllSorts(data.clone(), "Ordenado");
        }
        }
    }

    private static void testAllSorts(Integer[] data, String scenario) {

        System.out.println("\n--- Escenario: " + scenario + " ---");

        measure("Gnome Sort", data.clone(), arr -> GnomeSort.sort(arr));
        measure("Selection Sort", data.clone(), arr -> SelectionSort.sort(arr));
        measure("Quick Sort", data.clone(), arr -> QuickSort.sort(arr));
        measure("Merge Sort", data.clone(), arr -> MergeSort.sort(arr));
        measure("Radix Sort", data.clone(), arr -> RadixSort.sort(arr));
    }

    private static void measure(String name, Integer[] arr, SortAlgorithm algorithm) {

        long start = System.nanoTime();
        algorithm.sort(arr);
        long end = System.nanoTime();

        System.out.println(name + " → " + (end - start) + " ns");
    }

    interface SortAlgorithm {
        void sort(Integer[] arr);
    }
}
