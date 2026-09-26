package com.project;

import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PR115cp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
            System.out.println("Ús: PR115cp <origen> <destinació>");
            return;
        }

        // Ruta de l'arxiu origen
        String rutaOrigen = args[0];
        // Ruta de l'arxiu destinació
        String rutaDesti = args[1];

        // Crida al mètode per copiar l'arxiu
        copiarArxiu(rutaOrigen, rutaDesti);
    }

    // Mètode per copiar un arxiu de text de l'origen al destí
    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {

        Path dir_origen = Paths.get(rutaOrigen);
        Path dir_desti = Paths.get(rutaDesti);

        if (Files.isRegularFile(dir_origen)) { // Comprobamos que el fichero de origen es un fichero y que exista
            try {
                if (Files.exists(dir_desti)) { // Si el archivo de destino ya existe, damos advertencia de que el archivo sera sobreescrito
                    System.out.println("El archivo sera sobreescrito!");
                }
                String contenido_origen = Files.readString(dir_origen, StandardCharsets.UTF_8); //Para copiar el contenido de un fichero en otro
                Files.writeString(dir_desti, contenido_origen, StandardCharsets.UTF_8);
                System.out.println("El archivo se ha copiado con éxito!");

            } catch (IOException e) {
                System.out.println("Ha habido un problema al copiar el fichero");
            } 
        } else {
            System.out.println("La ruta de origen no es un fichero!");
        }

    }
}
