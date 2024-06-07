package com.hei.ratiocinator;

import com.hei.ratiocinator.affirmation.Affirmation;
import com.hei.ratiocinator.affirmation.Fait;
import com.hei.ratiocinator.affirmation.Mensonge;
import com.hei.ratiocinator.affirmation.Verite;

import java.util.Objects;
import java.util.Set;

public record Ratiocinator(Set<Fait> faits) {

    public String calculerLaVerite(String affirmation){

        String regex = "\\s*(\\bou\\b|\\bet\\b|\\bdonc\\b)\\s*";
        String[] affirmations = affirmation.split(regex);

        if (affirmations.length == 1) {

            if (Boolean.TRUE.equals(estCeVrai(affirmation))){
                return "Vrai";
            } else if (Boolean.FALSE.equals(estCeVrai(affirmation))) {
                return "Faux";
            }else {
                throw new JeNeSaisPas();
            }

        }else if (affirmations.length == 2){

            return verifierDesAffirmations(affirmation, affirmations);

        }else {

            String regex1 = "\\s*(\\bdonc\\b)\\s*";
            String[] affirmations1 = affirmation.split(regex1);

            String premiereAffirmation = affirmations1[0];
            String deuxiemeAffirmation = affirmations1[1];

            if (affirmation.contains(" donc ") && (affirmation.contains(" ou ") || affirmation.contains(" et "))) {

                String regex2 = "\\s*(\\bou\\b|\\bet\\b)\\s*";
                String[] affirmations2 = premiereAffirmation.split(regex2);

                String vraiOuFaux = verifierDesAffirmations(premiereAffirmation, affirmations2);

                if (vraiOuFaux.equals("Vrai") && Boolean.FALSE.equals(estCeVrai(deuxiemeAffirmation))){
                    return "Faux";
                }

                return "Vrai";

            }
        }

        throw new JeNeSaisPas();
    }


    public Boolean estCeVrai(String affirmation){
        for (Fait fait : faits){
            if (fait.getTexte().equals(affirmation)) {
                if (fait instanceof Verite) {
                    return true;
                } else if (fait instanceof Mensonge) {
                    return false;
                } else if (fait instanceof Affirmation) {
                    if (((Affirmation) fait).getStatus().equals("Vrai")) {
                        return true;
                    } else if (((Affirmation) fait).getStatus().equals("Faux")) {
                        return false;
                    }
                }
            }
        }
        throw new JeNeSaisPas();
    }


    public String verifierDesAffirmations (String affirmation, String[] affirmations){

        if (affirmation.contains(" ou ")){

            for (String affirmation1 : affirmations){
                if (Objects.equals(estCeVrai(affirmation1), true)){
                    return "Vrai";
                }
            }
        }else if(affirmation.contains(" et ")){

            for (String affirmation1 : affirmations){
                if (Objects.equals(estCeVrai(affirmation1), false)){
                    return "Faux";
                }
                return "Vrai";
            }
        } else if (affirmation.contains(" donc ")) {

            String premiereAffirmation = affirmations[0];
            String deuxiemeAffirmation = affirmations[1];

            if (Boolean.TRUE.equals(estCeVrai(premiereAffirmation)) && Boolean.FALSE.equals(estCeVrai(deuxiemeAffirmation))){
                return "Faux";
            }

            return "Vrai";
        }

        throw new JeNeSaisPas();
    }
}
