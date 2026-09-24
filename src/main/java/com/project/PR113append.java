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
        try (PrintWriter pw = new PrintWriter(
            new OutputStreamWriter(new FileOutputStream("fitxer.txt"), StandardCharsets.UTF_8))) {
            pw.println("Primera línia");   // println() afegeix el salt de línia
            pw.println("Segona línia");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Comprobando una cosa 
    }
}
