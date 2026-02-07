package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class NumberFileGenerator {

    public static void generateAndSaveNumbers(String filename, int amount) {
        if (amount > 3000) {
            System.out.println("Máximo permitido: 3000 números");
            return;
        }

        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for (int i = 0; i < amount; i++) {
                int number = random.nextInt(10000); // números entre 0 y 9999
                writer.write(String.valueOf(number));
                writer.newLine();
            }

            System.out.println("Archivo creado con " + amount + " números.");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo.");
            e.printStackTrace();
        }
    }
}
