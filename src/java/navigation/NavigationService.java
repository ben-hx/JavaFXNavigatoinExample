package navigation;

import javafx.stage.Stage;

import java.io.IOException;

/**
 * Service to manage navigation and navigation-parameters
 *
 * Created by ben-hx on 01.05.2016.
 */
public interface NavigationService {

    /**
     * Returns the default NavigationService-Implementation
     * @return Default-NavigationService
     */
    public static NavigationService getDefault() {
        return NavigationServiceImpl.getInstance();
    }

    /**
     * Navigates to a view
     * @param path Path to view-fxml, relativ to Package-Path resources.views
     * @throws java.io.IOException triggered, if there is no .fxml-file found
     */
    void navigateTo(String... path) throws IOException;

    /**
     * sets the primary-stage where all views are displayed
     * @param primaryStage Instanz of Stage
     */
    void setPrimaryStage(Stage primaryStage);

    /**
     * Adds a new navigation-param
     * @param key Key which parameter can be found
     * @param value param to save
     */
    void addNavigationParam(String key, Object value);

    /**
     * returns the navigationparam by name
     * @param key Key to find the param
     * @return Navigation-param
     */
    Object getNavigationParam(String key);
}
