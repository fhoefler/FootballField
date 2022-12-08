package htl.steyr.footballfield.application;

import htl.steyr.model.Appiontment;
import htl.steyr.model.Field;
import htl.steyr.model.Teams;
import htl.steyr.model.repository.AppointmentRepository;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class OpenAppiontmentController extends AbstractController{
    public AnchorPane mainPane;
    public ListView<Appiontment> appiontmentsListView;


    public SplitMenuButton chooseReserved;
    public TextField dateTextField;
    public TextField chooseTeam;
    public TextField chooseField;
    public TextField fieldTextFIeld;
    public ListView openappiontementListVIew;
    public Label appiontmentLabel;
    public TextField teamTextField;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentRepository openAppiontementRepository;

    private Appiontment selectedAppiontment;

    private Teams selectedTeam;

    private Field selectedField;

    public void initialize() {
        Appiontment[] open = new Appiontment[0];
        open = openAppiontementRepository.getOpenAppiontments("false");

        appiontmentsListView.getItems().addAll(open);

    }

    public void saveClicked(ActionEvent actionEvent) {
        Date date = Date.valueOf(dateTextField.getPromptText());
        boolean reserved = Boolean.parseBoolean(chooseReserved.getText());
        String teams = chooseTeam.getText();
        String field = chooseField.getText();

        selectedTeam = appointmentRepository.getTeamById(teams);
        selectedField = appointmentRepository.getFieldById(field);


        if (!date.equals("")) {
            if (selectedAppiontment == null) {
                //selectedAppiontment = new Appiontment(date, reserved, selectedTeam, selectedField);
            } else {
                selectedAppiontment.setDate(date);
                selectedAppiontment.setReserved(reserved);
                selectedAppiontment.setTeams(selectedTeam);
                selectedAppiontment.setField(selectedField);
            }
            appointmentRepository.save(selectedAppiontment);

            appiontmentsListView.refresh();

            clearSelection();
        }
    }

    public void closeClicked(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        s.close();
    }

    public void categoryListViewClicked(MouseEvent mouseEvent) {
        selectedAppiontment = appiontmentsListView.getSelectionModel().getSelectedItem();

        if (selectedAppiontment != null) {
            dateTextField.setText(String.valueOf(selectedAppiontment.getDate()));
            chooseTeam.setText(String.valueOf(selectedAppiontment.getTeams().getName()));
            chooseReserved.setText(String.valueOf(selectedAppiontment.isReserved()));
            chooseField.setText(String.valueOf(selectedAppiontment.getField().getName()));
        } else {
            clearSelection();
        }
    }





    public void clearSelection() {
        selectedAppiontment = null;

        dateTextField = null;
        chooseTeam.setText("");
        chooseField.setText("");
        chooseReserved.setText("");
    }


    public void reserveAppiontmentClicked(ActionEvent actionEvent) {
    }

    public void openappiontsmentClicked(MouseEvent mouseEvent) {
    }
}
