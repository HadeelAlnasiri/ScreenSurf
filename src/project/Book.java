/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author HUAWEI
 */
public class Book extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       //booking screen
        
        //borderpan 
        BorderPane bookBorder=new BorderPane();
        //add backgroung and style
        bookBorder.setStyle("-fx-background-image:url('backgound.jpeg');");
        GridPane bokinggrid=new GridPane();
        
        //back to movie
        ImageView back = new ImageView(new Image("backG.png"));
        back.setFitWidth(30);
        back.setFitHeight(30);
        back.setOnMouseClicked(e->{
            MovieDetails movieDetails= new MovieDetails();
            movieDetails.start(primaryStage);
        });
        
        bookBorder.setPadding(new Insets(20));
        bookBorder.setTop(back);
        bookBorder.setCenter(bokinggrid);
 
        
        Label movName=new Label(Home.movies.getMovieName());
       //lable move name & show the move name user tickit
       
       
        Label movieNameLbl = new Label("MOVIE NAME : ");
        movieNameLbl.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill:#EEE9DA;");
        movieNameLbl.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR,20));
        Label movieName=new Label();
        movieName.textProperty().bind(movName.textProperty());
        movieName.setStyle("-fx-font-size: 17px; -fx-font-weight: bold; -fx-text-fill:#EEE9DA;");
        HBox h2=new HBox ();
        h2.getChildren().addAll(movieNameLbl,movieName);
        bokinggrid.add(h2, 0, 2);
  
        
        //time and date for the move
        Label time = new Label("time and date:");
        time.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR,20));
        time.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill:#EEE9DA;");
        ComboBox  time1 = new ComboBox();
        time1.setStyle("-fx-background-color:#EEE9DA;");
        time1.getItems().addAll(  "4:00PM at 30 May", "10:00PM at 30 May","6:00PM at 2 Oct","6:00PM 3 Oct");
        time1.setValue("4:00PM at 30 May");
        HBox h5=new HBox ();
        h5.getChildren().addAll(time,time1);
        bokinggrid.add(h5, 0, 5);
            // hall the user choes
        Label hall = new Label("hall : ");
        hall.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill:#EEE9DA;");
        hall.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR,20));
        ComboBox  hallcom = new ComboBox();
        hallcom.getItems().addAll("stander", "VIP","GOLD","iMAX");
            hallcom.setStyle("-fx-background-color:#EEE9DA;");
        HBox h6=new HBox ();
        // action To display the price based on the user's choice
        h6.getChildren().addAll(hall,hallcom);
        Label prtxt = new Label();
        hallcom.setOnAction(e->{
            if (hallcom.getValue().equals("stander")){
                prtxt.setText("70");
            }else if (hallcom.getValue().equals("VIP")){
                prtxt.setText("150");
            }else if (hallcom.getValue().equals("GOLD")){
                prtxt.setText("160");
            }else if (hallcom.getValue().equals("iMAX")){
                prtxt.setText("80");
            }
        });
     
        bokinggrid.add(h6, 0, 6);
        //to show the price 
        Label prices = new Label("prices : ");
        prices.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill:#EEE9DA;");
        prices.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,20));
        HBox h7=new HBox ();
        h7.getChildren().addAll(prices,prtxt);
        bokinggrid.add(h7, 0, 7);
    /// Click to complete the ticket reservation and payment process
        Button buy =new Button("Buy");
        buy.setStyle("-fx-background-color:#EEE9DA;-fx-background-radius:20;");
        buy.setFont(Font.font("Cambria", FontWeight.NORMAL, FontPosture.REGULAR,17));
        bokinggrid.add(buy, 1, 8);
        buy.setOnAction(e->{
            Payment payment=new Payment();
            payment.start(primaryStage);
        });
 
        bokinggrid.setVgap(10);
        bokinggrid.setHgap(2);
        bokinggrid.setPadding(new Insets(80,0,0,10));

        Scene book = new Scene(bookBorder,650,500);
        primaryStage.setScene(book);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
