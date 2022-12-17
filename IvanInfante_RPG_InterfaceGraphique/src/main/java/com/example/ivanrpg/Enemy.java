package com.example.ivanrpg;

public class Enemy extends Combatant {

    public Enemy(int numFight, int nbHero) {
        this.lifePoints = numFight * 40 + nbHero * 5;
        this.damage = numFight * 10 + nbHero;
    }

}
