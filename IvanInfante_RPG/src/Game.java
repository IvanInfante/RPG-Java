package src;

public class Game {

    private static Hero[] heros;
    private static BasicEnemy[] basicEnemies;
    private static BasicEnemy[] boss = new BasicEnemy[1];
    private static Item[] inventaire;
    private static int nbHeros;
    private static int currentStage = 0;

    private static Warrior warrior = new Warrior();
    private static Hunter hunter = new Hunter();
    private static Mage mage = new Mage();
    private static Healer healer = new Healer();

    private static String[] promptParamInitAsk = {"\nCombien de héros dans votre équipe ? (4 max)\n-> " , "\nQuel est le nom du héros numéro ", "\nQuel est la classe de "};

    private static String[] hClasseList = {"Warrior", "Hunter", "Mage", "Healer"};

    private static String[] promptChoices = {"\n0) ", "\n1) ", "\n2) ", "\n3) ", "\n4) "};

    private static String[] promptGetWeapons = {" a reçu un buff de dégâts grâce à ", " a reçu un buff de dégâts et de flèches grâce à "};

    private static String[] promptTargetAsk = {"Quel ennemi voulez-vous attaquer ?", "Quel allié voulez-vous soigner ?"};
    private static String[] promptEnemyType = {"Le diablotin numéro ", "Le professeur maudit"};
    private static String[] promptLittleWin = {"Ce diablotin est déjà mort", "Tous les ennemis sont vaincus..."};
    private static String[] promptHeroStatus = {"Ce héros est mort", "Ce héros a déjà toute sa vie", "Vos héros sont déjà tous en pleine forme...", "Ce héros est déjà au combat", "Vos héros sont en pleine forme !"};

    private static String[] promptLogic = {"\n-> ", " ?", " => "};
    private static String[] inputFightStr = {"Choisissez une action :\n1) Attaquer\n2) Soigner\n3) Se défendre", "Choisissez une action :\n1) Attaquer\n2) Se défendre", "Choisissez une action :\n1) Attaquer\n2) Se défendre"};
    private static String[] innStagePromptStr = {"\nUn mini portail apparaît sur votre chemin.\n<Psst, vous aurez sans doute besoin de mon aide si vous voulez venir à bout de cette tour.> vous dit un feu follet", "\nQuel souhait voulez-vous ?\n1) Défense (Points de vie et Armure)\n2) Puissance (Attaque et Soin)\n3) Points spéciaux (Rage, Mana et Nombre de flèches)\n-> "};
    private static String[] innStageChoicesStr = {"Votre équipe est plus résistante !", "Votre équipe est plus forte !", "Votre équipe est plus endurante !"};
    private static String[] itemName = {"Graisse de Yak", "Plume de phénix", "Grande potion de soin"};

    private static boolean isRunning;

    private static boolean isNalgoloth = false;

    // élément du fil rouge
    private static int place = 0;
    private static String[] places = {"RDC", "Etage 1", "Etage 2", "Etage 3", "Dernier étage"};

    // méthode pour créer l'équipe de héros
    public static void initGame() {
        TextLogic.printHeading("Bienvenue dans le MiniRPG3000byIvan");
        TextLogic.anythingToContinue();

        // print l'introduction de l'histoire
        RedLine.Intro();

        // demande du nombre de héros
        nbHeros = TextLogic.askInt(promptParamInitAsk[0], 4);

        // tableaux heros et basicEnemies prennent la valeur du nombre de héros pour leur taille
        heros = new Hero[nbHeros];
        basicEnemies = new BasicEnemy[nbHeros];

        inventaire = new Item[3];

        inventaire[0] = new Item(itemName[0], 30, 4, 5);
        inventaire[1] = new Item(itemName[1], 40, 3, 4);
        inventaire[2] = new Item(itemName[2], 50, 2, 3);

        String name, heroClasse = "", weapon = "";
        int PVmax = 0, maxAR = 0, dmgpoints = 0, healpoints = 0, specialpoints = 0;

        // boucle créant en demandant au joueur les différents paramètres (nom, classe et l'arme signature du héros)
        for (int i = 0; i < nbHeros; i++) {
            int currentHero = i + 1;
            name = TextLogic.askStr(promptParamInitAsk[1] + currentHero + promptLogic[1], true);
            switch(TextLogic.askInt( promptParamInitAsk[2] + name + promptLogic[1] + promptChoices[1] + hClasseList[0] + promptChoices[2] + hClasseList[1] + promptChoices[3] + hClasseList[2] + promptChoices[4] + hClasseList[3] + promptLogic[0], 4)) {
                case 1 -> {
                    heroClasse = hClasseList[0];
                    PVmax = warrior.getPVmax();
                    maxAR = warrior.getMaxAR();
                    dmgpoints = warrior.getDmgpoints();
                    healpoints = warrior.getHealpoints();
                    specialpoints = warrior.getMaxRagepoints();
                }
                case 2 -> {
                    heroClasse = hClasseList[1];
                    PVmax = hunter.getPVmax();
                    maxAR = hunter.getMaxAR();
                    dmgpoints = hunter.getDmgpoints();
                    healpoints = hunter.getHealpoints();
                    specialpoints = hunter.getNbrMaxArrows();
                }
                case 3 -> {
                    heroClasse = hClasseList[2];
                    PVmax = mage.getPVmax();
                    maxAR = mage.getMaxAR();
                    dmgpoints = mage.getDmgpoints();
                    healpoints = mage.getHealpoints();
                    specialpoints = mage.getMaxManaPoints();
                }
                case 4 -> {
                    heroClasse = hClasseList[3];
                    PVmax = healer.getPVmax();
                    maxAR = healer.getMaxAR();
                    dmgpoints = healer.getDmgpoints();
                    healpoints = healer.getHealpoints();
                    specialpoints = healer.getMaxManaPoints();
                }
            }

            basicEnemies[i] = new BasicEnemy(100 + currentStage * 5, 20 + currentStage * 5);
            heros[i] = new Hero(name, heroClasse, PVmax, maxAR, dmgpoints, healpoints, specialpoints);

            heroInfo(i);
            TextLogic.printSeparator(30);
        }

        heroesInfo();

        isRunning = true;

        gameLoop();
    }

    public static void gameLoop() {
        TextLogic.clearConsole();

        while(isRunning) {
            printMenu();
            int input = TextLogic.askInt(promptLogic[0], 3);
            switch (input) {
                case 1 -> continueTrek();
                case 2 -> heroesInfo();
                case 3 -> isRunning = false;
            }
        }
    }

    public static void heroInfo(int i) {
        TextLogic.printSeparator(30);
        System.out.println(heros[i].getName() + promptLogic[2] + heros[i].getHeroClasse() + " (" + heros[i].getPV() + "PV/" + heros[i].getPVmax() + " " + heros[i].getAR() + "AR)\n  " + heros[i].getSpecialpoints() + "SP/" + heros[i].getMaxSpecialPoints());
    }

    public static void heroesInfo() {
        TextLogic.printHeading("INFO EQUIPE");

        for (int i = 0; i < nbHeros; i++) {
            heroInfo(i);
        }

        TextLogic.printSeparator(30);
        TextLogic.anythingToContinue();
    }

    // méthode pour continuer la partie
    public static void printMenu() {
        TextLogic.clearConsole();
        TextLogic.printHeading(places[place]);
        System.out.println("Choisissez une action :");
        TextLogic.printSeparator(30);
        System.out.println("1) Continuer votre périple");
        System.out.println("2) Info de l'équipe");
        System.out.println("3) Quitter le jeu");
    }

    public static int nbrHeroAlive() {
        int nbrHAlive = 0;
        for (int i = 0; i < nbHeros; i++) {
            if (heros[i].getPV() > 0) {
                nbrHAlive += 1;
            }
        }
        return nbrHAlive;
    }

    public static int nbrEnemyAlive() {
        int nbrEAlive = 0;
        if (currentStage != 4) {
            for (int i = 0; i < nbHeros; i++) {
                if (basicEnemies[i].getPV() > 0) {
                    nbrEAlive += 1;
                }
            }
        } else if (basicEnemies[0].getPV() > 0) {
            nbrEAlive = 1;
        }
        return nbrEAlive;
    }

    public static void checkPart() {
        if (nbrEnemyAlive() == 0) {
            currentStage++;
            place++;
            innStage();
        }
    }

    public static void continueTrek() {
        checkPart();
        if (currentStage != 4) {
            for (int i = 0; i < nbHeros; i++) {
                basicEnemies[i] = new BasicEnemy(30 * nbHeros + currentStage * 15, 20 + currentStage * 5);
                basicEnemies[i].setPV(basicEnemies[i].getPVmax());
            }
            switch (currentStage) {
                case 0 -> RedLine.firstPartIntro();
                case 1 -> {
                    RedLine.firstPartOutro();
                    RedLine.secondPartIntro();
                }
                case 2 -> {
                    RedLine.secondPartOutro();
                    RedLine.thirdPartIntro();
                }
                case 3 -> {
                    RedLine.thirdPartOutro();
                    RedLine.fourthPartIntro();
                }
            }
            fightStage();
        } else {
            boss[0] = new BasicEnemy(75 * nbHeros + currentStage * 15, 15 * nbHeros);
            basicEnemies = boss;
            RedLine.bossPartIntro();
            fightStage();
            RedLine.bossPartOutro();
            TextLogic.printHeading("En souvenir...");
            heroesInfo();
            RedLine.endPart();
            isRunning = false;
        }
    }

    public static void innStage() {
        System.out.println(innStagePromptStr[0]);
        switch(TextLogic.askInt(innStagePromptStr[1], 3)) {
            case 1 -> {
                for (int i = 0; i < nbHeros; i++) {
                    heros[i].setPVmax(heros[i].getPVmax() + 10);
                    heros[i].setMaxAR(heros[i].getMaxAR() + 5);
                }

                TextLogic.printHeading(innStageChoicesStr[0]);
            }
            case 2 -> {
                for (int i = 0; i < nbHeros; i++) {
                    heros[i].setMaxdmgpoints(heros[i].getDmgpoints() + 5);
                    heros[i].setHealpoints(heros[i].getHealpoints() + 5);
                }

                TextLogic.printHeading(innStageChoicesStr[1]);
            }
            case 3 -> {
                for (int i = 0; i < nbHeros; i++) {
                    heros[i].setMaxSpecialPoints(heros[i].getMaxSpecialPoints() + 3);
                }

                TextLogic.printHeading(innStageChoicesStr[2]);
            }
        }

        for (Item item : inventaire) {
            item.setNbrInInv(item.getNbrInInv() + 1);
            if (item.getNbrInInv() > item.getMaxnbrInInv()) {
                item.setNbrInInv(item.getMaxnbrInInv());
            }
        }

        heroesFullEnergy();

        TextLogic.anythingToContinue();
    }

    public static void attackHero(int currentHero) {
        int inputTargetTab;
        int inputTargetInt;

        if (currentStage != 4) {
            do {
                for (int j = 0; j < nbHeros; j++) {
                    if (basicEnemies[j].getPV() > 0) {
                        int currentBasicEnemy = j + 1;
                        System.out.println(currentBasicEnemy + ") " + promptEnemyType[0] + currentBasicEnemy + " a " + basicEnemies[j].getPV() + "PV");
                    }
                }
                inputTargetInt = TextLogic.askInt(promptTargetAsk[0] + promptLogic[0], nbHeros);
                inputTargetTab = inputTargetInt - 1;
                if (basicEnemies[inputTargetTab].getPV() <= 0) {
                    System.out.println(promptLittleWin[0]);
                }
            } while (basicEnemies[inputTargetTab].getPV() == 0 && nbrEnemyAlive() != 0);
        } else {
            inputTargetInt = 1;
            inputTargetTab = 0;
        }

        if (nbrEnemyAlive() != 0) {
            basicEnemies[inputTargetTab].setPV(basicEnemies[inputTargetTab].getPV() - heros[currentHero].getDmgpoints());

            if (basicEnemies[inputTargetTab].getPV() <= 0) {
                System.out.println(promptEnemyType[0] + inputTargetInt + " est vaincu !");
                basicEnemies[inputTargetTab].setPV(0);
            } else {
                System.out.println(promptEnemyType[0] + inputTargetInt + " a reçu " + heros[currentHero].getDmgpoints() + " points de dégâts.\nIl a désormais " + basicEnemies[inputTargetTab].getPV() + "PV/" + basicEnemies[currentHero].getPVmax());
            }
        } else {
            TextLogic.printHeading(promptLittleWin[1]);
        }


        TextLogic.printSeparator(30);
        TextLogic.anythingToContinue();
    }

    public static void defendHero(int currentHero) {
        int armorBuff = 5 + (int)(Math.random() * ((20 - 5) + 1));
        heros[currentHero].setAR(heros[currentHero].getAR() + armorBuff);
        System.out.println(heros[currentHero].getName() + " a reçu " + armorBuff + " AR bonus " + "\nIl a maintenant " + heros[currentHero].getAR() + "AR");

        TextLogic.printSeparator(30);
    }

    public static void healHero(int currentHero) {
        int inputTargetTab = 0;
        int inputTargetInt;

        int nbrHeroesFullPV = 0;

        do {
            for (int j = 0; j < nbHeros; j++) {
                if (heros[j].getPV() > 0 && heros[j].getPV() < heros[j].getPVmax()) {
                    int currentHeroToTarget = j + 1;
                    System.out.println(currentHeroToTarget + ") " + heros[j].getName() + " a " + heros[j].getPV() + "PV/" + heros[j].getPVmax());
                } else {
                    nbrHeroesFullPV += 1;
                }
            }
            if (nbrHeroesFullPV != nbHeros) {
                inputTargetInt = TextLogic.askInt(promptTargetAsk[1] + promptLogic[0], nbHeros);
                inputTargetTab = inputTargetInt - 1;
                if (heros[inputTargetTab].getPV() <= 0) {
                    System.out.println(promptHeroStatus[0]);
                } else if (heros[inputTargetTab].getPV() >= heros[inputTargetTab].getPVmax()) {
                    System.out.println(promptHeroStatus[1]);
                }
            }
        } while ((heros[inputTargetTab].getPV() <= 0 || heros[inputTargetTab].getPV() >= heros[inputTargetTab].getPVmax()) && nbrHeroesFullPV != nbHeros);

        if (nbrHeroesFullPV != nbHeros) {
            heros[inputTargetTab].setPV(heros[inputTargetTab].getPV() + heros[currentHero].getHealpoints());

            if (heros[inputTargetTab].getPV() >= heros[inputTargetTab].getPVmax()) {
                System.out.println(heros[inputTargetTab].getName() + " a récupéré toute sa vie.");
                heros[inputTargetTab].setPV(heros[inputTargetTab].getPVmax());
            } else {
                System.out.println(heros[inputTargetTab] + " a reçu " + heros[currentHero].getHealpoints() + " points de soins.\nIl a désormais " + heros[inputTargetTab].getPV() + "PV/" + heros[currentHero].getPVmax());
            }
        } else {
            TextLogic.printHeading(promptHeroStatus[2]);
        }


        TextLogic.printSeparator(30);
    }

    public static void attackEnemy(int currentHero) {
        int EnemyVS = currentHero;
        if (currentStage == 4) {
            EnemyVS = 0;
        }
        if (heros[currentHero].getAR() <= 0) {
            System.out.println(heros[currentHero].getName() + " se prend " + basicEnemies[EnemyVS].getDmgpoints() + " dégâts de vie");
            heros[currentHero].setPV(heros[currentHero].getPV() - basicEnemies[EnemyVS].getDmgpoints()); //dégâts sur la vie
            if (heros[currentHero].getPV() <= 0) {
                System.out.println(heros[currentHero].getName() + " est mort");
                heros[currentHero].setPV(0);
            }

        } else if (heros[currentHero].getAR() > 0) {
            heros[currentHero].setAR(heros[currentHero].getAR() - basicEnemies[EnemyVS].getDmgpoints()); //dégâts sur l'amure du héros
            System.out.println(heros[currentHero].getName() + " s'est fait attaquer !\nIl a reçu " + basicEnemies[EnemyVS].getDmgpoints() + " dégâts\nIl a maintenant " + heros[currentHero].getPV() + "PV/" + heros[currentHero].getPVmax() + " et " + heros[currentHero].getAR() + "AR");
            if (heros[currentHero].getAR() <= 0) {
                System.out.println(heros[currentHero].getName() + " n'a plus d'armure");
                heros[currentHero].setAR(0);
            }

        } else if (heros[currentHero].getPV() > 0) {
            System.out.println(heros[currentHero].getName() + " s'est fait attaquer !\nIl a maintenant " + heros[currentHero].getPV() + "PV/" + heros[currentHero].getPVmax() + " et " + heros[currentHero].getAR() + "AR");
        }

        TextLogic.printSeparator(30);
    }

    public static void attackEnemyVerifHero(int currentHero) {
        do {
            if (heros[currentHero].getPV() <= 0) {
                for (int i = 0; i < nbHeros; i++) {
                    if (heros[i].getPV() > 0) {
                        attackEnemy(currentHero);
                    }
                }
            } else {
                attackEnemy(currentHero);
                break;
            }
        } while (true);
    }

    public static void attackHeroGeneral(int i) {
        attackHero(i);
        if (heros[i].getHeroClasse().equals(hClasseList[1])) {
            heros[i].setSpecialpoints(heros[i].getSpecialpoints() - 1);
            if (heros[i].getSpecialpoints() <= 0) {
                System.out.println(heros[i].getName() + " n'a plus de flèches.\nIl fera moins de dégâts.");
                heros[i].setDmgpoints(20);
            } else {
                System.out.println(heros[i].getName() + " a " + heros[i].getSpecialpoints() + " flèches");
            }
        }
    }

    // étape de combat -> loop jusqu'à mort des héros ou des ennemis
    public static void fightStage() {
        while(nbrEnemyAlive() != 0) {
            for (int i = 0; i < nbHeros; i++) {
                int EnemyVS = i;
                if (currentStage == 4) {
                    EnemyVS = 0;
                }
                if (heros[i].getPV() > 0) {
                    TextLogic.printHeading("Un diablotin avec " + basicEnemies[EnemyVS].getPV() + "PV/" + basicEnemies[EnemyVS].getPVmax() + " se tient devant vous");
                    TextLogic.printHeading(heros[i].getName() + " de la classe " + heros[i].getHeroClasse() + " a " + heros[i].getPV() + "PV/" + heros[i].getPVmax() + " et " + heros[i].getAR() + "AR\n  " + heros[i].getSpecialpoints() + "SP/" + heros[i].getMaxSpecialPoints());
                    int inputAction = TextLogic.askInt("Choisissez une action :" + promptChoices[1] + "Combattre" + promptChoices[2] + "Utiliser un consommable" + promptLogic[0], 2);
                    TextLogic.printSeparator(30);
                    switch (inputAction) {
                        case 1 -> {
                            if (heros[i].getHeroClasse().equals(hClasseList[3])) {
                                int inputFight = TextLogic.askInt(inputFightStr[0] + promptLogic[0], 4);
                                switch (inputFight) {
                                    case 1 -> attackHero(i);
                                    case 2 -> {
                                        boolean teamPVCheck = false;
                                        for (int j = 0; j < nbHeros; j++) {
                                            if (heros[j].getPV() > 0 && heros[j].getPV() != heros[j].getPVmax()) {
                                                teamPVCheck = true;
                                                break;
                                            }
                                        }
                                        if (teamPVCheck) {
                                            healHero(i);
                                        } else {
                                            System.out.println("Votre équipe n'a pas besoin d'être soigné.");
                                        }
                                    }
                                    case 3 -> defendHero(i);
                                }
                            } else {
                                if (heros[i].getHeroClasse().equals(hClasseList[1])) {
                                    System.out.println(heros[i].getName() + " a " + heros[i].getSpecialpoints() + " flèches");
                                }
                                switch (TextLogic.askInt(inputFightStr[1] + promptLogic[0], 2)) {
                                    case 1 -> attackHeroGeneral(i);
                                    case 2 -> defendHero(i);
                                }
                            }
                        }
                        case 2 -> consumableMenu(i);
                    }
                    TextLogic.printSeparator(30);
                    TextLogic.anythingToContinue();
                }
                int currentEnemy = EnemyVS + 1;
                if (basicEnemies[EnemyVS].getPV() <= 0) {
                    System.out.println(promptEnemyType[0] + currentEnemy + " est mort.\nIl n'a pas pu agir.");
                } else {
                    if (basicEnemies[EnemyVS].getPV() < 0.25 * basicEnemies[EnemyVS].getPVmax()) {
                        int healEnemy = 5 + (int) (Math.random() * ((20 - 5) + 1));
                        basicEnemies[EnemyVS].setPV(basicEnemies[EnemyVS].getPV() + healEnemy);
                        System.out.println(promptEnemyType[0] + currentEnemy + " a gagné " + healEnemy + "PV\nIl a maintenant " + basicEnemies[EnemyVS].getPV() + "PV/" + basicEnemies[EnemyVS].getPVmax());
                    }
                }
                TextLogic.printSeparator(30);
            }

            if (nbrHeroAlive() == 0) {
                heroesDied();
            } else if (nbrEnemyAlive() == 0) {
                TextLogic.printSeparator(30);
                System.out.println(promptLittleWin[1]);
                TextLogic.anythingToContinue();
            }
        }
    }

    // ménu de consommables
    public static void consumableMenu(int currentHero) {
        TextLogic.printHeading("INVENTAIRE D'EQUIPE");
        System.out.print("Vous avez :");
        for (int i = 0; i < inventaire.length; i++) {
            System.out.println(promptChoices[i] + " " + inventaire[i].nbrInInv + " " + inventaire[i].getName());
        }

        switch(TextLogic.askInt("Que choisissez-vous ?" + promptLogic[0], 3)) {
            case 1 -> useConsumable(currentHero, " s'est régalé !", 0);
            case 2 -> useConsumable(currentHero, " se sent renaître !", 1);
            case 3 -> useConsumable(currentHero, " se sent respirer à nouveau !", 2);
        }

        TextLogic.printSeparator(30);
        TextLogic.anythingToContinue();
    }

    // méthode pour utiliser un consommable
    public static void useConsumable(int currentHero, String prompt, int nbrInv) {
        if (inventaire[nbrInv].getNbrInInv() != 0) {
            if (heros[currentHero].getPV() >= heros[currentHero].getPVmax()) {
                System.out.println(heros[currentHero].getName() + " a déjà toute sa vie.");
            } else {
                System.out.println(heros[currentHero].getName() + prompt);
                heros[currentHero].setPV(heros[currentHero].getPV() + inventaire[nbrInv].getHeal());
                System.out.println(heros[currentHero].getName() + " a gagné " + inventaire[nbrInv].getHeal());
                inventaire[nbrInv].setNbrInInv(inventaire[nbrInv].getNbrInInv() - 1);
            }
            if (heros[currentHero].getPV() >= heros[currentHero].getPVmax()) {
                heros[currentHero].setPV(heros[currentHero].getPVmax());
            }
        } else {
            System.out.println("Vous n'avez plus de " + inventaire[0].getName());
        }
    }

    // méthode pour redonner leur énergie aux différents héros (PV, AR et SP)
    public static void heroesFullEnergy() {
        for (int i = 0; i < nbHeros; i++) {
            heros[i].setPV(heros[i].getPVmax());
            heros[i].setAR(heros[i].getMaxAR());
            heros[i].setSpecialpoints(heros[i].getMaxSpecialPoints());
            heros[i].setDmgpoints(heros[i].getMaxdmgpoints());
        }
        System.out.println(promptHeroStatus[4]);
    }

    // méthode lorsque le joueur a perdu
    public static void heroesDied() {
        TextLogic.clearConsole();
        TextLogic.printHeading("Votre équipe est hors-combat...");
        TextLogic.printHeading("Vous êtiez à l'étage " + currentStage);
        TextLogic.printSeparator(30);
        System.out.println("Merci d'avoir joué !");
        isRunning = false;
    }
}
