package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Scrie {
    public static String numeFisier=null;
    public static String prefixFunctionar=null;
    public static void fisier(String continut) {
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/output/"+numeFisier,true);
            myWriter.write(continut+"\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void functionar(String continut,String numeFunctionar) {
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/output/"+prefixFunctionar+numeFunctionar+".txt",true);
            myWriter.write(continut+"\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void birou(String continut) {
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/output/"+numeFisier,true);

            myWriter.write(continut);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
