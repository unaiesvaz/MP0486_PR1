package com.project;

import java.io.File;
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
                

            } catch (IOException e) {
                System.out.println("No se pudo leer el archivo");
            }


        } else if (Files.isDirectory(ruta)) { // Caso de que sea un directorio
            System.out.println("La ruta especificada conduce a un directorio");
        } else {
            System.out.println("La ruta es desconocida"); // Comprobar si es correcto 
        }
        
    }
}
