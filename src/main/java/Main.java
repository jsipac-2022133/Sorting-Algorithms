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
        int[] sizes = { 10, 100, 500, 1000, 2000, 3000 };

        NumberFileGenerator.generateAndSaveNumbers(filename, 3000);
        Integer[] todosLosNumeros = NumberFileReader.readNumbersFromFile(filename);

        for (int size : sizes) {
            System.out.println("\n===== PRUEBA CON " + size + " NUMEROS =====");

            Integer[] datosOriginales = Arrays.copyOf(todosLosNumeros, size);

            System.out.println("\n--- DATOS DESORDENADOS ---");
            testAllSorts(datosOriginales.clone());

            Integer[] datosOrdenados = Arrays.copyOf(datosOriginales, size);
            Arrays.sort(datosOrdenados);

            System.out.println("\n--- DATOS ORDENADOS ---");
            testAllSorts(datosOrdenados.clone());
        }
    }

    private static void testAllSorts(Integer[] data) {
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
        System.out.println(name + " = " + (end - start) + " ns");
    }

    interface SortAlgorithm {
        void sort(Integer[] arr);
    }
}