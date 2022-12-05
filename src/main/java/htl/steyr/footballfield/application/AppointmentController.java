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
public class AppointmentController extends AbstractController{
    public AnchorPane mainPane;
    public ListView<Appiontment> appiontmentsListView;


    public SplitMenuButton chooseReserved;
    public TextField dateTextField;
    public TextField chooseTeam;
    public TextField chooseField;

    @Autowired
    AppointmentRepository appointmentRepository;

    private Appiontment selectedAppiontment;

    private Teams selectedTeam;

    private Field selectedField;

    public void initialize() {
        appiontmentsListView.getItems().addAll(appointmentRepository.findAll());

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
                selectedAppiontment = new Appiontment(date, reserved, selectedTeam, selectedField);
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

    public void newClicked(ActionEvent actionEvent) {
        clearSelection();
    }

    public void deleteClicked(ActionEvent actionEvent) {
        if(selectedAppiontment != null) {
            appointmentRepository.delete(selectedAppiontment);

            appiontmentsListView.refresh();
            clearSelection();
        }
    }

    public void chooseReservedClicked(ActionEvent actionEvent) {
        chooseReserved.setText("reserviert");
        chooseReserved.setText("frei");
    }

    public void chooseTeamClicked(ActionEvent actionEvent) {

    }

    public void chosseFieldClicked(ActionEvent actionEvent) {
    }

    public void clearSelection() {
        selectedAppiontment = null;

        dateTextField = null;
        chooseTeam.setText("");
        chooseField.setText("");
        chooseReserved.setText("");
    }
}
