package org.example;

import java.util.Comparator;

public class CereriComparator implements Comparator<WrapperCerere> {
    @Override
    public int compare(WrapperCerere prim, WrapperCerere doi) {
        if (prim.getCerere().getPrioritate() == doi.getCerere().getPrioritate()) {
            if (prim.getCerere().getData().compareTo(doi.getCerere().getData()) < 0)
                return -1;
            else if (prim.getCerere().getData().compareTo(doi.getCerere().getData()) > 0) {
                return 1;
            } else
                return 0;
        }
        if (prim.getCerere().getPrioritate() > doi.getCerere().getPrioritate())
            return -1;
        else
            return 1;
    }
}
