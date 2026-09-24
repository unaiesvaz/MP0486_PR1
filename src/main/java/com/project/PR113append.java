package com.project;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class PR113append {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que afegeix les frases al fitxer
        afegirFrases(camiFitxer);
    }

    public static void afegirFrases(String camiFitxer) { // Este metodo escribe sin borrar, agrega
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(camiFitxer, StandardCharsets.UTF_8, true))) { // El ultimo parametro es para determinar si agregamos texto o sobreescribimos (true o false)
            bw.write("I can only show you the door");
            bw.newLine(); //Salto de linea 
            bw.write("You're the one that has to walk through it");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        
    }
}
