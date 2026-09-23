package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PR112cat {

    public static void main(String[] args) {
        // Comprovar que s'ha proporcionat una ruta com a paràmetre
        if (args.length == 0) {
            System.out.println("No s'ha proporcionat cap ruta d'arxiu.");
            return;
        }

        // Obtenir la ruta del fitxer des dels paràmetres
        String rutaArxiu = args[0];
        mostrarContingutArxiu(rutaArxiu);
    }

    // Funció per mostrar el contingut de l'arxiu o el missatge d'error corresponent
    public static void mostrarContingutArxiu(String rutaArxiu) {
        Path ruta = Paths.get(rutaArxiu);

        if (Files.isRegularFile(ruta)) { // En el caso de que sea un fichero
            try {
                List<String> linies = Files.readAllLines(ruta, StandardCharsets.UTF_8);
                for (String linea : linies) {
                    System.out.println(linea);
                }
                

            } catch (IOException e) {
                System.out.println("No se pudo leer el archivo");
            }


        } else if (Files.isDirectory(ruta)) { // Caso de que sea una carpeta 
            System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
        } else {
            System.out.println("El fitxer no existeix o no és accessible."); // El resto de casos en el que no se encuentre o no exista el fichero 
        }
        
    }
}
