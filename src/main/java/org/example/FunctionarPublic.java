package org.example;

import java.text.SimpleDateFormat;
public class FunctionarPublic<T> {
    private String nume;

    public FunctionarPublic(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    void solutioneazaCerere(Cerere cerere) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String afis = dateFormat.format(cerere.getData());
        afis += " - ";
        if (!cerere.getText().contains("reprezentant legal"))
            afis += cerere.getText().split(",")[0].replace("Subsemnatul ", "");
        else
            afis += cerere.getText().split(",")[1].replace(" reprezentant legal al companiei ", "");
        Scrie.functionar(afis, this.nume);
    }
}
