package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NumberFileReader {

    public static Integer[] readNumbersFromFile(String filename) {

        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }

        // Convertimos la lista a arreglo
        return numbers.toArray(new Integer[0]);
    }
}
