package src;

// class pour print chaque partie de l'histoire (fil rouge) du jeu
public class RedLine {

    public static void Intro() {
        TextLogic.clearConsole();

        TextLogic.printHeading("HISTOIRE");

        System.out.println("Dans un lycée rural de votre région, le professeur préféré de votre classe a disparu.");
        System.out.println("Après vérification à son domicile, une équipe de jeunes vigoureux qui tenait à tout prix à avoir une bonne note, n'a trouvé personne.");
        System.out.println("Une relique ressemblant étrangement à un bracelet inca des annnées 70 (1370) posée devant sa porte attira l'attention de nos sympatiques héros.");
        System.out.println("Une faible interaction avec le bracelet suffit pour vous transporter dans une autre dimension.");
        System.out.println("Vous y voyez une tour au milieu d'une île flottant dans le vide intersidéral de Marseille.");
        System.out.println("Vous n'avez d'autres choix que d'y entrer...");

        TextLogic.anythingToContinue();
    }

    public static void firstPartIntro() {
        TextLogic.clearConsole();

        TextLogic.printHeading("PARTIE I - INTRO");

        System.out.println("Des diablotins vous y attendaient !");
        System.out.println("Pour accéder à l'étage supérieur, vous devrez les vaincre...");

        TextLogic.anythingToContinue();
    }

    public static void firstPartOutro() {
        TextLogic.clearConsole();

        TextLogic.printHeading("PARTIE I - OUTRO");

        System.out.println("Bravo, vous avez vaincu le florilège de diablotins !");
        System.out.println("Vous montez à l'étage supérieur.");

        TextLogic.anythingToContinue();
    }

    public static void secondPartIntro() {
        TextLogic.clearConsole();

        TextLogic.printHeading("PARTIE II - INTRO");

        System.out.println("Attention !");
        System.out.println("D'autres diablotins sont prêts à en découdre !");
        System.out.println("Et ils ont l'air plus coriaces !");

        TextLogic.anythingToContinue();
    }

    public static void secondPartOutro() {
        TextLogic.clearConsole();

        TextLogic.printHeading("PARTIE II - OUTRO");

        System.out.println("Bravo, vous avez vaincu le florilège de diablotins !");
        System.out.println("Vous montez à l'étage supérieur.");

        TextLogic.anythingToContinue();
    }

    public static void thirdPartIntro() {
        TextLogic.clearConsole();

        TextLogic.printHeading("PARTIE III - INTRO");

        System.out.println("Attention !");
        System.out.println("D'autres diablotins sont prêts à en découdre !");
        System.out.println("Et ils ont l'air plus coriaces !");

        TextLogic.anythingToContinue();
    }

    public static void thirdPartOutro() {
        TextLogic.clearConsole();

        TextLogic.printHeading("PARTIE III - OUTRO");

        System.out.println("Bravo, vous avez vaincu le florilège de diablotins !");
        System.out.println("Vous montez à l'étage supérieur.");

        TextLogic.anythingToContinue();
    }

    public static void fourthPartIntro() {
        TextLogic.clearConsole();

        TextLogic.printHeading("PARTIE IV - INTRO");

        System.out.println("Attention !");
        System.out.println("D'autres diablotins sont prêts à en découdre !");
        System.out.println("Et ils ont l'air plus coriaces !");

        TextLogic.anythingToContinue();
    }

    public static void fourthPartOutro() {
        TextLogic.clearConsole();

        TextLogic.printHeading("PARTIE IV - OUTRO");

        System.out.println("Bravo, vous avez vaincu le florilège de diablotins !");
        System.out.println("Vous montez à l'étage supérieur.");

        TextLogic.anythingToContinue();
    }

    public static void bossPartIntro() {
        TextLogic.clearConsole();

        TextLogic.printHeading("PARTIE V - Intro");

        System.out.println("Vous êtes enfin au dernier étage. Vous voyez un portail qui s'apparente à un échappatoire.");
        System.out.println("Sortant de l'ombre, le professeur préféré de tous apparaît.");
        System.out.println("Content dans un premier temps, vous comprenez vite qu'il a été corrompu par ce monde bien trop ténébreux.");
        System.out.println("Vous êtes dans l'obligation de le combattre...");

        TextLogic.anythingToContinue();
    }

    public static void bossPartOutro() {
        TextLogic.clearConsole();

        TextLogic.printHeading("PARTIE V - OUTRO");

        System.out.println("<Bien joué ! Vous vaincu la malédiction bien trop longue à expliquer ! Merci !> vous dit le professeur");
        System.out.println("Il promet une bonne note à nos jeunes héros et une reconnaissance éternel.");
        System.out.println("Sur ces belles parolesn, vous prenez la direction du portail heureux de cette aventure.");

        TextLogic.anythingToContinue();
    }

    public static void endPart() {
        TextLogic.clearConsole();

        TextLogic.printHeading("Merci d'avoir joué !");

        TextLogic.anythingToContinue();
    }

}
