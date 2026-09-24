package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PR114linies {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        // Crida al mètode que genera i escriu els números aleatoris
        generarNumerosAleatoris(camiFitxer);
    }


    // Mètode per generar 10 números aleatoris i escriure'ls al fitxer
    public static void generarNumerosAleatoris(String camiFitxer) {
        List<String> numeros = new ArrayList<>(); // Array en el que guardaremos todos los numeros

        for (int i=0;i<10;i++) {
            int num_random = (int) (Math.random() * 100); // Num random del 1 al 100
            String num_random_texto =  String.valueOf(num_random); // Pasamos el numero a formato String 
            numeros.add(num_random_texto);

        }
        String lista_nums = String.join("\n", numeros); // Join hace que el separador de una lista en este caso sea \n
            
        try { 
            Files.writeString(Paths.get(camiFitxer), lista_nums, StandardCharsets.UTF_8); // Con esto escribimos un String
        } catch (IOException e) {
                e.printStackTrace();
        }


        
    }
}
