package com.hei.ratiocinator;

import com.hei.ratiocinator.affirmation.Affirmation;
import com.hei.ratiocinator.affirmation.Fait;
import com.hei.ratiocinator.affirmation.Mensonge;
import com.hei.ratiocinator.affirmation.Verite;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RatiocinatorTest {

    @Test
    public void testCalculerLaVerite() {

        Fait verite1 = new Verite("Lou est beau");
        Fait mensonge1 = new Mensonge("Lou est pauvre");
        Fait fait1 = new Affirmation("Lou est généreux", "Vrai");


        Set<Fait> faits = new HashSet<>();
        faits.add(verite1);
        faits.add(mensonge1);
        faits.add(fait1);

        Ratiocinator ratiocinator = new Ratiocinator(faits);

        assertEquals("Faux", ratiocinator.calculerLaVerite("Lou est pauvre et Lou est généreux."));

        assertEquals("Faux", ratiocinator.calculerLaVerite("Lou est beau. Donc Lou est pauvre."));

        assertEquals("Vrai", ratiocinator.calculerLaVerite("Lou est pauvre. Donc Lou est généreux."));

        assertEquals("Vrai", ratiocinator.calculerLaVerite("Lou est beau ou Lou est généreux. Donc Lou est pauvre."));

        assertEquals("Vrai", ratiocinator.calculerLaVerite("Lou est beau ou Lou est généreux. Donc Lou est pauvre."));
    }
}
