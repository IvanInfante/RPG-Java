package com.example.ivanrpg;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private ChoiceBox<Integer> numHeroes;
    private ChoiceBox<String> hero1;
    private ChoiceBox<String> hero2;
    private ChoiceBox<String> hero3;
    private ChoiceBox<String> hero4;
    private Button submit;
    static Scene sceneCrea, sceneJeu;
    static Pane root;
    static Stage window;

    private Controller controller = new Controller();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        window = stage;

        root = new Pane();

        // Créer l'arrière-plan
        Image background = new Image("file:background.png");
        ImageView backgroundView = new ImageView(background);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(600);
        root.getChildren().add(backgroundView);

        // Créer le personnage
        Image character = new Image("file:yone.png");
        ImageView characterView = new ImageView(character);
        characterView.setFitWidth(100);
        characterView.setFitHeight(100);
        characterView.setX(100);
        characterView.setY(100);
        root.getChildren().add(characterView);

        // Créer les ennemis
        Image enemy = new Image("file:minion.png");
        ImageView enemyView1 = new ImageView(enemy);
        enemyView1.setFitWidth(100);
        enemyView1.setFitHeight(100);
        enemyView1.setX(600);
        enemyView1.setY(100);
        root.getChildren().add(enemyView1);

        ImageView enemyView2 = new ImageView(enemy);
        enemyView2.setFitWidth(100);
        enemyView2.setFitHeight(100);
        enemyView2.setX(600);
        enemyView2.setY(300);
        root.getChildren().add(enemyView2);

        // Créer les boites de textes pour les héros et les ennemis
        TextArea heroText = new TextArea();
        heroText.setPrefWidth(200);
        heroText.setPrefHeight(200);
        heroText.setLayoutX(50);
        heroText.setLayoutY(200);
        root.getChildren().add(heroText);

        TextArea enemyText = new TextArea();
        enemyText.setPrefWidth(200);
        enemyText.setPrefHeight(200);
        enemyText.setLayoutX(550);
        enemyText.setLayoutY(200);
        root.getChildren().add(enemyText);

        // Créer le menu déroulant pour les actions
        ComboBox<String> actionMenu = new ComboBox<>();
        actionMenu.getItems().addAll("Attaquer", "Se défendre", "Potion");
        actionMenu.setLayoutX(350);
        actionMenu.setLayoutY(550);
        root.getChildren().add(actionMenu);

        sceneJeu = new Scene(root, 800, 600);


        // Create ChoiceBox for number of heroes
        numHeroes = new ChoiceBox<>();
        numHeroes.getItems().addAll(1,2,3,4);
        numHeroes.setValue(1);
        numHeroes.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            int num = numHeroes.getItems().get((Integer) newValue);
            showHeroChoiceBoxes(num);
        });

        // Create ChoiceBoxes for hero classes
        hero1 = new ChoiceBox<>();
        hero2 = new ChoiceBox<>();
        hero3 = new ChoiceBox<>();
        hero4 = new ChoiceBox<>();
        hero1.getItems().addAll("Warrior", "Mage", "Rogue", "Healer");
        hero2.getItems().addAll("Warrior", "Mage", "Rogue", "Healer");
        hero3.getItems().addAll("Warrior", "Mage", "Rogue", "Healer");
        hero4.getItems().addAll("Warrior", "Mage", "Rogue", "Healer");
        hero1.setVisible(false);
        hero2.setVisible(false);
        hero3.setVisible(false);
        hero4.setVisible(false);


        // Create Submit button
        submit = new Button("Submit");
        submit.setOnAction(e -> {
            ArrayList<String> heroes = new ArrayList<>();
            System.out.println("Team:");
            if (hero1.isVisible()) {
                heroes.add(hero1.getValue());
                System.out.println("Hero 1: " + hero1.getValue());
            }
            if (hero2.isVisible()) {
                heroes.add(hero2.getValue());
                System.out.println("Hero 2: " + hero2.getValue());
            }
            if (hero3.isVisible()) {
                heroes.add(hero3.getValue());
                System.out.println("Hero 3: " + hero3.getValue());
            }
            if (hero4.isVisible()) {
                heroes.add(hero4.getValue());
                System.out.println("Hero 4: " + hero4.getValue());
            }

            controller.submitBtn(heroes);
            stage.setScene(sceneJeu);
        });

        // Layout
        HBox numBox = new HBox(new Label("Number of Heroes: "), numHeroes);
        VBox vbox = new VBox(numBox, hero1, hero2, hero3, hero4, submit);
        vbox.setAlignment(Pos.CENTER);

        sceneCrea = new Scene(vbox, 300, 300);

        window.setScene(sceneCrea);
        window.show();
    }

    private void showHeroChoiceBoxes(int num) {
        switch (num) {
            case 1 -> {
                hero1.setVisible(true);
                hero2.setVisible(false);
                hero3.setVisible(false);
                hero4.setVisible(false);
            }
            case 2 -> {
                hero1.setVisible(true);
                hero2.setVisible(true);
                hero3.setVisible(false);
                hero4.setVisible(false);
            }
            case 3 -> {
                hero1.setVisible(true);
                hero2.setVisible(true);
                hero3.setVisible(true);
                hero4.setVisible(false);
            }
            case 4 -> {
                hero1.setVisible(true);
                hero2.setVisible(true);
                hero3.setVisible(true);
                hero4.setVisible(true);
            }

        }
    }

}