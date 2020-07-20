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
public class print_alert {
    
    //ArrayList to store product 
    public static ArrayList <Product> product = new ArrayList();
    
    public static void display(){
        Stage primaryStage = new Stage();
        
        primaryStage.initModality(Modality.APPLICATION_MODAL); //Ensures no other actions can be done until window is closed
        primaryStage.setTitle("Print Screen"); //Window title
        primaryStage.setWidth(250); // Window width
        
        Label print_box_label = new Label();
        print_box_label.setText("Print");
        //cd_box_label.setFont(Font.font("Arial", FontWeight.BOLD, 20)); /*INLINE STYLING*/
        
        Text print_box_details = new Text();
        print_box_details.setText("Inventory items printed to console!");
        
        Text print = new Text();
        //print.setText(System.out.print(product.toString())); //PROBLEM PRINTING 
        
        Button print_box_ok = new Button();
        print_box_ok.setText("OK");
       // discontinue_box_save.setOnAction(e -> primaryStage.setUserData(e)); //Action Event
        print_box_ok.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                primaryStage.close();
            }
        });
        
        //Main Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(print_box_label, print_box_details,  print_box_ok);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, 150, 50);
        primaryStage.setScene(new Scene(new ScrollPane(layout)));
        primaryStage.showAndWait();
        
    }
   
}
