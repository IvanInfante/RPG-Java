package com.example.ivanrpg;

public class Boss extends Combatant {

    public Boss(int numFight, int nbHero) {
        this.lifePoints = numFight * 100 + nbHero * 10;
        this.damage = numFight * 20 + nbHero * 2;
    }

}
