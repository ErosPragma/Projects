/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_dbms;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Manu
 */
public class LIB_DBMS extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        
        
        Button btnF = new Button();
        btnF.setText("List");

        Button btnA = new Button();
        btnA.setText("Search");
        
        Button btnD = new Button();
        btnD.setText("Add");
        
        Button btnR = new Button();
        btnR.setText("Rent");
        
        btnF.setOnAction((ActionEvent event) -> {
            new BookList().show();
        });
        
        btnA.setOnAction((ActionEvent event) -> {
            new Serach("").show();
        });

        btnD.setOnAction((ActionEvent event) -> {
            new Add("").show();
        });
        
        btnR.setOnAction((ActionEvent event) -> {
            new Rent("").show();
        });
        
        btnF.setLayoutX(110);
        btnF.setLayoutY(110);
        btnA.setLayoutX(50);
        btnA.setLayoutY(110);
        btnD.setLayoutX(150);
        btnD.setLayoutY(110);
        btnR.setLayoutX(190);
        btnR.setLayoutY(110);     
        
        Pane root = new Pane();
        root.getChildren().add(btnF);
        root.getChildren().add(btnA);
        root.getChildren().add(btnD);
        root.getChildren().add(btnR);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("LibraryDBMS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
