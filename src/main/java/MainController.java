import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import lombok.Getter;

import java.io.IOException;


public class MainController implements HierarchicalController<MainController> {

    public MainController() {
        dataContainer = new DataContainer();
    }

    @Override
    public MainController getParentController() {
        return this;
    }

    @Override
    public void setParentController(MainController parent) {}

    public Pane pane;
    @Getter protected DataContainer dataContainer;

    private void loadIntoPane(String fxml) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        try {
            final BorderPane load = loader.load();
            pane.getChildren().clear();
            pane.getChildren().add(load);
            HierarchicalController<MainController> daneController = loader.getController();
            daneController.setParentController(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void bazaFilmow(ActionEvent actionEvent) {
        loadIntoPane("BazaFilmow.fxml");
    }

    public void bazaSal(ActionEvent actionEvent) {
        loadIntoPane("BazaSal.fxml");
    }

    public void bazaSeansow(ActionEvent actionEvent) {
        loadIntoPane("BazaSeansow.fxml");
    }


}