package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ManagementPrimarie {

    public static void main(String[] args) {
        List<Utilizator> utilizatori = new ArrayList();

        Birou<Persoana> birouPersoane = new Birou<Persoana>();
        Birou<Angajat> birouAngajati = new Birou<Angajat>();
        Birou<EntitateJuridica> birouEntitateJuridica = new Birou<EntitateJuridica>();
        Birou<Pensionar> birouPensionar = new Birou<Pensionar>();
        Birou<Elev> birouElevi = new Birou<Elev>();

        Scrie.numeFisier = args[0];
        Scrie.prefixFunctionar ="functionar_";

        try {
            File myObj = new File("src/main/resources/input/" + args[0]);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String comanda = data.split("; ")[0];
                String tipul = data.split("; ")[1];

                if (comanda.equals("adauga_utilizator")) {
                    String nume = data.split("; ")[2];
                    if (tipul.equals("persoana")) {
                        Persoana noua = new Persoana(nume);
                        utilizatori.add(noua);
                    }
                    if (tipul.equals("angajat")) {
                        String compania = data.split("; ")[3];
                        Angajat nou = new Angajat(compania, nume);
                        utilizatori.add(nou);
                    }
                    if (tipul.equals("pensionar")) {
                        Pensionar nou = new Pensionar(nume);
                        utilizatori.add(nou);
                    }
                    if (tipul.equals("elev")) {
                        String scoala = data.split("; ")[3];
                        Elev nou = new Elev(scoala, nume);
                        utilizatori.add(nou);
                    }
                    if (tipul.equals("entitate juridica")) {
                        String reprezentant = data.split("; ")[2];
                        nume = data.split("; ")[3];
                        EntitateJuridica noua = new EntitateJuridica(reprezentant, nume);
                        utilizatori.add(noua);
                    }
                }
                if (comanda.equals("cerere_noua")) {
                    String nume = data.split("; ")[1];
                    String cerere = data.split("; ")[2];
                    String dateString = data.split("; ")[3];

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
                    Date date = dateFormat.parse(dateString);

                    int prioritate = Integer.parseInt(data.split("; ")[4]);

                    for (Utilizator u : utilizatori) {
                        if (u instanceof EntitateJuridica) {
                            if (((EntitateJuridica) u).getReprezentant() != null && ((EntitateJuridica) u).getReprezentant().equals(nume)) {
                                Cerere noua = u.creazaCerere(cerere, prioritate, date);
                                birouEntitateJuridica.adaugaCerere(noua, (EntitateJuridica) u);
                            }
                        } else if (u.getNume() != null && u.getNume().equals(nume)) {
                            Cerere noua = u.creazaCerere(cerere, prioritate, date);
                            if (noua != null) {

                                if (u instanceof Persoana) {
                                    birouPersoane.adaugaCerere(noua, (Persoana) u);
                                }
                                if (u instanceof Pensionar) {
                                    birouPensionar.adaugaCerere(noua, (Pensionar) u);
                                }
                                if (u instanceof Elev) {
                                    birouElevi.adaugaCerere(noua, (Elev) u);
                                }
                                if (u instanceof Angajat) {
                                    birouAngajati.adaugaCerere(noua, (Angajat) u);
                                }
                            }
                        }
                    }
                }
                if (comanda.equals("afiseaza_cereri_in_asteptare")) {
                    String nume = data.split("; ")[1];

                    for (Utilizator u : utilizatori) {
                        if (u instanceof EntitateJuridica) {
                            if (((EntitateJuridica) u).getReprezentant() != null && ((EntitateJuridica) u).getReprezentant().equals(nume)) {
                                u.afisareCereriInAsteptare();
                                break;
                            }
                        } else if (u.getNume() != null && u.getNume().equals(nume)) {
                            u.afisareCereriInAsteptare();
                            break;
                        }
                    }
                }
                if (comanda.equals("afiseaza_cereri_finalizate")) {
                    String nume = data.split("; ")[1];

                    for (Utilizator u : utilizatori) {
                        if (u instanceof EntitateJuridica) {
                            if (((EntitateJuridica) u).getReprezentant() != null && ((EntitateJuridica) u).getReprezentant().equals(nume)) {
                                u.afisareCereriSolutionate();
                                break;
                            }
                        } else if (u.getNume() != null && u.getNume().equals(nume)) {
                            u.afisareCereriSolutionate();
                            break;
                        }
                    }
                }
                if (comanda.equals("retrage_cerere")) {
                    String nume = data.split("; ")[1];
                    String dateString = data.split("; ")[2];

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
                    Date date = dateFormat.parse(dateString);

                    for (Utilizator u : utilizatori) {
                        if (u instanceof EntitateJuridica) {
                            if (((EntitateJuridica) u).getReprezentant() != null && ((EntitateJuridica) u).getReprezentant().equals(nume)) {
                                Cerere eliminata=u.retrageCerere(date);
                                birouEntitateJuridica.retrageCerere(eliminata,u);
                                break;
                            }
                        } else if (u.getNume() != null && u.getNume().equals(nume)) {
                            if(u instanceof Persoana){
                                Cerere eliminata=u.retrageCerere(date);
                                birouPersoane.retrageCerere(eliminata,u);
                            } else if (u instanceof Elev) {
                                Cerere eliminata=u.retrageCerere(date);
                                birouElevi.retrageCerere(eliminata,u);
                            } else if (u instanceof Angajat) {
                                Cerere eliminata=u.retrageCerere(date);
                                birouAngajati.retrageCerere(eliminata,u);
                            } else if (u instanceof Pensionar) {
                                Cerere eliminata=u.retrageCerere(date);
                                birouPensionar.retrageCerere(eliminata,u);
                            }

                            break;
                        }
                    }
                }
                if (comanda.equals("adauga_functionar")) {
                    String tip = data.split("; ")[1];
                    String nume = data.split("; ")[2];

                    switch (tip) {
                        case "persoana":
                            birouPersoane.adaugaFunctionarPublic(new FunctionarPublic<>(nume));
                            break;

                        case "angajat":
                            birouAngajati.adaugaFunctionarPublic(new FunctionarPublic<>(nume));
                            break;

                        case "entitate juridica":
                            birouEntitateJuridica.adaugaFunctionarPublic(new FunctionarPublic<>(nume));
                            break;

                        case "elev":
                            birouElevi.adaugaFunctionarPublic(new FunctionarPublic<>(nume));
                            break;

                        case "pensionar":
                            birouPensionar.adaugaFunctionarPublic(new FunctionarPublic<>(nume));
                            break;

                        default:
                            System.out.println("greseala");
                    }
                }
                if (comanda.equals("rezolva_cerere")) {
                    String tip = data.split("; ")[1];
                    String nume = data.split("; ")[2];

                    FunctionarPublic functionar;

                    switch (tip) {
                        case "persoana":
                            functionar = birouPersoane.selecteazaFunctionar(nume);
                            if (functionar != null) {
                                Cerere solutionata=birouPersoane.cerereUrgenta();

                                for(Utilizator u: utilizatori){
                                    u.rezolvaCerere(solutionata.getData());
                                }
                                functionar.solutioneazaCerere(solutionata);
                                birouPersoane.rezolvaCerere();
                            }
                            break;

                        case "angajat":
                            functionar = birouAngajati.selecteazaFunctionar(nume);
                            if (functionar != null) {
                                Cerere solutionata=birouAngajati.cerereUrgenta();
                                for(Utilizator u: utilizatori){
                                    u.rezolvaCerere(solutionata.getData());
                                }
                                functionar.solutioneazaCerere(solutionata);
                                birouAngajati.rezolvaCerere();
                            }
                            break;

                        case "entitate juridica":
                            functionar = birouEntitateJuridica.selecteazaFunctionar(nume);
                            if (functionar != null) {
                                Cerere solutionata=birouEntitateJuridica.cerereUrgenta();
                                for(Utilizator u: utilizatori){
                                    u.rezolvaCerere(solutionata.getData());
                                }
                                functionar.solutioneazaCerere(solutionata);
                                birouEntitateJuridica.rezolvaCerere();
                            }
                            break;

                        case "elev":
                            functionar = birouElevi.selecteazaFunctionar(nume);
                            if (functionar != null) {
                                Cerere solutionata=birouElevi.cerereUrgenta();
                                for(Utilizator u: utilizatori){
                                    u.rezolvaCerere(solutionata.getData());
                                }
                                functionar.solutioneazaCerere(solutionata);
                                birouElevi.rezolvaCerere();
                            }
                            break;

                        case "pensionar":
                            functionar = birouPensionar.selecteazaFunctionar(nume);
                            if (functionar != null) {
                                Cerere solutionata=birouPensionar.cerereUrgenta();
                                for(Utilizator u: utilizatori){
                                    u.rezolvaCerere(solutionata.getData());
                                }
                                functionar.solutioneazaCerere(solutionata);
                                birouPensionar.rezolvaCerere();
                            }
                            break;

                        default:
                            System.out.println("greseala");
                    }
                }
                if (comanda.equals("afiseaza_cereri")) {
                    String tip = data.split("; ")[1];

                    switch (tip) {
                        case "persoana":
                            birouPersoane.afiseazaCereri();
                            break;
                        case "angajat":
                            birouAngajati.afiseazaCereri();
                            break;
                        case "elev":
                            birouElevi.afiseazaCereri();
                            break;
                        case "entitate juridica":
                            birouEntitateJuridica.afiseazaCereri();
                            break;
                        case "pensionar":
                            birouPensionar.afiseazaCereri();
                            break;
                        default:
                            System.out.println("probleme");
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        catch (ParseException e){
            System.out.println("Eroare");
        }
    }
}