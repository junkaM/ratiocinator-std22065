package com.hei.ratiocinator;

import com.hei.ratiocinator.affirmation.Affirmation;
import com.hei.ratiocinator.affirmation.Mensonge;
import com.hei.ratiocinator.affirmation.Verite;

import java.util.Arrays;
import java.util.Set;

public record Ratiocinator(Set<Affirmation> faits) {

    public String calculerLaVerite(String affirmation){

        String regex = "\\b(ou|et|donc)\\b";
        String[] affirmations = affirmation.split(regex);

        if (affirmation.contains(" ou ")){

            for (String affirmation1 : affirmations){
                if (estCeVrai(affirmation1).equals(true)){
                    return "Vrai";
                }
            }
        }else if(affirmation.contains(" et ")){

            for (String affirmation1 : affirmations){
                if (estCeVrai(affirmation1).equals(false)){
                    return "Faux";
                }
                return "Vrai";
            }
        } else if (affirmation.contains(" donc ")) {

            String premiereAffirmation = affirmations[0];
            String deuxiemeAffirmation = affirmations[1];
            if (estCeVrai(premiereAffirmation) && !estCeVrai(deuxiemeAffirmation)){
                return "Faux";
            }

            return "Vrai";
        }

        throw new JeNeSaisPas();
    }

    public Boolean estCeVrai(String affirmation){

        for (Affirmation fait : faits){
            if (fait.getTexte().equals(affirmation) && fait instanceof Verite){
                return true;

            }else if(fait.getTexte().equals(affirmation) && fait instanceof Mensonge){
                return false;
            }
        }

        return null;
    }

    
}
