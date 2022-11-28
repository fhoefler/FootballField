package htl.steyr.application;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class Controller extends AbstractController{

    public AnchorPane mainPane;

    public void intialize()  {

    }

    public void manageAppointments(ActionEvent actionEvent) {
        AppointmentController controller =
                (AppointmentController) openDialog(
                        getClass().getResource("appointment.fxml"),
                        "Termin",
                        mainPane.getScene().getWindow()
                );

        //controller.setObjects();
    }

    public void manageFields(ActionEvent actionEvent) {
        FieldController controller =
                (FieldController) openDialog(
                        getClass().getResource("field.fxml"),
                        "Platz",
                        mainPane.getScene().getWindow()
                );

        //controller.setObjects();
    }

    public void manageTeams(ActionEvent actionEvent) {
        TeamsController controller =
                (TeamsController) openDialog(
                        getClass().getResource("teams.fxml"),
                        "Mannschaft",
                        mainPane.getScene().getWindow()
                );

        //controller.setObjects();
    }
}
