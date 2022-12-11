package htl.steyr.footballfield.application;

import htl.steyr.model.Teams;
import htl.steyr.model.repository.TeamsRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class TeamsController extends AbstractController {
    public AnchorPane mainPane;
    public ListView<Teams> teamListView;
    public TextField nameTextField;

    @Autowired
    TeamsRepository teamsRepository;

    private Teams selectedTeams = null;

    public void initialize() {
        teamListView.getItems().addAll(teamsRepository.findAll());



    }

    public void saveClicked(ActionEvent actionEvent) {

        String name = nameTextField.getText();


        if (!name.equals("")) {
            if (selectedTeams == null) {
                selectedTeams = new Teams(name);
            } else {
                selectedTeams.setName(name);
            }

            teamsRepository.save(selectedTeams);

            teamListView.refresh();

            clearSelection();
        }
    }

    public void closeClicked(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        s.close();
    }

    public void categoryListViewClicked(MouseEvent mouseEvent) {
        //selectedTeams = teamListView.getSelectionModel().getSelectedItem();

        if (selectedTeams != null) {
            nameTextField.setText(selectedTeams.getName());
        } else {
            clearSelection();
        }
    }

    public void newClicked(ActionEvent actionEvent) {
        clearSelection();
    }

    public void deleteClicked(ActionEvent actionEvent) {
        if(selectedTeams != null) {
            teamsRepository.delete(selectedTeams);

            teamListView.refresh();
            clearSelection();
        }
    }

    public void clearSelection() {
        selectedTeams = null;

        nameTextField.setText("");
    }

    @PostMapping("/create")
    boolean createSchoolClass(@RequestParam String className) {
        if (className.isEmpty() || className.isBlank()) {
            return false;
        } else {
            Teams sc = new Teams();
            sc.setName(className);
            teamsRepository.save(sc);
            return true;
        }
    }
}
