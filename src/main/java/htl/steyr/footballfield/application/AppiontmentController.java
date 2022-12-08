package htl.steyr.footballfield.application;

import htl.steyr.model.Appiontment;
import htl.steyr.model.repository.AppointmentRepository;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppiontmentController extends AbstractController{
    public AnchorPane mainPane;
    public ListView<Appiontment> appiontmentsListView;




    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentRepository reservedappiontmentRepository;

    private Appiontment selectedAppiontment;



    public void initialize() {
        Appiontment[] reserved = new Appiontment[0];
        reserved = reservedappiontmentRepository.getReservedAppiontments("true");

        appiontmentsListView.getItems().addAll(reserved);

    }


    public void closeClicked(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        s.close();
    }



    public void deletereservedClicked(ActionEvent actionEvent) {
        if(selectedAppiontment != null) {
            selectedAppiontment.setReserved(false);
            appointmentRepository.save(selectedAppiontment);

            appiontmentsListView.refresh();

        }

    }


    public void appiontmentListViewClicked(MouseEvent mouseEvent) {
        selectedAppiontment = appiontmentsListView.getSelectionModel().getSelectedItem();

    }
}
