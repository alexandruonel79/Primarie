package org.example.Bonus;

import java.util.ArrayList;
import java.util.Date;

public class Eveniment {
    Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public ArrayList<Artist> getArtisti() {
        return artisti;
    }

    String locatie;
    ArrayList<Artist> artisti=new ArrayList<Artist>();

    String nume;
    public Eveniment(Date data, String locatie,String nume) {
        this.data = data;
        this.locatie = locatie;
        this.nume=nume;
    }

    void adaugaArtist(Artist nou){
        artisti.add(nou);
    }
}
