package org.example.Bonus;

import org.example.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Primarie {
    public static void main(String[] args) {
        ArrayList<Eveniment> evenimente = new ArrayList<Eveniment>();
        try {
            File myObj = new File("src/main/java/org/example/Bonus/inp/in2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String comanda = data.split("; ")[0];
                if(comanda.equals("adauga_eveniment")){
                    String dateString=data.split("; ")[1];
                    String locatie=data.split("; ")[2];
                    String nume=data.split("; ")[3];

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
                    Date date = dateFormat.parse(dateString);

                    Eveniment nou=new Eveniment(date,locatie,nume);
                    evenimente.add(nou);
                } else if (comanda.equals("adauga_speaker")) {
                    String nume=data.split("; ")[1];
                    String tip=data.split("; ")[2];
                    String eveniment=data.split("; ")[3];

                    Speaker nou=new Speaker(tip,nume);

                    for (Eveniment e: evenimente){
                        if(e.getNume().equals(eveniment)){
                            e.getArtisti().add(nou);
                        }
                    }
                } else if (comanda.equals("adauga_dansator")) {
                    String nume=data.split("; ")[1];
                    String trupa=data.split("; ")[2];
                    String tip=data.split("; ")[3];
                    String eveniment=data.split("; ")[4];

                    Dansator nou=new Dansator(trupa,tip,nume);

                    for (Eveniment e: evenimente){
                        if(e.getNume().equals(eveniment)){
                            e.getArtisti().add(nou);
                        }
                    }

                } else if (comanda.equals("adauga_cantaret")) {
                    String nume=data.split("; ")[1];
                    String gen=data.split("; ")[2];
                    String eveniment=data.split("; ")[3];

                    Cantaret nou=new Cantaret(gen,nume);

                    for (Eveniment e: evenimente){
                        if(e.getNume().equals(eveniment)){
                            e.getArtisti().add(nou);
                        }
                    }
                } else if (comanda.equals("afisare_evenimente")) {
                    try {
                        String continut="";
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
                        FileWriter myWriter = new FileWriter("src/main/java/org/example/Bonus/out/out1.txt",true);
                        if(evenimente.size()==0)
                            myWriter.write("Nu sunt evenimente");
                        for (Eveniment e: evenimente){
                            continut=String.format("Numele evenimentului este %s,data la care are loc este %s in locatia %s avand artistii:",e.getNume(),dateFormat.format(e.getData()),e.getLocatie());
                            for(Artist a: e.getArtisti()){
                                if(a instanceof Speaker)
                                    continut+=String.format("speakerul %s, de tip %s ",a.getNume(),((Speaker) a).getTip());
                                if(a instanceof Cantaret)
                                    continut+=String.format("cantaretul %s care ne incanta cu muzica %s ",a.getNume(),((Cantaret) a).getGen());
                                if(a instanceof Dansator)
                                    continut+=String.format("dansatorul %s care danseaza la trupa %s stilul %s ",a.getNume(),((Dansator) a).getTrupa(),((Dansator) a).getGen());
                            }
                        }
                        myWriter.write(continut+"\n");
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }

            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        catch (ParseException e){
            System.out.println("eroare");
        }
    }
}
