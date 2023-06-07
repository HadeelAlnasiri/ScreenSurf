/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.scene.image.Image;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author itzha
 */
public class Payment extends Application {
    
    @Override
    public void start(Stage primaryStage) {

   //Tool bar that is on the top of the page to add styling. 
        ToolBar top = new ToolBar();
        top.setPrefSize(600,50);
        top.setStyle("-fx-background-color:#EEE9DA;");
   //Label to give the user hint about what is in this interface. 
        Label payment = new Label("Payment");
        payment.setLayoutX(250);
        payment.setLayoutY(5);
        //Label Styling. 
        payment.setFont(Font.font("verdana",FontWeight.BOLD,25));
        payment.setTextFill(Color.rgb(147, 191, 207));
        
    //Image that represents a back button to allow the user to move back to the previous page(Book page). 
        ImageView backIcon = new ImageView(new Image("back.png"));
        backIcon.setLayoutX(10);
        backIcon.setLayoutY(10);
        backIcon.setFitWidth(30); backIcon.setFitHeight(30);
        backIcon.setOnMouseClicked(e->{
            Book book=new Book();
            book.start(primaryStage);
        });
    //Label that asks the user to choose the payment method.      
        Label chooseMethod = new Label("Please choose a payment methood: ");
        //Set Styling.
        chooseMethod.setFont(Font.font("Times New Romman",FontWeight.BOLD,17));
        chooseMethod.setTextFill(Color.web("#EEE9DA"));
        chooseMethod.setLayoutX(30);
        chooseMethod.setLayoutY(80);
    
    // Card Icon to represent the card option. (Adding it aims to give the interface look-and-feel). 
        ImageView cardIcon = new ImageView(new Image("card.png"));
        cardIcon.setLayoutX(55); 
        cardIcon.setLayoutY(145);
        cardIcon.setFitWidth(30); cardIcon.setFitHeight(30);
   // Apple Icon to represent the applepay option. (Adding it aims to give the interface look-and-feel).    
        ImageView appleIcon = new ImageView(new Image("ApplePay.png"));
        appleIcon.setFitWidth(40); appleIcon.setFitHeight(30);
        appleIcon.setLayoutX(55);
        appleIcon.setLayoutY(175);
    // Paypal Icon to represent the paypal option. (Adding it aims to give the interface look-and-feel). 
        ImageView palIcon = new ImageView(new Image("PayPal.png"));
        palIcon.setFitWidth(40); palIcon.setFitHeight(30);
        palIcon.setLayoutX(55);
        palIcon.setLayoutY(205);
        
   //HBox to add more details about the acceptable cards.        
        HBox card = new HBox(10);
    //First image is an image for visa cards.   (Adding it aims to give the interface look-and-feel).  
        ImageView visa = new ImageView(new Image("visa.jpg"));
        visa.setFitWidth(30); visa.setFitHeight(20);
    //Second image is an image for Masetr cards.   (Adding it aims to give the interface look-and-feel).    
        ImageView master = new ImageView (new Image("master.png"));
        master.setFitWidth(30); master.setFitHeight(25);
  
    //Adding them to the card HBox. 
        card.getChildren().addAll(visa,master);
        card.setLayoutX(185);
        card.setLayoutY(145);
        
    //Radio Buttons group that represents the acceptable payment methods. (3 Methods)
        ToggleGroup paymentOptions = new ToggleGroup();
        //First method: pay with a Card. 
        RadioButton cardPay = new RadioButton("Card");
        cardPay.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 15));
        cardPay.setToggleGroup(paymentOptions);
        //Second method: pay using ApplePay.
        RadioButton applePay = new RadioButton("Apple Pay");
        applePay.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 15));
        applePay.setToggleGroup(paymentOptions);
        //Third method: pay using PayPal. 
        RadioButton payPal = new RadioButton("Pay Pal");
        payPal.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 15));
        payPal.setToggleGroup(paymentOptions);
    
    //VBox that contains the three buttons to arrange them vertically.
        VBox payBtns = new VBox(10);
        payBtns.getChildren().addAll(cardPay, applePay, payPal);
        payBtns.setLayoutX(115);
        payBtns.setLayoutY(145);
        
        
    //Button (Pay) at the end of the page, which the user will click after entering the card information. 
        Button payDone = new Button("PAY");
        //Set Styling:
        payDone.setFont(Font.font("Times New Romman",FontWeight.BOLD,17));
        payDone.setTextFill(Color.rgb(147, 191, 207));
        payDone.setStyle("-fx-background-color:#EEE9DA;-fx-background-radius:20;");
        payDone.setLayoutX(280);
        payDone.setLayoutY(520);
        
        //--------------- Card Info : -------------------
    //GridPane that contains fields to let the user enter the card information(Card number, CVV code, and date of expiration.)    
        GridPane cardInfo = new GridPane();
        //won't be visible unless the user chooses the card payment method. 
        cardInfo.setVisible(false);
        //Set Styling.
        cardInfo.setPadding(new Insets(10,10,10,10));
        cardInfo.setVgap(0);
        cardInfo.setHgap(0);
    //Label inside the GridPane to ask the user the card details information:
        Label cardDetail = new Label("Credit Card Details ");
        cardDetail.setFont(Font.font("times-roman",FontWeight.BOLD,25));
        cardDetail.setStyle("-fx-text-fill:#EEE9DA;");
        cardInfo.add(cardDetail, 0, 0);
        
    //Labeled Field to enter the Card Number:    
        Label labelCNumber = new Label("Card Number ");
        labelCNumber.setStyle("-fx-text-fill:#EEE9DA;");
        TextField cardNum = new TextField();
        cardNum.setStyle("-fx-background-color: #E3F4F4;");
        cardInfo.add(labelCNumber, 0, 1);
        cardInfo.add(cardNum, 0, 2);
    //Labeled Field to enter the Expiration Date:   
        Label labelCDate = new Label("Expiration Date ");
        labelCDate.setStyle("-fx-text-fill:#EEE9DA;");
        cardInfo.add(labelCDate, 0, 3);
    //HBox that will contain the month and year combo boxes in order to ask the user to enter Expiration Date of the card:
        //Adding it aims to simplify the data entry to the user.
        HBox CradDate = new HBox(3);
        //Month combobox with the 12 months inside. 
        ComboBox <String> month = new ComboBox<>();
        month.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12");
        month.setValue("MM");
       //Year combobox with the acceptable years of Expiration.
        ComboBox <String> year = new ComboBox<>();
        year.getItems().addAll("2021","2022","2023","2024","2024","2025","2026","2027","2028","2029");
        year.setValue("YYYY");
    //Adding the two combo boxes to the HBox as mentioned previously.
        CradDate.getChildren().addAll(month,year);
        cardInfo.add(CradDate, 0, 4);
        
    //Labeled Field to enter the CVV code:   
        Label labelCVV = new Label("CVV Code ");
        labelCVV.setStyle("-fx-text-fill:#EEE9DA;");
        cardInfo.add(labelCVV, 0, 5);   
        TextField cvv = new TextField();
        cvv.setStyle("-fx-background-color: #E3F4F4;");
        cardInfo.add(cvv, 0, 6);
        
    //Set Styling to the GridPane cardInfo. 
        cardInfo.setStyle("-fx-border-color: rgb(238,233,218)");
        cardInfo.setLayoutX(180);
        cardInfo.setLayoutY(275);
        
    //Label that is used to display the user a message about the payment state   
        Label message = new Label();
        message.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
        message.setTextFill(Color.web("#EEE9DA"));
        message.setLayoutX(180);
        message.setLayoutY(470);
        
    //Pane that will be used to check the user intention in paying using another way of Payment(Not Card, Apple Pay or PayPal).
        Pane paymentDone = new Pane();
        paymentDone.setStyle("-fx-border-color:#EEE9DA; -fx-background-color:#EEE9DA;");
    //Set Styling: 
        paymentDone.setPrefSize(185, 80);
        paymentDone.setLayoutX(210);
        paymentDone.setLayoutY(280);
    //Label ask the user ("Pay using ....?) to let the user confirmed the payment method.      
        Label payOK = new Label();
        payOK.setFont(Font.font("Times New Romman",FontWeight.BOLD,17));
        payOK.setLayoutX(10);
        payOK.setLayoutY(5);
    //Button pay that will be inside the paymentDone pane, which is used to done the payment process the (Using Apple Pay or pay pal).
        //*This button is equivalent to the (payDone) button that is used to done the payment process when the user chooses the payment method CARD* 
        Button pay = new Button("PAY");
        pay.setStyle("-fx-background-color:#EEE9DA;-fx-background-radius:20;");
        //Set Styling
        pay.setStyle("-fx-background-color:rgb(147, 191, 207);");
        pay.setTextFill(Color.web("#EEE9DA"));
        pay.setLayoutX(75);
        pay.setLayoutY(50);
   //This pane won't be visible unless the user chooses Apple Pay or Pay pal payment methods.
    paymentDone.setVisible(false);
    
   //Pane that contains all the above-mentioned nodes.     
    Pane paymentPane = new Pane();   
    paymentPane.setStyle("-fx-background-color:rgb(147, 191, 207);");
    paymentPane.getChildren().addAll(top,backIcon,payment,chooseMethod,card,cardIcon,appleIcon,palIcon,payBtns,cardInfo,message,payDone,paymentDone);
        
    //-- Action Event: 
     // -Source: the carPay Radio Button.
     // -Action:When the user chooses the card payment method, the cardInfo GridPane that asks the user to enter the card details will appear. 
        cardPay.setOnAction(e->{
            paymentDone.setVisible(false);
            if (cardPay.isSelected()){
                message.setText("");
                cardInfo.setVisible(true);
   //--- Action Event: 
     // -Source: payDone Button.
    // Action: When the user clicks on it, the entered data must match these constraints, if not; a message that asks the user to retry will be displayed.
                payDone.setOnAction(p->{
                    if(cardNum.getText().matches(".*\\D.*") | cardNum.getText().isEmpty() | cardNum.getText().length()!=16){
                        message.setText("Infalid Card Number, please Try Again.");
                        cardNum.setText("");
                     } else if(cvv.getText().matches(".*\\D.*") | cvv.getText().length()!=3 | cvv.getText().isEmpty()){
                        message.setText("Infalid cvv code, please Try Aging.");
                        cvv.setText("");
                    }else if(year.getSelectionModel().isEmpty() | month.getSelectionModel().isEmpty()){
                        message.setText("Please Enter the card date of expiration.");
                    }
    //IF all data are valid, a thanking message will be displayed to confirm the user's booking.
                    else{
                        message.setText("Thank you! \n Wish you a Happy Watching :)");  
                    }
                 });
            }
        });
   //-- Action Event: 
    // -Source: the applePay Radio Button.
    // -Action: When the user chooses the apple pay payment method, the cardInfo GridPane will be invisible again,
    // and the paymentDone pane which asks the user to confirm the chosen payment method will appear. 
        applePay.setOnAction(e->{
            if(applePay.isSelected()){
                message.setText("");
                cardInfo.setVisible(false);
                paymentDone.setVisible(true);
           //The label content when the user choose paypal:
                payOK.setText("Pay Using ApplePay?");
   //-- Action Event: 
    // -Source: the pay Button.
    // -Action: When the user clicks on it, a thanking message will be displayed to confirm the user's booking.    
                pay.setOnAction(a->{
                  message.setText("Thank you! \n Wish you a Happy Watching :)");
                }); 
            }
        });
           
   //-- Action Event: 
    // -Source: the applePay Radio Button.
    // -Action: When the user chooses the apple pay payment method, the cardInfo GridPane will be invisible again,
    // and the paymentDone pane which asks the user to confirm the chosen payment method will appear. 
        payPal.setOnAction(e->{
            if(payPal.isSelected()){
                message.setText("");
                cardInfo.setVisible(false);
                paymentDone.setVisible(true);
          //The label content when the user choose paypal:
                payOK.setText("Pay Using PayPal?");
   //-- Action Event: 
    // -Source: the pay Button.
    // -Action: When the user clicks on it, a thanking message will be displayed to confirm the user's booking. 
                pay.setOnAction(a->{
                    message.setText("Thank you! \n Wish you a Happy Watching :)");
                });
            }
        });
        //Adding the label node and the button to the pane paymentDone.    
        paymentDone.getChildren().addAll(payOK,pay);

        Scene paymentPage = new Scene(paymentPane, 600, 600);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(paymentPage);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
