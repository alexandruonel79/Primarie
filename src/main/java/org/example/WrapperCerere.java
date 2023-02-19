package org.example;

import java.text.SimpleDateFormat;

public class WrapperCerere {
    private Cerere cerere;
    private Utilizator utilizator;

    public WrapperCerere(Cerere cerere, Utilizator utilizator) {
        this.cerere = cerere;
        this.utilizator = utilizator;
    }

    public Cerere getCerere() {
        return cerere;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    @Override
    public boolean equals(Object obj) {
        WrapperCerere c = (WrapperCerere) obj;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String first = dateFormat.format((c.getCerere().getData()));
        String second = dateFormat.format((this.getCerere().getData()));

        if (first.equals(second) && this.getCerere().getPrioritate() == c.getCerere().getPrioritate())
            return true;
        else
            return false;
    }
}
