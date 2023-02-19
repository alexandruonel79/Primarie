package org.example.Bonus;

public class Dansator extends Artist{
   private String trupa;
   private String gen;

    public String getTrupa() {
        return trupa;
    }

    public String getGen() {
        return gen;
    }

    public Dansator(String trupa, String gen, String nume) {
        this.nume=nume;
        this.trupa = trupa;
        this.gen = gen;
    }
}
