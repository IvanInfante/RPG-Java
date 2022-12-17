package com.example.ivanrpg;

public class Hero extends Combatant {

    private TypesHero heroType;

    private Potion potions;

    public Hero(String hClass) {
        switch (hClass) {
            case "Mage" -> {
                this.heroType = TypesHero.MAGE;
            }
            case "Hunter" -> {
                this.heroType = TypesHero.HUNTER;
            }
            case "Warrior" -> {
                this.heroType = TypesHero.WARRIOR;
            }
            case "Healer" -> {
                this.heroType = TypesHero.HEALER;
            }
        }
        assert heroType != null;
        this.lifePoints = heroType.getLifePoints();
        this.damage = heroType.getDamage();
    }

    //METHODES
    // toutes les attacks et defenses vont etre communes a chaques classes
    public int attack() {
        return this.damage;
    }

    public int defend() { // se défendre rajoute de l'armor
        this.lifePoints += 10;

        return this.lifePoints;
    }

    public TypesHero getHeroType() {
        return heroType;
    }
}
