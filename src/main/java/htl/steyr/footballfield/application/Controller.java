package htl.steyr.footballfield.application;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class Controller extends AbstractController{

    public AnchorPane mainPane;

    public void intialize()  {

    }

    public void manageAppointments(ActionEvent actionEvent) {
        AppiontmentController controller =
                (AppiontmentController) openDialog(
                        getClass().getResource("appiontment.fxml"),
                        "Termin löschen",
                        mainPane.getScene().getWindow()
                );

        controller.setObjects();
    }

    public void manageFields(ActionEvent actionEvent) {
        FieldController controller =
                (FieldController) openDialog(
                        getClass().getResource("field.fxml"),
                        "Platz",
                        mainPane.getScene().getWindow()
                );

        controller.setObjects();
    }

    public void manageTeams(ActionEvent actionEvent) {
        TeamsController controller =
                (TeamsController) openDialog(
                        getClass().getResource("teams.fxml"),
                        "Mannschaft",
                        mainPane.getScene().getWindow()
                );

        controller.setObjects();
    }

    public void manageopenAppiontments(ActionEvent actionEvent) {
        FreeAppiontmentController controller =
                (FreeAppiontmentController) openDialog(
                        getClass().getResource("freeappiontment.fxml"),
                        "Offene Termine",
                        mainPane.getScene().getWindow()
                );

        controller.setObjects();
    }

    public void managenewAppiontments(ActionEvent actionEvent) {
        NewAppiontmentController controller =
                (NewAppiontmentController) openDialog(
                        getClass().getResource("newappiontment.fxml"),
                        "Neue Termine",
                        mainPane.getScene().getWindow()
                );

        controller.setObjects();
    }
}
