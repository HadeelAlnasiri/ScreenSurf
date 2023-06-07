/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static project.Home.movies;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;

/**
 *
 * @author HUAWEI
 */
public class MovieDetails extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        MovieInfo movie = Home.movies;   
        BorderPane moviePane = new BorderPane();
        moviePane.setStyle("-fx-background-image:url('backgound.jpeg');");

        ImageView back = new ImageView(new Image("backG.png"));
        back.setFitWidth(30);
        back.setFitHeight(30);
        moviePane.setTop(back);
        moviePane.setPadding(new Insets(20));
        
        back.setOnMouseClicked(e -> {
            Home home=new Home();
            home.start(primaryStage);
        });

        VBox imageContainer = new VBox();
        imageContainer.setPadding(new Insets(10));
        imageContainer.setPrefWidth(200);
        imageContainer.setPrefHeight(200);

        HBox content = new HBox();
        content.setSpacing(20);

//        Image MoviePost
        ImageView moviePoster = new ImageView(Home.poster);
        moviePoster.setFitWidth(300);
        moviePoster.setFitHeight(400);
        imageContainer.getChildren().add(moviePoster);
        content.getChildren().add(imageContainer);

        VBox AllDetails = new VBox();
        AllDetails.setSpacing(10);

        HBox detailsContainer1 = new HBox();
        detailsContainer1.setSpacing(10);

        HBox detailsContainer2 = new HBox();
        detailsContainer2.setSpacing(10);

        HBox detailsContainer3 = new HBox();
        detailsContainer3.setSpacing(10);

        HBox detailsContainer4 = new HBox();
        detailsContainer4.setSpacing(10);

//        HBox detailsContainer5 = new HBox();
//        detailsContainer5.setSpacing(10);

        Label movieName = new Label("Name:");
        movieName.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill:#EEE9DA;");

        Text MovieName = new Text(movie.getMovieName());
        MovieName.setText(movie.getMovieName());
        MovieName.setStyle("-fx-font-size: 24px; -fx-fill:#EEE9DA;");

        detailsContainer1.getChildren().addAll(movieName,MovieName);
        AllDetails.getChildren().add(detailsContainer1);

        Label genres=new Label("Genres: ");
        genres.setStyle("-fx-font-size: 17px; -fx-font-weight: bold; -fx-text-fill:#EEE9DA;");
        Label genre=new Label(movie.getGenres());
        genre.setStyle("-fx-font-size: 17px; -fx-text-fill:#EEE9DA;");
        detailsContainer2.getChildren().addAll(genres,genre);
        AllDetails.getChildren().add(detailsContainer2);

        Label description = new Label("Description: ");
        description.setStyle("-fx-font-size: 17px; -fx-font-weight: bold; -fx-text-fill:#EEE9DA;");
        TextArea movieDescription = new TextArea(movie.getDescription());
        movieDescription.setStyle("-fx-control-inner-background: #93BFCF;-fx-font-size: 17px; -fx-text-fill:#EEE9DA; ");
        movieDescription.setEditable(false);
        movieDescription.setPrefColumnCount(20);
        movieDescription.setPrefRowCount(3);
        movieDescription.setWrapText(true);
        detailsContainer3.getChildren().addAll(description,movieDescription);
        AllDetails.getChildren().add(detailsContainer3);


        Label date = new Label("Release date:");
        date.setStyle("-fx-font-size: 17px; -fx-font-weight: bold; -fx-text-fill:#EEE9DA;");
        Text ReDate = new Text(movie.getDateOfShow());
        ReDate.setStyle("-fx-font-size: 17px; -fx-fill:#EEE9DA;");
        ReDate.setText(movie.getDateOfShow());
        detailsContainer4.getChildren().addAll(date,ReDate);
        AllDetails.getChildren().add(detailsContainer4);
                 content.getChildren().addAll(AllDetails);

        Button bookBtn = new Button("Book now");
        bookBtn.setStyle("-fx-background-radius:20;-fx-background-color: #EEE9DA;");         
        bookBtn.setOnAction((ActionEvent e)->{
            Book book= new Book();
            book.start(primaryStage);
        });
        bookBtn.setAlignment(Pos.TOP_RIGHT);
        AllDetails.getChildren().add(bookBtn);
        moviePane.setCenter(content);
        Scene movieInfo = new Scene(moviePane,850,600);
        primaryStage.setScene(movieInfo);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
