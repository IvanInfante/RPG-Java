package com.example.ivanrpg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class testG8 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();


        // Créer un label à mettre en haut de la scène
        Text label = new Text("Mon titre");
        label.setFont(new Font("Arial", 30));
        label.setX(50);
        label.setY(50);
        root.getChildren().add(label);

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

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}

