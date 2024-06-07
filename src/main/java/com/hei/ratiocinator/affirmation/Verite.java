package com.hei.ratiocinator.affirmation;

import lombok.Getter;

@Getter
public final class Verite extends Fait {
    private String status = "Faux";

    public Verite(String texte) {
        super(texte);
        this.status = status;
    }
}
