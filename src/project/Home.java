/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HUAWEI
 */
public class Home extends Application {
    static MovieInfo movies=new MovieInfo();
    static Image poster;
    @Override
    public void start(Stage primaryStage) {
    // ----------------------  Home Page : -----------------

    //HBox that contains the icons which appears on the top of the page.
        HBox icons = new HBox(10);
        
        ImageView logo = new ImageView(new Image("screenSurf logo.png"));
        logo.setFitHeight(130); 
        logo.setFitWidth(100);
        logo.setLayoutX(150);
        logo.setLayoutY(2);
        
    //First Icon: The Profile Button, which moves the user to the profile page(which displays the account info).   
        Button profileBtn = new Button();
        profileBtn.setPrefSize(50, 30);
        profileBtn.setStyle("-fx-background-color:#EEE9DA;");
        ImageView profile = new ImageView(new Image("profile.png"));
        profile.setFitHeight(25);profile.setFitWidth(25);
    //--- Action Event : 
    //Source : Profile Button 
    //Actio : changing the scene to move the user to the profile page.
        profileBtn.setGraphic(profile);
        profileBtn.setOnAction(e->{
            Profile b=new Profile();
            b.start(primaryStage);
        });
        
    //Second Icon: The Contact Button, which displays a titled pane -named contactInfo- with the cinema's contact info inside.          
        Button contactBtn = new Button();
        contactBtn.setPrefSize(50, 30);
        contactBtn.setStyle("-fx-background-color:#EEE9DA;");
        ImageView contact = new ImageView(new Image("contact.png"));
        contact.setFitHeight(25); contact.setFitWidth(25);
        contactBtn.setGraphic(contact);

    //Adding all the icons in the icons Box that is previously mentioned.
        icons.getChildren().addAll( contactBtn,profileBtn );
        icons.setLayoutX(240);
        icons.setLayoutY(10);
        
    //Label "Trending Now" that defines the list of trending movies. 
        Label trending = new Label ("Trending Now");
        trending.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 34));
        trending.setTextFill(Color.web("#EEE9DA"));
        trending.setLayoutX(20);
        trending.setLayoutY(125);
        
    //HBox that contains the list of trending movie posters.
        HBox trendingMovies = new HBox(5);
        
        //First movie: 
        Image blackBerryPster =new Image("Blackberry.jpg");
        ImageView blackBerry = new ImageView(blackBerryPster);
        blackBerry.setFitHeight(140); blackBerry.setFitWidth(115);
        //--- Mouse Event: 
     //Source: The imageView that view the movie poster. 
     //Action: Changing the scene to the movie page to display the movie information and allow the user to book a ticket to watch it. 
        blackBerry.setOnMouseClicked((MouseEvent e) -> {
            poster=blackBerryPster;
            String mov="Blackberry";
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            movies=(MovieInfo)session.get(MovieInfo.class, mov);
            tx.commit();
            session.close(); 
            
            MovieDetails movieDetails=new MovieDetails();
            movieDetails.start(primaryStage);
            
        });
        
        //Second movie: 
        Image stillPoster =new Image("Still.jpg");
        ImageView still = new ImageView(stillPoster);
        still.setFitHeight(140); still.setFitWidth(115);
        //--- Mouse Event: 
     //Source: The imageView that view the movie poster. 
     //Action: Changing the scene to the movie page to display the movie information and allow the user to book a ticket to watch it. 
        still.setOnMouseClicked((MouseEvent e) -> {
            poster=stillPoster;
            String mov="still";
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            movies=(MovieInfo)session.get(MovieInfo.class, mov);
            tx.commit();
            session.close(); 
            
            MovieDetails movieDetails=new MovieDetails();
            movieDetails.start(primaryStage);
            
        });
        
        //Third movie: 
        Image encantoPoster = new Image("Encanto.jpg");
        ImageView encanto = new ImageView(encantoPoster);
        encanto.setFitHeight(140); encanto.setFitWidth(115);
        //--- Mouse Event: 
     //Source: The imageView that view the movie poster. 
     //Action: Changing the scene to the movie page to display the movie information and allow the user to book a ticket to watch it.  
        encanto.setOnMouseClicked((MouseEvent e) -> {
            poster=encantoPoster;
            String mov="Encanto";
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            movies=(MovieInfo)session.get(MovieInfo.class, mov);
            tx.commit();
            session.close(); 
            
            MovieDetails movieDetails=new MovieDetails();
            movieDetails.start(primaryStage);
            
        });
        
        //Fourth movie: 
        Image LittleMermaidPoster =new Image("Little Mermaid.jpg");
        ImageView LittleMermaid = new ImageView(LittleMermaidPoster);
        LittleMermaid.setFitHeight(140); LittleMermaid.setFitWidth(115);
        //--- Mouse Event: 
     //Source: The imageView that view the movie poster. 
     //Action: Changing the scene to the movie page to display the movie information and allow the user to book a ticket to watch it. 
        LittleMermaid.setOnMouseClicked((MouseEvent e) -> {
            poster=LittleMermaidPoster;
            String mov="Little mermaid";
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            movies=(MovieInfo)session.get(MovieInfo.class, mov);
            tx.commit();
            session.close(); 
            
            MovieDetails movieDetails=new MovieDetails();
            movieDetails.start(primaryStage);
            
        });
        
        //Fifth movie: 
        Image kandaharPoster =new Image("Kandahar.jpg");
        ImageView kandahar = new ImageView(kandaharPoster);
        kandahar.setFitHeight(140); kandahar.setFitWidth(115);
    //--- Mouse Event: 
     //Source: The imageView that view the movie poster. 
     //Action: Changing the scene to the movie page to display the movie information and allow the user to book a ticket to watch it. 
        kandahar.setOnMouseClicked((MouseEvent e) -> {
            poster=kandaharPoster;
            String mov="Kandahar";
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            movies=(MovieInfo)session.get(MovieInfo.class, mov);
            tx.commit();
            session.close(); 
            
            MovieDetails movieDetails=new MovieDetails();
            movieDetails.start(primaryStage);
            
        });
    //HBox specifications:
        trendingMovies.setStyle("-fx-background-color:#EEE9DA;");
        trendingMovies.setLayoutY(170);trendingMovies.setLayoutX(2.5);
        
    //Adding all the posters to the trendingMovies Hbox. 
        trendingMovies.getChildren().addAll(blackBerry,still,encanto,LittleMermaid,kandahar);
        
    //Label "Showing Now" that defines the list of the Showing Now movies.    
        Label showing = new Label("Showing Now");
        showing.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 34));
        showing.setTextFill(Color.web("#EEE9DA"));
      
        showing.setLayoutX(20);
        showing.setLayoutY(345);
    //HBox that contains the list of trending movie posters.      
        HBox showingMovies = new HBox(5);
    //First Movie:
        Image manCalledOttoPoster =new Image("a man called otto.jpg");
        ImageView manCalledOtto = new ImageView(manCalledOttoPoster);
        manCalledOtto.setFitHeight(140); manCalledOtto.setFitWidth(115);
    //--- Mouse Event: 
     //Source: The imageView that view the movie poster. 
     //Action: Changing the scene to the movie page to display the movie information and allow the user to book a ticket to watch it.     
        manCalledOtto.setOnMouseClicked((MouseEvent e) -> {
            poster=manCalledOttoPoster;
            String mov="a man called otto";
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            movies=(MovieInfo)session.get(MovieInfo.class, mov);
            tx.commit();
            session.close(); 
            
            MovieDetails movieDetails=new MovieDetails();
            movieDetails.start(primaryStage);
            
        });
    //Second Movie:   
        Image hypnoticPoster =new Image("Hypnotic.jpg");
        ImageView hypnotic = new ImageView(hypnoticPoster);
        hypnotic.setFitHeight(140); hypnotic.setFitWidth(115);
        //--- Mouse Event: 
     //Source: The imageView that view the movie poster. 
     //Action: Changing the scene to the movie page to display the movie information and allow the user to book a ticket to watch it. 
        hypnotic.setOnMouseClicked((MouseEvent e) -> {
            poster=hypnoticPoster;
            String mov="hypnotic";
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            movies=(MovieInfo)session.get(MovieInfo.class, mov);
            tx.commit();
            session.close(); 
            
            MovieDetails movieDetails=new MovieDetails();
            movieDetails.start(primaryStage);
            
        });
        //Third Movie:       
        Image artificeGirlPoster =new Image("The artifice girl.jpg");
        ImageView artificeGirl = new ImageView(artificeGirlPoster);
        artificeGirl.setFitHeight(140); artificeGirl.setFitWidth(115);
        //--- Mouse Event: 
     //Source: The imageView that view the movie poster. 
     //Action: Changing the scene to the movie page to display the movie information and allow the user to book a ticket to watch it. 
        artificeGirl.setOnMouseClicked((MouseEvent e) -> {
            poster=artificeGirlPoster;
            String mov="artifice girl";
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            movies=(MovieInfo)session.get(MovieInfo.class, mov);
            tx.commit();
            session.close(); 
            
            MovieDetails movieDetails=new MovieDetails();
            movieDetails.start(primaryStage);
            
        });
        //Fourth Movie:        
        Image boogeymanPoster =new Image("The boogeyman.jpg");
        ImageView boogeyman = new ImageView(boogeymanPoster);
        boogeyman.setFitHeight(140); boogeyman.setFitWidth(115);
        //--- Mouse Event: 
     //Source: The imageView that view the movie poster. 
     //Action: Changing the scene to the movie page to display the movie information and allow the user to book a ticket to watch it. 
        boogeyman.setOnMouseClicked((MouseEvent e) -> {
            poster=boogeymanPoster;
            String mov="The boomgeyman";
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            movies=(MovieInfo)session.get(MovieInfo.class, mov);
            tx.commit();
            session.close(); 
            
            MovieDetails movieDetails=new MovieDetails();
            movieDetails.start(primaryStage);
            
        });
         //Fifth Movie:       
        Image sisuPoster =new Image("Sisu.jpg");
        ImageView sisu = new ImageView(sisuPoster);
        sisu.setFitHeight(140); sisu.setFitWidth(115);
         //--- Mouse Event: 
     //Source: The imageView that view the movie poster. 
     //Action: Changing the scene to the movie page to display the movie information and allow the user to book a ticket to watch it. 
        sisu.setOnMouseClicked((MouseEvent e) -> {
            poster=sisuPoster;
            String mov="sisu";
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            movies=(MovieInfo)session.get(MovieInfo.class, mov);
            tx.commit();
            session.close(); 
            
            MovieDetails movieDetails=new MovieDetails();
            movieDetails.start(primaryStage);
            
        });
         //HBox specifications       
        showingMovies.setStyle("-fx-background-color:#EEE9DA;");
        showingMovies.setLayoutX(2.5);
        showingMovies.setLayoutY(390);
        //Adding all the posters to the showingMovies Hbox.
        showingMovies.getChildren().addAll(manCalledOtto,hypnotic,artificeGirl,boogeyman,sisu);
        
        //Titled Pane to display the cinema contact information. 
        TitledPane contactInfo = new TitledPane();
           contactInfo.setText("Contact Us!");
           contactInfo.setFont(Font.font("Constantia", FontWeight.NORMAL, FontPosture.ITALIC, 12));
           contactInfo.setTextFill(Color.web("#93BFCF"));
           contactInfo.setLayoutX(75);
           contactInfo.setLayoutY(250);
           contactInfo.setPrefSize(230, 150);
           ImageView phoneIcon = new ImageView(new Image("phoneIcon.png"));
           phoneIcon.setFitHeight(30); phoneIcon.setFitWidth(30);
           phoneIcon.setLayoutX(15);
        phoneIcon.setLayoutY(20);
        Text phone = new Text("0540701192");
        phone.setLayoutX(60);
        phone.setLayoutY(40);
        phone.setFont(Font.font("Franklin Gothic Medium", FontWeight.BOLD, FontPosture.REGULAR, 16));
        ImageView emailIcon = new ImageView(new Image("email.png"));
        emailIcon.setLayoutX(15);
        emailIcon.setLayoutY(70);
        emailIcon.setFitHeight(30); emailIcon.setFitWidth(30);
        Text emailhomePage = new Text("ScreenSurf@gmail.com");
        emailhomePage.setLayoutX(55);
        emailhomePage.setLayoutY(90);
        emailhomePage.setFont(Font.font("Franklin Gothic Medium", FontWeight.BOLD, FontPosture.REGULAR, 16));
        //Pane to group the nodes that define the content of the titled pane.  
        Pane paneContent = new Pane();
        paneContent.getChildren().addAll(phoneIcon,phone,emailIcon,emailhomePage);
        //Set the Titled pane content.      
        contactInfo.setContent(paneContent);
        contactInfo.setContentDisplay(ContentDisplay.CENTER);
        //Hide the contact info pane. (Will be visible only when the user clicks on the contact button). 
        contactInfo.setVisible(false);
        //The root pane which contains the icons HBox, the two HBox which display the movie posters with the labels for each, and the contact info pane -Invisible-.
        Pane root = new Pane(logo,icons,trending,trendingMovies,showing,showingMovies,contactInfo);
        //Background to the root pane.
        root.setStyle("-fx-background-image:url('backgound.jpeg');");
        Scene home = new Scene(root, 600, 600);
        
         //--- Action Event: 
      // -Source: Contact Button (contactBtn) that inside the icons HBox. 
      // -Action: When the user clicks the button, the pane that contains the contact information will appears.(Visible) 
        contactBtn.setOnAction(e->{
           contactInfo.setVisible(true); 
        });
        //--- Mouse Event: 
      //Source: the scene(maonPage).
      // -Action: Whenever the user clicks on the scene (mainPage), the pane that displays the contact information will be invisible again. (NOT visible).
        home.setOnMouseClicked(m->{
            if(contactInfo.isVisible() == true)
            contactInfo.setVisible(false);
        });
        //scene
        primaryStage.setTitle("Welcome To ScreenSurf");
        primaryStage.setScene(home);
        primaryStage.show();
        
        //---------------------------------------------------------------------------------------------------------------

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
