package com.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PR111Files {

    public static void main(String[] args) {
        String camiDirectori = System.getProperty("user.dir") + "/data/pr111";
        gestionarArxius(camiDirectori);
    }

    // Rep la ruta del directori on cal crear la carpeta myFiles
    public static void gestionarArxius(String camiDirectori) {
        Path ruta = Paths.get(camiDirectori); // NO podemos hacer directamente aqui el resolve porque es un String
        Path ruta_myfiles = ruta.resolve("myFiles"); //.resolve agrega el texto que introduzcas a la ruta (para mantener el tipo Path)
        try {
            Files.createDirectories(ruta_myfiles); // Crea los directorios indicados, tanto el final como los padres 

            Files.createFile(ruta_myfiles.resolve("file1.txt")); // Creamos los ficheros en la ruta indicada con resolve
            Files.createFile(ruta_myfiles.resolve("file2.txt"));

            System.out.println("Els arxius de la carpeta son: ");
            try (Stream<Path> fills = Files.list(ruta_myfiles)) {     // llista el contingut (cal tancar el Stream)
                fills.forEach(fitxer -> System.out.println(fitxer.getFileName()));
            }

            Files.move(ruta_myfiles.resolve("file2.txt"), ruta_myfiles.resolve("renamedFile.txt")); //Renombrar un fichero
            Files.deleteIfExists(ruta_myfiles.resolve("file1.txt")); // Borrar un fichero IF existe, sin error

            System.out.println("Els arxius de la carpeta son: ");
            try (Stream<Path> fills = Files.list(ruta_myfiles)) {     // llista el contingut (cal tancar el Stream)
                fills.forEach(fitxer -> System.out.println(fitxer.getFileName()));
            }



        } catch (IOException e) {
            System.out.println("Error al gestionar los archivos");
        }
    }
}
