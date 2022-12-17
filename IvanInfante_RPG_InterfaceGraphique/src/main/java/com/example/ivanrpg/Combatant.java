package com.example.ivanrpg;

public abstract class Combatant {

    int lifePoints, damage;

    public int getLifePoints() {
        return lifePoints;
    }

    public int getDamage() {
        return damage;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}