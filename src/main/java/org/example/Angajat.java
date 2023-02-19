package org.example;

public class Angajat extends Utilizator{
    private String compania;
    public Angajat(String compania,String nume) {
        this.compania = compania;
        this.nume=nume;
    }

    @Override
    String scriereText(String input) {
        try {
            if (input.equals(Cerere.CerereEnum.inlocuirebuletin.text) || input.equals(Cerere.CerereEnum.inlocuirecarnetdesofer.text) || input.equals(Cerere.CerereEnum.inregistrarevenitsalarial.text)) {
                input = String.format("Subsemnatul %s, angajat la compania %s, va rog sa-mi aprobati urmatoarea solicitare: %s", nume, compania,input);
                return input;
            } else {
                throw new CerereInvalida("Cererea este invalida");
            }
        } catch (CerereInvalida e) {
            String afis="Utilizatorul de tip angajat nu poate inainta o cerere de tip "+input;
            Scrie.fisier(afis);
            return null;
        }

    }
}

