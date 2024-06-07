package com.hei.ratiocinator.affirmation;

public final class Verite extends Affirmation {
    private Boolean Status = true;

    public Verite(String texte, Boolean status) {
        super(texte);
        Status = status;
    }

    @Override
    public Boolean calculerLaVerite(Affirmation affirmation) {
        return null;
    }
}
