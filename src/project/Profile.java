/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HUAWEI
 */
public class Profile extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //pane and style in it 
        GridPane profilePage=new GridPane();
        
        profilePage.setStyle("-fx-background-image:url('backgound.jpeg');");
        
        profilePage.setAlignment(Pos.TOP_LEFT);
        // button back return the user to the main page
        ImageView back = new ImageView(new Image("backG.png"));
        back.setFitWidth(30);
        back.setFitHeight(30);
        back.setOnMouseClicked(e->{
            Home home=new Home();
            home.start(primaryStage);
        });
        profilePage.add(back, 1, 0);
        
        Line line = new Line();
        line.setStrokeWidth(3);
        line.setStroke(Color.web("#EEE9DA"));
        line.setStartY(12); line.setEndY(28);
        
        // open the session 
        //and log in the if statmint to combare the USERNAME in log in 
        //if the valu is the same in the session  record the data into profileUser
        //else search the USERNAME in SignUp if the valu is the 
        //same in the session  record the data into profileUser
        user profileUser;
        Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            // 
            if(LogIn.USERNAME!=null){
                profileUser = (user)session.get(user.class, LogIn.USERNAME);
            }else{
                profileUser = (user)session.get(user.class, SignUp.USERNAME);
            }
                //close  the session
            tx.commit();
        session.close();        

       //lable user info
        Label userinfolbl = new Label(" USER INFO");
        userinfolbl.setLayoutY(20);
        userinfolbl.setTextFill(Color.web("#EEE9DA"));
        userinfolbl.setFont(Font.font("times-roman",FontWeight.BOLD,25));
        profilePage.add(line, 0, 1);
        profilePage.add(userinfolbl, 0, 1);
        
        
        // lable name 
        Label uName = new Label("\t Name:"); 
        uName.setFont(Font.font("times-roman",FontWeight.BOLD,15));
        uName.setStyle("-fx-text-fill:#EEE9DA;");
        Label nameText = new Label();
        //get the name frome profilePage and show
        nameText.setText(profileUser.getName());
        nameText.setStyle("-fx-text-fill:#EEE9DA;");
        profilePage.add(uName, 0, 3);
        profilePage.add(nameText, 1, 3);
            //lable UserName
        Label userName = new Label("\t UserName:"); 
        userName.setFont(Font.font("times-roman",FontWeight.BOLD,15));
        userName.setStyle("-fx-text-fill:#EEE9DA;");
        Label userName1=new Label();
        userName1.setStyle("-fx-text-fill:#EEE9DA;");
        //get the Username frome profilePage and show
        userName1.setText(profileUser.getUsername());
        profilePage.add(userName, 0, 4);
        profilePage.add(userName1, 1, 4);
        // label number
        Label number = new Label("\t Phone number:"); 
        number.setFont(Font.font("times-roman",FontWeight.BOLD,15));
        number.setStyle("-fx-text-fill:#EEE9DA;");
        Label phonenubertext = new Label();  
        // get the number frome profilePage and show
        phonenubertext.setText(Integer.toString(profileUser.getPhoneNumber()));
        phonenubertext.setStyle("-fx-text-fill:#EEE9DA;");
        profilePage.add(number, 0, 5);
        profilePage.add(phonenubertext, 1, 5);

            // lable email
        Label emailProfile = new Label("\t Email:");
        emailProfile.setFont(Font.font("times-roman",FontWeight.BOLD,15));
        emailProfile.setStyle("-fx-text-fill:#EEE9DA;");
        Label emailtest = new Label();
        //get the email frome profilePage and show
        emailtest.setText(profileUser.getEmail());
        emailtest.setStyle("-fx-text-fill:#EEE9DA;");
        profilePage.add(emailProfile, 0, 6);
        profilePage.add(emailtest, 1,6);
        

        profilePage.setVgap(20);
        profilePage.setHgap(20);
        profilePage.setPadding(new Insets(20,20,20,20));
        

        Scene profileScene= new Scene(profilePage,600,600);
//---------------------------------------------------------------
        
        primaryStage.setScene(profileScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}