package controllers.main;

import com.sun.javaws.exceptions.InvalidArgumentException;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.ToDo;
import navigation.NavigationService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ben-hx on 01.05.2016.
 */
public class MainController implements Initializable {

    public Label headerLabel;
    public TextArea taContent;
    public TextField tfSubject;
    public TableView<ToDo> tvToDo;
    public TableColumn<ToDo, String> subjectColumn;
    public TableColumn<ToDo, String> contentColumn;
    private NavigationService navigationService;

    public MainController() {
        this.navigationService = NavigationService.getDefault();
    }

    public void save(ActionEvent actionEvent) {
        try {
            tvToDo.getItems().add(new ToDo(tfSubject.getText(),taContent.getText()));
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } finally {
            tfSubject.setText("");
            taContent.setText("");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        headerLabel.textProperty().set(String.format("Willkmmen %s", navigationService.getNavigationParam("name")));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        contentColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
    }
}
