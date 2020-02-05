/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.db;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Manu
 */
public class TestDB extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btnF = new Button();
        btnF.setText("Faculty");

        Button btnS = new Button();
        btnS.setText("Student");
        
        
        Button btnA = new Button();
        btnA.setText("Admin");
        
        
        btnA.setOnAction((ActionEvent event) -> {
            new Loginn(-1,"").show();
        });
        
        btnF.setOnAction((ActionEvent event) -> {
            new Loginn(1,"").show();
        });
        btnS.setOnAction((ActionEvent event) -> {
            new Loginn(0,"").show();
        });
        btnA.setLayoutX(5);
        btnA.setLayoutY(5);
        btnF.setLayoutX(160);
        btnF.setLayoutY(110);
        btnS.setLayoutX(90);
        btnS.setLayoutY(110);
        Pane root = new Pane();
        root.getChildren().add(btnF);
        root.getChildren().add(btnS);
        root.getChildren().add(btnA);
        
       
        Scene scene = new Scene(root, 300, 250);
        
       
        primaryStage.setTitle("Student Grading System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

  
    public static void main() {
        launch();
    }
}
