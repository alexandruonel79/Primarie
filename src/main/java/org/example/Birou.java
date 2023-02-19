package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Birou<T> {
    protected PriorityQueue<WrapperCerere> cereriInAsteptare = new PriorityQueue(1, new CereriComparator());
    protected ArrayList<FunctionarPublic> functionariPublici = new ArrayList<FunctionarPublic>();

    public Birou() {
    }

    void adaugaCerere(Cerere cerere, T utilizator) {
        if (cerere != null)
            cereriInAsteptare.add(new WrapperCerere(cerere, (Utilizator) utilizator));
    }

    void adaugaFunctionarPublic(FunctionarPublic nou) {
        functionariPublici.add(nou);
    }

    FunctionarPublic<T> selecteazaFunctionar(String nume) {
        for (FunctionarPublic<T> functionar : functionariPublici) {
            if (functionar.getNume().equals(nume)) {
                return functionar;
            }
        }
        return null;
    }

    Cerere cerereUrgenta() {
        if (cereriInAsteptare.size() > 0) {
            return cereriInAsteptare.peek().getCerere();
        }
        return null;
    }

    void afiseazaCereri() {
        PriorityQueue<WrapperCerere> copie = new PriorityQueue<WrapperCerere>(cereriInAsteptare);
        String afis = "";
        int ok = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        while (copie.size() > 0) {
            WrapperCerere actual = copie.poll();
            if (ok == 0) {
                if (actual.getUtilizator() instanceof Angajat) {
                    afis += "angajat";
                } else if (actual.getUtilizator() instanceof Persoana) {
                    afis += "persoana";
                } else if (actual.getUtilizator() instanceof Elev) {
                    afis += "elev";
                } else if (actual.getUtilizator() instanceof Pensionar) {
                    afis += "pensionar";
                } else if (actual.getUtilizator() instanceof EntitateJuridica) {
                    afis += "entitate juridica";
                }
                afis += " - cereri in birou:\n";
            }
            afis += actual.getCerere().getPrioritate() + " - ";
            afis += dateFormat.format(actual.getCerere().getData()) + " - " + actual.getCerere().getText();
            afis += "\n";
            ok = 1;
        }
        Scrie.birou(afis);
    }

    void rezolvaCerere() {

        if (cereriInAsteptare.size() > 0) {
           WrapperCerere rezolvata= cereriInAsteptare.poll();
           rezolvata.getUtilizator().adaugaCerereSolutionata(rezolvata.getCerere());
        }
    }

    void retrageCerere(Cerere cerere, Utilizator utilizator) {
        WrapperCerere nou = new WrapperCerere(cerere, utilizator);
        cereriInAsteptare.remove(nou);
    }
}
