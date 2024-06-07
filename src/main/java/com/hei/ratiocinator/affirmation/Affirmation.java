package com.hei.ratiocinator.affirmation;

import lombok.Getter;

@Getter
public final class Affirmation extends Fait {

    private final String status;
    public Affirmation(String texte, String status) {
        super(texte);
        this.status = status;
    }
}
