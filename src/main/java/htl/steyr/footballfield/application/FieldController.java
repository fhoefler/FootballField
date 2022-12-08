package htl.steyr.footballfield.application;

import htl.steyr.model.Field;
import htl.steyr.model.repository.FieldRepository;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FieldController extends AbstractController{
    public AnchorPane mainPane;
    public ListView<Field> fieldListView;
    public TextField nameTextField;

    @Autowired
    FieldRepository fieldRepository;

    private Field selectedField = null;

    public void initialize() {
        selectedField = null;
        fieldListView.getItems().addAll(fieldRepository.findAll());
    }

    public void saveClicked(ActionEvent actionEvent) {
        String name = nameTextField.getText();


        if (!name.equals("")) {
            if (selectedField == null) {
                selectedField = new Field(name);

            } else {
                selectedField.setName(name);

            }

            fieldRepository.save(selectedField);

            fieldListView.refresh();

            clearSelection();
        }
    }

    public void closeClicked(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        s.close();
    }

    public void categoryListViewClicked(MouseEvent mouseEvent) {
        selectedField = fieldListView.getSelectionModel().getSelectedItem();

        if (selectedField != null) {
            nameTextField.setText(selectedField.getName());

        } else {
            clearSelection();
        }
    }

    public void newClicked(ActionEvent actionEvent) {
        clearSelection();
    }

    public void deleteClicked(ActionEvent actionEvent) {
        if(selectedField != null) {
            fieldRepository.delete(selectedField);

            fieldListView.refresh();
            clearSelection();
        }
    }

    public void clearSelection() {
        selectedField = null;

        nameTextField.setText("");
    }
}
