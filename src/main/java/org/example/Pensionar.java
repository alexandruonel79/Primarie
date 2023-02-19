package org.example;

public class Pensionar extends Utilizator {
    public Pensionar(String nume) {
        this.nume = nume;
    }
    @Override
    String scriereText(String input) {
        try {
            if (input.equals(Cerere.CerereEnum.inlocuirebuletin.text) || input.equals(Cerere.CerereEnum.inlocuirecarnetdesofer.text) || input.equals(Cerere.CerereEnum.inregistrarecupoanedepensie.text)) {
                input = String.format("Subsemnatul %s, va rog sa-mi aprobati urmatoarea solicitare: %s", nume, input);
                return input;
            } else {
                throw new CerereInvalida("Cererea este invalida");
            }
        } catch (CerereInvalida e) {
            String afis = "Utilizatorul de tip pensionar nu poate inainta o cerere de tip " + input;
            Scrie.fisier(afis);
            return null;
        }
    }
}
