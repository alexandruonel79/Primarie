package org.example.Bonus;

public class Speaker extends Artist{
    private String tip;

    public String getTip() {
        return tip;
    }

    public Speaker(String tip, String nume) {
        this.tip = tip;
        this.nume=nume;
    }
}
