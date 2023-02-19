package org.example;

public class EntitateJuridica extends Utilizator {
    private String reprezentant;

    public String getReprezentant() {
        return reprezentant;
    }

    public EntitateJuridica(String reprezentant, String nume) {
        this.reprezentant = reprezentant;
        this.nume = nume;
    }

    @Override
    String scriereText(String input) {
        try {
            if (input.equals(Cerere.CerereEnum.creareactconstitutiv.text) || input.equals(Cerere.CerereEnum.reinnoireautorizatie.text)) {
                input = String.format("Subsemnatul %s, reprezentant legal al companiei %s, va rog sa-mi aprobati urmatoarea solicitare: %s", nume, reprezentant, input);
                return input;
            } else {
                throw new CerereInvalida("Cererea este invalida");
            }
        } catch (CerereInvalida e) {
            String afis = "Utilizatorul de tip entitate juridica nu poate inainta o cerere de tip " + input;
            Scrie.fisier(afis);
            return null;
        }
    }
}
