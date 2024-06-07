package com.hei.ratiocinator.affirmation;

import lombok.Getter;

@Getter
public final class Mensonge extends Fait {
    private String status = "Faux";

    public Mensonge(String texte) {
        super(texte);
        this.status = status;
    }
}
