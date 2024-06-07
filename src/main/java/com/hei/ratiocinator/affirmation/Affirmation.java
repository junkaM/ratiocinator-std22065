package com.hei.ratiocinator.affirmation;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public sealed abstract class Affirmation permits
        Verite, Mensonge {
        protected final String texte;
}
