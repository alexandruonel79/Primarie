package org.example;

import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Utilizator {
    protected String nume;
    Set<Cerere> cereriInAsteptare = new TreeSet<>(new CereriUtilizatori());
    Set<Cerere> cereriSolutionate = new TreeSet<>(new CereriUtilizatori());

    public String getNume() {
        return nume;
    }

    abstract String scriereText(String input);

    Cerere creazaCerere(String tipul, int prioritate, Date data) {
        String text = this.scriereText(tipul);
        if (text != null) {
            Cerere noua = new Cerere(text, prioritate, data);
            cereriInAsteptare.add(noua);
            return noua;
        }
        return null;
    }

    Cerere retrageCerere(Date data) {

        Cerere trimitere = null;
        Iterator<Cerere> c = cereriInAsteptare.iterator();
        while (c.hasNext()) {
            Cerere element = c.next();
            if (element.getData() != null && element.getData().equals(data)) {
                trimitere = element;
                cereriInAsteptare.remove(element);
                break;
            }
        }
        return trimitere;
    }

    Cerere rezolvaCerere(Date data) {
        Cerere trimitere = null;
        Iterator<Cerere> c = cereriInAsteptare.iterator();
        while (c.hasNext()) {
            Cerere element = c.next();
            if (element.getData() != null && element.getData().equals(data)) {
                cereriSolutionate.add(element);
                trimitere = new Cerere(element.getText(), element.getPrioritate(), element.getData());
                cereriInAsteptare.remove(element);
                break;
            }
        }
        return trimitere;
    }

    void afisareCereriInAsteptare() {
        if (cereriInAsteptare.size() == 0)
            return;

        String continut = "";

        if (this instanceof EntitateJuridica)
            continut = ((EntitateJuridica) this).getReprezentant() + " - cereri in asteptare:";
        else
            continut = this.getNume() + " - cereri in asteptare:";

        Scrie.fisier(continut);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        for (Cerere c : cereriInAsteptare) {
            String afis = dateFormat.format(c.getData());
            afis += " - ";
            afis += c.getText();
            Scrie.fisier(afis);
        }
    }

    void afisareCereriSolutionate() {
        if (cereriSolutionate.size() == 0)
            return;

        String continut = "";

        if (this instanceof EntitateJuridica)
            continut = ((EntitateJuridica) this).getReprezentant() + " - cereri in finalizate:";
        else
            continut = this.getNume() + " - cereri in finalizate:";

        Scrie.fisier(continut);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        for (Cerere c : cereriSolutionate) {
            String afis = dateFormat.format(c.getData());
            afis += " - ";
            afis += c.getText();
            Scrie.fisier(afis);
        }
    }

    void adaugaCerereSolutionata(Cerere cerere) {
        cereriSolutionate.add(cerere);
    }
}