package org.example;

import java.util.Comparator;

public class CereriUtilizatori implements Comparator<Cerere> {
    public int compare(Cerere prima, Cerere doua) {
        if (prima.getData().compareTo(doua.getData()) == 0) {
            return 0;
        } else if (prima.getData().compareTo(doua.getData()) > 0) {
            return 1;
        } else {
            return -1;
        }

    }
}
