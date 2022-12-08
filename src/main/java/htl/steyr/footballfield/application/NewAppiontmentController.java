package htl.steyr.footballfield.application;

import htl.steyr.model.Appiontment;
import htl.steyr.model.Field;
import htl.steyr.model.Teams;
import htl.steyr.model.repository.AppointmentRepository;
import htl.steyr.model.repository.FieldRepository;
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
public class NewAppiontmentController extends AbstractController {
    public AnchorPane mainPane;
    public ListView<Appiontment> appiontmentsListView;


    public SplitMenuButton chooseReserved;
    
    public TextField chooseTeam;
    public TextField chooseField;
    public TextField fieldTextFIeld;
    public DatePicker dateTextField;


    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    FieldRepository fieldRepository;

    private Appiontment newAppiontment;

    private Field selectedfield;


    public void closeClicked(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        s.close();
    }




    public void newappiontmentClicked(ActionEvent actionEvent) {
        Date date = Date.valueOf(dateTextField.getValue());
        String field = fieldTextFIeld.getText();

        if(field != null)  {
            selectedfield = fieldRepository.findFieldByName(field);

            if(selectedfield != null) {
                newAppiontment = new Appiontment(date, selectedfield);

                appointmentRepository.save(newAppiontment);

            }

        }



    }


}
