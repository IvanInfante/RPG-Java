package com.example.ivanrpg;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);

    Random rand = new Random();

    private int numFight = 1;

    private Hero[] heroes;
    private Enemy[] enemys;
    private Boss[] boss;
    private int Nenemies;
    int tmp;
    int nbrHeroes = 0;

    public void playGame() {

        while(nbrHeroes > 4 || nbrHeroes < 1){
            System.out.println("Saissisez le nombre de classes que vous voulez");
            nbrHeroes = scanner.nextInt();
            heroes = new Hero[nbrHeroes];

        }

        for (int i = 1; i <= nbrHeroes; i++) {
            System.out.println("Choississez votre classe (1 meme classe par partie)");
            System.out.println("1 (Warrior)");
            System.out.println("2 (Hunter)");
            System.out.println("3 (Mage)");
            System.out.println("4 (Healer)");
            int choix = scanner.nextInt();
            if (choix == 1) {
                heroes[i-1] = new Hero("Warrior");
            }
            else if (choix == 2) {
                heroes[i-1] = new Hero("Mage");
            }
            else if (choix == 3) {
                heroes[i-1] = new Hero("Healer");
            }
            else if (choix == 4) {
                heroes[i-1] = new Hero("Hunter");
            }
            else {
                System.out.println("Mauvais choix");
            }
        }
    }

    public void generateCombat() {
        while(Nenemies>1 && nbrHeroes > 0) {
        Nenemies = nbrHeroes;
        enemys = new Enemy[Nenemies];
        //boss = new Boss[Nenemies];
        //boss[0] = new Boss(100, 20);
        for (int j = 1; j < Nenemies; j++) {
            enemys[j] = new Enemy(numFight, nbrHeroes); // Les ennemies ont 80 pv + ou - 14 hp et de meme pour les dmg
        }
        System.out.println("Vous faites face à " + Nenemies + "ennemis");

    }}

    public void attaquer(){
        int action = scanner.nextInt();
        if (action == 1) {
            System.out.println("Quel est votre cible ?");
            for (int r = 1; r< Nenemies; r++)
            {
                System.out.println("L'ennemi "+r +" a "+ enemys[r].lifePoints+ " PV");
            }
            int target = scanner.nextInt();
            System.out.println("Avec qui voulez-vous tapez ?");
            //for (int f = 1; f<= nbrHeroes; f++)
            for (int f = 1; f<= nbrHeroes; f++)
            {
                System.out.println(f +" pour "+ heroes[f-1].getHeroType().toString());
            }
            int i = scanner.nextInt();
            enemys[target].lifePoints = enemys[target].lifePoints - heroes[i-1].attack();
            System.out.println("L'ennemie a pris " + heroes[i-1].attack() + " damage");
            System.out.println("Il lui reste " + enemys[target].lifePoints + " de vie");
            // Si un ennime meurt on le supprime du tableau
            if (enemys[target].lifePoints<=0)
            {
                //cbtfin=cbtfin-1;
                System.out.println("L'ennemi que vous avez attaque est mort");
                for (int n = target; n < Nenemies - 1; n++) {
                    enemys[n] = enemys[n + 1];
                }

                Nenemies=Nenemies-1;
            }
            // Attaque ennemi
            int targethero=rand.nextInt(nbrHeroes);
            heroes[targethero].setLifePoints(heroes[targethero].getLifePoints() - enemys[1].getDamage());
            System.out.println( heroes[targethero].getHeroType().toString()+" a perdu " + (enemys[1].getDamage())+ "PV");
            System.out.println(heroes[targethero].getHeroType().toString()+" a  " + heroes[targethero].getLifePoints()+ "PV");
            // Le heros mort est supprimé du tableau
            if (heroes[targethero].getLifePoints() <=0)
            {
                System.out.println("Votre heros a succombe à ses blessures");
                for (int h = targethero; h < nbrHeroes - 1; h++) {
                    heroes[h] = heroes[h + 1];
                }

                nbrHeroes=nbrHeroes-1;
            }
        }
    }

    public void seDefendre(){
        int action = scanner.nextInt();

        if (action == 2) {
            System.out.println("Avec qui voulez-vous shield ?");
            for (int f = 1; f<= nbrHeroes; f++)
            {
                System.out.println(f +" pour "+ heroes[f-1].getHeroType().toString());
            }
            int l = scanner.nextInt();
            System.out.println("Vous vous etes shield");
            heroes[l-1].defend();
            //Attaque ennemi
            int targethero=rand.nextInt(nbrHeroes);
            heroes[targethero].setLifePoints(heroes[targethero].getLifePoints() - (enemys[1].getDamage()));
            System.out.println(heroes[targethero].getHeroType().toString()+" a perdu " + (enemys[1].getDamage())+ "PV");
            System.out.println(heroes[targethero].getHeroType().toString()+" a  " + heroes[targethero].getLifePoints()+ "PV");
            // Le heros mort est supprimé du tableau
            if (heroes[targethero].getLifePoints() <=0)
            {
                System.out.println("Votre heros a succombe à ses blessures");
                for (int h = targethero; h < nbrHeroes - 1; h++) {
                    heroes[h] = heroes[h + 1];
                }

                nbrHeroes=nbrHeroes-1;
            }

        }

    }

    public void potion(){
        int action = scanner.nextInt();
        if (action == 3) {
            System.out.println("Avec qui voulez vous soignez ?");
            for (int f = 1; f<= nbrHeroes; f++)
            {
                System.out.println(f +" pour "+ heroes[f-1].getHeroType().toString());
            }
            int p = scanner.nextInt();
            System.out.println(heroes[p-1].getHeroType().toString()+" est soignez de 10  PV" );
            heroes[p-1].getLifePoints();
            System.out.println("Votre heros a " +heroes[p-1].getLifePoints() +"PV");
            //Attaque ennemi
            int targethero=rand.nextInt(nbrHeroes);
            heroes[targethero].setLifePoints(heroes[targethero].getLifePoints() - (enemys[1].getDamage()));
            System.out.println(heroes[targethero].getHeroType().toString()+" a perdu " + (enemys[1].getDamage())+ "PV");
            System.out.println(heroes[targethero].getHeroType().toString()+" a  " + heroes[targethero].getLifePoints()+ "PV");
            if (heroes[targethero].getLifePoints() <=0)
            {
                System.out.println(heroes[targethero].getHeroType().toString()+" a succombe à ses blessures");
                for (int h = targethero; h < nbrHeroes - 1; h++) {
                    heroes[h] = heroes[h + 1];
                }

                nbrHeroes=nbrHeroes-1;
            }

        }


        }

    public int combat() {
        //int cbtfin=Nenemies;
        while(Nenemies>1 && nbrHeroes > 0) {
            System.out.println("Que voulez vous faire ?");
                System.out.println("1 (Attaquer)");
                System.out.println("2 (Se defendre)");
                System.out.println("3 (Potion)");
            int action = scanner.nextInt();
            // ATTAQUER
            attaquer();

            // Se defendre
            seDefendre();

            // SE SOIGNER
            potion();

                // Le heros mort est supprimé du tableau

        }
        if (nbrHeroes==0)
        {
            System.out.println("Vous avez perdu ! Tous vos héros sont morts !!");
            return tmp=1;
        }
        else
            System.out.println("Félicitations ! Il ne reste aucun ennemi !");
        return tmp = 2;
    }
}

