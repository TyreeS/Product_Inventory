/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author tsmith
 */
public class discontinue_alert {
    
    public static void display(){
        Stage primaryStage = new Stage();
        
        primaryStage.initModality(Modality.APPLICATION_MODAL); //Ensures no other actions can be done until window is closed
        primaryStage.setTitle("Discontinue Alert"); //Window title
        primaryStage.setWidth(200); // Window width
        
        Label discontinue_alert_label = new Label();
        discontinue_alert_label.setText("Discontinue Product");
        //cd_box_label.setFont(Font.font("Arial", FontWeight.BOLD, 20)); /*INLINE STYLING*/
        
        Text discontinue_alert_details = new Text();
        discontinue_alert_details.setText("Product Discontinued!");
        
        Button discontinue_alert_ok = new Button();
        discontinue_alert_ok.setText("OK");
       // discontinue_box_save.setOnAction(e -> primaryStage.setUserData(e)); //Action Event
        discontinue_alert_ok.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                primaryStage.close();
            }
        });
        
        //Main Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(discontinue_alert_label, discontinue_alert_details, discontinue_alert_ok);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, 200, 150);
        primaryStage.setScene(new Scene(new ScrollPane(layout)));
        primaryStage.showAndWait();
        
    }
   
}
