/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

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
import org.hibernate.Session;

/**
 *
 * @author HUAWEI
 */
public class SignUp extends Application {
    static String USERNAME;
    @Override
    public void start(Stage primaryStage) {
      
       	// a grid pane that contains all of sign up interface nods
        GridPane org = new GridPane();
	org.setPadding(new Insets(10,10,10,10));
	org.setVgap(10);
	org.setHgap(10);
	org.setStyle(" -fx-background-image:url('backgound.jpeg');");
               
                
                
	Label titleSingUp = new Label("SIGN UP");
	org.add(titleSingUp, 11, 1);
	titleSingUp.setFont(Font.font("times-roman",FontWeight.BOLD,25));
	titleSingUp.setStyle("-fx-text-fill:#EEE9DA;");;
		   
        // text field that will store the name
	Label nameEntery = new Label("Full Name:");
	nameEntery.setStyle("-fx-text-fill:#EEE9DA;");
	TextField name = new TextField("");
	name.setStyle("-fx-background-color: #E3F4F4;");
	org.add(nameEntery, 10, 7);
	org.add(name, 11, 7);
		    	
	// text field that will store the username	    	
	Label UserNameEntery = new Label("Username:");
	UserNameEntery.setStyle("-fx-text-fill:#EEE9DA;");
	TextField username = new TextField("");
	username.setStyle("-fx-background-color: #E3F4F4;");
	org.add(UserNameEntery,10,9);
	org.add(username, 11, 9);
		    	 
	//text field that will store the email	    	 
	Label EmailEntery = new Label("Email:");
	       EmailEntery.setStyle("-fx-text-fill:#EEE9DA;");
	TextField email = new TextField();
	       email.setStyle("-fx-background-color: #E3F4F4;");
	org.add(EmailEntery,10,11);
	org.add(email, 11, 11);
		    	
	// text field that will store the phone number	    	
	Label PhoneNumberEntery = new Label("Phone Number:");
	       PhoneNumberEntery.setStyle("-fx-text-fill:#EEE9DA;");
	TextField phoneNumber = new TextField("");
	phoneNumber.setStyle("-fx-background-color: #E3F4F4;");
	org.add(PhoneNumberEntery,10,13);
	org.add(phoneNumber, 11, 13);
                
         // password field that will store the password	     
        Label PasswordEntery = new Label("Password:");
	PasswordEntery.setStyle("-fx-text-fill:#EEE9DA;");
	PasswordField password = new PasswordField();
	password.setStyle("-fx-background-color: #E3F4F4;");
	org.add(PasswordEntery,10,15);
	org.add(password, 11, 15);
		    	
	// after clicking on this button the account info will be saved in the database and the user will go to home page	    	
	Button signUp = new Button("Sign Up");
	org.add(signUp, 11, 20);
	signUp.setStyle("-fx-background-radius:20;-fx-background-color: #EEE9DA;"); 
	        
	Label checkExists = new Label("DO YOU HAVE ACCUONT ?");
	checkExists.setStyle("-fx-text-fill: #EEE9DA;");
	org.add(checkExists, 10, 26);
	 
        // this action will transfer the users to log in interfacs if they have an existing account 
	Label loginTrans = new Label("Log in");
	loginTrans.setUnderline(true);
	       loginTrans.setFont(Font.font("times-roman",FontWeight.BOLD,17));
	loginTrans.setStyle("-fx-text-fill:#EEE9DA;");
	org.add(loginTrans, 11, 26);
        loginTrans.setOnMouseClicked(e ->{
            LogIn login=new LogIn();
            login.start(primaryStage);
		  	     
	});
		        
	// label to show the error message	        
	Label msg = new Label("");
	msg.setFont(Font.font("times-roman",FontWeight.BOLD,15));
	msg.setTextFill(Color.web("#EEE9DA"));       
	org.add(msg,11, 21);
		               	
	/*this action will let the system check if each of the data fields entry
        is empty or not then
        the system will check the constraints and validation for each of the required information*/	
        
	signUp.setOnAction(e ->{
            // name must not be empty and it must contain only letters 
	    if(name.getText().trim().isEmpty()){
	        name.setStyle("-fx-background-color: #E3F4F4;-fx-border-color:red; -fx-border-width:1px;");
	        msg.setText("You must enter your name.");
	    }else if(name.getText().matches("[a-zA-Z]")){ 
	        name.setStyle("-fx-border-color:red; -fx-border-width:1px;-fx-background-color: #E3F4F4;");
	        msg.setText("Name must contain letters.");  
	    }
	    // username must not be empty and  it must contain letters and digits.               
	    else if (username.getText().trim().isEmpty()){
	        username.setStyle("-fx-border-color:red; -fx-border-width:1px;-fx-background-color: #E3F4F4;");
	        msg.setText("You must enter a username.");
	    }else if (!username.getText().matches("[a-zA-Z0-9]+")){
	        username.setStyle("-fx-border-color:red; -fx-border-width:1px;-fx-background-color: #E3F4F4;");
	        msg.setText("username must contain the following:" +" letters and "+"\n"+ "at lest one number ");
	    }
		              
	    else if(email.getText().trim().isEmpty()){
                // email must not be empty 
	        email.setStyle("-fx-border-color:red; -fx-border-width:1px;-fx-background-color: #EEEE3F4F49DA;");
	        msg.setText("You must enter an email.");
	    }
                   
            else if(phoneNumber.getText().trim().isEmpty()){
                // phone number must not be empty and it must contain only 10 digits
	        phoneNumber.setStyle("-fx-border-color:red; -fx-border-width:1px;-fx-background-color: #E3F4F4;");
	        msg.setText("You must enter you phone number.");
	    }else if(!phoneNumber.getText().matches("[0-9]+")){
	        phoneNumber.setStyle("-fx-background-color: #E3F4F4;-fx-border-color:red; -fx-border-width:1px;");
	        msg.setText("Phone number must be 10 digitsS.");
	    }
	               
	    else if(password.getText().trim().isEmpty()){
                // password must not be empty and it must contain uppercase letter , lowercase letter , digits
	        password.setStyle("-fx-border-color:red; -fx-border-width:1px;-fx-background-color: #E3F4F4;");
	        msg.setText("You must enter a password.");
	    }else if(!isPasswordValid(password.getText())){
	        password.setStyle("-fx-border-color:red; -fx-border-width:1px;-fx-background-color: #E3F4F4;");
	        msg.setText("Password must be 8 digits."+"\n"
	        +"at least one uppercase letter."+"at least one lowercase letter"+"\n"+"and at least one digit.");
	    }
	    else {  
                
                // saving the account information in the database 
                USERNAME=username.getText();      
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                     
                user User = new user();
                User.setName(name.getText());
                User.setUsername(username.getText());
                User.setEmail(email.getText());
                User.setPhoneNumber(Integer.parseInt(phoneNumber.getText()));
                User.setpassword(password.getText());
                session.save(User);
                       
                session.getTransaction().commit();
                session.close();
                
                Home home =new Home();
                home.start(primaryStage);
                
	    }
	});
	Scene signup = new Scene(org,660,600);	        

        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(signup);
        primaryStage.show();
    }
    
    // this method will check the passwor constrains and validations of the password 
    public boolean isPasswordValid(String passWord){
	boolean containsUppercase = false;
	boolean containsLowercase = false;
	boolean containsDigit = false;

	for (int i = 0; i < passWord.length(); i++){
	    char c = passWord.charAt(i);
	    if (Character.isUpperCase(c)){
	        containsUppercase = true;
	    } else if (Character.isLowerCase(c)){
	        containsLowercase = true;
	    } else if (Character.isDigit(c)){
	         containsDigit = true;
	    }
	}  
	    boolean meetsLengthRequirement = passWord.length() == 8;

	    return containsUppercase && containsLowercase && containsDigit && meetsLengthRequirement;
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
