package org.example.Bonus;

public class Cantaret extends Artist{
   private String gen;

    public String getGen() {
        return gen;
    }

    public Cantaret(String gen, String nume) {
        this.gen = gen;
        this.nume=nume;
    }
}
