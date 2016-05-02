import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import navigation.NavigationService;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        NavigationService navigationService = NavigationService.getDefault();
        navigationService.setPrimaryStage(primaryStage);
        //navigationService.navigateTo("login", "login.fxml");

        Parent root = FXMLLoader.load(getClass().getResource("views/login/login.fxml"));
        primaryStage.setTitle("Navigation Example");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
