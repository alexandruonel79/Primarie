package org.example;

public class Persoana extends Utilizator{
    public Persoana(String nume) {
        this.nume=nume;
    }

    @Override
    String scriereText(String input) {
        try {
            if (input.equals(Cerere.CerereEnum.inlocuirebuletin.text) || input.equals(Cerere.CerereEnum.inlocuirecarnetdesofer.text)) {
                input = String.format("Subsemnatul %s, va rog sa-mi aprobati urmatoarea solicitare: %s", nume, input);
                return input;
            } else {
                throw new CerereInvalida("Cererea este invalida");
            }
        } catch (CerereInvalida e) {
            String afis="Utilizatorul de tip persoana nu poate inainta o cerere de tip "+input;
            Scrie.fisier(afis);
            return null;
        }
    }
}
