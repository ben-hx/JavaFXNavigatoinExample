package controllers.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import navigation.NavigationService;

import java.io.IOException;

/**
 * Created by ben-hx on 01.05.2016.
 */
public class LoginController {

    private NavigationService navigationService;
    public TextField userNameField;

    public LoginController() {
        navigationService = NavigationService.getDefault();
    }

    public void loginAction(ActionEvent actionEvent) {
        proceedLogin();
    }

    private void proceedLogin() {
        try {
            navigationService.addNavigationParam("name", userNameField.getText());
            navigationService.navigateTo("main", "main.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
