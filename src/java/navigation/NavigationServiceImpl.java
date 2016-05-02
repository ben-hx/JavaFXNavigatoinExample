package navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *  Default-Implementation of the NavigationService
 *
 * Created by ben-hx on 01.05.2016.
 */
public class NavigationServiceImpl implements NavigationService {
    private final static String VIEW_PATH = "views/";
    private static NavigationServiceImpl instance = new NavigationServiceImpl();
    private final FXMLLoader fxmlLoader;
    private final Map<String, Object> params;
    private Stage primaryStage;

    private NavigationServiceImpl() {
        fxmlLoader = new FXMLLoader();
        params = new HashMap<String, Object>();
    }

    static NavigationService getInstance() {
        return instance;
    }

    private static String concatPath(String... args) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            buffer.append(args[i]);
            if (i < args.length - 1) {
                buffer.append("/");
            }
        }
        return buffer.toString();
    }

    @Override
    public void navigateTo(String... path) throws IOException {
        String resource = String.format(VIEW_PATH+"%s", concatPath(path));
        Parent view = FXMLLoader.load(getClass().getClassLoader().getResource(resource));
        primaryStage.setScene(new Scene(view));
    }

    @Override
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void addNavigationParam(String key, Object value) {
        params.put(key, value);
    }

    @Override
    public Object getNavigationParam(String key) {
        return params.containsKey(key) ? params.get(key) : null;
    }
}
