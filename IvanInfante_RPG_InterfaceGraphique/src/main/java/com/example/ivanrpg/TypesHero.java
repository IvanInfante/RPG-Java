package com.example.ivanrpg;

public enum TypesHero {

    WARRIOR(200, 50),
    MAGE(150, 125),
    HEALER(100, 25),
    HUNTER(130, 120);

    private final int lifePoints, damage;

    TypesHero(int lifePoints, int damage) {
        this.lifePoints = 100;
        this.damage = 10;
    }

    public String toString(TypesHero hClass) {
        return switch (hClass) {
            case WARRIOR -> "Warrior";
            case MAGE -> "Mage";
            case HEALER -> "Healer";
            case HUNTER -> "Hunter";
            default -> "Unknown";
        };
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getDamage() {
        return damage;
    }

}
