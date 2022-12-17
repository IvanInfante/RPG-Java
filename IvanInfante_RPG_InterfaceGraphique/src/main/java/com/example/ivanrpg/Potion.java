package com.example.ivanrpg;

import java.util.ArrayList;

public class Potion {

    private int heal;

    public Potion(int heal) {
        this.heal = heal;
    }

    public void usePotion(Hero hero, ArrayList<Potion> inventory) {
        hero.setLifePoints(hero.getLifePoints() + heal);
        inventory.remove(0);
    }
}
