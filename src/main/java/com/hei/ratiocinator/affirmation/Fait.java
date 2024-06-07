package com.hei.ratiocinator.affirmation;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public sealed abstract class Fait permits Affirmation, Mensonge, Verite {
        protected final String texte;
}
