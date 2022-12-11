package htl.steyr.footballfield.application;

import htl.steyr.model.Appiontment;
import htl.steyr.model.Field;
import htl.steyr.model.Teams;
import htl.steyr.model.repository.AppointmentRepository;
import htl.steyr.model.repository.TeamsRepository;
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
public class FreeAppiontmentController extends AbstractController{
    public AnchorPane mainPane;
    public ListView<Appiontment> appiontmentsListView;


    public SplitMenuButton chooseReserved;
    public TextField dateTextField;
    public TextField chooseTeam;
    public TextField chooseField;
    public TextField fieldTextFIeld;
    public ListView<Appiontment> freeappiontementListVIew;
    public Label appiontmentLabel;
    public TextField teamTextField;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentRepository freeAppiontementRepository;

    @Autowired
    TeamsRepository teamsRepository;

    private Appiontment selectedAppiontment = null;

    private Teams selectedTeam = null;

    public void initialize() {
        selectedTeam = null;
        selectedAppiontment = null;

        Appiontment[] free = new Appiontment[0];
        free = freeAppiontementRepository.getFreeAppiontments("false");

        freeappiontementListVIew.getItems().addAll(free);

    }


    public void closeClicked(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        s.close();
    }



    public void clearSelection() {
        selectedAppiontment = null;
        appiontmentLabel.setText("Termin");
    }


    public void reserveAppiontmentClicked(ActionEvent actionEvent) {
        String team = teamTextField.getText();

        if(team != null)  {
            selectedTeam = teamsRepository.findTeamByName(team);
            if(selectedAppiontment != null)  {
                selectedAppiontment.setReserved(true);
                selectedAppiontment.setTeams(selectedTeam);

                appointmentRepository.save(selectedAppiontment);
                freeappiontementListVIew.refresh();
            } else {
                System.out.println("Du musst einen freien Termin aussuchen");
            }
        }



    }


    public void openappiontsmentListViewClicked(MouseEvent mouseEvent) {

        selectedAppiontment = freeappiontementListVIew.getSelectionModel().getSelectedItem();

        if(selectedAppiontment != null)  {
            appiontmentLabel.setText(selectedAppiontment.getDate() + "-" + selectedAppiontment.getField().getName());
        } else {
            clearSelection();
        }
    }
}
