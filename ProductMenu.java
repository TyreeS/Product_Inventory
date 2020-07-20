
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author tsmith
 */
public class ProductMenu extends Application {

    Scanner input = new Scanner(System.in); //input for users 

    int item_num;
    
    public static ArrayList<Product> product = new ArrayList<Product>();

    //Stage and Scenes to be used
    Stage window;
    Scene mainScene;
    Scene new_Cd;
    Scene new_Dvd;
    Scene add_Units;
    Scene deduct_Units;
    Scene discontinue_Product;
    Scene print_Products;
    Scene trans;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        menu();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    //Method used to call to Menu items
    public void menu() { 
        //Background Image 
        Image image = new Image("wallpaper.png"); //primaryStage background image object
        ImageView bg = new ImageView(image);
        
        //MENU
        Menu create = new Menu("_Create a Product"); //_ used to give shortcut with Alt
        //Menu item CD
        MenuItem new_cd = new MenuItem("New CD...");
        //Calls to the create_new_Cd() method and opens the Create New CD scene 
        new_cd.setOnAction(e
                -> {
            create_new_Cd();
        }
        );

        //Line separator 
        SeparatorMenuItem line = new SeparatorMenuItem(); //Line separator used to separate CD and DVD on Menu item list
        
        //Menu item DVD
        MenuItem new_dvd = new MenuItem("New DVD...");
        //Calls to the create_new_DVD() method and opens the Create New DVD scene 
        new_dvd.setOnAction(e
                -> {
            create_new_DVD();
        }); 
        create.getItems().addAll(new_cd, line, new_dvd); //Places CD and DVD under the same Menu item

        //Add units Menu item
        Menu add = new Menu("_Add Units");
        MenuItem new_add = new MenuItem("Add unit items");
        //Calls to the add_items() method and opens the Add units scene
        new_add.setOnAction(e
                -> {
            add_items();
        }); 
        add.getItems().addAll(new_add);

        //Deduct units Menu item
        Menu deduct = new Menu("_Deduct Units");
        MenuItem new_deduct = new MenuItem("Deduct unit items");
        //Calls to the deduct_items() method and opens the Deduct units scene
        new_deduct.setOnAction(e
                -> {
        //Throws Exception from class    
            try {
                deduct_items();
                if(item_num > 1){
                    throw new InvalidNumberException();
                }
            } catch(InvalidNumberException d){
            }
        });
        deduct.getItems().addAll(new_deduct);

        //Discontinue Menu item
        Menu discontinue = new Menu("_Discontinue Product");
        MenuItem new_discontinue = new MenuItem("Discontinue item");
        //Calls to the discontinue_product() method and opens the Discontinue item scene
        new_discontinue.setOnAction(e
                -> {
            discontinue_product();
        });
        discontinue.getItems().addAll(new_discontinue);

        //Print Menu items
        Menu print = new Menu("_Print Products");
        MenuItem new_print = new MenuItem("Print");
        //Calls the print method
        new_print.setOnAction(e
                -> {
            print_alert.display();
            print();
        }
        );
        print.getItems().addAll(new_print);

        //Menu bar object used to hold Menu items
        MenuBar menu_bar = new MenuBar();
        //Items in menu bar
        menu_bar.getMenus().addAll(create, add, deduct, discontinue, print);

        //Border pane used as main window which holds the Menu bar at the top
        BorderPane root = new BorderPane();
        root.getChildren().addAll(bg);
        root.setTop(menu_bar); //Places the Menu at the top of the window

        Scene mainScene = new Scene(root, 510, 300);

        window.setTitle("Product Inventory"); //Main window title
        window.setScene(mainScene);
        window.show();
    }

    public void print_items() {

        Label print_box_label = new Label();
        print_box_label.setText("Print");
        //cd_box_label.setFont(Font.font("Arial", FontWeight.BOLD, 20)); /*INLINE STYLING*/

        Text print_box_details = new Text();
        print_box_details.setText("Inventory items");

        Text print = new Text();
        //print.setText(System.out.print(product.toString())); //PROBLEM PRINTING 

        Button print_box_ok = new Button();
        print_box_ok.setText("OK");
        // discontinue_box_save.setOnAction(e -> primaryStage.setUserData(e)); //Action Event
        print_box_ok.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                menu();
            }
        });

        //Main Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(print_box_label, print_box_details, print_box_ok);
        layout.setAlignment(Pos.TOP_LEFT);

        Scene print_Products = new Scene(layout, 150, 50);
        window.setScene(print_Products);
        window.show();

    }

    //Create new CD method 
    public void create_new_Cd() {

        Label cd_box_label = new Label();
        cd_box_label.setText("New CD");
        cd_box_label.setFont(Font.font("Arial", FontWeight.BOLD, 20)); /*INLINE STYLING*/

        Text cd_box_details = new Text();
        cd_box_details.setText("Fill out the required fields to add product to inventory");

        Label cd_box_name_label = new Label();
        cd_box_name_label.setText("Name of CD");

        TextField cd_box_name = new TextField();
        cd_box_name.setPromptText("Name of CD");

        Label cd_box_artist_label = new Label();
        cd_box_artist_label.setText("Name of Artist");

        TextField cd_box_artist = new TextField();
        cd_box_artist.setPromptText("Name of Artist");

        Label cd_box_songs_label = new Label();
        cd_box_songs_label.setText("Number of songs on album");

        TextField cd_box_songs = new TextField();
        cd_box_songs.setPromptText("Number of songs on album");

        Label cd_box_label_label = new Label();
        cd_box_label_label.setText("Record Label registered");

        TextField cd_box_record_label = new TextField();
        cd_box_record_label.setPromptText("Record Label registered");

        Label cd_box_price_label = new Label();
        cd_box_price_label.setText("Price of CD");

        TextField cd_box_price = new TextField();
        cd_box_price.setPromptText("Price of CD");

        //Grid pane used to hold Save and Cancel buttons
        GridPane grid_buttons = new GridPane();
        grid_buttons.setPadding(new Insets(15, 15, 15, 15));
        grid_buttons.setVgap(10);
        grid_buttons.setHgap(10);
        //grid_buttons.setStyle("-fx-background-color: #FFFFFF");

        //Save button
        Button cd_box_save = new Button();
        cd_box_save.setText("Save");   
        GridPane.setConstraints(cd_box_save, 0, 0);
        cd_box_save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //CD Object Instance
                CD cd = new CD();

                String product_name = cd_box_name.getText();
                cd.setProduct_name(product_name);
                String artist = cd_box_artist.getText();
                cd.setArtist(artist);
                
                try{
                    int songs_on_album = Integer.parseInt(cd_box_songs.getText());
                    cd.setSongs_on_album(songs_on_album);
                } catch(NumberFormatException e){
                    System.out.println("Error: " + cd_box_songs.getText() + "Is not a number for songs on album");
                }
                
                String record_label = cd_box_record_label.getText();
                cd.setRecord_label(record_label);
                
                try{
                    double unit_price = Double.parseDouble(cd_box_price.getText());
                    cd.setUnit_price(unit_price);
                } catch(NumberFormatException e){
                    System.out.println("Error: " + cd_box_price.getText() + "Is not a price");
                }
                    
                cd.status();
                
                product.add(cd); //Saves CD object to product ArrayList
                
                //print();
                
                menu(); //Returns user to Menu 
            }
        });  

        //Cancel button
        Button cd_box_close = new Button();
        cd_box_close.setText("Cancel");
        GridPane.setConstraints(cd_box_close, 1, 0);
        cd_box_close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                menu();
            }
        });
        
        grid_buttons.getChildren().addAll(cd_box_save, cd_box_close);

        //Main Layout for CD box
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(cd_box_label, cd_box_details, cd_box_name_label, cd_box_name, cd_box_artist_label, cd_box_artist, cd_box_songs_label, cd_box_songs, cd_box_label_label, cd_box_record_label, cd_box_price_label, cd_box_price, grid_buttons);
        layout.setAlignment(Pos.TOP_LEFT);

        new_Cd = new Scene(layout, 500, 500);
        window.setScene(new Scene(new ScrollPane(layout)));
        window.show();

    }

    //Create new DVD method
    public void create_new_DVD() {
        
        Label dvd_box_label = new Label();
        dvd_box_label.setText("New DVD");
        dvd_box_label.setFont(Font.font("Arial", FontWeight.BOLD, 20)); /*INLINE STYLING*/

        Text dvd_box_details = new Text();
        dvd_box_details.setText("Fill out the required fields to add product to inventory");

        Label dvd_box_name_label = new Label();
        dvd_box_name_label.setText("Name of DVD");

        TextField dvd_box_name = new TextField();
        dvd_box_name.setPromptText("Name of DVD");

        Label dvd_box_movie_length_label = new Label();
        dvd_box_movie_length_label.setText("Movie length in minutes");

        TextField dvd_box_movie_length = new TextField();
        dvd_box_movie_length.setPromptText("Movie length in minutes");

        Label dvd_box_age_rating_label = new Label();
        dvd_box_age_rating_label.setText("Age rating");

        TextField dvd_box_age_rating = new TextField();
        dvd_box_age_rating.setPromptText("Age rating");

        Label dvd_box_film_studio_label = new Label();
        dvd_box_film_studio_label.setText("Film studio");

        TextField dvd_box_film_studio = new TextField();
        dvd_box_film_studio.setPromptText("Film studio");

        Label dvd_box_price_label = new Label();
        dvd_box_price_label.setText("Price of DVD");

        TextField dvd_box_price = new TextField();
        dvd_box_price.setPromptText("Price of DVD");

        //Grid pane used to hold Save and Cancel buttons
        GridPane grid_buttons = new GridPane();
        grid_buttons.setPadding(new Insets(15, 15, 15, 15));
        grid_buttons.setVgap(10);
        grid_buttons.setHgap(10);
        //grid_buttons.setStyle("-fx-background-color: #FFFFFF");

        Button dvd_box_save = new Button();
        dvd_box_save.setText("Save");
        GridPane.setConstraints(dvd_box_save, 0, 0);
        dvd_box_save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //DVD Object Instances 
                DVD dvd = new DVD();

                String product_name = dvd_box_name.getText();
                dvd.setProduct_name(product_name);
                
                try{
                    int movie_length = Integer.parseInt(dvd_box_movie_length.getText());
                    dvd.setMovie_length(movie_length);
                } catch(NumberFormatException e){
                    System.out.println("Error: " + dvd_box_movie_length.getText() + "Is not a number for length of movie");
                }
                
                try{
                    int age_rating = Integer.parseInt(dvd_box_age_rating.getText());
                    dvd.setAge_rating(age_rating);
                } catch(NumberFormatException e){
                    System.out.println("Error: " + dvd_box_age_rating.getText() + "Is not a number for age rating");
                }
                
                String film_studio = dvd_box_film_studio.getText();
                dvd.setFilm_studio(film_studio);
                
                try{
                    double unit_price = Double.parseDouble(dvd_box_price.getText());
                    dvd.setUnit_price(unit_price);
                } catch(NumberFormatException e){
                    System.out.println("Error: " + dvd_box_price.getText() + "Is not a number for price of dvd");
                }
                
                dvd.status();
                
                product.add(dvd); //Saves DVD object to product ArrayList
                
                //print();
                
                menu(); //Returns user to Menu
            }
        });

        Button dvd_box_close = new Button();
        dvd_box_close.setText("Close");
        GridPane.setConstraints(dvd_box_close, 1, 0);
        dvd_box_close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                menu();
            }
        });

        grid_buttons.getChildren().addAll(dvd_box_save, dvd_box_close);

        //Main Layout for DVD box
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(dvd_box_label, dvd_box_details, dvd_box_name_label, dvd_box_name, dvd_box_movie_length_label, dvd_box_movie_length, dvd_box_age_rating_label, dvd_box_age_rating, dvd_box_film_studio_label, dvd_box_film_studio, dvd_box_price_label, dvd_box_price, grid_buttons);
        layout.setAlignment(Pos.TOP_LEFT);

        Scene new_Dvd = new Scene(layout, 500, 460);
        window.setScene(new Scene(new ScrollPane(layout)));
        window.show();
    }

    //Add units method
    private void add_items() {

        Label add_box_label = new Label();
        add_box_label.setText("Add Units");
        add_box_label.setFont(Font.font("Arial", FontWeight.BOLD, 20)); /*INLINE STYLING*/

        Text add_box_details = new Text();
        add_box_details.setText("Fill out the required fields to add units");

        Label add_box_item_number_label = new Label();
        add_box_item_number_label.setText("Enter item number to be edited");

        TextField add_box_item_number = new TextField();
        add_box_item_number.setPromptText("Enter number");

        Label add_box_units_label = new Label();
        add_box_units_label.setText("Enter number of units to be added");

        TextField add_box_units = new TextField();
        add_box_units.setPromptText("Enter number");

        //Grid pane used to hold Save and Cancel buttons
        GridPane grid_buttons = new GridPane();
        grid_buttons.setPadding(new Insets(15, 15, 15, 15));
        grid_buttons.setVgap(10);
        grid_buttons.setHgap(10);
        //grid_buttons.setStyle("-fx-background-color: #FFFFFF");

        Button add_box_save = new Button();
        add_box_save.setText("Save");
        GridPane.setConstraints(add_box_save, 0, 0);
        add_box_save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                //try{ //EXCEPTION THROWING ERROR
                    int item_number = Integer.parseInt(add_box_item_number.getText()) - 1;
                    Product addToProduct = product.get(item_number); //Locates item in ArrayList
                //} catch(NumberFormatException e){
                    //System.out.println("Error: " + add_box_item_number.getText() + "Is not an item number");
                //}
                
                 
                try{
                int units = Integer.parseInt(add_box_units.getText());
                addToProduct.addUnits(units);
                }catch(NumberFormatException e){
                    System.out.println("Error: " + add_box_units.getText() + "Is not a unit number");
                }
                
                //print();
                
                menu();
            }
        });

        Button add_box_close = new Button();
        add_box_close.setText("Close");
        GridPane.setConstraints(add_box_close, 1, 0);
        add_box_close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                menu();
            }
        });

        grid_buttons.getChildren().addAll(add_box_save, add_box_close);

        //Main Layout for add box
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(add_box_label, add_box_details, add_box_item_number_label, add_box_item_number, add_box_units_label, add_box_units, grid_buttons);
        layout.setAlignment(Pos.TOP_LEFT);

        Scene add_Units = new Scene(layout, 500, 260);
        window.setScene(new Scene(new ScrollPane(layout)));
        window.show();
    }
    
    //Deduct units method
    private void deduct_items() {
        
        Label deduct_box_label = new Label();
        deduct_box_label.setText("Deduct Units");
        deduct_box_label.setFont(Font.font("Arial", FontWeight.BOLD, 20)); /*INLINE STYLING*/

        Text deduct_box_details = new Text();
        deduct_box_details.setText("Fill out the required fields to deduct units");

        Label deduct_box_item_number_label = new Label();
        deduct_box_item_number_label.setText("Enter item number to be edited");

        TextField deduct_box_item_number = new TextField();
        deduct_box_item_number.setPromptText("Enter number");

        Label deduct_box_units_label = new Label();
        deduct_box_units_label.setText("Enter number of units to be deducted");

        TextField deduct_box_units = new TextField();
        deduct_box_units.setPromptText("Enter number");

        //Grid pane used to hold Save and Cancel buttons
        GridPane grid_buttons = new GridPane();
        grid_buttons.setPadding(new Insets(15, 15, 15, 15));
        grid_buttons.setVgap(10);
        grid_buttons.setHgap(10);
        //grid_buttons.setStyle("-fx-background-color: #FFFFFF");

        Button deduct_box_save = new Button();
        deduct_box_save.setText("Save");
        GridPane.setConstraints(deduct_box_save, 0, 0);
        deduct_box_save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                //try{ //EXCEPTION THROWING ERROR
                    int item_number = Integer.parseInt(deduct_box_item_number.getText()) - 1;
                    Product deductToProduct = product.get(item_number); //Locates item in ArrayList
                //} catch(NumberFormatException e){
                    //System.out.println("Error: " + deduct_box_item_number.getText() + "Is not an item number");
                //}
                
                try{
                    int units = Integer.parseInt(deduct_box_units.getText());
                    deductToProduct.deductUnits(units);
                } catch(NumberFormatException e){
                    System.out.println("Error: " + deduct_box_units.getText() + "Is not a number of units");
                }
                
                //print();
                
                menu();
            }
        });

        Button deduct_box_close = new Button();
        deduct_box_close.setText("Close");
        GridPane.setConstraints(deduct_box_close, 1, 0);
        deduct_box_close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                menu();
            }
        });

        grid_buttons.getChildren().addAll(deduct_box_save, deduct_box_close);

        //Main Layout for deduct box
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(deduct_box_label, deduct_box_details, deduct_box_item_number_label, deduct_box_item_number, deduct_box_units_label, deduct_box_units, grid_buttons);
        layout.setAlignment(Pos.TOP_LEFT);

        Scene deduct_Units = new Scene(layout, 500, 260);
        window.setScene(new Scene(new ScrollPane(layout)));
        window.showAndWait();
    }
   
    //Discontinue item method
    private void discontinue_product() {
        
        Label discontinue_box_label = new Label();
        discontinue_box_label.setText("Discontinue Product");
        discontinue_box_label.setFont(Font.font("Arial", FontWeight.BOLD, 20)); /*INLINE STYLING*/

        Text discontinue_box_details = new Text();
        discontinue_box_details.setText("Fill out the required fields to discontinue product");

        Label discontinue_box_item_number_label = new Label();
        discontinue_box_item_number_label.setText("Enter item number to be edited");

        TextField discontinue_box_item_number = new TextField();
        discontinue_box_item_number.setPromptText("Enter number");

         //Grid pane used to hold Save and Cancel buttons
        GridPane grid_buttons = new GridPane();
        grid_buttons.setPadding(new Insets(15, 15, 15, 15));
        grid_buttons.setVgap(10);
        grid_buttons.setHgap(10);
        //grid_buttons.setStyle("-fx-background-color: #FFFFFF");

        Button discontinue_box_save = new Button("Save");
        GridPane.setConstraints(discontinue_box_save, 0, 0);
        discontinue_box_save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                try{
                    int item_number = Integer.parseInt(discontinue_box_item_number.getText()) - 1; //Locates item in ArrayList
                    //System.out.println(product.indexOf(item_number)); //pulls up item number to be removed
                    product.remove(item_number); //Removes item
                } catch(NumberFormatException e){
                    System.out.println("Error: " + discontinue_box_item_number.getText() + "Is not an item number");
                }
                               
                discontinue_alert.display();
                
                menu();
            }
        });
        
        Button discontinue_box_close = new Button("Cancel");
        discontinue_box_close.setText("Cancel");
        GridPane.setConstraints(discontinue_box_close, 1, 0);
        discontinue_box_close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                menu();
            }
        });
        
        grid_buttons.getChildren().addAll(discontinue_box_save, discontinue_box_close);

        //Main Layout for discontinue box
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(discontinue_box_label, discontinue_box_details, discontinue_box_item_number_label, discontinue_box_item_number, grid_buttons);
        layout.setAlignment(Pos.TOP_LEFT);

        Scene discontinue_Product = new Scene(layout, 300, 200);
        window.setScene(new Scene(new ScrollPane(layout)));
        window.show();
    }
    
    public void print() { //Prints contents of ArrayList
        for (Product p : product) { //for loop used to print contents of ArrayList
            if (p != null) {
                System.out.println(p.toString());
            }
        }

    }

}
