package com.example.ivanrpg;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Controller {

    public void submitBtn(ArrayList<String> heroes) {
        System.out.println("Team controller:");
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println("Hero " + (i + 1) + ": " + heroes.get(i));
        }
    }

}
