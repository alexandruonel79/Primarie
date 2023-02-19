package org.example;

public class Elev extends Utilizator{
    private String scoala;

    public Elev(String scoala,String nume) {
        this.scoala = scoala;
        this.nume=nume;
    }
    @Override
    String scriereText(String input) {
        try {
            if (input.equals(Cerere.CerereEnum.inlocuirebuletin.text) || input.equals(Cerere.CerereEnum.inlocuirecarnetdeelev.text)) {
                input = String.format("Subsemnatul %s, elev la scoala %s, va rog sa-mi aprobati urmatoarea solicitare: %s", nume,scoala, input);
                return input;
            } else {
                throw new CerereInvalida("Cererea este invalida");
            }
        } catch (CerereInvalida e) {
            String afis="Utilizatorul de tip elev nu poate inainta o cerere de tip "+input;
            Scrie.fisier(afis);
            return null;
        }

    }
}
