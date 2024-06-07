package com.hei.ratiocinator.affirmation;

public final class Mensonge extends Affirmation {
    private Boolean status = false;

    public Mensonge(String texte, Boolean status) {
        super(texte);
        this.status = status;
    }
}
