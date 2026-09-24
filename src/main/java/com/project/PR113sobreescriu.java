package com.project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class PR113sobreescriu {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que escriu les frases sobreescrivint el fitxer
        escriureFrases(camiFitxer);
    }

    // Mètode que escriu les frases sobreescrivint el fitxer amb UTF-8; cada línia acaba amb un salt de línia
    public static void escriureFrases(String camiFitxer) { // Este metodo sobreescribe 
        try (PrintWriter pw = new PrintWriter(
            new OutputStreamWriter(new FileOutputStream(camiFitxer), StandardCharsets.UTF_8))) {
            pw.println("I can only show you the door");   // println() afegeix el salt de línia
            pw.println("You're the one that has to walk through it");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
