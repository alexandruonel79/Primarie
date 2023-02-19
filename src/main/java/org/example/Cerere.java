package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cerere {
    private String text;
    private int prioritate;
    private Date data;

    public Date getData() {
        return data;
    }

    public int getPrioritate() {
        return prioritate;
    }

    public String getText() {
        return text;
    }

    public Cerere(String text, int prioritate, Date data) {
        this.text = text;
        this.prioritate = prioritate;
        this.data = data;
    }

    public enum CerereEnum {
        inlocuirebuletin("inlocuire buletin"),
        inregistrarevenitsalarial("inregistrare venit salarial"),
        inlocuirecarnetdesofer("inlocuire carnet de sofer"),
        inlocuirecarnetdeelev("inlocuire carnet de elev"),
        creareactconstitutiv("creare act constitutiv"),
        reinnoireautorizatie("reinnoire autorizatie"),
        inregistrarecupoanedepensie("inregistrare cupoane de pensie"),
        ;

        String text;

        CerereEnum(String text) {
            this.text = text;
        }
    }
    @Override
    public boolean equals(Object o) {
        Cerere c = (Cerere) o;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String first=dateFormat.format((c.getData()));
        String second=dateFormat.format((this.getData()));

        if (first.equals(second))
            return true;
        else
            return false;
    }
}
