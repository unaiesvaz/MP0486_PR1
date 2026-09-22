package com.project;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PR110ReadFile {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/GestioTasques.java";
        llegirIMostrarFitxer(camiFitxer);  // Només cridem a la funció amb la ruta del fitxer
    }

    // Funció que llegeix el fitxer i mostra les línies amb numeració
    public static void llegirIMostrarFitxer(String camiFitxer) {
        int contador_lineas = 1;
        File fitxer = new File (camiFitxer);

        if (fitxer.isFile()) { //Nos sirve para comprobar si al final de la ruta indicada hay un fichero
            try {
                // Tot el fitxer com a llista de línies (UTF-8):
                List<String> linies = Files.readAllLines(Paths.get(camiFitxer), StandardCharsets.UTF_8);
                for (String linia : linies) { //Para cada linea del fichero
                    System.out.println(contador_lineas + ": " + linia);
                    contador_lineas++;
                }

            } catch (IOException e) {

                System.out.println("No se pudo leer el archivo");
            }

        } else {
            System.out.println("La ruta especificada no existe");
        }
    }
}
