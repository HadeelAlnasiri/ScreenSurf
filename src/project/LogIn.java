/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author HUAWEI
 */
public class LogIn extends Application {
    private Scene login;
    static String USERNAME;
    @Override
    public void start(Stage primaryStage) {
        
        // grid pane that contains all of the log in interface nodes
       	GridPane org2 = new GridPane();
	login = new Scene(org2,650,500);
	org2.setStyle("-fx-background-color: rgb(147, 191, 207);");
	org2.setPadding(new Insets(10,10,10,10));
	org2.setVgap(10);
	org2.setHgap(10);
	org2.setStyle(" -fx-background-image:url('backgound.jpeg');");
		
        
	Label msg1 = new Label("");
	msg1.setTextFill(Color.web("#EEE9DA"));
	
        
	Label titleLogIn = new Label("LOG IN");
	org2.add(titleLogIn, 12, 1);
	titleLogIn.setFont(Font.font("verdana",FontWeight.BOLD,25));
	titleLogIn.setStyle("-fx-text-fill: #EEE9DA;");  
        
        // users will enter thier username here 
	Label UserNameEntery1 = new Label("User Name:");
	UserNameEntery1.setStyle("-fx-text-fill:#EEE9DA;");
	TextField usernametxf = new TextField();
	usernametxf.setStyle("-fx-background-color: #E3F4F4;");
	org2.add(UserNameEntery1, 11, 5);
	org2.add(usernametxf, 12, 5);
        
         // users will enter thier password here 
	Label passwordEntery = new Label("Password:");
	passwordEntery.setStyle("-fx-text-fill:#EEE9DA;");
	PasswordField Password1 = new PasswordField();	
	Password1.setStyle("-fx-background-color: #E3F4F4;");
	org2.add(passwordEntery, 11, 7);
	org2.add(Password1, 12, 7);
        
        // this button will transfer the users to the home page 
	Button LOGIN = new Button("Log In");
	LOGIN.setStyle("-fx-background-radius:20;-fx-background-color: #EEE9DA;");
	org2.add(LOGIN, 12, 11);
        
			
	Label createAccuont = new Label("Do not hava an accuont?");
	org2.add(createAccuont, 11, 15);
	createAccuont.setStyle("-fx-text-fill: #EEE9DA;");
				
	// this label will allow the users to go to  the sign up interface to creat an account 
  
	Label SignUp = new Label("SIGN UP");
	SignUp.setUnderline(true);
	SignUp.setStyle("-fx-text-fill:#EEE9DA;");
	SignUp.setFont(Font.font("times-roman",FontWeight.BOLD,17));
	org2.add(SignUp, 12, 15);
	org2.add(msg1, 12, 12);
			
        /* first the system will check if the text field is empty if true it will pop up an error massege  then 
        after the users enter thier username the system will compaere it with the saved username in the database
        and same applies on the password .
        if the entered data is diffrean than the saved data in the database the system will ask the user to sign up or enter a correct information .
        */
	LOGIN.setOnAction(e ->{
            if(usernametxf.getText().isEmpty()){
		usernametxf.setStyle("-fx-background-color: #E3F4F4;-fx-border-color:red; -fx-border-width:1px;");
                msg1.setText(" You muust enter your username");	
	    }else if(Password1.getText().isEmpty()){
		Password1.setStyle("-fx-background-color: #E3F4F4;-fx-border-color:red; -fx-border-width:1px;");
		msg1.setText(" You muust enter your password");	
	    }else if(!loginCheckuser(usernametxf.getText(),Password1.getText())){
                
                msg1.setText("Username not found please \n sing up or password wrong ");
            }else{
                USERNAME=usernametxf.getText();
                Home home =new Home();
                home.start(primaryStage);
            }
                   
	});
				
       // this action will allow the user to go to the sign scene to creat an account .
        SignUp.setOnMouseClicked(e ->{
            SignUp signup=new SignUp();
            signup.start(primaryStage);
        });
	primaryStage.setScene(login);
	primaryStage.setTitle("Wellcome to ScreenSurf !");
	primaryStage.show();
    }
      // this method compare the enterd information with the data in the database 
    
    
        public boolean loginCheckuser(String UserName1,String password){
        List<user> users = new ArrayList<>();
        
        Session sessionread = HibernateUtil.getSessionFactory().openSession();
        Query query = sessionread.createQuery("from user");
        users =query.list();
        sessionread.close();
        
        boolean exists=false;
                
        for(user u:users){
            if(UserName1.equals(u.getUsername())){
                if(password.equals(u.getPassword())){
                    exists=true;   
                }
            }
        }
        return exists;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
